package com.stylefeng.guns.modular.informationCollect;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.base.tips.ErrorTip;
import com.stylefeng.guns.core.base.tips.SuccessTip;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.core.util.FileUtil;
import com.stylefeng.guns.core.util.type.StringUtils;
import com.stylefeng.guns.modular.gunsFile.controller.service.IGunsFileService;
import com.stylefeng.guns.modular.system.dao.GunsFileMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.FileListMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.FileRoleMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.InformationCollectMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.ProcessFileMapper;
import com.stylefeng.guns.modular.system.model.GunsFile;
import com.stylefeng.guns.modular.system.model.informationCollect.FileList;
import com.stylefeng.guns.modular.system.model.informationCollect.FileRole;
import com.stylefeng.guns.modular.system.model.informationCollect.InformationCollect;
import com.stylefeng.guns.modular.system.model.informationCollect.ProcessFile;
import com.stylefeng.guns.modular.system.service.impl.InformationCollectOrderLogServiceImpl;
import com.stylefeng.guns.util.ExportUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/informationFile")
public class informationFileController {
    private String PREFIX = "/informationCollect/";

    @Autowired
    private FileListMapper fileListMapper;
    @Autowired
    private ProcessFileMapper processFileMapper;
    @Autowired
    private IGunsFileService iGunsFileService;
    @Autowired
    private InformationCollectMapper informationCollectMapper;
    @Autowired
    private GunsFileMapper gunsFileMapper;

    @RequestMapping("/file_manager")
    public String file_manager() {
        return PREFIX + "file/file_manager.html";
    }

    @RequestMapping("/getFileList")
    @ResponseBody
    public List<FileList> getFileList(FileList fileList) {
        EntityWrapper<FileList> entityWrapper = new EntityWrapper();
        if (fileList.getProject_state() != null && !fileList.getProject_state().equals("")) {
            entityWrapper.eq("project_state", fileList.getProject_state());
        }
        if (fileList.getIs_need() != null && !fileList.getIs_need().equals("")) {
            entityWrapper.eq("is_need", fileList.getIs_need());
        }
        if (fileList.getFile_name() != null && !fileList.getFile_name().equals("")) {
            entityWrapper.like("file_name", fileList.getFile_name());
        }
        List<FileList> list = fileListMapper.selectList(entityWrapper);
        return list;

    }

    @Autowired
    private FileRoleMapper fileRoleMapper;

