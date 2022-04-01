package com.stylefeng.guns.modular.gunsFile.controller.service;

import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.system.model.GunsFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huanbiao
 * @since 2018-08-13
 */
public interface IGunsFileService extends IService<GunsFile> {

    List<GunsFile> selectUrlByFileId(String val);

    GunsFile getGunsFileByfileId(String fileId);

    Boolean delRecordFile(String gunFileId);

    String getFiles(String s);
}
