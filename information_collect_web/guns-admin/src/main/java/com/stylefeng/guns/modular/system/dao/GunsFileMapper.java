package com.stylefeng.guns.modular.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.modular.system.model.GunsFile;
import com.stylefeng.guns.modular.system.model.SysFile;
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
public interface GunsFileMapper extends BaseMapper<GunsFile> {
    GunsFile getGunsFileByfileId(@Param("fileId") String fileId);

    Integer delRecordFile(@Param("gunFileId") String gunFileId);
}