    @RequestMapping("/getFileListByOrderId_normal")
    @ResponseBody
    public List<Map<String, Object>> getFileListByOrderId_normal(Integer id, FileList fileList) {
        List<Map<String, Object>> list = new ArrayList<>();
        EntityWrapper<FileList> entityWrapper = new EntityWrapper();

//        ?????????
        entityWrapper.eq("status", "??????");
        if (fileList.getProject_state() != null && !fileList.getProject_state().equals("")) {
            entityWrapper.eq("project_state", fileList.getProject_state());
        }
        if (fileList.getIs_need() != null && !fileList.getIs_need().equals("")) {
            entityWrapper.eq("is_need", fileList.getIs_need());
        }
        if (fileList.getFile_name() != null && !fileList.getFile_name().equals("")) {
            entityWrapper.like("file_name", fileList.getFile_name());
        }
//        //        ????????????
//        EntityWrapper<FileRole> fileRoleEntityWrapper = new EntityWrapper<>();
//        fileRoleEntityWrapper.eq("information_id", id);
//        //        ????????????????????????
//        List<FileRole> fileRoleList = fileRoleMapper.selectList(fileRoleEntityWrapper);
//        if (fileRoleList.size() > 0) {
//            entityWrapper.andNew();
//            List<String> fileroleid = Arrays.asList(fileRoleList.get(0).getFile_id().split(","));
//            for (String fileRole : fileroleid) {
//                entityWrapper.eq("id", fileRole).or();
//            }
//            entityWrapper.eq("1", "2");
//        } else {
//            entityWrapper.eq("1", "2");
//        }

        List<FileList> fileLists = fileListMapper.selectList(entityWrapper);
        for (FileList file : fileLists) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", file.getId());
            map.put("file_name", file.getFile_name());
            map.put("project_state", file.getProject_state());
            map.put("is_need", file.getIs_need());
            map.put("status", file.getStatus());
            EntityWrapper<ProcessFile> processFileEntityWrapper = new EntityWrapper<>();
            processFileEntityWrapper.eq("information_id", id);
            processFileEntityWrapper.eq("file_list_id", file.getId());
            List<ProcessFile> processFileList = processFileMapper.selectList(processFileEntityWrapper);
            List<GunsFile> gunsFileList = new ArrayList<>();
            if (processFileList.size() > 0) {
                List<String> files = Arrays.asList(processFileList.get(0).getFile().split(","));
                for (String filesid : files) {
                    GunsFile file1 = iGunsFileService.getGunsFileByfileId(filesid);
                    if (file1 != null) {
                        gunsFileList.add(file1);
                    }
                }
            }
            map.put("file_map", gunsFileList);
            list.add(map);

        }
        return list;
    }


    @RequestMapping("/choose_file")
    public String choose_file(Integer id, Model model) {
        model.addAttribute("id", id);
        return PREFIX + "file/choose_file.html";
    }

    @RequestMapping("/update_fileRole")
    @ResponseBody
    public Tip update_fileRole(Integer id, String file_list_id) {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("information_id", id);
        List<FileRole> fileRoleList = fileRoleMapper.selectList(entityWrapper);
        if (fileRoleList.size() > 0) {
            FileRole fileRole = fileRoleList.get(0);
            fileRole.setFile_id(file_list_id);
            fileRoleMapper.updateById(fileRole);
        } else {
            FileRole fileRole = new FileRole();
            fileRole.setFile_id(file_list_id);
            fileRole.setInformation_id(id);
            fileRoleMapper.insert(fileRole);
        }
        return new SuccessTip();
    }


    @RequestMapping("/getFileListByOrderId")
    @ResponseBody
    public List<Map<String, Object>> getFileListByOrderId(Integer id, FileList fileList) {
        List<Map<String, Object>> list = new ArrayList<>();
        EntityWrapper<FileList> entityWrapper = new EntityWrapper();
        if (fileList.getProject_state() != null && !fileList.getProject_state().equals("")) {
            entityWrapper.eq("project_state", fileList.getProject_state());
        }
        if (fileList.getIs_need() != null && !fileList.getIs_need().equals("")) {
            entityWrapper.eq("is_need", fileList.getIs_need());
        }
        if (fileList.getFile_name() != null && !fileList.getFile_name().equals("")) {
            entityWrapper.like("file_name", fileList.getFile_name());
        }
        List<FileList> fileLists = fileListMapper.selectList(entityWrapper);
        for (FileList file : fileLists) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", file.getId());
            map.put("file_name", file.getFile_name());
            map.put("project_state", file.getProject_state());
            map.put("is_need", file.getIs_need());
            map.put("status", file.getStatus());
            EntityWrapper<ProcessFile> processFileEntityWrapper = new EntityWrapper<>();
            processFileEntityWrapper.eq("information_id", id);
            processFileEntityWrapper.eq("file_list_id", file.getId());
            List<ProcessFile> processFileList = processFileMapper.selectList(processFileEntityWrapper);
            List<GunsFile> gunsFileList = new ArrayList<>();
            if (processFileList.size() > 0) {
                List<String> files = Arrays.asList(processFileList.get(0).getFile().split(","));
                for (String filesid : files) {
                    GunsFile file1 = iGunsFileService.getGunsFileByfileId(filesid);
                    if (file1 != null) {
                        gunsFileList.add(file1);
                    }
                }
            }
            map.put("file_map", gunsFileList);
            list.add(map);

        }
        return list;
    }

    @RequestMapping("/uploadFileById")
    public String uploadFileById(Integer id, Integer informationId, Model model) {
        model.addAttribute("order_id", informationId);
        model.addAttribute("id", id);
        return PREFIX + "file/upload_file.html";
    }

    @RequestMapping("/download_file")
    @ResponseBody
    public byte[] download_file(String filePath) {

        try {
            return FileUtil.downloadFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Autowired
    InformationCollectOrderLogServiceImpl informationCollectOrderLogService;

    @RequestMapping("/update_file")
    @ResponseBody
    public Tip update_file(String file_str, Integer informationId, Integer id) {
        EntityWrapper<ProcessFile> entityWrapper = new EntityWrapper();
        entityWrapper.eq("file_list_id", id);
        entityWrapper.eq("information_id", informationId);
        List<ProcessFile> list = processFileMapper.selectList(entityWrapper);
        if (list.size() > 0) {
            ProcessFile processFile = list.get(0);
            if (!processFile.getFile().contains(file_str)) {
                String filelist = processFile.getFile() + "," + file_str;
                processFile.setFile(filelist);
                processFileMapper.updateById(processFile);
                informationCollectOrderLogService.insertLog(informationId, "????????????", "????????????");
            }
        } else {
            ProcessFile processFile = new ProcessFile();
            processFile.setFile_list_id(id);
            processFile.setFile(file_str);
            processFile.setInformation_id(informationId);
            processFileMapper.insert(processFile);
            informationCollectOrderLogService.insertLog(informationId, "????????????", "????????????");
        }
        return new SuccessTip();
    }

    @RequestMapping("/file_add")
    public String file_add() {
        return PREFIX + "file/file_add.html";
    }

    @RequestMapping("/insert_fileList")
    @ResponseBody
    public Tip insert_fileList(FileList fileList) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(new Date());
        fileList.setAdd_time(time);
        if (fileList.getFile_name() != null && !fileList.getFile_name().equals("")) {
            fileListMapper.insert(fileList);
            return new SuccessTip();
        } else {
            return new ErrorTip(500, "??????");
        }

    }

    @RequestMapping("/update_fileStatus")
    @ResponseBody
    public Tip update_fileStatus(String status, String id) {
        if (id != null && !id.equals("")) {
            FileList fileList = fileListMapper.selectById(id);
            if (fileList != null) {
                fileList.setStatus(status);
                fileListMapper.updateById(fileList);
                return new SuccessTip();
            }

        }
        return new ErrorTip(500, "??????");
    }

    @RequestMapping("/all_file_list")
    public String all_file_list() {
        return PREFIX + "all_file_list.html";
    }

    @RequestMapping("/getAllFileList")
    @ResponseBody
    public List<Map<String, Object>> getAllFileList(String project_stage, String DICI_system_num, String file_name, String project_name) {
        //????????????process_file????????????
        List<Map<String, Object>> processFile = processFileMapper.selectMaps(null);
        //??????????????????informationCollect???????????????????????????
        List<Map<String, Object>> collect = new ArrayList<>();
        //??????????????????gun_file???????????????????????????
        List<Map<String, Object>> file = new ArrayList<>();
        //??????informationCollect?????????????????????????????????????????????????????????????????????
        List<Map<String, Object>> filePackage = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(processFile)) {
            //??????processFile?????????information_id???file_list_id???file????????????????????????????????????
            for (Map<String, Object> map : processFile) {
                boolean flag = false;
                String informationId = map.get("information_id").toString();
                //??????information_id??????????????????????????????????????????collect??????????????????????????????
                if (CollectionUtils.isNotEmpty(collect)) {
                    for (Map<String, Object> temp : collect) {
                        if (informationId.equals(temp.get("id").toString())) {
                            map.put("project_name", temp.get("project_name").toString() != null ? temp.get("project_name") : null);
                            map.put("project_money", temp.get("project_money").toString() != null ? temp.get("project_money") : null);
                            map.put("project_stage", temp.get("project_stage").toString() != null ? temp.get("project_stage") : null);
                            map.put("DICI_system_num", temp.get("DICI_system_num").toString() != null ? temp.get("DICI_system_num") : null);
                            flag = true;
                            break;
                        }
                    }
                }
                //?????????collect??????????????????information_id???informationCollect???????????????????????????????????????collect???
                if (!flag) {
                    EntityWrapper<InformationCollect> entityWrapper = new EntityWrapper<>();
                    entityWrapper.eq("id", Integer.parseInt(informationId));
                    List<Map<String, Object>> temp = informationCollectMapper.selectMaps(entityWrapper);
                    if (CollectionUtils.isNotEmpty(temp)) {
                        map.put("project_name", temp.get(0).get("project_name").toString() != null ? temp.get(0).get("project_name") : null);
                        map.put("project_money", temp.get(0).get("project_money").toString() != null ? temp.get(0).get("project_money") : null);
                        map.put("project_stage", temp.get(0).get("project_stage").toString() != null ? temp.get(0).get("project_stage") : null);
                        map.put("DICI_system_num", temp.get(0).get("DICI_system_num").toString() != null ? temp.get(0).get("DICI_system_num") : null);
                        collect.add(temp.get(0));
                    }
                }
                //??????file_list_id???j_file_list??????file_name??????????????????
                if (map.get("file_list_id") != null) {
                    EntityWrapper<FileList> entityWrapper = new EntityWrapper<>();
                    entityWrapper.eq("id", map.get("file_list_id"));
                    List<Map<String, Object>> fileList = fileListMapper.selectMaps(entityWrapper);
                    map.put("file_name", fileList.get(0).get("file_name"));
                }
                //???process_file??????file???fileId??????????????????
                if (map.get("file") != null) {
                    flag = false;
                    String fileStr = map.get("file").toString();
                    String[] fileArray = {};
                    String newFileStr = "";
                    filePackage = new ArrayList<>();
                    if (fileStr.contains(",")) {
                        fileArray = fileStr.split(",");
                        if (fileArray.length > 0) {
                            //??????process_file???file????????????file_id??????file
                            for (String s : fileArray) {
                                flag = false;
                                //????????????gun_file?????????fileArray????????????????????????????????????????????????
                                if (CollectionUtils.isNotEmpty(file)) {
                                    for (Map<String, Object> m : file) {
                                        if (s.equals(m.get("file_id").toString())) {
                                            newFileStr = newFileStr + m.get("filename").toString() + ",";
                                            filePackage.add(m);
                                            //???????????????fileArray???????????????filename
                                            flag = true;
                                            break;
                                        }
                                    }
                                }
                                //????????????????????????fileArray??????????????????????????????
                                if (!flag) {
                                    EntityWrapper<GunsFile> entityWrapper = new EntityWrapper<>();
                                    entityWrapper.eq("file_id", s);
                                    List<Map<String, Object>> temp = gunsFileMapper.selectMaps(entityWrapper);
                                    //?????????gun_file????????????file??????????????????filename??????newFileStr???
                                    if (CollectionUtils.isNotEmpty(temp)) {
                                        Map<String, Object> objectMap = new HashMap<>();
                                        if (temp.get(0).get("filename") != null) {
                                            //??????????????????gun_file??????file???
                                            objectMap.put("file_id", s);
                                            objectMap.put("filename", temp.get(0).get("filename").toString());
                                            objectMap.put("file_path", temp.get(0).get("filePath").toString());
                                            filePackage.add(objectMap);
                                            file.add(objectMap);
                                            newFileStr = newFileStr + temp.get(0).get("filename").toString() + ",";
                                        }
                                        flag = true;
                                    }
                                }
                            }
                        }
                        //?????????????????????????????????????????????????????????????????????
                        if (CollectionUtils.isNotEmpty(filePackage)) {
                            map.put("files", JSON.toJSONString(filePackage));
                        } else {
                            map.put("files", null);
                        }
                    } else {
                        filePackage = new ArrayList<>();
                        //???process_file??????file??????","??????????????????
                        if (CollectionUtils.isNotEmpty(file)) {
                            flag = false;
                            for (Map<String, Object> m : file) {
                                if (fileStr.equals(m.get("file_id").toString())) {
                                    newFileStr = newFileStr + m.get("filename").toString() + ",";
                                    filePackage.add(m);
                                    flag = true;
                                    break;
                                }
                            }
                            if (!flag) {
                                EntityWrapper<GunsFile> entityWrapper = new EntityWrapper<>();
                                entityWrapper.eq("file_id", fileStr);
                                List<Map<String, Object>> temp = gunsFileMapper.selectMaps(entityWrapper);
                                //?????????gun_file????????????file??????????????????filename??????newFileStr???
                                if (CollectionUtils.isNotEmpty(temp)) {
                                    Map<String, Object> objectMap = new HashMap<>();
                                    if (temp.get(0).get("filename") != null) {
                                        //??????????????????gun_file??????file???
                                        objectMap.put("file_id", fileStr);
                                        objectMap.put("filename", temp.get(0).get("filename").toString());
                                        objectMap.put("file_path", temp.get(0).get("filePath").toString());
                                        file.add(objectMap);
                                        filePackage.add(objectMap);
                                        newFileStr = newFileStr + temp.get(0).get("filename").toString() + ",";
                                    }
                                    flag = true;
                                }
                            }
                        }
                        //?????????????????????????????????????????????????????????????????????
                        if (CollectionUtils.isNotEmpty(filePackage)) {
                            map.put("files", JSON.toJSONString(filePackage));
                        } else {
                            map.put("files", null);
                        }
                    }
                    if (flag) {
                        map.put("fileName", newFileStr);
                    } else {
                        map.put("filename", "??????");
                    }
                }
            }
        }
        Iterator<Map<String, Object>> iterator = processFile.iterator();
        while (iterator.hasNext()) {
            Map<String, Object> map = iterator.next();
            if (StringUtils.isNotEmpty(project_stage)) {
                if (project_stage.contains(",")) {
                    String[] stageArray = project_stage.split(",");
                    if (!Arrays.asList(stageArray).contains(map.get("project_stage").toString())) {
                        iterator.remove();
                        continue;
                    }
                } else {
                    if (!map.get("project_stage").toString().contains(project_stage)) {
                        iterator.remove();
                        continue;
                    }
                }
            }
            if (StringUtils.isNotEmpty(DICI_system_num)) {
                if (!map.get("DICI_system_num").toString().contains(DICI_system_num)) {
                    iterator.remove();
                    continue;
                }
            }
            if (StringUtils.isNotEmpty(file_name)) {
                if (!map.get("file_name").toString().contains(file_name)) {
                    iterator.remove();
                    continue;
                }
            }
            if (StringUtils.isNotEmpty(project_name)) {
                if (!map.get("project_name").toString().contains(project_name)) {
                    iterator.remove();
                }
            }
        }
        return processFile;
    }

    @RequestMapping("/process_file_list")
    public String process_file_list() {
        return PREFIX + "file/process_file_list.html";
    }

    /**
     * j_process_file,f_information_collect,j_file_list,t_guns_file????????????
     * @param projectName f_information_collect???project_name
     * @param systemNum f_information_collect???DICI_system_num
     * @param fileName j_file_list???file_name
     * @param filename t_guns_file???filename
     * @return
     */
    @RequestMapping("/getProcessFileList")
    @ResponseBody
    public Object getProcessFileList(String projectName,String systemNum, String fileName, String filename) {
        List<Map<String, Object>> processFileList = processFileMapper.selectMaps(null);
        List<Map<String, Object>> informationCollectList = informationCollectMapper.selectMaps(null);
        List<Map<String, Object>> fileListList = fileListMapper.selectMaps(null);
        List<Map<String, Object>> gunFileList = gunsFileMapper.selectMaps(null);
        //????????????????????????gunFile,????????????,key??????fileId,value??????file???name
        List<Map<String,Object>> repeatFileList=new ArrayList<>();
        //?????????????????????map
        Map<String, Object> answerMap;
        List<Map<String, Object>> mapList = new ArrayList<>();
        //??????
        for (Map<String, Object> map : processFileList) {
            answerMap = new HashMap<>();
            String informationCollectId = map.get("information_id").toString();
            String fileListId = map.get("file_list_id").toString();
            String fileStr = map.get("file").toString();
            if (StringUtils.isNotEmpty(informationCollectId)) {
                for (Map<String, Object> m : informationCollectList) {
                    if (m.get("id").toString().equals(informationCollectId)) {
                        //???project_name???DICI_system_num??????answerMap
                        answerMap.put("project_name", m.get("project_name"));
                        answerMap.put("DICI_system_num", m.get("DICI_system_num"));
                        break;
                    }
                }
            }
            if (StringUtils.isNotEmpty(fileListId)) {
                for (Map<String, Object> m : fileListList) {
                    if (m.get("id").toString().equals(fileListId)) {
                        //???file_name??????answerMap
                        answerMap.put("file_name", m.get("file_name"));
                        break;
                    }
                }
            }
            boolean flag;
            boolean notFind;
            if (StringUtils.isNotEmpty(fileStr)) {
                if (fileStr.contains(",")) {
                    String[] spiltArray = fileStr.split(",");
                    for (String s : spiltArray) {
                        Map<String, Object> temp = new HashMap<>(answerMap);
                        //??????flag???false????????????fileMap???
                        flag = false;
                        notFind = false;
                        //??????????????????????????????map????????????????????????map
                        if (!repeatFileList.isEmpty()) {
                            for (Map<String, Object> repeat : repeatFileList) {
                                //??????repeatFileList????????????????????????????????????mapList???
                                if (repeat.get("fileId").toString().equals(s)) {
                                    temp.put("filename", repeat.get("filename"));
                                    temp.put("fileId",s);
                                    temp.put("filePath",repeat.get("filePath"));
                                    temp.put("gunsFileId",repeat.get("gunsFileId").toString());
                                    flag = true;
                                    notFind = true;
                                    break;
                                }
                            }
                        }
                        if (!flag) {
                            //???repeatFileList?????????????????????gunFileList?????????
                            for (Map<String, Object> m : gunFileList) {
                                if (m.get("fileId").equals(s)) {
                                    Map<String,Object> fileMap=new HashMap<>();
                                    temp.put("filename", m.get("filename"));
                                    temp.put("fileId",s);
                                    temp.put("filePath",m.get("filePath"));
                                    temp.put("gunsFileId",m.get("id").toString());

                                    //??????file_id???filename???fileMap???
                                    fileMap.put("fileId",s);
                                    fileMap.put("filename",m.get("filename"));
                                    fileMap.put("filePath",m.get("filePath"));
                                    fileMap.put("gunsFileId",m.get("id").toString());
                                    repeatFileList.add(fileMap);
                                    notFind = true;
                                    break;
                                }
                            }
                        }
                        if (!notFind) {
                            temp.put("filename", "??????????????????");
                        }
                        //???????????????project_name,DICI_system_num,file_name,filename???????????????mapList
                        mapList.add(temp);
                    }
                } else {
                    //????????????????????????
                    flag = false;
                    notFind = false;
                    if (!repeatFileList.isEmpty()) {
                        for (Map<String, Object> repeat : repeatFileList) {
                            //??????repeatFileList????????????????????????????????????mapList???
                            if (repeat.get("fileId").equals(fileStr)) {
                                answerMap.put("filename", repeat.get("filename"));
                                answerMap.put("fileId",fileStr);
                                answerMap.put("filePath",repeat.get("filePath"));
                                answerMap.put("gunsFileId",repeat.get("gunsFileId").toString());
                                flag = true;
                                notFind = true;
                                break;
                            }
                        }
                    }
                    if (!flag) {
                        EntityWrapper<GunsFile> entityWrapper = new EntityWrapper<>();
                        entityWrapper.eq("file_id", fileStr);
                        List<GunsFile> list = gunsFileMapper.selectList(entityWrapper);
                        if (list.size() > 0) {
                            Map<String,Object> fileMap=new HashMap<>();
                            answerMap.put("filename", list.get(0).getFilename());
                            answerMap.put("fileId",fileStr);
                            answerMap.put("filePath",list.get(0).getFilePath());
                            answerMap.put("gunsFileId",list.get(0).getId());
                            notFind = true;
                            fileMap.put("fileId",fileStr);
                            fileMap.put("filename", list.get(0).getFilename());
                            fileMap.put("filePath",list.get(0).getFilePath());
                            fileMap.put("gunsFileId",list.get(0).getId());
                            repeatFileList.add(fileMap);
                        }
                    }
                    if (!notFind) {
                        answerMap.put("filename", "??????????????????");
                    }
                    mapList.add(answerMap);
                }
            }
        }
        //??????
        Iterator<Map<String,Object>> iterator=mapList.iterator();
        while(iterator.hasNext()){
            Map<String,Object> map=iterator.next();
            if(StringUtils.isNotEmpty(projectName)){
                //??????????????????????????????
                if(!map.get("project_name").toString().contains(projectName)){
                    iterator.remove();
                    continue;
                }
            }
            if(StringUtils.isNotEmpty(systemNum)){
                if(!map.get("DICI_system_num").toString().contains(systemNum)){
                    iterator.remove();
                    continue;
                }
            }
            if(StringUtils.isNotEmpty(fileName)){
                if(!map.get("file_name").toString().contains(fileName)){
                    iterator.remove();
                    continue;
                }
            }
            if(StringUtils.isNotEmpty(filename)){
                if(!map.get("filename").toString().contains(filename)){
                    iterator.remove();
                }
            }
        }
        return mapList;
    }


    @RequestMapping("/downloadBatchFile")
    @ResponseBody
    public void  downloadBatchFile(HttpServletResponse response, String fileList) throws IOException {
        List<File> files = new ArrayList<>();
        String[] fileStr=fileList.split(",");
        for(String s:fileStr){
            GunsFile gunsFile=gunsFileMapper.selectById(Integer.parseInt(s));
            String prefix=gunsFile.getFilename().substring(0,gunsFile.getFilename().indexOf("."));
            String suffix=gunsFile.getFilename().substring(gunsFile.getFilename().indexOf("."));
            File file=new File(ResourceUtils.getFile("classpath:").getPath()+gunsFile.getFilePath());
            File tempFile = new File(ResourceUtils.getFile("classpath:").getPath()+"/uploads",prefix+suffix);
            tempFile.createNewFile();
            FileInputStream is = null;
            FileOutputStream os = null;
            is = new FileInputStream(file);
            os = new FileOutputStream(tempFile);
            int len;
            byte b[] = new byte[1024];
            try {
                len = is.read(b);
                while (len != -1) {
                    os.write(b, 0, len);
                    len = is.read(b);
                }
            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                is.close();
                os.close();
            }
            files.add(tempFile);
        }
        ExportUtil.zipDownload(response, "????????????.zip", files);
    }
}