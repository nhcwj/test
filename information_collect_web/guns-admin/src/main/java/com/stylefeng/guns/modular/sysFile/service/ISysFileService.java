package com.stylefeng.guns.modular.sysFile.service;

import com.stylefeng.guns.modular.system.model.SysFile;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhirongrui123
 * @since 2018-06-28
 */
public interface ISysFileService extends IService<SysFile> {

    List<SysFile> selectUrlByFileId(String val);
    List<SysFile> getSysFile(String fileId);
    SysFile getSysFileByFileId(String fileId);
    /**
     * 获取发展党员的思想汇报文件
     * @param userId
     * @param partyStage
     * @return
     */
    List<SysFile> getMindReportFile(String userId,String partyStage);

    /**
     * 获取发展党员文件
     * @param userId
     * @param partyStage
     * @return
     */
    List<SysFile> getPartyFile(String userId,String partyStage);
}
