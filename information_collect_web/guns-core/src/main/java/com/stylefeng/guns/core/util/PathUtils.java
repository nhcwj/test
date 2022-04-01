package com.stylefeng.guns.core.util;

import com.stylefeng.guns.core.util.type.TypeUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by Administrator on 2017/7/14.
 */
public class PathUtils {

    public static final String ADMIN_PATH = "/weixin-app-admin";

    private static final Logger log = Logger.getLogger(PathUtils.class);

    public static String getSuffix(MultipartFile file) {
        if (file == null) return "";
        String name = file.getOriginalFilename();
        return FileUtil.suffix(name);
    }

    /**
     * 获取当前网站域名
     *
     * @return
     */
    public static String getHostAddr() {
        HttpServletRequest request = ServletUtils.getRequest();
        String appPath = request.getContextPath();
        return request.getScheme() + "://" + request.getServerName() + (request.getServerPort() == 80 ? "" : (":" + request.getServerPort())) + appPath;
    }

    public static File getUpload(String filename) throws IOException {
        return getUpload(filename, null);
    }

    public static File getUpload(String filename, MultipartFile f) throws IOException {
        File file = null;
        try {
//            String realPath = ClassUtils.getDefaultClassLoader().getResource("/").getPath();
            String realPath=PathUtils.class.getResource("/").getPath();
//            String realPath=ServletUtils.getRequest().getSession().getServletContext().getRealPath("/");
//            String realPath = ClassUtils.getDefaultClassLoader().getResource("/").getPath();
            StringBuffer path = new StringBuffer();
            path.append(realPath);
            path.append("uploads");
            path.append(File.separator + DateUtils.toInt());
            File dir = new File(path.toString());
            if (!dir.exists()) dir.mkdirs();

            //获取文件后缀名
            String ext = getSuffix(f);
            if (!TypeUtils.empty(ext)) {
                filename += ext;
            }
            file = new File(dir, filename);
            if (!file.exists()) {
                file.createNewFile();
            }

            if (f != null) {

                f.transferTo(file);
            }
        } catch (IOException e) {
            log.error("【Upload File】upload new file(" + file == null ? "NULL" : file.getAbsolutePath() + ") failed", e);
            FileUtil.delete(file);
            throw e;
        }
        return file;
    }

    


    public static File getThumb(File toFile, String ext) {
        File thumbFile = null;

        File thumbFileDir = new File(toFile.getParentFile(), "thumbnails");
        if (!thumbFileDir.exists()) {
            thumbFileDir.mkdirs();
        }
        String name = toFile.getName();
        if (!TypeUtils.empty(ext)) {
            int ind = name.lastIndexOf(".");
            name = name.substring(0, ind > 0 ? ind : name.length());
            name = name + ext;
        }
        thumbFile = new File(thumbFileDir, "thumb_" + name);

        return thumbFile;
    }

    public static File getMp3(File toFile, String filename) {
        File dir = toFile.getParentFile();
        File file = new File(dir, "mp3" + File.separator + filename + ".mp3");
        if (file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static File getFileBypath(String filePath) {
        String realPath = ClassUtils.getDefaultClassLoader().getResource("/").getPath();
        return new File(realPath, filePath);
    }

    public static String getPath(File file) {
        if (file == null) {
            return "";
        }
        String realPath=PathUtils.class.getResource("/").getPath();
        String path = file.getAbsolutePath();
        path = path.replace(realPath, "");

        if (!path.startsWith(File.separator)) {
            path = File.separator + path;
        }

        path = path.replaceAll("\\\\", "/");

        //update by zhirongrui 只获取/uploads/......的路径(相对路径)
        path = path.substring(path.lastIndexOf("/uploads"));
        return path;
    }

    /**
     * 获取网站根目录
     *
     * @return
     */
    public static String getContextPath() {
        // TODO 仅测试使用, 使用现有服务器资源
//        return "http://fsdx.fsecity.com:8088" + ServletUtils.getRequest().getContextPath();
        return ServletUtils.getRequest().getContextPath();
    }

    /**
     * 处理图片路径
     *
     * @param path
     * @return
     */
    public static String getImagePath(String path) {
        if (StrUtils.empty(path)) {
            return "";
        }
        if (path.startsWith("http://")) {
            return path;
        }
        if (path.startsWith("${admin}")) {
            return path.replace("${admin}", ADMIN_PATH);
        }
        if (path.startsWith("${home}")) {
            return path.replace("${home}", getContextPath());
        }
        if (path.startsWith("/weixin-app-server")) {
            return path.replace("/weixin-app-server", getContextPath());
        }
        if (path.startsWith("/weixin-app-admin")) {
            return path.replace("/weixin-app-admin", ADMIN_PATH);
        }
        if (path.startsWith("/wx-dev")) {
            return path.replace("/wx-dev", getContextPath());
        }
        if (path.startsWith("/wxgh")) {
            return path.replace("/wxgh", getContextPath());
        }
        if (path.indexOf("/") == -1) {
            return getContextPath() + "/uploads/image/material/" + path;
        }
        return getContextPath() + path;
    }

    public class PATH_NOTICE {
    }
    /**
    *处理下载文件，文档损坏的情况
    **/
    public static String inputStream2String(InputStream in) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = 0;
        byte[] b = new byte[1024];
        while ((len = in.read(b, 0, b.length)) != -1) {
            baos.write(b, 0, len);
        }
        byte[] buffer =  baos.toByteArray();
        //base64加密
        return Base64.encodeBase64String(buffer);
    }
    
    
    /**
    *上传书记述职材料
    **/
    public static File getSecReportUpload(String filename, MultipartFile f) throws IOException {
        File file = null;
        try {
//            String realPath = ClassUtils.getDefaultClassLoader().getResource("/").getPath();
            String realPath=PathUtils.class.getResource("/").getPath()+"static/";
//            String realPath=ServletUtils.getRequest().getSession().getServletContext().getRealPath("/");
//            String realPath = ClassUtils.getDefaultClassLoader().getResource("/").getPath();
            System.out.println("-------------------- "+realPath+" -------------------");
            StringBuffer path = new StringBuffer();
            path.append(realPath);
            path.append("SecReportFile");
            path.append(File.separator + DateUtils.toInt());
            File dir = new File(path.toString());
            if (!dir.exists()) dir.mkdirs();

            //获取文件后缀名
            String ext = getSuffix(f);
            if (!TypeUtils.empty(ext)) {
                filename += ext;
            }
            file = new File(dir, filename);
            if (!file.exists()) {
                file.createNewFile();
            }

            if (f != null) {
                f.transferTo(file);
            }
        } catch (IOException e) {
            log.error("【Upload File】upload new file(" + file == null ? "NULL" : file.getAbsolutePath() + ") failed", e);
            FileUtil.delete(file);
            throw e;
        }
        return file;
    }

    /**
    *获取书记述职材料上传路径
    **/
    public static String getSecReportPath(File file) {
        if (file == null) {
            return "";
        }
        String realPath=PathUtils.class.getResource("/").getPath();
        String path = file.getAbsolutePath();
        path = path.replace(realPath, "");

        if (!path.startsWith(File.separator)) {
            path = File.separator + path;
        }

        path = path.replaceAll("\\\\", "/");

        //update by zhirongrui 只获取/uploads/......的路径(相对路径)
        path = path.substring(path.lastIndexOf("/static"));
        return path;
    }



}
