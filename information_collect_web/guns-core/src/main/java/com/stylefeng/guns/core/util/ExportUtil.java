/*
package com.stylefeng.guns.core.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.*;

*/
/**
 * author zhirongrui
 * time 2018/6/11
 * 导出工具类
 *//*

public class ExportUtil {

    */
/**
     * 创建Excel文件
     *
     * @param excelPath excel文件的存放路径
     * @param version   excel版本（2003/2007）
     * @param name      excel文件名
     * @return
     * @throws IOException
     *//*

    public static Workbook creatExcel(String excelPath, String version, String name,String titleName, String[] head, Map<String,List> excelData) throws IOException {
        // XSSFWork used for .xslx (>=2007), HSSWorkbook for 03 .xsl
        Workbook workbook = null;
        if (version.equals("2007")) {
            workbook = new XSSFWorkbook();// 创建 一个excel文档对象
        } else if (version.equals("2003")) {
            workbook = new HSSFWorkbook();// 创建 一个excel文档对象
        }
        Sheet sheet = workbook.createSheet(name);// 创建一个工作薄对象
        //创建表头
        Row row0 = sheet.createRow(0);// 创建一个行对象,0行
        row0.setHeightInPoints(50);// 设置标题的高度
        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        titleStyle.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
        titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        Font font = workbook.createFont(); // 创建字体对象
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗
        font.setFontName("黑体"); // 设置字体类型
        font.setFontHeightInPoints((short) 15); // 设置字体大小
        titleStyle.setFont(font); // 为标题样式设置字体样式
        Cell cell0 = row0.createCell(0);//创建标题第一列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,7));// 合并列标题
        cell0.setCellValue(titleName);//设置值标题
        cell0.setCellStyle(titleStyle);//设置标题的样式

        */
/*****创建第一行*****//*

        Row row1 = sheet.createRow(1);
        row1.setHeightInPoints(37);// 设置表头高度

        // 第四步，创建表头单元格样式 以及表头的字体样式
        CellStyle headStyle = workbook.createCellStyle();
        headStyle.setWrapText(true);// 设置自动换行
        headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        headStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式

        headStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        headStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        headStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

        Font headerFont = workbook.createFont(); // 创建字体样式
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗
        headerFont.setFontName("黑体"); // 设置字体类型
        headerFont.setFontHeightInPoints((short) 10); // 设置字体大小
        headStyle.setFont(headerFont); // 为标题样式设置字体样式

        // 第四.一步，创建表头的列
        for (int i = 0; i < head.length; i++) {
            Cell cell1 = row1.createCell(i);
            cell1.setCellValue(head[i]);
            cell1.setCellStyle(headStyle);
        }
        //第5，循环导出数据建立单元格值
        int num = 1;//从第2行开始
        for(Map.Entry<String, List> entry : excelData.entrySet()){
            num++;
            row1 = sheet.createRow(num);
            List list = entry.getValue();
            for(int i=0;i<list.size();i++){//遍历VALUE
                //创建列
                String list_i = list.get(i).toString();
                row1.createCell(i).setCellValue(list_i);
                if(list_i != null && list_i.length() > 0){
                    sheet.setColumnWidth(i, list_i.length() * 712);
                }
            }
        }
        FileOutputStream outputStream = new FileOutputStream(excelPath + "\\" + name + ".xls");
        workbook.write(outputStream);// 将文档对象写入文件输出流
        outputStream.close();// 关闭文件输出流
        System.out.println("创建成功 office excel");
       return workbook;
    }

    */
/**
     * 设置样式
     *
     * @param workbook
     * @return
     *//*

    private static CellStyle getStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();// 创建样式对象
        // 设置对齐方式
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);// 水平居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中

        // 设置边框
        style.setBorderTop(HSSFCellStyle.BORDER_THICK);// 顶部边框粗线
        style.setTopBorderColor(HSSFColor.RED.index);// 设置为红色
        style.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);// 底部边框双线
        style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);// 左边边框
        style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);// 右边边框

        style.setWrapText(true);// 设置单元格内容是否自动换行
        // 格式化日期
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        // 设置单元格字体
        Font font = workbook.createFont(); // 创建字体对象
        font.setFontHeightInPoints((short) 14);// 设置字体大小
        font.setColor(HSSFColor.RED.index);// 设置字体颜色
        font.setFontName("宋体");// 设置为宋体字
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 设置粗体
        style.setFont(font);// 将字体加入到样式对象

        return style;
    }

    */
/**
     * 读取excel
     *
     * @param fileName
     * @return 行<列>
     * @throws IOException
     *//*

    private static List<List<Object>> readExcel(String fileName) throws IOException {
        File file = new File(fileName);
        Workbook wb = null;
        if (fileName.endsWith(".xlsx")) {// 2007
            wb = new XSSFWorkbook(new FileInputStream(file));// 创建 一个excel文档对象
        } else if (fileName.endsWith(".xls")) {// 2003
            wb = new HSSFWorkbook(new FileInputStream(file));// 创建 一个excel文档对象
        }

        Sheet sheet = wb.getSheetAt(0);// 读取第一个sheet页表格内容
        Object value = null;
        Row row = null;
        Cell cell = null;
        System.out.println("读取office 2007 excel内容如下：");
        //        System.out.println(sheet.getPhysicalNumberOfRows());// 获取的是物理行数，也就是不包括那些空行（隔行）的情况。
        //        System.out.println(sheet.getLastRowNum());// 获取的是最后一行的编号（编号从0开始）
        // 行
        List<List<Object>> rowlist = new LinkedList<List<Object>>();
        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            // 列
            List<Object> cellList = new LinkedList<Object>();
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                if (cell == null) {
                    continue;
                }

                DecimalFormat df = new DecimalFormat("0");// 格式化 number String
                DecimalFormat nf = new DecimalFormat("0.00");// 格式化数字
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
                switch (cell.getCellType()) {
                    case XSSFCell.CELL_TYPE_STRING:// 字符串——String type
                        value = cell.getStringCellValue();
                        break;
                    case XSSFCell.CELL_TYPE_NUMERIC:// 数字——Number type
                        if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                            value = df.format(cell.getNumericCellValue());
                        } else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                            value = nf.format(cell.getNumericCellValue());
                        } else {
                            value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                        }
                        break;
                    case XSSFCell.CELL_TYPE_BOOLEAN:// boolean——Boolean type
                        value = cell.getBooleanCellValue();
                        break;
                    case XSSFCell.CELL_TYPE_BLANK:// 空白——Blank type
                        value = "";
                        break;
                    default:// default type
                        value = cell.toString();
                }
                if (value == null || "".equals(value)) {
                    continue;
                }
                cellList.add(value);
            }
            rowlist.add(cellList);
        }
        return rowlist;
    }


    */
/**
     *
     * @Description 弹出下载提示框
     * @author        <p style="color:#8e8e8e;font-family:微软雅黑;font-size=16px;font-weight:bold;">Cloud</p>
     * @date        <p style="color:#000;font-family:微软雅黑;font-size=16px;">2016-11-25下午1:25:51</p>
     * @param response    请求头信息
     * @param fileName      文件名称
     * @throws IOException
     *//*

    public static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
