package com.stylefeng.guns.modular.system.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.shiro.ShiroUser;
import com.stylefeng.guns.core.util.FileUtil;
import com.stylefeng.guns.modular.gunsFile.controller.service.IGunsFileService;

import com.stylefeng.guns.modular.system.model.GunsFile;

import com.stylefeng.guns.util.GlobalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

/**
 * 工具controller
 * add by huangbiao
 **/
@Controller
@RequestMapping("base")
public class UtilController {
    @Autowired
    private IGunsFileService gunsFileService;


    private static final Integer MAX_EXPORT_PEOPLE_NUM = 3;

    private static Integer max_export_people_num = 0;

    @RequestMapping("/downloadSingleBeforeFile")
    @ResponseBody
    public void downloadSingleBeforeFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realPath = ResourceUtils.getFile("classpath:").getPath() + "/static/templateFile/散单批量建单模板.xlsx";
        String fileName = "散单批量建单模板.xlsx";
        byte[] decodeByte = FileUtil.downloadFile(realPath);
        // 对文件进行url编码
        if (request.getHeader("user-agent").toLowerCase().contains("msie")
                || request.getHeader("user-agent").toLowerCase().endsWith("like gecko")// ie10以上取消了msie用户代理字符串
        ) {
            // IE
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } else {
            // 非IE
            fileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
        }
        if (decodeByte != null) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
            InputStream fis = null;
            OutputStream os = null;
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

    @RequestMapping("/downloadBeforeFile")
    @ResponseBody
    public void downloadBeforeFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realPath = ResourceUtils.getFile("classpath:").getPath() + "/static/templateFile/是否大项目-批量建单模板.xlsx";
        String fileName = "批量建单模板.xlsx";
        byte[] decodeByte = FileUtil.downloadFile(realPath);
        // 对文件进行url编码
        if (request.getHeader("user-agent").toLowerCase().contains("msie")
                || request.getHeader("user-agent").toLowerCase().endsWith("like gecko")// ie10以上取消了msie用户代理字符串
        ) {
            // IE
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } else {
            // 非IE
            fileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
        }
        if (decodeByte != null) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
            InputStream fis = null;
            OutputStream os = null;
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

    @RequestMapping("/downloadFile")
    @ResponseBody
    public void downloadFile(HttpServletRequest request, HttpServletResponse response, String filePath, String fileName) throws IOException {
        String realPath = ResourceUtils.getFile("classpath:").getPath() + filePath;
        byte[] decodeByte = FileUtil.downloadFile(realPath);
        // 对文件进行url编码
        if (request.getHeader("user-agent").toLowerCase().contains("msie")
                || request.getHeader("user-agent").toLowerCase().endsWith("like gecko")// ie10以上取消了msie用户代理字符串
        ) {
            // IE
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } else {
            // 非IE
            fileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
        }
        if (decodeByte != null) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
            InputStream fis = null;
            OutputStream os = null;
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

    /**
     * 下载文件
     **/
    public void downloadFile(byte[] decodeByte, HttpServletResponse response, String fileName) {
        if (decodeByte != null) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
            InputStream fis = null;
            OutputStream os = null;
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

    /**
     * 图片预览
     **/
    @RequestMapping("/showImg")
    public void showImg(HttpServletResponse response, String fileId, String imgType) throws IOException {
        EntityWrapper<GunsFile> wrapper = new EntityWrapper<GunsFile>();
        wrapper.eq("file_id", fileId);
        GunsFile gunsFile = gunsFileService.selectOne(wrapper);
        String realPath = "";
        if ("thumb".equals(imgType)) {
            //获取缩略图
            realPath = UtilController.class.getResource("/").getPath() + gunsFile.getThumbPath().substring(1);
        } else {
            //获取原图
            realPath = UtilController.class.getResource("/").getPath() + gunsFile.getFilePath().substring(1);
        }
        File f = new File(realPath);
        InputStream fis = new FileInputStream(f);
        OutputStream outputStream = response.getOutputStream();
        int len = 0;
        byte[] buf = new byte[1024];
        while ((len = fis.read(buf, 0, 1024)) != -1) {
            outputStream.write(buf, 0, len);
        }
        outputStream.close();
    }

    /**
     * 跳转到主页
     */
    @RequestMapping(value = "/map")
    public String map(Model model) {
        ShiroUser user = ShiroKit.getUser();
//        String roleName = user.getRoleNames().get(0).substring(0,2);
//        if(roleName.equals("分公")){
//            model.addAttribute("roleName","");
//        }else{
//            model.addAttribute("roleName",roleName);
//        }
        return "/map.html";

        //获取菜单列表
    }


    /**
     * 前端获取是否可以导出
     *
     * @return
     */
    @RequestMapping("/addMaxExportPeopleNum")
    @ResponseBody
    public Integer addMaxExportPeopleNum() {
        if (max_export_people_num >= MAX_EXPORT_PEOPLE_NUM) {
            return -1;
        } else {
            max_export_people_num++;
            return max_export_people_num;
        }
    }

    /**
     * 导出完毕，释放空位
     *
     * @return
     */
    @RequestMapping("/subMaxExportPeopleNum")
    @ResponseBody
    public Integer subMaxExportPeopleNum() {
        max_export_people_num--;
        return max_export_people_num;
    }

    /**
     * 重置导出人数
     *
     * @return
     */
    @RequestMapping("/resetMaxExportPeopleNum")
    @ResponseBody
    public String resetMaxExportPeopleNum() {
        max_export_people_num = 0;
        return "重置成功";
    }




}
