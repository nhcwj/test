package com.stylefeng.guns.modular.gunsFile.controller.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.core.util.type.StringUtils;
import com.stylefeng.guns.modular.gunsFile.controller.service.IGunsFileService;
import com.stylefeng.guns.modular.system.dao.GunsFileMapper;
import com.stylefeng.guns.modular.system.model.GunsFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangbiao
 * @since 2018-08-13
 */
@Service
public class GunsFileServiceImpl extends ServiceImpl<GunsFileMapper, GunsFile> implements IGunsFileService {

    @Autowired
    private GunsFileMapper gunsFileMapper;

    @Override
    public List<GunsFile> selectUrlByFileId(String val) {
        List<GunsFile> list = gunsFileMapper.selectList(
                new EntityWrapper<GunsFile>().eq("file_id", val)
        );
        return list;
    }
    @Override
    public GunsFile getGunsFileByfileId(String fileId){
        return gunsFileMapper.getGunsFileByfileId(fileId);
    }

    @Override
    public Boolean delRecordFile(String gunFileId) {
        Integer deleteNum = gunsFileMapper.delRecordFile(gunFileId);
        if(deleteNum ==0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String getFiles(String files) {
        if (StringUtils.isBlank(files)){
            return null;
        }
        List<Map<String,Object>> fileMaps=new ArrayList<>();
        if(files!=null && files.length()>0){
            String[] fileStr=files.split(",");
            List<String> fileList= Arrays.asList(fileStr);
            for(Integer i=0;i<fileList.size();i++){
                Map<String,Object> map=new HashMap<>();
                GunsFile file=getGunsFileByfileId(fileList.get(i));
                map.put("file_name",file.getFilename());
                map.put("file_path",file.getFilePath());
                fileMaps.add(map);
            }
            return JSON.toJSONString(fileMaps);
        }else{
            return "";
        }
    }
}
