package com.stylefeng.guns.modular.sysFile.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
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
import com.stylefeng.guns.modular.gunsFile.controller.service.IGunsFileService;
import com.stylefeng.guns.modular.sysFile.service.ISysFileService;
import com.stylefeng.guns.modular.system.model.GunsFile;
import com.stylefeng.guns.modular.system.model.SysFile;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.flowable.validation.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by zhirongrui on 2018/6/29.
 */
@Component
public class fileApi {
    private static final Log log = LogFactory.getLog(fileApi.class);


    @Autowired
    private IGunsFileService gunsFileService;

    @Autowired
    private ISysFileService sysFileService;
    /**
     * 添加文件到数据库
     *
     * @param file
     * @param param
     * @return
     */
    @Transactional
    public GunsFile addFile(FileBean file, FileParam param) throws IOException {
        String md5 = MD5.getFileMD5(file.getSaveFile());
        EntityWrapper<GunsFile> entityWrapper = new EntityWrapper<>();
        Wrapper<GunsFile> wrapper = entityWrapper.eq("md5",md5);
        GunsFile gunsFile = gunsFileService.selectOne(wrapper);
        if (gunsFile == null || !gunsFile.getSize().equals(file.getSize())) {
            System.out.println(file.getFilename());
            System.out.println(file.getContentType());
            String thumb="";
            if(file.getContentType().contains("jpeg") || file.getContentType().contains("png") || file.getContentType().contains("jpg")){
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
            gunsFile.setUpload_people(ShiroKit.getUser().getName());
            gunsFileService.insert(gunsFile);
        }

        return gunsFile;
    }
    /**
    *添加文件数组到数据库并返回文件ID数组
    **/
    public List<String> addFileAndReturnFileIds(MultipartFile[] fileList){
        List<String> fileStr=new ArrayList<String>();
        if(fileList!=null && fileList.length>0){
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
    /**
     * 添加文件到数据库
     *
     * @param f
     * @param param
     * @return
     */
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
    /**
    *添加书记述职材料到数据库
    **/
    public GunsFile addSecReportFile(MultipartFile f, FileParam param) {
        try {
            String fileId = StringUtils.uuid();
            File toFile = PathUtils.getSecReportUpload(fileId, f);
            FileBean fileBean = new FileBean(f, fileId);
            fileBean.setSaveFile(toFile);
            return addSecReportFile(fileBean, param);
        } catch (IOException e) {
            throw new GunsException("上传失败");
        }
    }

    /**
     * 添加书记述职文件到数据库
     *
     * @param file
     * @param param
     * @return
     */
    public GunsFile addSecReportFile(FileBean file, FileParam param) throws IOException {
        String md5 = MD5.getFileMD5(file.getSaveFile());
        EntityWrapper<GunsFile> entityWrapper = new EntityWrapper<>();
        Wrapper<GunsFile> wrapper = entityWrapper.eq("md5",md5);
        GunsFile gunsFile = gunsFileService.selectOne(wrapper);
        if (gunsFile == null || !gunsFile.getSize().equals(file.getSize())) {
            String thumb = createThumb(param, file.getSaveFile()); //创建略缩图

            gunsFile = new GunsFile();
            gunsFile.setFileId(file.getFileId());
            gunsFile.setFilename(file.getFilename());
            gunsFile.setFilePath(PathUtils.getSecReportPath(file.getSaveFile()));
            gunsFile.setMimeType(file.getContentType());
            gunsFile.setThumbPath(thumb);
            gunsFile.setSize(file.getSize());
            gunsFile.setMd5(md5);
            gunsFile.setAddTime(new Date());
            gunsFile.setType(param == null ? "" : param.getType());
//            InputStream inputStream= null;
//            try {
//                inputStream = new FileInputStream(file.getSaveFile());
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            sysFile.setBlob_address(inputStream);
            gunsFileService.insert(gunsFile);
        }

        return gunsFile;
    }






    /**
     * 添加文件到数据库
     *
     * @param file
     * @param param
     * @return
     */
    public SysFile addSysFile(FileBean file, FileParam param) throws IOException {
        String md5 = MD5.getFileMD5(file.getSaveFile());
        EntityWrapper<SysFile> entityWrapper = new EntityWrapper<>();
        Wrapper<SysFile> wrapper = entityWrapper.eq("md5",md5);
        SysFile sysFile = sysFileService.selectOne(wrapper);
        if (sysFile == null || !sysFile.getSize().equals(file.getSize())) {
            String thumb = createThumb(param, file.getSaveFile()); //创建略缩图

            sysFile = new SysFile();
            sysFile.setFileId(file.getFileId());
            sysFile.setFilename(file.getFilename());
            sysFile.setFilePath(PathUtils.getPath(file.getSaveFile()));
            sysFile.setMimeType(file.getContentType());
            sysFile.setThumbPath(thumb);
            sysFile.setSize(file.getSize());
            sysFile.setMd5(md5);
            sysFile.setAddTime(new Date());
            sysFile.setType(param == null ? "" : param.getType());
//            InputStream inputStream= null;
//            try {
//                inputStream = new FileInputStream(file.getSaveFile());
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            sysFile.setBlob_address(inputStream);
            if(param.getCreateBlob()){
                InputStream inputStream= null;
                try {
                    inputStream = new FileInputStream(file.getSaveFile());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                sysFile.setBlob_address(inputStream);
            }
            sysFileService.insert(sysFile);
        }

        return sysFile;
    }

    /**
     * 添加文件到数据库
     *
     * @param f
     * @param param
     * @return
     */
    public SysFile addSysFile(MultipartFile f, FileParam param) {
        try {
            String fileId = StringUtils.uuid();
            File toFile = PathUtils.getUpload(fileId, f);
            FileBean fileBean = new FileBean(f, fileId);
            fileBean.setSaveFile(toFile);
            return addSysFile(fileBean, param);
        } catch (IOException e) {
            throw new GunsException("上传失败");
        }
    }

    /**
     * 创建略缩图
     *
     * @param param
     * @param toFile
     * @return
     */
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
    /**
    *三会一课下载二进制文件
    **/
    public  String downloadFile(String fileId) throws IOException {

        if(fileId == null || fileId ==""){
            return "";
        }
        File file=null;
        InputStream fis=null;
        String realPath="";
        List<SysFile> sysFileList=sysFileService.getSysFile(fileId);
        for(SysFile s:sysFileList){
            if(s.getBlob_address()==null){
                break;
            }
            fis=(InputStream)s.getBlob_address();
            String  mine_type=s.getMimeType();
            String file_path=s.getFilePath();
            int first=file_path.indexOf("/uploads");
            int last=file_path.lastIndexOf("/");
            int extLocation=file_path.lastIndexOf(".");
            String dir=file_path.substring(first+1,last);
            String fileName=file_path.substring(last+1);
            File FileDir=new File(PathUtils.class.getResource("/").getPath()+dir);
            if (!FileDir.exists()) FileDir.mkdirs();
            if(mine_type.indexOf("image")<0){
                //office类型
                fileName+=file_path.substring(extLocation);
            }else{
                //图片类型
                if(fileName.indexOf(".")<0){
                    fileName+=".jpg";
                }
            }
            file=new File(FileDir,fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            realPath=file.getPath();
            OutputStream os=null;
            try {
                 os=new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int len = 0;
            byte[] b = new byte[1024];
            try {
                while ((len = fis.read(b)) > 0) {
                    os.write(b, 0, len);
                }
                fis.close();
                os.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return realPath;
}




    /**
     *二进制下载方法
     * @param filePath
     * @param fileName
     * @param blodAddress
     * @return
     * @throws IOException
     */
    public Map<String,String> downloadBinaryFile(String filePath,String fileName,Object blodAddress) throws IOException {
        Map<String, String> map = new HashMap<>();
        InputStream fis = null;
        OutputStream os = null;
        String realPath = "";
        int first = filePath.indexOf("/uploads");
        int last = filePath.lastIndexOf("/");
        String dir = filePath.substring(first + 1, last);
        File FileDir = new File(PathUtils.class.getResource("/").getPath() + dir);
        if (!FileDir.exists()){
            FileDir.mkdirs();
        }
        File file = new File(FileDir, fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        realPath = file.getPath();
        try {
            os = new FileOutputStream(file);
            if (blodAddress != null) {
                fis = (InputStream) blodAddress;
                int len = 0;
                byte[] b = new byte[1024];
                try {
                    while ((len = fis.read(b)) > 0) {
                        os.write(b, 0, len);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (os != null) {
                os.close();
            }
        }
        map.put("realPath",realPath);
        return map;
    }
}
