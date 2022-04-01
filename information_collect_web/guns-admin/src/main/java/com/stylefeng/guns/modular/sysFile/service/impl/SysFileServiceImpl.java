package com.stylefeng.guns.modular.sysFile.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.modular.system.model.SysFile;
import com.stylefeng.guns.modular.system.dao.SysFileMapper;
import com.stylefeng.guns.modular.sysFile.service.ISysFileService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhirongrui123
 * @since 2018-06-28
 */
@Service
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements ISysFileService {

    @Autowired
    private SysFileMapper sysFileMapper;

    @Override
    public List<SysFile> selectUrlByFileId(String val) {
        List<SysFile> list = sysFileMapper.selectList(
                new EntityWrapper<SysFile>().eq("file_id", val)
        );
        return list;
    }
    public List<SysFile> getSysFile(String fileId){
        return sysFileMapper.getSysFile(fileId);
    }

    @Override
    public SysFile getSysFileByFileId(String fileId) {
        return sysFileMapper.getSysFileByFileId(fileId);
    }


    @Override
    public List<SysFile> getMindReportFile(String userId, String partyStage) {
        return sysFileMapper.getMindReportFile(userId,partyStage);
    }

    @Override
    public List<SysFile> getPartyFile(String userId, String partyStage) {
        return sysFileMapper.getPartyFile(userId,partyStage);
    }
}
