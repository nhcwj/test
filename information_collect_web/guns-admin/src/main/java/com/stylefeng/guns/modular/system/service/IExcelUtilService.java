package com.stylefeng.guns.modular.system.service;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;

public interface IExcelUtilService {

    public <T> void downloadExcel(HttpServletRequest request, HttpServletResponse response, String sheetName, List<T> dataset);

    public void uploadExcel(HttpServletRequest request, HttpServletResponse response, MultipartFile[] fileList) throws Exception;
}
