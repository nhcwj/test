package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.SysFile;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhirongrui123
 * @since 2018-06-28
 */
@Component
public interface SysFileMapper extends BaseMapper<SysFile> {
    List<SysFile> getSysFile(@Param("fileId")String fileId);

    List<SysFile> getMindReportFile(@Param("userId") String userId,@Param("partyStage") String partyStage);

    List<SysFile> getPartyFile(@Param("userId") String userId,@Param("partyStage") String partyStage);

    SysFile getSysFileByFileId(@Param("fileId")String fileId);
}
