package com.stylefeng.guns.modular.informationCollect;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.constant.Enum.ICTRoleEnum;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.type.StringUtils;
import com.stylefeng.guns.modular.gunsFile.controller.service.IGunsFileService;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.*;
import com.stylefeng.guns.modular.system.model.GunsFile;
import com.stylefeng.guns.modular.system.model.informationCollect.*;
import com.stylefeng.guns.modular.system.service.IIctOtherService;
import com.stylefeng.guns.modular.system.service.IRoleService;
import jdk.nashorn.internal.scripts.JO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/ict_see")
public class IctSeeController {

    private String PREFIX = "/informationCollect/ict_see/";

    @Autowired
    IGunsFileService fileService;

    @Autowired
    private IctOrderMapper ictOrderMapper;

    @Autowired
    private IctInfoMapper ictInfoMapper;

    @Autowired
    private IctLogMapper ictLogMapper;

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private OrderTypeMapper orderTypeMapper;

    @Autowired
    private ServicesPackageMapper servicesPackageMapper;


    @RequestMapping("/index")
    public String orderEdit(Model model, Integer id) {
        IctOrder ictOrder = ictOrderMapper.selectById(id);
        EntityWrapper logEntityWrapper = new EntityWrapper();
        ictOrder = ictOrderMapper.selectById(id);
        logEntityWrapper.eq("order_id", id);
        logEntityWrapper.orderBy("operate_time", false);
        List<IctLog> logList = ictLogMapper.selectList(logEntityWrapper);
        model.addAttribute("log", CollectionUtils.isNotEmpty(logList) ? logList : new ArrayList<IctLog>());
        if (ictOrder != null) {
            model.addAttribute("orderInfo", ictOrder);
            model.addAttribute("project_scheme_files", getFiles(ictOrder.getProject_scheme_files()));
            model.addAttribute("project_quote_files", getFiles(ictOrder.getProject_quote_files()));
            model.addAttribute("client_contract_files", getFiles(ictOrder.getClient_contract_files()));
            model.addAttribute("own_company_files", getFiles(ictOrder.getOwn_company_files()));
            model.addAttribute("order_confirm_files", getFiles(ictOrder.getOrder_confirm_files()));
            model.addAttribute("client_order_protocols", getFiles(ictOrder.getClient_order_files()));

            IctInfo ictInfo = new IctInfo();
            String info_order_id = ictOrder.getInfo_order_id();
            if (StringUtils.isNotEmpty(info_order_id)) {
                if (info_order_id.contains(",")) {
                    String[] splitArray = info_order_id.split(",");
                    info_order_id = splitArray[0];
                }
                ictInfo = ictInfoMapper.selectById(Integer.parseInt(info_order_id));
            }
            if (ictInfo != null) {
                model.addAttribute("orderInfo_plus", ictInfo);
                model.addAttribute("client_receive_files", getFiles(ictInfo.getClient_receive_files()));
                model.addAttribute("client_pay_files", getFiles(ictInfo.getClient_pay_files()));
                model.addAttribute("last_pay_files", getFiles(ictInfo.getLast_pay_files()));
            }else{
                model.addAttribute("orderInfo_plus", new IctInfo());
                model.addAttribute("client_receive_files","");
                model.addAttribute("client_pay_files","");
                model.addAttribute("last_pay_files","");
            }

            //账户信息上传时间
            if (StringUtils.isNotEmpty(ictOrder.getOwn_company_files())) {
                EntityWrapper<GunsFile> wrapper = new EntityWrapper<>();
                wrapper.eq("file_id", ictOrder.getOwn_company_files());
                List<GunsFile> gunsFileList = fileService.selectList(wrapper);
                if (gunsFileList.size() > 0) {
                    String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(gunsFileList.get(0).getAddTime());
                    model.addAttribute("own_add_time", date);
                }
            } else {
                model.addAttribute("own_add_time", "");
            }
            //验收证明信息上传时间
            if (ictInfo!=null&&StringUtils.isNotEmpty(ictInfo.getClient_receive_files())) {
                EntityWrapper<GunsFile> wrapper = new EntityWrapper<>();
                wrapper.eq("file_id", ictInfo.getClient_receive_files());
                List<GunsFile> gunsFileList = fileService.selectList(wrapper);
                if (gunsFileList.size() > 0) {
                    String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(gunsFileList.get(0).getAddTime());
                    model.addAttribute("receive_add_time", date);
                }
            } else {
                model.addAttribute("receive_add_time", "");
            }
            //服务包信息
            EntityWrapper<OrderType> wrapper=new EntityWrapper<>();
            wrapper.eq("ict_order_id",ictOrder.getId());
            List<Map<String,Object>> order_type_list=orderTypeMapper.selectMaps(wrapper);
            for(Map<String,Object> map:order_type_list){
                String type_id=map.getOrDefault("type_id","").toString();
                if(StringUtils.isNotEmpty(type_id)){
                    Integer type=Integer.parseInt(type_id);
                    ServicesPackage service=servicesPackageMapper.selectById(type);
                    map.put("services_package",service.getServices_package());
                    map.put("services_package_son",service.getServices_package_son());
                    map.put("company",service.getCompany());
                    map.put("give_company_no_tax_money",service.getGive_company_no_tax_money());
                    map.put("give_company_money",service.getGive_company_money());
                    map.put("client_no_tax_money",service.getClient_no_tax_money());
                    map.put("client_money",service.getClient_money());
                    map.put("over_files",getFileMap(map.getOrDefault("over_files","").toString()));
                }
            }
            if(order_type_list.size()>0){
                model.addAttribute("order_type_list", JSON.toJSONString(order_type_list));
            }else{
                model.addAttribute("order_type_list", "");
            }
        } else {
            model.addAttribute("orderInfo", new IctOrder());
            model.addAttribute("orderInfo_plus", new IctInfo());
            model.addAttribute("project_scheme_files", "");
            model.addAttribute("project_quote_files", "");
            model.addAttribute("client_contract_files", "");
            model.addAttribute("own_company_files", "");
            model.addAttribute("client_receive_files", "");
            model.addAttribute("client_pay_files", "");
            model.addAttribute("order_confirm_files", "");
            model.addAttribute("client_order_protocols", "");
            model.addAttribute("last_pay_files", "");
            model.addAttribute("own_add_time", "");
            model.addAttribute("receive_add_time", "");
        }

        return PREFIX + "/index.html";
    }


