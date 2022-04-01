package com.stylefeng.guns.modular.system.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.util.FileUtil;
import com.stylefeng.guns.modular.gunsFile.controller.service.IGunsFileService;
import com.stylefeng.guns.modular.sysFile.service.impl.fileApi;
import com.stylefeng.guns.modular.system.model.GunsFile;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gjx
 * @description 文件工具类
 * @date 2021/3/4
 */
@Controller
@RequestMapping("/fileUtil")
public class FileUtilController {

    @Autowired
    private IGunsFileService fileService;
    @Autowired
    private com.stylefeng.guns.modular.sysFile.service.impl.fileApi fileApi;


    @RequestMapping("/downloadFileByFileId")
    @ResponseBody
    public void downloadFileByFileId(String fileId,HttpServletRequest request, HttpServletResponse response){

        EntityWrapper<GunsFile> wrapper = new EntityWrapper<>();
        wrapper.eq("file_id",fileId);
        List<GunsFile> gunsFiles = fileService.selectList(wrapper);

        if (gunsFiles.size()>0){
            String fileName=gunsFiles.get(0).getFilename();
            String filePath=gunsFiles.get(0).getFilePath();
//            String realPath = ApplyLandOrderController.class.getResource("/").getPath()+filePath.substring(1);
            try {
                downloadFile(request, response, "",fileName);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void downloadFile(HttpServletRequest request, HttpServletResponse response, String path, String realName) throws IOException {
        String[] split = path.split("/");
        String fileName = split[split.length - 1];
        byte[] decodeByte= FileUtil.downloadFile(path);
        // 对文件进行url编码
        if (realName != null && realName != ""){
            fileName = realName;
        }
        if (request.getHeader("user-agent").toLowerCase().contains("msie")
                || request.getHeader("user-agent").toLowerCase().endsWith("like gecko")// ie10以上取消了msie用户代理字符串
                ) {
            // IE
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } else {
            // 非IE
            fileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
        }

        if(decodeByte!=null){
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" +fileName);// 设置文件名
            InputStream fis = null;
            OutputStream os=null;
            try {
                fis = new ByteArrayInputStream(decodeByte);
                os = response.getOutputStream();
                int len = 0;
                byte[] b = new byte[1024];
                while ((len = fis.read(b)) > 0) {
                    os.write(b, 0, len);
                }
                fis.close();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/updateFile")
    @ResponseBody
    public String updateContractData(@RequestParam("file") MultipartFile[] fileList) throws JSONException {
        if (fileList.length>0){
            List<String> fileStr = new ArrayList<String>();
            fileStr = fileApi.addFileAndReturnFileIds(fileList);
            String strx = "";
            int i=0;
            for(String str : fileStr){
                strx+=str;
                if(i<fileStr.size()-1){
                    strx+=",";
                }
                i++;
            }
            return strx;
        }else{
            return null;
        }
    }

    @RequestMapping("/getFileInfo")
    @ResponseBody
    public Map<String,String> getFileInfo(String fileIds){
        return null;
    }
}
