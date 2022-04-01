package com.stylefeng.guns.util;

import com.alibaba.fastjson.JSONArray;
import com.stylefeng.guns.core.util.FileUtil;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author gjx
 * @description
 * @date 2022/1/10
 */
public class ExportUtilFormwork {

    private static List<String> CELL_HEAD_CN;
    private static List<String> CELL_HEAD_EN;
    private static final int ZIP_BUFFER_SIZE = 8192;
    private static final String FILE_PATH = System.getProperty("java.io.tmpdir") + File.separator;

    /**
     * @desc: exportList-数据集合
     *        CELL_HEAD_CN_X-列名
     *        CELL_HEAD_EN_X-对应字段
     *        fileName-导出的文件的名称
     * @author gjx
     * @date
     * @param  
     * @return 
     */
    public static void exportData(List<Map<String, Object>> exportList,List<String> CELL_HEAD_CN_X, List<String> CELL_HEAD_EN_X, HttpServletResponse response, String fileName) {

        CELL_HEAD_CN = CELL_HEAD_CN_X;
        CELL_HEAD_EN = CELL_HEAD_EN_X;
        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet = buildDataSheet(workbook);
        int rowNum=1;
        for(int i=0;i<exportList.size();i++){
            if(exportList.get(i)==null){
                continue;
            }
            Row row=sheet.createRow(rowNum++);
            convertDataToRow(exportList.get(i),row);
        }

        exportFormwork(response, fileName, workbook);
    }

    /**
     * 设置第一行格式
     *
     * @param workbook
     * @return
     */
    public static CellStyle buildHeadCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        //水平左边对齐
        style.setAlignment(HorizontalAlignment.LEFT);
        //垂直居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        //字体设置
        Font font = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);
        return style;
    }

    /**
     * 生成sheet表，并写入第一行数据（列头）
     *
     * @param workbook
     * @return
     */
    private static Sheet buildDataSheet(Workbook workbook) {
        Sheet sheet = workbook.createSheet();
        //设置默认行高
        sheet.setDefaultRowHeight((short) 400);
        CellStyle cellStyle = buildHeadCellStyle(workbook);
        //设置列头宽度，写入表头
        Row head = sheet.createRow(0);
        for (int i = 0; i < CELL_HEAD_CN.size(); i++) {
            sheet.setColumnWidth(i, 4000);
            Cell cell = head.createCell(i);
            cell.setCellValue(CELL_HEAD_CN.get(i));
            cell.setCellStyle(cellStyle);
            CellStyle textCellStyle = workbook.createCellStyle();
            //将所有列设为字符串格式
            textCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("@"));
            sheet.setDefaultColumnStyle(i, textCellStyle);
        }
        return sheet;
    }

    private static void convertDataToRow(Map<String, Object> data, Row row) {
        int cellNum = 0;
        Cell cell;
        for(int i=0;i<CELL_HEAD_CN.size();i++){
            cell=row.createCell(cellNum++);
            if(data.get(CELL_HEAD_EN.get(i))!=null){

                if(data.get(CELL_HEAD_EN.get(i)).toString().length()>32767){
                    JSONArray jsonArray=JSONArray.parseArray(data.get(CELL_HEAD_EN.get(i)).toString());
                    cell.setCellValue(jsonArray.getString(0));
                }else {
                    cell.setCellValue(data.get(CELL_HEAD_EN.get(i)).toString());
                }

            }else{
                cell.setCellValue("--");
            }

        }
    }


    /**
     * 通过单号判断日期，获取month个月内的所有单号
     *
     * @param dataList
     * @param interval
     * @return
     */
    public static List<String> getLimitTimeOrder(List<String> dataList, int interval) {
        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        int month;
        List<String> result = new ArrayList<>();
        for (String num : dataList) {
            System.out.println(num);
            String[] temp = num.split("-");
            String str = temp[temp.length-2];
            System.out.println(str);
            str = str.substring(4, 6);
            month = Integer.parseInt(str);
            System.out.println(str + "---" + month);
            if (currentMonth - month < interval) {
                result.add(num);
            }
        }
        return result;
    }



    public static void zipDownload(HttpServletResponse response, String zipFileName, List<File> fileList) {
        // zip文件路径
        String zipPath = FILE_PATH + zipFileName;
        try {
            //创建zip输出流
            try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipPath))) {
                //声明文件集合用于存放文件
                byte[] buffer = new byte[1024];
                //将文件放入zip压缩包
                for (int i = 0; i < fileList.size(); i++) {
                    File file = fileList.get(i);
                    try (FileInputStream fis = new FileInputStream(file)) {
                        out.putNextEntry(new ZipEntry(file.getName()));
                        int len;
                        // 读入需要下载的文件的内容，打包到zip文件
                        while ((len = fis.read(buffer)) > 0) {
                            out.write(buffer, 0, len);
                        }
                        out.closeEntry();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println(FileUtil.delete(file));
                }
            }
            //下载zip文件
            downFile(response, zipFileName);
        } catch (Exception e) {
        } finally {
            // zip文件也删除
            fileList.add(new File(zipPath));
//            deleteFile(fileList);
        }
    }
    private static void downFile(HttpServletResponse response, String zipFileName) {
        try {
            String path = FILE_PATH + zipFileName;
            File file = new File(path);
            if (file.exists()) {
                try (InputStream ins = new FileInputStream(path);
                     BufferedInputStream bins = new BufferedInputStream(ins);
                     OutputStream outs = response.getOutputStream();
                     BufferedOutputStream bouts = new BufferedOutputStream(outs)) {
                    response.setContentType("application/x-download");
                    response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(zipFileName, "UTF-8"));
                    int bytesRead = 0;
                    byte[] buffer = new byte[ZIP_BUFFER_SIZE];
                    while ((bytesRead = bins.read(buffer, 0, ZIP_BUFFER_SIZE)) != -1) {
                        bouts.write(buffer, 0, bytesRead);
                    }
                    bouts.flush();
                }
            }
        } catch (Exception e) {
        }
    }

    public static void exportFormwork(HttpServletResponse response, String fileName, Workbook workbook){
        String fileNameURL = null;
        try {
            fileNameURL = URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream fos = null;
        byte[] retArr = null;
        try {
            fos = new ByteArrayOutputStream();
            workbook.write(fos);
            retArr = fos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        OutputStream os = null;
        try {
            os = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            response.reset();
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.setHeader("Content-disposition", "attachment;filename="+fileNameURL+";"+"filename*=utf-8''"+fileNameURL);
            os.write(retArr);
            os.flush();
        }catch (IOException e){

        } finally{
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
