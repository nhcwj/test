package com.stylefeng.guns.modular.informationCollect;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.constant.Enum.ICTEnum;
import com.stylefeng.guns.constant.Enum.ICTRoleEnum;
import com.stylefeng.guns.core.base.tips.ErrorTip;
import com.stylefeng.guns.core.base.tips.SuccessTip;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.type.StringUtils;
import com.stylefeng.guns.modular.gunsFile.controller.service.IGunsFileService;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.*;
import com.stylefeng.guns.modular.system.model.GunsFile;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.model.informationCollect.*;
import com.stylefeng.guns.modular.system.service.IIctOtherService;
import com.stylefeng.guns.modular.system.service.IRoleService;
import com.stylefeng.guns.util.ExportUtilFormwork;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ict_pc")
public class IctController {

    private String PREFIX = "/informationCollect/ict/";

    @Autowired
    IGunsFileService fileService;

    @Autowired
    private IctOrderMapper ictOrderMapper;

    @Autowired
    private IctInfoMapper ictInfoMapper;

    @Autowired
    private ServicesPackageMapper servicesPackageMapper;

    @Autowired
    private IctLogMapper ictLogMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IIctOtherService ictOtherService;

    @Autowired
    private IctRemarkMapper remarkMapper;

    @RequestMapping("/orderList")
    public String orderList(Model model) {
        String roleList = iRoleService.getUsetStr(ShiroKit.getUser(),"ICT??????");
        if(roleList.contains("???????????????") || roleList.contains("???????????????") || roleList.contains("????????????")
                || roleList.contains("????????????") || roleList.contains("??????") || roleList.contains("??????????????????")){
            model.addAttribute("edit_status",true);
            return PREFIX + "/order_list.html";
        }
        model.addAttribute("edit_status",false);
        return PREFIX + "/order_list.html";
    }

    @RequestMapping("/getOther_order")
    @ResponseBody
    public List<Map<String,Object>> getOther_order(Integer id){
        List<Map<String, Object>> mapList = new ArrayList<>();
        EntityWrapper<IctOther> wrapper = new EntityWrapper<>();
        wrapper.eq("ict_id",id);
        mapList =ictOtherService.selectMaps(wrapper);
        for(Map<String,Object> map : mapList){

            if(map.get("user_id")!=null &&!map.get("user_id").equals("")){
                User user = userMapper.selectById(map.get("user_id").toString());
                if(user!=null){
                    map.put("person_name",user.getName());
                }
            }

        }
        return mapList;
    }

    @RequestMapping("/update_orderType_work")
    @ResponseBody
    public Object update_orderType_work(String files){
        System.out.println(files);
        Integer id=0;
        String process="??????????????????";
        if(!files.equals("")){
            for(String str :files.split(",")){
                if(str.split(":").length==2){
                    OrderType orderType =orderTypeMapper.selectById(str.split(":")[0]);
                    id=orderType.getIct_order_id();
                    orderType.setOver_files(str.split(":")[1]);
                    orderTypeMapper.updateById(orderType);

                }
            }
        }
        EntityWrapper<OrderType> entityWrapper=new EntityWrapper<>();
        entityWrapper.eq("ict_order_id",id);
        List<OrderType> orderTypes=orderTypeMapper.selectList(entityWrapper);
        for(OrderType orderType : orderTypes){
            if(orderType.getOver_files()==null || orderType.getOver_files().equals("")){
                process="????????????";
                return process;
            }
        }

        return process;
    }

    @RequestMapping("/update_orderType")
    @ResponseBody
    public Object update_orderType(String type_id,String implement_people,String implement_people_phone){
        int i=0;

        for(String id :type_id.split(",")){
            OrderType orderType =orderTypeMapper.selectById(id);
            orderType.setImplement_people(implement_people.split(",")[i]);
            orderType.setImplement_people_phone(implement_people_phone.split(",")[i]);
            orderTypeMapper.updateById(orderType);
            i=i+1;
        }
        return "success";
    }