    public String getFiles(String files) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Map<String, Object>> fileMaps = new ArrayList<>();
        if (files != null && files.length() > 0) {
            String[] fileStr = files.split(",");
            List<String> fileList = Arrays.asList(fileStr);
            for (Integer i = 0; i < fileList.size(); i++) {
                Map<String, Object> map = new HashMap<>();
                GunsFile file = fileService.getGunsFileByfileId(fileList.get(i));
                map.put("file_name", file.getFilename());
                map.put("file_path", file.getFilePath());
                map.put("files", fileList.get(i));
                map.put("upload_people", file.getUpload_people());
                map.put("add_time", sdf.format(file.getAddTime()));
                fileMaps.add(map);
            }
            return JSON.toJSONString(fileMaps);
        } else {
            return "";
        }
    }
    public Object getFileMap(String files) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Map<String, Object>> fileMaps = new ArrayList<>();
        if (files != null && files.length() > 0) {
            String[] fileStr = files.split(",");
            List<String> fileList = Arrays.asList(fileStr);
            for (Integer i = 0; i < fileList.size(); i++) {
                Map<String, Object> map = new HashMap<>();
                GunsFile file = fileService.getGunsFileByfileId(fileList.get(i));
                map.put("file_name", file.getFilename());
                map.put("file_path", file.getFilePath());
                map.put("files", fileList.get(i));
                map.put("upload_people", file.getUpload_people());
                map.put("add_time", sdf.format(file.getAddTime()));
                fileMaps.add(map);
            }
        }
        return fileMaps;

    }
}
