package com.stylefeng.guns.util;

import com.aspose.words.Document;
import com.aspose.words.ImageSaveOptions;
import com.aspose.words.SaveFormat;
import com.stylefeng.guns.modular.system.model.fileDomainVO;

import java.io.File;
import java.io.FileOutputStream;

/**
 *  office工具类
 *  author : huangbiao
**/
public class WordUtil {
    
    /**
    *word转换成pdf
    **/
    public static void WordToPdf(String Details,String InputFile,String OutputFile,String fileName){
        fileDomainVO vo = new fileDomainVO();
        vo.setDetail(Details);
        vo.setInputfile(InputFile);
        vo.setOutputfile(OutputFile);
        vo.setFileNameAfter(fileName);
        Document doc=null;
        try {
            //初始化定义
            File file =null;
            ImageSaveOptions iso = null;
            //输出流
            FileOutputStream os =null;
            //判断是否转换图片
            //file.mkdirs();
            //新建一个空白文档
            file = new File(vo.getOutputfile());
            //创建文件夹
            file.mkdirs();
            file = new File(vo.getOutputfile()+vo.getFileNameAfter());
            if(file.exists()){
                return;
            }
            os = new FileOutputStream(file);
            //getInputfile是将要被转化文档
            doc = new Document(vo.getInputfile());
            //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
            //------------------------------------------逻辑判断
            //>>>>>>DocToPDF
            if(Details.equals("DocToPDF")){
                doc.save(os, SaveFormat.PDF);
            }//>>>>>>DocToDocx
            else if(vo.getDetails().equals(com.stylefeng.guns.modular.system.model.Details.DocToDocx)){
                doc.save(os, SaveFormat.DOCX);
            }//>>>>>>DocToTexT
            else if(vo.getDetails().equals(com.stylefeng.guns.modular.system.model.Details.DocToTexT)){
                doc.save(os, SaveFormat.TEXT);
            }//>>>>>>DocToXps
            else if(vo.getDetails().equals(com.stylefeng.guns.modular.system.model.Details.DocToXps)){
                doc.save(os, SaveFormat.XPS);
            }//>>>>>>HtmlToDoc
            else if(vo.getDetails().equals(com.stylefeng.guns.modular.system.model.Details.HtmlToDoc)){
                doc.save(os, SaveFormat.DOC);
            }//>>>>>>DocToJPEG
            else if(vo.getDetails().equals(com.stylefeng.guns.modular.system.model.Details.DocToJPEG)){
                //iso.setResolution(128);
                iso.setPrettyFormat(true);
                iso.setUseAntiAliasing(true);
                for (int i = 0; i < doc.getPageCount(); i++)
                {
                    iso.setPageIndex(i);
                    doc.save(vo.getOutputfile() + vo.getFileNameAfter() +"---"+(i+1)+ ".jpeg", iso);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
