package com.stylefeng.guns.modular.workOrder.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.base.tips.SuccessTip;
import com.stylefeng.guns.core.bean.FileBean;
import com.stylefeng.guns.core.bean.FileParam;
import com.stylefeng.guns.core.bean.FileType;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.PathUtils;
import com.stylefeng.guns.core.util.crypt.MD5;
import com.stylefeng.guns.core.util.ffmpeg.VideoUtils;
import com.stylefeng.guns.core.util.type.StringUtils;
import com.stylefeng.guns.core.util.type.TypeUtils;
import com.stylefeng.guns.modular.gunsFile.controller.service.impl.GunsFileServiceImpl;
import com.stylefeng.guns.modular.system.controller.UtilController;
import com.stylefeng.guns.modular.system.dao.GunsFileMapper;
import com.stylefeng.guns.modular.system.dao.RoleMapper;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.model.GunsFile;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: biu
 * @Date: 2021/4/12 10:21
 * @Description:
 */
@Controller
@RequestMapping("/workOrder")
@CrossOrigin
public class workOrderController extends UtilController {

    private String PREFIX = "/workOrder/";

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private com.stylefeng.guns.modular.sysFile.service.impl.fileApi fileApi;
    @Autowired
    private GunsFileServiceImpl gunsFileService;

    @Autowired
    private GunsFileMapper gunsFileMapper;

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UtilController utilController;




    //上传文件
    @RequestMapping("/uploadFiles")
    @ResponseBody
    @CrossOrigin
    public Object uploadFiles(@RequestParam("file") MultipartFile[] fileList) throws ParseException {
        List<String> fileStr = addFileAndReturnFileIds(fileList);
        Map<String, Object> returnData = new HashMap<String, Object>();
        returnData.put("code", 200);
        returnData.put("fileList", fileStr);
        return returnData;
    }

    public List<String> addFileAndReturnFileIds(MultipartFile[] fileList) {
        List<String> fileStr = new ArrayList<String>();
        if (fileList != null && fileList.length > 0) {
            //组合image名称，“;隔开”
            List<String> fileName = new ArrayList<String>();
            for (MultipartFile m : fileList) {
                //1.文件不为空
                //定义文件参数类，获取文件后缀，保存文件到t_sys_file表中
                FileParam fileParam = new FileParam();
                String ext = PathUtils.getSuffix(m).substring(1);
                fileParam.setThumb(true);
//                fileParam.setType(ext);
                GunsFile gunsFile = this.addFile(m, fileParam);
                fileStr.add(gunsFile.getFileId());
            }
        }
        return fileStr;
    }

    public GunsFile addFile(MultipartFile f, FileParam param) {
        try {
            String fileId = StringUtils.uuid();
            File toFile = PathUtils.getUpload(fileId, f);
            FileBean fileBean = new FileBean(f, fileId);
            fileBean.setSaveFile(toFile);
            return addFile(fileBean, param);
        } catch (IOException e) {
            throw new GunsException("上传失败");
        }
    }

    public GunsFile addFile(FileBean file, FileParam param) throws IOException {
        String md5 = MD5.getFileMD5(file.getSaveFile());
        EntityWrapper<GunsFile> entityWrapper = new EntityWrapper<>();
        Wrapper<GunsFile> wrapper = entityWrapper.eq("md5", md5);
        GunsFile gunsFile = gunsFileService.selectOne(wrapper);
        if (gunsFile == null || !gunsFile.getSize().equals(file.getSize())) {
            String thumb = "";
            if (file.getContentType().contains("jpeg") || file.getContentType().contains("png") || file.getContentType().contains("jpg")) {
                thumb = createThumb(param, file.getSaveFile()); //创建略缩图
            }
            gunsFile = new GunsFile();
            gunsFile.setFileId(file.getFileId());
            gunsFile.setFilename(file.getFilename());
            gunsFile.setFilePath(PathUtils.getPath(file.getSaveFile()));
            gunsFile.setMimeType(file.getContentType());
            gunsFile.setThumbPath(thumb);
            gunsFile.setSize(file.getSize());
            gunsFile.setMd5(md5);
            gunsFile.setAddTime(new Date());
            gunsFile.setType(param == null ? "" : param.getType());
//            gunsFile.setUpload_people(ShiroKit.getUser().getName());
            gunsFileService.insert(gunsFile);
        }

        return gunsFile;
    }

    public String createThumb(FileParam param, File toFile) throws FileNotFoundException {
        File thumbFile = null;
        try {
            if (param != null && param.getThumb() != null && param.getThumb()) {
                //图片略缩图
                if (FileType.IMAGE.getType().equals(param.getType())) {
                    Thumbnails.Builder<File> builder = Thumbnails.of(toFile);
                    if (!TypeUtils.empty(param.getSize())) {
                        String[] size = param.getSize().split("x");
                        if (size.length == 1) {
                            builder.width(Integer.valueOf(size[0]));
                        } else if (size.length == 2) {
                            builder.size(Integer.valueOf(size[0]), Integer.valueOf(size[1]));
                        }
                    }
                    thumbFile = PathUtils.getThumb(toFile, ".jpg");
                    builder.toFile(thumbFile);

                    //视频文件略缩图
                } else if (FileType.VIDEO.getType().equals(param.getType())) {
                    thumbFile = PathUtils.getThumb(toFile, ".jpg");
                    VideoUtils.getVideoImage(toFile.getAbsolutePath(),
                            thumbFile.getAbsolutePath());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PathUtils.getPath(thumbFile);
    }

    @RequestMapping("/uploadFilex")
    @ResponseBody
    public Object uploadFilex(@RequestParam("jumpFile") MultipartFile[] fileList) throws ParseException {
        List<String> fileStr = fileApi.addFileAndReturnFileIds(fileList);
        Map<String, Object> returnData = new HashMap<String, Object>();
        returnData.put("code", 200);
        returnData.put("fileList", fileStr);
        return returnData;
    }

    //删除文件
    @RequestMapping("/removeFile")
    @ResponseBody
    public Object uploadFiles(HttpSession session, String fileId) throws ParseException {
        return new SuccessTip();
//        EntityWrapper<GunsFile> fileEntityWrapper = new EntityWrapper<>();
//        fileEntityWrapper.eq("file_id", fileId);
//        GunsFile file = gunsFileService.selectOne(fileEntityWrapper);
//        String realPath = workOrderController.class.getResource("/").getPath();
//        String path = file.getFilePath().substring(1);
//        String removePath = realPath + path;
//        File removeFile = new File(removePath);
//        Boolean removed = removeFile.delete();
//        if (removed) {
//            gunsFileService.delete(fileEntityWrapper);
//            return new SuccessTip();
//        } else {
//            return new ErrorTip(500, "删除失败");
//        }
    }


}

