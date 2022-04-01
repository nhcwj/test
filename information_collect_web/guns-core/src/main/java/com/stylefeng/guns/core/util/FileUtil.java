package com.stylefeng.guns.core.util;

import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.core.exception.GunsExceptionEnum;
import com.stylefeng.guns.core.util.type.TypeUtils;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileUtil {

    private static Logger log = LoggerFactory.getLogger(FileUtil.class);

    public static final int cache = 10 * 1024;
    /**
     * NIO way
     */
    public static byte[] toByteArray(String filename) {

        File f = new File(filename);
        if (!f.exists()) {
            log.error("文件未找到！" + filename);
            throw new GunsException(GunsExceptionEnum.FILE_NOT_FOUND);
        }
        FileChannel channel = null;
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(f);
            channel = fs.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            while ((channel.read(byteBuffer)) > 0) {
                // do nothing
                // System.out.println("reading");
            }
            return byteBuffer.array();
        } catch (IOException e) {
            throw new GunsException(GunsExceptionEnum.FILE_READING_ERROR);
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                throw new GunsException(GunsExceptionEnum.FILE_READING_ERROR);
            }
            try {
                fs.close();
            } catch (IOException e) {
                throw new GunsException(GunsExceptionEnum.FILE_READING_ERROR);
            }
        }
    }

    /**
     * 删除目录
     *
     * @author fengshuonan
     * @Date 2017/10/30 下午4:15
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    public static boolean isExist(File file) {
        if (file == null) {
            return false;
        }
        return file.exists();
    }

    public static String suffix(String name) {
        if (TypeUtils.empty(name) || name.lastIndexOf(".") == -1) return "";
        return name.substring(name.lastIndexOf("."));
    }

    public static boolean delete(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        return file.delete();
    }

    public static File getTemp() {
        String floader = System.getProperty("java.io.tmpdir");
        return new File(floader);
    }

    /**
     * 将流写入到文件中
     *
     * @param in
     * @param file 待保存文件的路径
     * @throws IOException
     */
    public static void toFile(InputStream in, File file) throws Exception {
//        if (file.exists()) {
//            throw new Exception("文件已经存在");
//        }

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();

        FileOutputStream out = new FileOutputStream(file);

        byte[] bytes = new byte[cache];
        int len = 0;
        while ((len = in.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
        in.close();
        out.flush();
        out.close();
    }
    public static byte[] downloadFile(String realPath) throws IOException {
        byte[] decodeByte=null;
        if (realPath != null) {
            //设置文件路径
            File file = new File(realPath);
            //File file = new File(realPath , fileName);
            if (file.exists()) {
                byte[] buffer = new byte[1024];
                InputStream is=new FileInputStream(file);
                String content=PathUtils.inputStream2String(is);
                decodeByte = Base64.decodeBase64(content);
            }
        }
        return decodeByte;
    }
}