    @RequestMapping("/getOrderList1")
    @ResponseBody
    public java.util.List<Map<String, Object>> getOrderList1(String order_number, String order_time, String current_process, String company_name, String custom_name,
                                                            String custom_phone, String custom_manager, String custom_manager_phone,
                                                            String group_code,String status) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        EntityWrapper<IctOrder> wrapper = new EntityWrapper<>();
        if (!StringUtils.isBlank(order_number)) {
            wrapper.like("order_no", order_number);
        }
        if (!StringUtils.isBlank(current_process)) {
            wrapper.like("order_status", current_process);
        }
        if (!StringUtils.isBlank(company_name)) {
            wrapper.like("company_name", company_name);
        }
        if (!StringUtils.isBlank(custom_name)) {
            wrapper.like("client_name", custom_name);
        }
        if (!StringUtils.isBlank(custom_phone)) {
            wrapper.like("client_link_phone", custom_phone);
        }
        if (!StringUtils.isBlank(custom_manager)) {
            wrapper.like("client_manager", custom_manager);
        }
        if (!StringUtils.isBlank(custom_manager_phone)) {
            wrapper.like("client_manager_phone", custom_manager_phone);
        }
        if (!StringUtils.isBlank(group_code)) {
            wrapper.like("company_no", group_code);
        }
        if (!StringUtils.isBlank(order_time)) {
            wrapper.like("order_time", order_time);
        }
        if (!StringUtils.isBlank(status)) {
            wrapper.eq("status", status);
        }
        wrapper.orderBy("order_time",false);
        mapList = ictOrderMapper.selectMaps(wrapper);
        return mapList;
    }

    @Autowired
    private OrderTypeMapper orderTypeMapper;

    @RequestMapping("/orderEdit")
    public String orderEdit(Model model, Integer id) {
        List<Map<String,Object>> servicesPackage=servicesPackageMapper.selectMaps(new EntityWrapper<>());
        model.addAttribute("servicesPackage",JSON.toJSONString(servicesPackage));

        IctOrder ictOrder = ictOrderMapper.selectById(id);

        List<Map<String,Object>> list = orderTypeMapper.getOrderTypeMap(ictOrder.getId());
        if(list.size()>0){
            model.addAttribute("order_type_list",list);
        }else {
            model.addAttribute("order_type_list",new ArrayList());
        }
        String type_id_list="";
        for (Map map:list){
            if(type_id_list.equals("")){
                type_id_list=map.get("id").toString();
            }else {
                type_id_list=type_id_list+','+map.get("id");
            }
//            if(map.get("over_files")!=null && !map.get("over_files").equals("")){
//                model.addAttribute("over_files_"+map.get("type_id").toString(),getFiles(map.get("over_files").toString()));
//            }else {
//                model.addAttribute("over_files_"+map.get("type_id").toString(),"");
//            }
        }
        model.addAttribute("type_id_list",type_id_list);

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
            model.addAttribute("client_order_files",getFiles(ictOrder.getClient_order_files()));
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
            //????????????????????????
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
            //??????????????????????????????
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
            model.addAttribute("last_pay_files", "");
            model.addAttribute("client_order_files","");
            model.addAttribute("own_add_time", "");
            model.addAttribute("receive_add_time", "");
        }
        String rolestr= iRoleService.getUsetStr(ShiroKit.getUser(),"ICT??????");
        if(rolestr.contains(ICTRoleEnum.MIDDLEGROUND_MANAGER.getRoleName())){
            model.addAttribute("hasAllButton",true);
        }else{
            model.addAttribute("hasAllButton",false);
        }
        model.addAttribute("hasSpecialButton",false);
        if(ictOrder!=null&&"????????????".contains(ictOrder.getOrder_status())&&rolestr.contains(ICTRoleEnum.PRE_PEOPLE.getRoleName())){
            model.addAttribute("hasSpecialButton",true);
        }
        if(ictOrder!=null&&"????????????".contains(ictOrder.getOrder_status())&&rolestr.contains(ICTRoleEnum.WORK_PEOPLE.getRoleName())){
            model.addAttribute("hasSpecialButton",true);
        }
        String roleList = iRoleService.getUsetStr(ShiroKit.getUser(),"ICT??????");
        if(roleList.contains("???????????????") || roleList.contains("???????????????") || roleList.contains("????????????")
                || roleList.contains("????????????") || roleList.contains("??????") || roleList.contains("??????????????????")){
            model.addAttribute("check_show",true);
            return PREFIX + "/orderEdit.html";
        }
        model.addAttribute("check_show",false);

        return PREFIX + "/orderEdit.html";
    }

    @RequestMapping("/updateIctOrder_sjOrder")
    @ResponseBody
    public Tip updateIctOrder_sjOrder(IctOrder ictOrder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = simpleDateFormat.format(new Date());
        User user = userMapper.selectById(ShiroKit.getUser().getId());
        IctOrder ictOrder1 = ictOrderMapper.selectById(ictOrder.getId());
        //        ??????decimal update?????????0??????
        ictOrder.setService_price(ictOrder1.getService_price());
        ictOrder.setService_total_price(ictOrder1.getService_total_price());
        ictOrder.setProject_total_price(ictOrder1.getProject_total_price());
        ictOrderMapper.updateById(ictOrder);

        IctLog ictLog = new IctLog();
        ictLog.setName(user.getName());
        ictLog.setPhone(user.getPhone());
        ictLog.setOrder_id(ictOrder.getId() + "");
        ictLog.setProcess("???????????????");
        ictLog.setContent("??????");
        ictLog.setOperate_time(today);
        ictLogMapper.insert(ictLog);
        return new SuccessTip();
    }

    @RequestMapping("/updateIctOrder")
    @ResponseBody
    public Tip updateIctOrder(IctOrder ictOrder,String remark) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = simpleDateFormat.format(new Date());
        User user = userMapper.selectById(ShiroKit.getUser().getId());
        IctOrder ictOrder1 = ictOrderMapper.selectById(ictOrder.getId());
        ictOrder.setIs_change("???");
        ictOrder.setIs_change_client("???");
        if(ictOrder1.getOrder_status().equals("????????????")){
            ictOrder.setProject_budget(ictOrder1.getProject_budget());
            ictOrder.setService_price(ictOrder1.getService_price());
            ictOrder.setProject_total_price(ictOrder1.getProject_total_price());
        }else {
            ictOrder.setProject_budget(ictOrder1.getProject_budget());
            ictOrder.setService_price(ictOrder1.getService_price());
            ictOrder.setService_total_price(ictOrder1.getService_total_price());
            ictOrder.setProject_total_price(ictOrder1.getProject_total_price());
        }


        String process = ictOrder1.getOrder_status();
        if (process.equals("??????????????????")) {
            ictOrder.setFirst_verify_time(today);
        } else if (process.equals("????????????")) {
            ictOrder.setDesign_time(today);
        } else if (process.equals("??????????????????")) {
            ictOrder.setOrder_verify_time(today);
        } else if (process.equals("??????/????????????")) {
            IctInfo ictInfo = ictInfoMapper.selectById(ictOrder1.getInfo_order_id());
            ictInfo.setPay_confrim_time(today);
            ictInfoMapper.updateById(ictInfo);
        } else if (process.equals("????????????")) {
            IctInfo ictInfo = ictInfoMapper.selectById(ictOrder1.getInfo_order_id());
            ictInfo.setWork_time(today);
            ictInfoMapper.updateById(ictInfo);
        } else if (process.equals("????????????")) {
            IctInfo ictInfo = ictInfoMapper.selectById(ictOrder1.getInfo_order_id());
            ictInfo.setOver_pay_confrim_time(today);
            ictInfoMapper.updateById(ictInfo);
        }
        Integer temp = ictOrderMapper.updateById(ictOrder);
        IctLog ictLog = new IctLog();
        ictLog.setName(user.getName());
        ictLog.setPhone(user.getPhone());
        ictLog.setOrder_id(ictOrder.getId() + "");
        ictLog.setProcess(ictOrder1.getOrder_status());
        ictLog.setContent("??????");
        ictLog.setOperate_time(today);
        ictLogMapper.insert(ictLog);
        //??????????????????
        if(StringUtils.isNotEmpty(remark)){
            IctReamrkInfo reamrkInfo=new IctReamrkInfo();
            reamrkInfo.setName(user.getName());
            reamrkInfo.setPhone(user.getPhone());
            reamrkInfo.setOperate_time(today);
            reamrkInfo.setProcess(ictOrder1.getOrder_status());
            reamrkInfo.setOrder_id(ictOrder1.getId()+"");
            reamrkInfo.setRemark(remark);
            remarkMapper.insert(reamrkInfo);
        }
        if (temp > 0) {
            return new SuccessTip();
        } else {
            return new ErrorTip(500, "????????????");
        }
    }

    @RequestMapping("/updateIctInfo")
    @ResponseBody
    public Tip updateIctInfo(IctInfo ictInfo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = simpleDateFormat.format(new Date());
        EntityWrapper<IctOrder> entityWrapper=new EntityWrapper<>();
        entityWrapper.eq("info_order_id",ictInfo.getId());
        IctOrder ictOrder=ictOrderMapper.selectList(entityWrapper).get(0);
        String process=ictOrder.getOrder_status();
        if(process.equals("??????/????????????")){
            ictInfo.setPay_confrim_time(today);
        }else if(process.equals("??????????????????")){
            ictInfo.setWork_people_time(today);
        }else if(process.equals("????????????")){
            ictInfo.setWork_time(today);
        }else if(process.equals("??????????????????")){
            ictInfo.setOver_pay_time(today);
        }else if(process.equals("????????????")){
            ictInfo.setOver_pay_confrim_time(today);
        }

        Integer temp = ictInfoMapper.updateById(ictInfo);
        if (temp > 0) {
            return new SuccessTip();
        } else {
            return new ErrorTip(500, "????????????");
        }
    }

    @RequestMapping("/updateIctOrderType")
    @ResponseBody
    public Tip updateIctOrderType(String ids,String package_nums,String build_over_times,Integer order_id){
        String[] type_id_sz=ids.length()>0?ids.split(","):new String[0];
        String[] package_num_sz=package_nums.length()>0?package_nums.split(","):new String[0];
        String[] build_over_time_sz=build_over_times.length()>0?build_over_times.split(","):new String[0];
        Integer temp = 0;
        for(int i=0;i<type_id_sz.length;i++){
            OrderType orderType=new OrderType();
            orderType.setType_id(Integer.parseInt(type_id_sz[i]));
            orderType.setPackage_num(Integer.parseInt(package_num_sz[i]));
            orderType.setBuild_over_time(build_over_time_sz[i]);
            orderType.setIct_order_id(order_id);
            temp+=orderTypeMapper.insert(orderType);
        }
        if (temp > 0) {
            return new SuccessTip();
        } else {
            return new ErrorTip(500, "????????????");
        }
    }

    @RequestMapping("/confirmPage")
    public String confirmPage(Model model,Integer id,Integer type,String order_status){
        model.addAttribute("id",id);
        model.addAttribute("type",type);
        model.addAttribute("order_status",order_status);
        return PREFIX+"/confirmPage.html";
    }

    @RequestMapping("/verifyPage")
    public String verifyPage(Model model,Integer id,Integer type,String order_status){
        model.addAttribute("id",id);
        model.addAttribute("type",type);
        model.addAttribute("order_status",order_status);
        return PREFIX+"/verifyPage.html";
    }

    @RequestMapping("/orderDeal")
    @ResponseBody
    public Object orderDeal(Integer id,Integer type,String content,String remark){
        IctOrder tempOrder=ictOrderMapper.selectById(id);
        String process = tempOrder.getStatus();
        String temp_status="";
        if (type==1){
            tempOrder.setStatus(ICTEnum.BACK_VERIFY.getStatus().toString());
            temp_status="????????????";
        }else if(type==2){
            tempOrder.setStatus(ICTEnum.HANG_VERIFY.getStatus().toString());
            temp_status="????????????";
        }else if(type==3){
            tempOrder.setStatus(ICTEnum.CANCEL.getStatus().toString());
            temp_status="??????";
        }else if(type==4){
            tempOrder.setStatus(ICTEnum.CANCEL_VERIFY.getStatus().toString());
            temp_status="?????????????????????";
        }else if(type==21){
            tempOrder.setStatus(ICTEnum.HANG.getStatus().toString());
            temp_status="??????";
        }else if(type==22){
            tempOrder.setStatus(ICTEnum.NORMAL.getStatus().toString());
            temp_status="??????";
        }else if(type==41){
            tempOrder.setStatus(ICTEnum.NORMAL.getStatus().toString());
            tempOrder.setOrder_status("??????????????????");
            temp_status="??????";
        }else if(type==51){
            tempOrder.setStatus(ICTEnum.NORMAL.getStatus().toString());
            tempOrder.setOrder_status(ICTRoleEnum.getNext(tempOrder.getOrder_status()));
            temp_status="???????????????";
        }else if(type==210){
            tempOrder.setStatus(ICTEnum.NORMAL.getStatus().toString());
            temp_status="????????????";
        }else if(type==410){
            tempOrder.setStatus(ICTEnum.NORMAL.getStatus().toString());
            temp_status="????????????";
        }else if(type==510){
            tempOrder.setStatus(ICTEnum.NORMAL.getStatus().toString());
            temp_status="?????????????????????";
        }
        ictOtherService.insert_ictOther(id.toString(),process,temp_status,content);
        ictOrderMapper.updateById(tempOrder);

        User user = userMapper.selectById(ShiroKit.getUser().getId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = simpleDateFormat.format(new Date());
        if(StringUtils.isNotEmpty(remark)){
            IctReamrkInfo reamrkInfo=new IctReamrkInfo();
            reamrkInfo.setName(user.getName());
            reamrkInfo.setPhone(user.getPhone());
            reamrkInfo.setOperate_time(today);
            reamrkInfo.setProcess(tempOrder.getOrder_status()+"-"+temp_status);
            reamrkInfo.setOrder_id(tempOrder.getId()+"");
            reamrkInfo.setRemark(remark);
            remarkMapper.insert(reamrkInfo);
        }

        return "success";
    }

    @RequestMapping("/hangupList")
    public String hangupList(){
        return PREFIX+"/hangup_list.html";
    }

    @RequestMapping("/backbeforeList")
    public String backbeforeList(){
        return PREFIX+"/backbefore_list.html";
    }

    @RequestMapping("/gobackList")
    public String gobackList(){
        return PREFIX+"/goback_list.html";
    }

    @RequestMapping("/unhangList")
    public String unhangList(){
        return PREFIX+"/unhang_list.html";
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

    /**
     * ??????excel
     **/
    @RequestMapping("/download")
    @ResponseBody
    public void download(HttpServletResponse response) throws IOException {

        List<Map<String, Object>> orderList = ictOrderMapper.selectMaps(null);
        List<Map<String, Object>> infoList = ictInfoMapper.selectMaps(null);

        List<String> HeadList = new ArrayList<>();
        HeadList.add("??????????????????");
        HeadList.add("????????????");
        HeadList.add("????????????");
        HeadList.add("????????????");
        HeadList.add("??????????????????????????????");
        HeadList.add("????????????????????????");
        HeadList.add("????????????????????????");
        HeadList.add("??????????????????????????????");
        HeadList.add("????????????");
        HeadList.add("????????????");
        HeadList.add("????????????");
        HeadList.add("??????????????????");
        HeadList.add("??????????????????");
        HeadList.add("?????????");
        HeadList.add("??????");
        HeadList.add("????????????");
        HeadList.add("????????????");
        HeadList.add("????????????");
        HeadList.add("??????????????????");
        HeadList.add("ict??????");
        HeadList.add("????????????");
        HeadList.add("ICT????????????");
        HeadList.add("????????????");
        HeadList.add("????????????");
        HeadList.add("????????????????????????");
        HeadList.add("????????????");
        HeadList.add("????????????????????????");
        HeadList.add("??????");
        HeadList.add("??????????????????");
        HeadList.add("????????????");
        HeadList.add("????????????????????????");
        HeadList.add("????????????");
        HeadList.add("???????????????");
        HeadList.add("???????????????");
        HeadList.add("???????????????");
        HeadList.add("???????????????");
        HeadList.add("??????????????????");
        HeadList.add("????????????");
        HeadList.add("????????????????????????");
        HeadList.add("??????????????????????????????");
        HeadList.add("??????????????????");
        HeadList.add("??????????????????");
        HeadList.add("???????????????");
        HeadList.add("????????????????????????");
        HeadList.add("??????????????????????????????");
        HeadList.add("????????????/??????????????????");
        HeadList.add("??????/????????????????????????");
        HeadList.add("????????????????????????");
        HeadList.add("??????????????????????????????");
        HeadList.add("????????????????????????");
        HeadList.add("??????????????????");
        HeadList.add("???????????????");
        HeadList.add("???????????????????????????");
        HeadList.add("???????????????");
        HeadList.add("???????????????");
        HeadList.add("??????????????????");
        HeadList.add("???????????????");
        HeadList.add("??????????????????????????????");
        HeadList.add("??????/????????????????????????");
        HeadList.add("??????/????????????");
        HeadList.add("????????????????????????");
        HeadList.add("??????????????????");

        HeadList.add("????????????");
        HeadList.add("?????????????????????");

        List<String> HeadEnList = new ArrayList<>();
        HeadEnList.add("order_status");
        HeadEnList.add("status");
        HeadEnList.add("order_no");
        HeadEnList.add("order_time");
        HeadEnList.add("first_verify_time");
        HeadEnList.add("design_time");
        HeadEnList.add("confirm_time");
        HeadEnList.add("order_verify_time");
        HeadEnList.add("company_name");
        HeadEnList.add("client_name");
        HeadEnList.add("client_email");
        HeadEnList.add("client_link_phone");
        HeadEnList.add("order_region");
        HeadEnList.add("fgs");
        HeadEnList.add("wg");
        HeadEnList.add("order_amount");
        HeadEnList.add("project_budget");
        HeadEnList.add("support_type");
        HeadEnList.add("is_need_support");
        HeadEnList.add("ict_num");
        HeadEnList.add("address");
        HeadEnList.add("ict_type");
        HeadEnList.add("need_desc");
        HeadEnList.add("pre_people");
        HeadEnList.add("pre_people_phone");
        HeadEnList.add("implement_people");
        HeadEnList.add("implement_people_phone");
        HeadEnList.add("factory");
        HeadEnList.add("factory_phone");
        HeadEnList.add("client_manager");
        HeadEnList.add("client_manager_phone");
        HeadEnList.add("company_no");
        HeadEnList.add("service_name");
        HeadEnList.add("service_num");
        HeadEnList.add("service_price");
        HeadEnList.add("service_total_price");
        HeadEnList.add("build_finish_time");
        HeadEnList.add("project_total_price");
        HeadEnList.add("order_pass_suggest");
        HeadEnList.add("order_is_pass");
        HeadEnList.add("is_change");
        HeadEnList.add("is_change_client");
        HeadEnList.add("apply_phone");
        HeadEnList.add("is_manager_register");
        HeadEnList.add("contract_is_pass");
        HeadEnList.add("wait_pay_time");
        HeadEnList.add("pay_confrim_time");
        HeadEnList.add("work_time");
        HeadEnList.add("over_pay_time");
        HeadEnList.add("over_pay_confrim_time");
        HeadEnList.add("is_pay_all");
        HeadEnList.add("buy_name");
        HeadEnList.add("buy_tax_payer_no");
        HeadEnList.add("buy_address");
        HeadEnList.add("buy_phone");
        HeadEnList.add("buy_open_hang");
        HeadEnList.add("buy_account");
        HeadEnList.add("contract_is_pass1");
        HeadEnList.add("first_is_pass");
        HeadEnList.add("first_suggest");
        HeadEnList.add("last_is_pass");
        HeadEnList.add("last_suggest");
        HeadEnList.add("order_type");
        HeadEnList.add("is_add_records_client");
        for (Map<String, Object> m : orderList) {
            String info_id = m.getOrDefault("info_order_id", "").toString();
            if (StringUtils.isNotEmpty(info_id)) {
                String temp = info_id.split(",")[0];
                Map<String, Object> info = infoList.stream().filter(i -> {
                    return i.getOrDefault("id", "").toString().equals(temp);
                })
                        .collect(Collectors.toList()).get(0);
                info.put("contract_is_pass1",info.getOrDefault("contract_is_pass",""));
                m.putAll(info);
            }
            String status_id= m.getOrDefault("status","").toString();
            m.put("status",ICTEnum.getStatusName(Integer.parseInt(status_id)));
        }
//        Workbook workbook = null;

        //1.???????????? 2.????????????3????????????

        ExportUtilFormwork.exportData(orderList, HeadList, HeadEnList, response, "??????????????????.xlsx");

//        String fileName="??????????????????.xlsx";
//        String fileNameURL = URLEncoder.encode(fileName, "UTF-8");
//        ByteArrayOutputStream fos = null;
//        byte[] retArr = null;
//        try {
//            fos = new ByteArrayOutputStream();
//            workbook.write(fos);
//            retArr = fos.toByteArray();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                workbook.close();
//                fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        OutputStream os = response.getOutputStream();
//        try {
//            response.reset();
//            response.setContentType("application/force-download");// ???????????????????????????
//            response.setHeader("Content-disposition", "attachment;filename="+fileNameURL+";"+"filename*=utf-8''"+fileNameURL);
//            os.write(retArr);
//            os.flush();
//        } finally {
//            if (os != null) {
//                os.close();
//            }
//        }

    }
    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("/getOrderList")
    @ResponseBody
    public java.util.List<Map<String, Object>> getOrderList(String order_number, String order_time, String current_process, String company_name, String custom_name,
                                                            String custom_phone, String custom_manager, String custom_manager_phone,
                                                            String group_code,String status) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        EntityWrapper<IctOrder> wrapper = new EntityWrapper<>();
        if (!StringUtils.isBlank(order_number)) {
            wrapper.like("order_no", order_number);
        }
        if (!StringUtils.isBlank(current_process)) {
            wrapper.like("order_status", current_process);
        }
        if (!StringUtils.isBlank(company_name)) {
            wrapper.like("company_name", company_name);
        }
        if (!StringUtils.isBlank(custom_name)) {
            wrapper.like("client_name", custom_name);
        }
        if (!StringUtils.isBlank(custom_phone)) {
            wrapper.like("client_link_phone", custom_phone);
        }
        if (!StringUtils.isBlank(custom_manager)) {
            wrapper.like("client_manager", custom_manager);
        }
        if (!StringUtils.isBlank(custom_manager_phone)) {
            wrapper.like("client_manager_phone", custom_manager_phone);
        }
        if (!StringUtils.isBlank(group_code)) {
            wrapper.like("company_no", group_code);
        }
        if (!StringUtils.isBlank(order_time)) {
            wrapper.like("order_time", order_time);
        }
        if (!StringUtils.isBlank(status)) {
            wrapper.like("status", status);
        }
//        wrapper.eq("status","1");

        wrapper.orderBy("order_time",false);
        String rolestr= iRoleService.getUsetStr(ShiroKit.getUser(),"ICT??????");
            wrapper.andNew();
            if(rolestr.contains(ICTRoleEnum.MIDDLEGROUND_MANAGER.getRoleName()) || rolestr.contains("???????????????") || rolestr.contains("?????????")){
                if(ICTRoleEnum.MIDDLEGROUND_MANAGER.getOther()){
                    for(String eq_content: ICTRoleEnum.MIDDLEGROUND_MANAGER.getOrder_status()){
                        wrapper.eq("order_status",eq_content).or();
                    }
                }
            }else {
                List<ICTRoleEnum> ictRoleEnumList = ICTRoleEnum.getAll_Enum();
                for (ICTRoleEnum ictRoleEnum : ictRoleEnumList){
                    if(rolestr.contains(ictRoleEnum.getRoleName())){
                        if(ICTRoleEnum.PRE_PEOPLE.getOther()) {
                            for (String eq_content : ICTRoleEnum.PRE_PEOPLE.getOrder_status()) {
                                wrapper.eq("order_status", eq_content).or();
                            }
                        }else {
                            if(ictRoleEnum.getRoleName().equals("??????")){
                                wrapper.eq("factory",ShiroKit.getUser().getName()).or();
                            }
                        }
                    }
                }
                if(rolestr.contains("?????????????????????")) {
                    if (ShiroKit.getUser().getPosition() == null || ShiroKit.getUser().getPosition().equals("") || ShiroKit.getUser().getPosition().equals("??????")) {
                        wrapper.eq("1", 1).or();
                    } else {
                        String[] positionList = ShiroKit.getUser().getPosition().split(",");
                        for (String positon : positionList) {
                            wrapper.like("order_region", positon).or();
                        }
                    }
                }

            }
//            ???????????????
        wrapper.eq("1","2");

        mapList = ictOrderMapper.selectMaps(wrapper);
        return mapList;
    }


    @RequestMapping("/getRemarkList")
    @ResponseBody
    public java.util.List<Map<String, Object>> getRemarkList(Integer order_id){

        EntityWrapper<IctReamrkInfo> wrapper=new EntityWrapper<>();
        wrapper.eq("order_id",order_id);
        return remarkMapper.selectMaps(wrapper);
    }
}
