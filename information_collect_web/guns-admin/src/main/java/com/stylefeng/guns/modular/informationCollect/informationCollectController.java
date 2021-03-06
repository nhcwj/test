package com.stylefeng.guns.modular.informationCollect;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.base.tips.SuccessTip;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.type.StringUtils;
import com.stylefeng.guns.modular.system.dao.GunsFileMapper;
import com.stylefeng.guns.modular.system.dao.RoleMapper;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.*;
import com.stylefeng.guns.modular.system.model.GunsFile;
import com.stylefeng.guns.modular.system.model.Role;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.model.informationCollect.*;
import com.stylefeng.guns.modular.system.service.IInformationCollectOrderLogService;
import com.stylefeng.guns.util.ExportUtilFormwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: cwj
 * @Date: 2021/10/15 17:01
 * @Description:
 */
@Controller
@RequestMapping("/informationCollect")
public class informationCollectController {
    @Autowired
    private InformationCollectMapper informationCollectMapper;
    @Autowired
    private AppraiseMapper appraiseMapper;

    @Autowired
    private BudgetInfoMapper budgetInfoMapper;

    @Autowired
    private PrescriptiMapper prescriptiMapper;

    @Autowired
    private WeeklyReportMapper weeklyReportMapper;

    @Autowired
    private IctCountMapper ictCountMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private GunsFileMapper gunsFileMapper;

    @Autowired
    private IInformationCollectOrderLogService informationCollectOrderLogService;

    private String PREFIX = "/informationCollect/";
    @RequestMapping("/index")
    public String index(Model model){
        Role role=new Role();
        role.setName("????????????");
        Integer xj_role=roleMapper.selectOne(role).getId();
        List<Integer> rolelist = ShiroKit.getUser().getRoleList();
        String roleName="";
        if(rolelist.size()>0){
            for(Integer roleid : rolelist){
                if(roleid>xj_role){
                    roleName =roleName + roleMapper.selectById(roleid).getName();
                }
            }
        }
        model.addAttribute("roleName",roleName);

        return PREFIX+"index.html";
    }
    @RequestMapping("/ongoing")
    public String ongoing(Model model){
        Role role=new Role();
        role.setName("????????????");
        Integer xj_role=roleMapper.selectOne(role).getId();
        List<Integer> rolelist = Objects.requireNonNull(ShiroKit.getUser()).getRoleList();
        String roleName="";
        if(rolelist.size()>0){
            for(Integer roleid : rolelist){
                if(roleid>xj_role){
                    roleName =roleName + roleMapper.selectById(roleid).getName();
                }
            }
        }
        model.addAttribute("roleName",roleName);
        return PREFIX+"ongoing.html";
    }
    @RequestMapping("/over")
    public String over(Model model){
        Role role=new Role();
        role.setName("????????????");
        Integer xj_role=roleMapper.selectOne(role).getId();
        List<Integer> rolelist = ShiroKit.getUser().getRoleList();
        String roleName="";
        if(rolelist.size()>0){
            for(Integer roleid : rolelist){
                if(roleid>xj_role){
                    roleName =roleName + roleMapper.selectById(roleid).getName();
                }
            }
        }
        model.addAttribute("roleName",roleName);

        return PREFIX+"over.html";
    }
    @RequestMapping("/add_new")
    public String add_new(Model model,Integer id){
        EntityWrapper<Role> wrapper=new EntityWrapper<>();
        wrapper.eq("name","????????????");
        Integer pay_manager_id = roleMapper.selectList(wrapper).get(0).getId();
        EntityWrapper<User> entityWrapper=new EntityWrapper();
        entityWrapper.like("roleid",pay_manager_id+"");
        entityWrapper.ne("id",1);
        model.addAttribute("payManagerList",userMapper.selectList(entityWrapper));

        EntityWrapper<Role> wrapper1=new EntityWrapper<>();
        wrapper1.eq("name","????????????");
        Integer pay_assistant_id = roleMapper.selectList(wrapper1).get(0).getId();
        EntityWrapper<User> entityWrapper1=new EntityWrapper();
        entityWrapper1.like("roleid",pay_assistant_id+"");
        entityWrapper1.ne("id",1);
        model.addAttribute("payAssistantList",userMapper.selectList(entityWrapper1));

        if(id!=null && !id.equals("")){
            model.addAttribute("info",informationCollectMapper.selectById(id));
        }else {
            model.addAttribute("info",new InformationCollect());
        }
        return PREFIX+"add_new.html";
    }
    @Autowired
    private FileRoleMapper fileRoleMapper;
    @Autowired
    private FileListMapper fileListMapper;
    @Autowired
    private ProcessFileMapper processFileMapper;

    @RequestMapping("/edit")
    public String edit(Integer id, Model model){
        if(1==1){
            EntityWrapper<Role> wrapper=new EntityWrapper<>();
            wrapper.eq("name","????????????");
            Integer pay_manager_id = roleMapper.selectList(wrapper).get(0).getId();
            EntityWrapper<User> entityWrapper=new EntityWrapper();
            entityWrapper.like("roleid",pay_manager_id+"");
            entityWrapper.ne("id",1);
            model.addAttribute("payManagerList",userMapper.selectList(entityWrapper));

            EntityWrapper<Role> wrapper1=new EntityWrapper<>();
            wrapper1.eq("name","????????????");
            Integer pay_assistant_id = roleMapper.selectList(wrapper1).get(0).getId();
            EntityWrapper<User> entityWrapper1=new EntityWrapper();
            entityWrapper1.like("roleid",pay_assistant_id+"");
            entityWrapper1.ne("id",1);
            model.addAttribute("payAssistantList",userMapper.selectList(entityWrapper1));
        }
        Role role=new Role();
        role.setName("????????????");
        Integer xj_role=roleMapper.selectOne(role).getId();
        List<Integer> rolelist = ShiroKit.getUser().getRoleList();
        String roleName="";
        if(rolelist.size()>0){
            for(Integer roleid : rolelist){
                if(roleid>xj_role){
                    roleName =roleName + roleMapper.selectById(roleid).getName();
                }
            }
        }
        model.addAttribute("roleName",roleName);

        EntityWrapper<Appraise> entityWrapper=new EntityWrapper();
        InformationCollect informationCollect=informationCollectMapper.selectById(id);
        model.addAttribute("info",informationCollect);
        entityWrapper.eq("order_id",informationCollect.getId());
        if(appraiseMapper.selectList(entityWrapper).size()>0){
            model.addAttribute("appraise",appraiseMapper.selectList(entityWrapper).get(0));
        }else {
            model.addAttribute("appraise",new Appraise());
        }
        EntityWrapper<Prescripti> prescriptiEntityWrapper=new EntityWrapper<>();
        prescriptiEntityWrapper.eq("information_id",informationCollect.getId());
        if(prescriptiMapper.selectList(prescriptiEntityWrapper).size()>0){
            model.addAttribute("prescripti",prescriptiMapper.selectList(prescriptiEntityWrapper).get(0));
        }else {
            model.addAttribute("prescripti",new Prescripti());
        }
//        ???????????????????????????
        EntityWrapper<FileList> fileListEntityWrapper=new EntityWrapper<>();
        fileListEntityWrapper.eq("project_state",informationCollect.getProject_stage());
        fileListEntityWrapper.eq("is_need","???");
        fileListEntityWrapper.eq("status","??????");
        List<FileList> fileLists=fileListMapper.selectList(fileListEntityWrapper);
//        ???????????????????????????????????????
        EntityWrapper<ProcessFile> processFileEntityWrapper=new EntityWrapper<>();
        processFileEntityWrapper.eq("information_id",informationCollect.getId());
        List<ProcessFile> processFileList =processFileMapper.selectList(processFileEntityWrapper);
        Boolean is_file=true;
        if(fileLists.size()>0){
            for(FileList fileList:fileLists){
                Boolean is_file_in=false;
                for(ProcessFile processFile:processFileList){
                    if(processFile.getFile_list_id().equals(fileList.getId())){
                        is_file_in=true;
                        break;
                    }
                }
                if(is_file_in==false){
                    is_file=false;
                }
                if(is_file){
                    is_file=is_file_in;
                }else {
                    break;
                }
            }
            model.addAttribute("is_file",is_file);
        }else {
            model.addAttribute("is_file",true);
        }


        return PREFIX+"edit.html";
    }
//    ???????????????
    @RequestMapping("/insert_information_collect")
    @ResponseBody
    public Object insert_information_collect(InformationCollect informationCollect){
//        ???????????????id
        informationCollect.setApply_user(ShiroKit.getUser().getId()+"");
//        ???????????????????????????
        informationCollect.setProject_stage("????????????");
//        ?????????????????????200?????????
        if(Integer.parseInt(informationCollect.getProject_money())>200){
//            ??????????????????
            informationCollect.setCurrent_process("??????");
        }else {
//            ???????????????????????????
            if(informationCollect.getIs_important().equals("???")){
                //            ??????????????????
                informationCollect.setCurrent_process("??????");
            }else {
//                ?????????????????????????????????????????????????????????
                if(informationCollect.getDept().contains("???????????????????????????")){
                    //            ??????????????????
                    informationCollect.setCurrent_process("??????");
                }else {
//                    ???????????????????????????
                    informationCollect.setCurrent_process("???????????????");
//                    ????????????????????????/?????????????????????????????????????????????????????????
                    informationCollect.setChoose_dept(informationCollect.getDept());
                }

            }
        }
        if(informationCollect.getId()==null || informationCollect.getId().equals("")){
            informationCollectMapper.insert(informationCollect);
            informationCollectOrderLogService.insertLog(informationCollect.getId(),"????????????","??????");
        }else {
            informationCollectMapper.updateById(informationCollect);
            informationCollectOrderLogService.insertLog(informationCollect.getId(),"????????????","????????????");
        }


        return "success";
    }

    @RequestMapping("/add_worktime")
    public String add_worktime(){
        return PREFIX+"edit/add/worktime.html";
    }
    @RequestMapping("/apply")
    public String apply(){
        return PREFIX+"apply.html";
    }
    @RequestMapping("/add_condition")
    public String add_condition(){
        return PREFIX+"edit/add/condition.html";
    }
    @RequestMapping("/add_income")
    public String add_income(){
        return PREFIX+"edit/add/income.html";
    }
    @RequestMapping("/add_pay")
    public String add_pay(){
        return PREFIX+"edit/add/pay.html";
    }
    @RequestMapping("/other_order")
    public String other_order(){
        return PREFIX+"other_order.html";
    }
    @RequestMapping("/add_weekreport")
    public String add_weekreport(){
        return PREFIX+"edit/add/weekreport.html";
    }
    @RequestMapping("/see_weekreport")
    public String see_weekreport(String see,Integer current_week, Model model){
        System.out.println(current_week);
        model.addAttribute("current_week",current_week);
        if(see!=null&&see.equals("see")){
            model.addAttribute("see","see");
        }else {
            model.addAttribute("see","nosee");
        }
        return PREFIX+"/weekreport_see.html";
    }
    @RequestMapping("/see_timeline")
    public String see_timeline(Integer current_timeline, Model model){
        model.addAttribute("current_timeline",current_timeline);
        return PREFIX+"/timeline_see.html";
    }
    @RequestMapping("/change_weekreport")
    public String change_weekreport(Integer current_week, Model model){
        System.out.println(current_week);
        model.addAttribute("current_week",current_week);
        return PREFIX+"/weekreport_change.html";
    }
    @RequestMapping("/change_timeline")
    public String change_timeline(Integer row, Model model){
        model.addAttribute("row",row);
        return PREFIX+"/change_timeline.html";
    }
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getpay_manger")
    @ResponseBody
    public List<String> getpay_manger(){
        List<String> list=new ArrayList<>();
        EntityWrapper<User> entityWrapper=new EntityWrapper();
        for(User user:userMapper.selectList(entityWrapper)){
            Role role=new Role();
            role.setName("????????????");
            Integer xj_role=roleMapper.selectOne(role).getId();
            List<Integer> rolelist = ShiroKit.getUser().getRoleList();
            String roleName="";
            if(rolelist.size()>0){
                for(Integer roleid : rolelist){
                    if(roleid>xj_role){
                        roleName =roleName + roleMapper.selectById(roleid).getName();
                    }
                }
            }
            if(roleName.contains("????????????")) {
                list.add(user.getName());
            }
        }
        return list;
    }
    @RequestMapping("/edit_see")
    public String edit_see(Integer id, Model model){
        model.addAttribute("informationId",id);
        Role role=new Role();
        role.setName("????????????");
        Integer xj_role=roleMapper.selectOne(role).getId();
        List<Integer> rolelist = ShiroKit.getUser().getRoleList();
        String roleName="";
        if(rolelist.size()>0){
            for(Integer roleid : rolelist){
                if(roleid>xj_role){
                    roleName =roleName + roleMapper.selectById(roleid).getName();
                }
            }
        }
        if(roleName.contains("????????????")){
            model.addAttribute("cansee",false);
        }else {
            model.addAttribute("cansee",true);
        }
        EntityWrapper<Appraise> entityWrapper=new EntityWrapper();
        InformationCollect informationCollect=informationCollectMapper.selectById(id);
        if (!StringUtils.isBlank(informationCollect.getOther_file())) {
            String other_file = informationCollect.getOther_file();
            model.addAttribute("other_file", getFiles(other_file));
        } else {
            model.addAttribute("other_file", "");
        }
        model.addAttribute("info",informationCollect);
        entityWrapper.eq("order_id",informationCollect.getId());
        if(appraiseMapper.selectList(entityWrapper).size()>0){
            model.addAttribute("appraise",appraiseMapper.selectList(entityWrapper).get(0));
        }else {
            model.addAttribute("appraise",new Appraise());
        }
        EntityWrapper<Prescripti> prescriptiEntityWrapper=new EntityWrapper<>();
        prescriptiEntityWrapper.eq("information_id",informationCollect.getId());
        if(prescriptiMapper.selectList(prescriptiEntityWrapper).size()>0){
            model.addAttribute("prescripti",prescriptiMapper.selectList(prescriptiEntityWrapper).get(0));
        }else {
            model.addAttribute("prescripti",new Prescripti());
        }
        EntityWrapper<InformationCollectOrderLog> informationCollectOrderLogEntityWrapper=new EntityWrapper<>();
        informationCollectOrderLogEntityWrapper.eq("order_id",informationCollect.getId());
        informationCollectOrderLogEntityWrapper.orderBy("id",false);
        if(informationCollectOrderLogService.selectList(informationCollectOrderLogEntityWrapper).size()>0){
            model.addAttribute("log",informationCollectOrderLogService.selectList(informationCollectOrderLogEntityWrapper));
        }else {
            model.addAttribute("log",new ArrayList<InformationCollectOrderLog>());
        }
        EntityWrapper<WeeklyReport> weeklyReportEntityWrapper =new EntityWrapper<>();
        weeklyReportEntityWrapper.eq("information_collect_id",informationCollect.getId());
        if(weeklyReportMapper.selectList(weeklyReportEntityWrapper).size()>0){
            model.addAttribute("weeklyReport",weeklyReportMapper.selectList(weeklyReportEntityWrapper).get(0));
        }else {
            model.addAttribute("weeklyReport",new WeeklyReport());
        }
        EntityWrapper<BudgetInfo> budgetInfoEntityWrapper=new EntityWrapper<>();
        budgetInfoEntityWrapper.eq("information_collect_id",informationCollect.getId());
        if(budgetInfoMapper.selectList(budgetInfoEntityWrapper).size()>0){
            model.addAttribute("budgetInfo",budgetInfoMapper.selectList(budgetInfoEntityWrapper).get(0));
        }else {
            model.addAttribute("budgetInfo",new BudgetInfo());
        }

        return PREFIX+"edit_see.html";
    }
//?????????????????????
    @RequestMapping("/getContent_applyUser")
    @ResponseBody
    public List<InformationCollect> getContent_applyUser(InformationCollect informationCollect) {
        EntityWrapper<InformationCollect> entityWrapper = new EntityWrapper();
//        ??????????????????
        if(informationCollect.getDept()!=null){
            entityWrapper.like("dept",informationCollect.getDept());
        }
        if(informationCollect.getDICI_system_num()!=null){
            entityWrapper.like("DICI_system_num",informationCollect.getDICI_system_num());
        }
        if (informationCollect.getProject_name()!=null){
            entityWrapper.like("project_name",informationCollect.getProject_name());
        }
        if(informationCollect.getPay_manager()!=null){
            entityWrapper.like("pay_manager",informationCollect.getPay_manager());
        }
        if(informationCollect.getPay_assistant()!=null){
            entityWrapper.like("pay_assistant",informationCollect.getPay_assistant());
        }
        if(informationCollect.getProject_stage()!=null){
            entityWrapper.like("project_stage",informationCollect.getProject_stage());
        }
        if(informationCollect.getTime_progress_situation()!=null){
            entityWrapper.like("time_progress_situation",informationCollect.getTime_progress_situation());
        }
        if(ShiroKit.getUser().getId()!=1){
            informationCollectOrderLogService.insertLog(null,"???????????????????????????","????????????");
        }
//        ???????????????id
        entityWrapper.eq("apply_user",ShiroKit.getUser().getId()+"");
        return informationCollectMapper.selectList(entityWrapper);

    }
//?????????????????????
    @RequestMapping("/getContent_manager")
    @ResponseBody
    public List<InformationCollect> getContent_manager(InformationCollect informationCollect) {
        EntityWrapper<InformationCollect> entityWrapper = new EntityWrapper();
//        ??????????????????
        if(informationCollect.getDept()!=null){
            entityWrapper.like("dept",informationCollect.getDept());
        }
        if(informationCollect.getDICI_system_num()!=null){
            entityWrapper.like("DICI_system_num",informationCollect.getDICI_system_num());
        }
        if (informationCollect.getProject_name()!=null){
            entityWrapper.like("project_name",informationCollect.getProject_name());
        }
        if(informationCollect.getPay_manager()!=null){
            entityWrapper.like("pay_manager",informationCollect.getPay_manager());
        }
        if(informationCollect.getPay_assistant()!=null){
            entityWrapper.like("pay_assistant",informationCollect.getPay_assistant());
        }
        if(informationCollect.getProject_stage()!=null){
            entityWrapper.like("project_stage",informationCollect.getProject_stage());
        }
        if(informationCollect.getTime_progress_situation()!=null){
            entityWrapper.like("time_progress_situation",informationCollect.getTime_progress_situation());
        }
        if(ShiroKit.getUser().getId()!=1){
            informationCollectOrderLogService.insertLog(null,"???????????????????????????","????????????");
        }
//        ??????????????????????????????????????????
        entityWrapper.eq("current_process","??????");
        return informationCollectMapper.selectList(entityWrapper);

    }
//    ?????????/?????????????????????
    @RequestMapping("/getContent_transfer")
    @ResponseBody
    public List<InformationCollect> getContent_transfer(InformationCollect informationCollect) {
        EntityWrapper<InformationCollect> entityWrapper = new EntityWrapper();
        if(informationCollect.getDept()!=null){
            entityWrapper.like("dept",informationCollect.getDept());
        }
        if(informationCollect.getDICI_system_num()!=null){
            entityWrapper.like("DICI_system_num",informationCollect.getDICI_system_num());
        }
        if (informationCollect.getProject_name()!=null){
            entityWrapper.like("project_name",informationCollect.getProject_name());
        }
        if(informationCollect.getPay_manager()!=null){
            entityWrapper.like("pay_manager",informationCollect.getPay_manager());
        }
        if(informationCollect.getPay_assistant()!=null){
            entityWrapper.like("pay_assistant",informationCollect.getPay_assistant());
        }
        if(informationCollect.getProject_stage()!=null){
            entityWrapper.like("project_stage",informationCollect.getProject_stage());
        }
        if(informationCollect.getTime_progress_situation()!=null){
            entityWrapper.like("time_progress_situation",informationCollect.getTime_progress_situation());
        }
        if(ShiroKit.getUser().getId()!=1){
            informationCollectOrderLogService.insertLog(null,"???????????????/?????????????????????","????????????");
        }
//        ????????????????????????
        List<Integer> roleList=ShiroKit.getUser().getRoleList();
        String rolestr="";
        for(Integer roleid:roleList){
            rolestr=rolestr+roleMapper.selectById(roleid).getName();
        }
//        ????????????????????????????????????
        if(rolestr.contains("??????????????????")){
//            ????????????????????????????????????
            entityWrapper.eq("current_process","???????????????");
//            ??????????????????????????????????????????
            User user=userMapper.selectById(ShiroKit.getUser().getId());
            String position = user.getPosition();
            if(position!=null && !position.equals("") && !position.equals("??????")){
                entityWrapper.andNew();
                List<String>positionlist = Arrays.asList(position.split(","));
                for(String positionstr :positionlist){
//                    ?????????????????????????????????
                    entityWrapper.like("choose_dept",positionstr).or();
                }
                entityWrapper.eq("1","2");
            }
//            ????????????????????????????????????
        } else if(rolestr.contains("??????????????????")){
//            ?????????????????????????????????????????????
            entityWrapper.eq("current_process","???????????????");
        }else {
            entityWrapper.eq("1","2");
        }
        System.out.println(informationCollectMapper.selectList(entityWrapper).size());
        return informationCollectMapper.selectList(entityWrapper);

}
//    ??????????????????
    @RequestMapping("/getContent_pass")
    @ResponseBody
    public List<InformationCollect> getContent_pass(InformationCollect informationCollect) {
        EntityWrapper<InformationCollect> entityWrapper = new EntityWrapper();
//        ??????????????????
        if(informationCollect.getDept()!=null){
            entityWrapper.like("dept",informationCollect.getDept());
        }
        if(informationCollect.getDICI_system_num()!=null){
            entityWrapper.like("DICI_system_num",informationCollect.getDICI_system_num());
        }
        if (informationCollect.getProject_name()!=null){
            entityWrapper.like("project_name",informationCollect.getProject_name());
        }
        if(informationCollect.getPay_manager()!=null){
            entityWrapper.like("pay_manager",informationCollect.getPay_manager());
        }
        if(informationCollect.getPay_assistant()!=null){
            entityWrapper.like("pay_assistant",informationCollect.getPay_assistant());
        }
        if(informationCollect.getProject_stage()!=null){
            entityWrapper.like("project_stage",informationCollect.getProject_stage());
        }
        if(informationCollect.getTime_progress_situation()!=null){
            entityWrapper.like("time_progress_situation",informationCollect.getTime_progress_situation());
        }
        if(ShiroKit.getUser().getId()!=1){
            informationCollectOrderLogService.insertLog(null,"???????????????/????????????","????????????");
        }
//        ??????-??????????????????????????????
        Integer userId=ShiroKit.getUser().getId();
        entityWrapper.like("pass_user",userId+"");

        List<InformationCollect> list=informationCollectMapper.selectList(entityWrapper);
        List<InformationCollect> InformationCollectList= new ArrayList<>();
//        ????????????
        for(InformationCollect informationCollect1:list){
            List<String> userlist= Arrays.asList(informationCollect1.getPass_user().split(","));
            for(String id:userlist){
                if(id.equals(userId+"")){
                    InformationCollectList.add(informationCollect1);
                    break;
                }
            }
        }
        return InformationCollectList;

    }

    @RequestMapping("/getContent")
    @ResponseBody
    public List<InformationCollect> getContent(String ongoing,InformationCollect informationCollect) {
        EntityWrapper<InformationCollect> entityWrapper = new EntityWrapper();
        if(informationCollect.getDept()!=null){
            entityWrapper.like("dept",informationCollect.getDept());
        }
        if(informationCollect.getDICI_system_num()!=null){
            entityWrapper.like("DICI_system_num",informationCollect.getDICI_system_num());
        }
        if (informationCollect.getProject_name()!=null){
            entityWrapper.like("project_name",informationCollect.getProject_name());
        }
        if(informationCollect.getPay_manager()!=null){
            entityWrapper.like("pay_manager",informationCollect.getPay_manager());
        }
        if(informationCollect.getPay_assistant()!=null){
            entityWrapper.like("pay_assistant",informationCollect.getPay_assistant());
        }
        if(informationCollect.getProject_stage()!=null){
            entityWrapper.like("project_stage",informationCollect.getProject_stage());
        }
        if(informationCollect.getTime_progress_situation()!=null){
            entityWrapper.like("time_progress_situation",informationCollect.getTime_progress_situation());
        }
        if(ongoing!=null){
            entityWrapper.ne("project_stage","???????????????");
        }
        Role role=new Role();
        role.setName("????????????");
        Integer xj_role=roleMapper.selectOne(role).getId();
        List<Integer> rolelist = ShiroKit.getUser().getRoleList();
        String roleName="";
        if(rolelist.size()>0){
            for(Integer roleid : rolelist){
                if(roleid>xj_role){
                    roleName =roleName + roleMapper.selectById(roleid).getName();
                }
            }
        }
        entityWrapper.eq("current_process","??????");
        if(roleName.contains("??????") || roleName.contains("????????????") || roleName.contains("????????????") || roleName.contains("????????????")|| roleName.contains("????????????")){
            User user=userMapper.selectById(ShiroKit.getUser().getId());
            if(user.getPosition()==null || user.getPosition().equals("") ||user.getPosition().equals("??????")){

            }else {
                entityWrapper.andNew();
                List<String>positionlist = Arrays.asList(user.getPosition().split(","));
                for(String positionstr :positionlist){
                    entityWrapper.like("choose_dept",positionstr).or();
                }
                entityWrapper.eq("1","2");

            }

        }else {
            if(roleName.contains("????????????")){
                entityWrapper.like("pay_manager",ShiroKit.getUser().getName());
            }else if(roleName.contains("????????????")){
                entityWrapper.like("pay_assistant",ShiroKit.getUser().getName());
            }
        }
        if(ShiroKit.getUser().getId()!=1){
            informationCollectOrderLogService.insertLog(null,"????????????","????????????");
        }

        return informationCollectMapper.selectList(entityWrapper);

    }

    @RequestMapping("/update_appraise")
    @ResponseBody
    public Tip update_appraise(Appraise appraise){

        EntityWrapper entityWrapper=new EntityWrapper();
        entityWrapper.eq("order_id",appraise.getOrder_id());
        List<Appraise> list=appraiseMapper.selectList(entityWrapper);
        if(list.size()>0){
            appraise.setId(list.get(0).getId());
            appraiseMapper.updateById(appraise);
        }else {
            appraiseMapper.insert(appraise);
        }
        informationCollectOrderLogService.insertLog(appraise.getOrder_id(),"???????????????","??????");
        return new SuccessTip();
    }
    @RequestMapping("/getBudgetInfo")
    @ResponseBody
    public BudgetInfo getBudgetInfo(Integer information_id) {
        BudgetInfo budgetInfo=new BudgetInfo();
        budgetInfo.setInformation_collect_id(information_id);
        budgetInfo=budgetInfoMapper.selectOne(budgetInfo);
        if(budgetInfo!=null){
            return budgetInfo;
        }else{
            return new BudgetInfo();
        }
    }

    @RequestMapping("/log_see")
    public String log_see(){
        return PREFIX+"log_see.html";
    }

    @RequestMapping("/getlog")
    @ResponseBody
    public List<InformationCollectOrderLog> getlog(String name){
        EntityWrapper<InformationCollectOrderLog> entityWrapper=new EntityWrapper<>();
        entityWrapper.orderBy("id",false);
        if(name!=null && !name.equals("")){
            entityWrapper.like("user_name",name);
        }
        List<InformationCollectOrderLog> list=informationCollectOrderLogService.selectList(entityWrapper);
        for(InformationCollectOrderLog informationCollectOrderLog:list){
            if(informationCollectOrderLog.getOrder_id()!=null){
                informationCollectOrderLog.setUser_dept(informationCollectMapper.selectById(informationCollectOrderLog.getOrder_id()).getDICI_system_num());
            }else {
                informationCollectOrderLog.setUser_dept("");
            }
        }
        return list;
    }
    @RequestMapping("/editBudgetInfo")
    @ResponseBody
    public Object editBudgetInfo(BudgetInfo budgetInfo) {
        Map<String,Object> returnMap=new HashMap<>();
        if(budgetInfo.getId()==null){
            budgetInfoMapper.insert(budgetInfo);
        }else{
            budgetInfoMapper.updateById(budgetInfo);
        }
        informationCollectOrderLogService.insertLog(budgetInfo.getInformation_collect_id(),"??????????????????","??????");
        returnMap.put("code",200);
        returnMap.put("data",budgetInfo);
        return returnMap;
    }
    @RequestMapping("/getReportInfo")
    @ResponseBody
    public WeeklyReport getReportInfo(Integer information_id) {
        WeeklyReport weeklyReport=new WeeklyReport();
        weeklyReport.setInformation_collect_id(information_id);
        weeklyReport=weeklyReportMapper.selectOne(weeklyReport);
        if(weeklyReport!=null){
            return weeklyReport;
        }else{
            return new WeeklyReport();
        }
    }
    @RequestMapping("/editReportInfo")
    @ResponseBody
    public Object editReportInfo(WeeklyReport weeklyReport) {
        while (weeklyReport.getReport_info().substring(0,1).equals("\"")){
            weeklyReport.setReport_info(StrUtil.strip(weeklyReport.getReport_info(),"\""));
        }
        Map<String,Object> returnMap=new HashMap<>();
        if(weeklyReport.getId()==null){

            weeklyReportMapper.insert(weeklyReport);
        }else{
            weeklyReportMapper.updateById(weeklyReport);
        }
        informationCollectOrderLogService.insertLog(weeklyReport.getInformation_collect_id(),"????????????","??????");
        returnMap.put("code",200);
        returnMap.put("data",weeklyReport);
        return returnMap;
    }

    @RequestMapping("/update_information_collect")
    @ResponseBody
    public Object update_information_collect(InformationCollect informationCollect){
        informationCollectMapper.updateById(informationCollect);
        informationCollectOrderLogService.insertLog(informationCollect.getId(),"??????????????????","??????");
        return "success";
    }
    // ??????
    @RequestMapping("/goback_information")
    @ResponseBody
    public Object goback_information(InformationCollect informationCollect){
        InformationCollect informationCollect1=informationCollectMapper.selectById(informationCollect.getId());
        String pass_user=informationCollect1.getPass_user();
        if(pass_user!=null && !pass_user.equals("")){
            informationCollect.setPass_user(pass_user+","+ShiroKit.getUser().getId());
        }else {
            informationCollect.setPass_user(ShiroKit.getUser().getId()+"");
        }
        informationCollect.setCurrent_process("??????");
        informationCollectMapper.updateById(informationCollect);
        informationCollectOrderLogService.insertLog(informationCollect.getId(),informationCollect.getBack_idea(),"??????");
        return "success";
    }
    // ???????????????
    @RequestMapping("/information_assign")
    @ResponseBody
    public Object information_assign(InformationCollect informationCollect){
        InformationCollect informationCollect1=informationCollectMapper.selectById(informationCollect.getId());
        String pass_user=informationCollect1.getPass_user();
        if(pass_user!=null && !pass_user.equals("")){
            informationCollect.setPass_user(pass_user+","+ShiroKit.getUser().getId());
        }else {
            informationCollect.setPass_user(ShiroKit.getUser().getId()+"");
        }
        if(informationCollect.getChoose_dept().contains("???????????????????????????")){
            informationCollect.setCurrent_process("???????????????");
        }else {
            informationCollect.setCurrent_process("???????????????");
        }

        informationCollectMapper.updateById(informationCollect);
        informationCollectOrderLogService.insertLog(informationCollect.getId(),"????????????????????????","??????");
        return "success";
    }
    // ???????????????
    @RequestMapping("/information_transfer")
    @ResponseBody
    public Object information_transfer(InformationCollect informationCollect){
        informationCollect=informationCollectMapper.selectById(informationCollect.getId());
        String pass_user=informationCollect.getPass_user();
        if(pass_user!=null && !pass_user.equals("")){
            informationCollect.setPass_user(pass_user+","+ShiroKit.getUser().getId());
        }else {
            informationCollect.setPass_user(ShiroKit.getUser().getId()+"");
        }
        informationCollect.setCurrent_process("??????");
        informationCollectMapper.updateById(informationCollect);
        informationCollectOrderLogService.insertLog(informationCollect.getId(),"???/???????????????","???/???????????????");
        return "success";
    }
    @RequestMapping("/getProgressInfo")
    @ResponseBody
    public Prescripti getProgressInfo(Integer information_id) {
        Prescripti prescripti=new Prescripti();
        prescripti.setInformation_id(information_id);
        prescripti=prescriptiMapper.selectOne(prescripti);
        if(prescripti!=null){
            return prescripti;
        }else{
            return new Prescripti();
        }
    }
//    ????????????
    @RequestMapping("/delete_information_collect")
    @ResponseBody
    public Object delete_information_collect(Integer id){
        InformationCollect informationCollect =informationCollectMapper.selectById(id);
        informationCollect.setCurrent_process("??????");
        informationCollectMapper.updateById(informationCollect);
        informationCollectOrderLogService.insertLog(informationCollect.getId(),"???????????????","??????");
        return "success";
    }
    @RequestMapping("/edit_prescripti")
    @ResponseBody
    public Object edit_prescripti(Prescripti prescripti){
        System.out.println(prescripti.getProgress_write());
        while (prescripti.getProgress_write().substring(0,1).equals("\"")){
            prescripti.setProgress_write(StrUtil.strip(prescripti.getProgress_write(),"\""));
        }

        System.out.println(prescripti.getProgress_write());
        InformationCollect informationCollect = informationCollectMapper.selectById(prescripti.getInformation_id());
        EntityWrapper<FileList> fileListEntityWrapper=new EntityWrapper<>();
        fileListEntityWrapper.eq("project_state",informationCollect.getProject_stage());
        fileListEntityWrapper.eq("is_need","???");
        fileListEntityWrapper.eq("status","??????");
        List<FileList> fileLists=fileListMapper.selectList(fileListEntityWrapper);
        EntityWrapper<ProcessFile> processFileEntityWrapper=new EntityWrapper<>();
        processFileEntityWrapper.eq("information_id",informationCollect.getId());
        List<ProcessFile> processFileList =processFileMapper.selectList(processFileEntityWrapper);
        Boolean is_file=true;
        if(fileLists.size()>0){
            for(FileList fileList:fileLists){
                Boolean is_file_in=false;
                for(ProcessFile processFile:processFileList){
                    if(processFile.getFile_list_id().equals(fileList.getId())){
                        is_file_in=true;
                        break;
                    }
                }
                if(is_file_in==false){
                    is_file=false;
                }
                if(is_file){
                    is_file=is_file_in;
                }else {
                    break;
                }
            }


        }
        if(!is_file){
            return "error";
        }

        if(prescripti.getId()==null){

            prescriptiMapper.insert(prescripti);
        }else{
            prescriptiMapper.updateById(prescripti);

            if(prescripti.getTime_level_compare()!=null&& !prescripti.getTime_level_compare().equals("") &&Integer.parseInt(prescripti.getTime_level_compare())<=0){
                informationCollect.setTime_progress_situation("??????");
            }else {
                informationCollect.setTime_progress_situation("??????");
            }
            informationCollect.setProject_stage(prescripti.getProject_stage().split(",")[prescripti.getProject_stage().split(",").length-1]);
            informationCollect.setStage_activity(prescripti.getStage_activity().split(",")[prescripti.getStage_activity().split(",").length-1]);
            informationCollectMapper.updateById(informationCollect);
        }
        informationCollectOrderLogService.insertLog(prescripti.getInformation_id(),"????????????","??????");
        return "success";
    }

    @RequestMapping("/decision_list")
    public String decision_list(Model model){
        return PREFIX+"decision/decision_list.html";
    }

    @RequestMapping("/decision_detail")
    public String decision_detail(Model model,Integer id){
        InformationCollect informationCollect=informationCollectMapper.selectById(id);
        model.addAttribute("info",informationCollect);
        return PREFIX+"decision/decision_detail.html";
    }

    @RequestMapping("/assign_list")
    public String assign_list(Model model){
        return PREFIX+"assign/assign_list.html";
    }

    @RequestMapping("/assign_detail")
    public String assign_detail(Model model,Integer id){
        EntityWrapper<Role> wrapper=new EntityWrapper<>();
        wrapper.eq("name","????????????");
        Integer pay_manager_id = roleMapper.selectList(wrapper).get(0).getId();
        EntityWrapper<User> entityWrapper=new EntityWrapper();
        entityWrapper.like("roleid",pay_manager_id+"");
        entityWrapper.ne("id",1);
        model.addAttribute("payManagerList",userMapper.selectList(entityWrapper));

        EntityWrapper<Role> wrapper1=new EntityWrapper<>();
        wrapper1.eq("name","????????????");
        Integer pay_assistant_id = roleMapper.selectList(wrapper1).get(0).getId();
        EntityWrapper<User> entityWrapper1=new EntityWrapper();
        entityWrapper1.like("roleid",pay_assistant_id+"");
        entityWrapper1.ne("id",1);
        model.addAttribute("payAssistantList",userMapper.selectList(entityWrapper1));

        InformationCollect informationCollect=informationCollectMapper.selectById(id);
        model.addAttribute("info",informationCollect);
        return PREFIX+"assign/assign_detail.html";
    }
    @RequestMapping("/pass_verify")
    @ResponseBody
    public Object pass_verify(InformationCollect informationCollect){
        String verify_idea= informationCollect.getVerify_idea();
        informationCollect=informationCollectMapper.selectById(informationCollect.getId());
        informationCollect.setVerify_idea(verify_idea);
        String current_process = informationCollect.getCurrent_process();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowtime = sf.format(new Date());
        if (current_process.equals("????????????")){
            informationCollect.setCurrent_process("??????");
        }else if(current_process.equals("????????????")) {
            informationCollect.setCurrent_process("??????");
        }
        String verify_user=informationCollect.getVerify_user();
        String verify_time=informationCollect.getVerify_time();
        if(verify_user==null || !verify_user.equals("")){
            informationCollect.setVerify_user(ShiroKit.getUser().getId()+"");
        }else {
            informationCollect.setVerify_user(verify_user+","+ShiroKit.getUser().getId());
        }
        if(verify_time==null || !verify_time.equals("")){
            informationCollect.setVerify_time(nowtime);
        }else {
            informationCollect.setVerify_time(verify_time+","+nowtime);
        }
        informationCollectMapper.updateById(informationCollect);
        informationCollectOrderLogService.insertLog(informationCollect.getId(),current_process+"-??????",current_process);
        return "success";
    }
    @RequestMapping("/nopass_verify")
    @ResponseBody
    public Object nopass_verify(InformationCollect informationCollect){
        String verify_idea= informationCollect.getVerify_idea();
        informationCollect=informationCollectMapper.selectById(informationCollect.getId());
        informationCollect.setVerify_idea(verify_idea);
        String current_process = informationCollect.getCurrent_process();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowtime = sf.format(new Date());
        informationCollect.setCurrent_process("??????");
        String verify_user=informationCollect.getVerify_user();
        String verify_time=informationCollect.getVerify_time();
        if(verify_user==null || !verify_user.equals("")){
            informationCollect.setVerify_user(ShiroKit.getUser().getId()+"");
        }else {
            informationCollect.setVerify_user(verify_user+","+ShiroKit.getUser().getId());
        }
        if(verify_time==null || !verify_time.equals("")){
            informationCollect.setVerify_time(nowtime);
        }else {
            informationCollect.setVerify_time(verify_time+","+nowtime);
        }
        informationCollectMapper.updateById(informationCollect);
        informationCollectOrderLogService.insertLog(informationCollect.getId(),current_process+"-?????????-"+informationCollect.getVerify_idea(),current_process);
        return "success";
    }
    @RequestMapping("/add_verify_remove")
    @ResponseBody
    public Object add_verify_remove(InformationCollect informationCollect){
        String apply = informationCollect.getApply_verify_idea();
        informationCollect =informationCollectMapper.selectById(informationCollect.getId());
        informationCollect.setCurrent_process("????????????");
        informationCollect.setApply_verify_idea(apply);
        informationCollectMapper.updateById(informationCollect);
        informationCollectOrderLogService.insertLog(informationCollect.getId(),apply,"??????????????????");
        return "success";
    }
    @RequestMapping("/add_verify_wait")
    @ResponseBody
    public Object add_verify_wait(InformationCollect informationCollect){
        String apply = informationCollect.getApply_verify_idea();
        informationCollect =informationCollectMapper.selectById(informationCollect.getId());
        informationCollect.setCurrent_process("????????????");
        informationCollect.setApply_verify_idea(apply);
        informationCollectMapper.updateById(informationCollect);
        informationCollectOrderLogService.insertLog(informationCollect.getId(),apply,"??????????????????");
        return "success";
    }
    @RequestMapping("/add_verify")
    public String add_verify(Model model,Integer id){
        model.addAttribute("info",informationCollectMapper.selectById(id));
        return PREFIX+"verify/add_verify.html";
    }
    @RequestMapping("/apply_verify")
    public String apply_verify(){
        return PREFIX+"verify/apply_verify.html";
    }
    @RequestMapping("/getApply_verify")
    @ResponseBody
    public List<InformationCollect> getApply_verify(InformationCollect informationCollect){
        EntityWrapper<InformationCollect> entityWrapper = new EntityWrapper();
        if(informationCollect.getDept()!=null){
            entityWrapper.like("dept",informationCollect.getDept());
        }
        if(informationCollect.getDICI_system_num()!=null){
            entityWrapper.like("DICI_system_num",informationCollect.getDICI_system_num());
        }
        if (informationCollect.getProject_name()!=null){
            entityWrapper.like("project_name",informationCollect.getProject_name());
        }
        if(informationCollect.getCurrent_process()!=null){
            entityWrapper.like("current_process",informationCollect.getCurrent_process());
        }
        if(informationCollect.getPay_assistant()!=null){
            entityWrapper.like("pay_assistant",informationCollect.getPay_assistant());
        }
        if(informationCollect.getProject_stage()!=null){
            entityWrapper.like("project_stage",informationCollect.getProject_stage());
        }
        if(informationCollect.getTime_progress_situation()!=null){
            entityWrapper.like("time_progress_situation",informationCollect.getTime_progress_situation());
        }
        if(ShiroKit.getUser().getId()!=1){
            informationCollectOrderLogService.insertLog(null,"????????????/??????????????????","????????????");
        }
        if(!ShiroKit.getUser().getName().contains("?????????????????????")){
            entityWrapper.like("pay_manager",ShiroKit.getUser().getName());
        }
        entityWrapper.ne("current_process","??????");
        entityWrapper.ne("current_process","??????");
        entityWrapper.ne("current_process","???????????????");
        entityWrapper.ne("current_process","??????");
        entityWrapper.ne("current_process","???????????????");
        return informationCollectMapper.selectList(entityWrapper);
    }

    @RequestMapping("/replace_order")
    @ResponseBody
    public Object replace_order(Integer id){
        InformationCollect informationCollect = informationCollectMapper.selectById(id);
        informationCollect.setCurrent_process("??????");
        informationCollectOrderLogService.insertLog(informationCollect.getId(),"??????????????????","????????????");
        informationCollectMapper.updateById(informationCollect);
        return "success";
    }

    @RequestMapping("/defer_verify_list")
    public String defer_verify_list(Model model){
        return PREFIX+"verify/defer_verify_list.html";
    }
    @RequestMapping("/defer_verify_detail")
    public String defer_verify_detail(Model model,Integer id){
        InformationCollect informationCollect=informationCollectMapper.selectById(id);
        model.addAttribute("info",informationCollect);
        return PREFIX+"verify/defer_verify_detail.html";
    }
    @RequestMapping("/get_wait_verify_list")
    @ResponseBody
    public List<InformationCollect> get_wait_verify_list(InformationCollect informationCollect) {
        EntityWrapper<InformationCollect> entityWrapper = new EntityWrapper();
        if(informationCollect.getDept()!=null){
            entityWrapper.like("dept",informationCollect.getDept());
        }
        if(informationCollect.getDICI_system_num()!=null){
            entityWrapper.like("DICI_system_num",informationCollect.getDICI_system_num());
        }
        if (informationCollect.getProject_name()!=null){
            entityWrapper.like("project_name",informationCollect.getProject_name());
        }
        if(informationCollect.getPay_manager()!=null){
            entityWrapper.like("pay_manager",informationCollect.getPay_manager());
        }
        if(informationCollect.getPay_assistant()!=null){
            entityWrapper.like("pay_assistant",informationCollect.getPay_assistant());
        }
        if(informationCollect.getProject_stage()!=null){
            entityWrapper.like("project_stage",informationCollect.getProject_stage());
        }
        if(informationCollect.getTime_progress_situation()!=null){
            entityWrapper.like("time_progress_situation",informationCollect.getTime_progress_situation());
        }
        if(ShiroKit.getUser().getId()!=1){
            informationCollectOrderLogService.insertLog(null,"????????????????????????","????????????");
        }
//        ????????????????????????
        List<Integer> roleList=ShiroKit.getUser().getRoleList();
        String rolestr="";
        for(Integer roleid:roleList){
            rolestr=rolestr+roleMapper.selectById(roleid).getName();
        }
//        ????????????????????????????????????
        if(rolestr.contains("??????????????????")){
            entityWrapper.lt("project_money",200);
            User user=userMapper.selectById(ShiroKit.getUser().getId());
            String position = user.getPosition();
            if(position!=null && ! position.equals("") && !position.equals("??????")){
                entityWrapper.andNew();
                List<String>positionlist = Arrays.asList(position.split(","));
                for(String positionstr :positionlist){
                    entityWrapper.like("choose_dept",positionstr).or();
                }
                entityWrapper.eq("1","2");
            }
//            ????????????????????????????????????
        } else if(rolestr.contains("??????????????????")){
//            entityWrapper.andNew();
            entityWrapper.ge("project_money",200);
//            entityWrapper.or().eq("choose_dept","????????????");
        }else {
            entityWrapper.eq("1","2");
        }
        entityWrapper.andNew();
        entityWrapper.like("current_process","????????????");
        entityWrapper.or();
        entityWrapper.like("current_process","????????????");
        return informationCollectMapper.selectList(entityWrapper);
    }
    @RequestMapping("/get_verifyed_list")
    @ResponseBody
    public List<InformationCollect> get_wait_verifyed_list(InformationCollect informationCollect) {
        EntityWrapper<InformationCollect> entityWrapper = new EntityWrapper();
        if(informationCollect.getDept()!=null){
            entityWrapper.like("dept",informationCollect.getDept());
        }
        if(informationCollect.getDICI_system_num()!=null){
            entityWrapper.like("DICI_system_num",informationCollect.getDICI_system_num());
        }
        if (informationCollect.getProject_name()!=null){
            entityWrapper.like("project_name",informationCollect.getProject_name());
        }
        if(informationCollect.getPay_manager()!=null){
            entityWrapper.like("pay_manager",informationCollect.getPay_manager());
        }
        if(informationCollect.getPay_assistant()!=null){
            entityWrapper.like("pay_assistant",informationCollect.getPay_assistant());
        }
        if(informationCollect.getProject_stage()!=null){
            entityWrapper.like("project_stage",informationCollect.getProject_stage());
        }
        if(informationCollect.getTime_progress_situation()!=null){
            entityWrapper.like("time_progress_situation",informationCollect.getTime_progress_situation());
        }
        if(ShiroKit.getUser().getId()!=1){
            informationCollectOrderLogService.insertLog(null,"???????????????????????????","????????????");
        }
        entityWrapper.like("verify_user",ShiroKit.getUser().getId().toString());
        return informationCollectMapper.selectList(entityWrapper);

    }

    @RequestMapping("/get_pay_people")
    @ResponseBody
    public Map<String,Object> get_pay_people(InformationCollect informationCollect){
        Map<String,Object> result=new HashMap<>();
        String position=informationCollect.getChoose_dept().substring(0,2);

        EntityWrapper<Role> wrapper=new EntityWrapper<>();
        wrapper.eq("name","????????????");
        Integer pay_manager_id = roleMapper.selectList(wrapper).get(0).getId();
        EntityWrapper<User> entityWrapper=new EntityWrapper();
        entityWrapper.like("roleid",pay_manager_id+"");
        entityWrapper.ne("id",1);
        entityWrapper.andNew();
        if("??????".equals(position)){
            entityWrapper.like("position","??????");
            entityWrapper.or();
            entityWrapper.eq("position","");
            entityWrapper.or();
            entityWrapper.isNull("position");
        }else{
            entityWrapper.like("position",position);
        }
        result.put("pay_manager",userMapper.selectList(entityWrapper));

        EntityWrapper<Role> wrapper1=new EntityWrapper<>();
        wrapper1.eq("name","????????????");
        Integer pay_assistant_id = roleMapper.selectList(wrapper1).get(0).getId();
        EntityWrapper<User> entityWrapper1=new EntityWrapper();
        entityWrapper1.like("roleid",pay_assistant_id+"");
        entityWrapper1.ne("id",1);
        entityWrapper1.andNew();
        if("??????".equals(position)){
            entityWrapper1.like("position","??????");
            entityWrapper1.or();
            entityWrapper1.eq("position","");
            entityWrapper1.or();
            entityWrapper1.isNull("position");
        }else{
            entityWrapper1.like("position",position);
        }
        result.put("pay_assistant",userMapper.selectList(entityWrapper1));
        return result;
    }

    @RequestMapping("/get_export_content")
    @ResponseBody
    public void get_export_content(InformationCollect informationCollect, HttpServletResponse response) throws IOException {
        EntityWrapper<InformationCollect> entityWrapper = new EntityWrapper();
        entityWrapper.ne("project_stage","???????????????");
        Role role=new Role();
        role.setName("????????????");
        Integer xj_role=roleMapper.selectOne(role).getId();
        List<Integer> rolelist = ShiroKit.getUser().getRoleList();
        String roleName="";
        if(rolelist.size()>0){
            for(Integer roleid : rolelist){
                if(roleid>xj_role){
                    roleName =roleName + roleMapper.selectById(roleid).getName();
                }
            }
        }
        entityWrapper.ne("project_stage","??????");
        entityWrapper.eq("current_process","??????");
        if(roleName.contains("??????") || roleName.contains("????????????") || roleName.contains("????????????") || roleName.contains("????????????")|| roleName.contains("????????????")){
            User user=userMapper.selectById(ShiroKit.getUser().getId());
            if(user.getPosition()==null || user.getPosition().equals("") ||user.getPosition().equals("??????")){

            }else {
                entityWrapper.andNew();
                List<String>positionlist = Arrays.asList(user.getPosition().split(","));
                for(String positionstr :positionlist){
                    entityWrapper.like("choose_dept",positionstr).or();
                }
                entityWrapper.eq("1","2");

            }
        }else {
            if(roleName.contains("????????????")){
                entityWrapper.like("pay_manager",ShiroKit.getUser().getName());
            }else if(roleName.contains("????????????")){
                entityWrapper.like("pay_assistant",ShiroKit.getUser().getName());
            }
        }
        List<InformationCollect> tempList=informationCollectMapper.selectList(entityWrapper);
        String Ids="";
        for(int i=0;i<tempList.size();i++){
            Ids+=tempList.get(i).getId().toString()+",";
        }
        Ids=Ids.substring(0,Ids.length()-1);
        List<Map<String,Object>> result=informationCollectMapper.get_export_content(Ids);
        for(int j=0;j<result.size();j++){
            if(!result.get(j).getOrDefault("report_info","").equals("")){
                List<JSONObject> tempList2= JSONArray.parseArray(result.get(j).get("report_info").toString(),JSONObject.class);
                Collections.reverse(tempList2);
                result.get(j).put("report_info",JSONArray.parseArray(tempList2.toString()));
            }
        }

        List<List<String>> title = get_title();
        ExportUtilFormwork.exportData(result, title.get(0), title.get(1), response, "????????????.xlsx");
    }

    @RequestMapping("/get_export_content2")
    @ResponseBody
    public void get_export_content2(InformationCollect informationCollect, HttpServletResponse response) throws IOException {
        EntityWrapper<InformationCollect> entityWrapper = new EntityWrapper();
        entityWrapper.eq("project_stage","???????????????");
        List<InformationCollect> tempList=informationCollectMapper.selectList(entityWrapper);
        String Ids="";
        for(int i=0;i<tempList.size();i++){
            Ids+=tempList.get(i).getId().toString()+",";
        }
        Ids=Ids.substring(0,Ids.length()-1);
        List<Map<String,Object>> result=informationCollectMapper.get_export_content(Ids);
        for(int j=0;j<result.size();j++){
            if(!result.get(j).getOrDefault("report_info","").equals("")){
                List<JSONObject> tempList2= JSONArray.parseArray(result.get(j).get("report_info").toString(),JSONObject.class);
                Collections.reverse(tempList2);
                result.get(j).put("report_info",JSONArray.parseArray(tempList2.toString()));
            }
        }

        List<List<String>> title = get_title();
        ExportUtilFormwork.exportData(result, title.get(0), title.get(1), response, "????????????.xlsx");
    }

    @RequestMapping("/ict_count")
    public String ict_count(){
        return PREFIX+"test/ictCount.html";
    }

    @Autowired
    private IctPVMapper ictPVMapper;

    @RequestMapping("/get_ict_count")
    @ResponseBody
    public Object get_ict_count(){
        List<Map<String,Object>> result=new ArrayList<>();
        List<Map<String,Object>> enter_times=ictCountMapper.select_date();
        for (int i=0;i<enter_times.size();i++){
            result.add(ictCountMapper.select_count_by_date(enter_times.get(i).get("enter_time").toString()));
//            EntityWrapper entityWrapper=new EntityWrapper();
//            entityWrapper.eq("count_time",enter_times.get(i).get("enter_time").toString());
//            List<IctPV> ictPVList=ictPVMapper.selectList(entityWrapper);
//            if(ictPVList!=null){
//                result.add(ictPVList.get(0).getCount());
//            }

        }
        return result;
    }
    @RequestMapping("/get_ict_count_all")
    @ResponseBody
    public Object get_ict_count_all(){
        List<Map<String,Integer>> result=new ArrayList<>();
        EntityWrapper entityWrapper=new EntityWrapper();
        Integer uv=ictCountMapper.selectList(entityWrapper).size();
        EntityWrapper entityWrapper1=new EntityWrapper();
        List<IctPV> ictPVList = ictPVMapper.selectList(entityWrapper1);
        Integer pv= 0;
        if(ictPVList.size()>0){
            for(IctPV ictpv : ictPVList){
                pv=pv+ictpv.getCount();
            }
        }
        Map<String,Integer> map=new HashMap<>();
        map.put("uv",uv+220);
        map.put("pv",pv+1910);
        result.add(map);
        return result;
    }

    private static List<List<String>> get_title(){
        List<List<String>> list = new ArrayList<>(4);
        List<String> CELL_HEAD_CN = new ArrayList<>();
        List<String> CELL_HEAD_EN = new ArrayList<>();
        CELL_HEAD_CN.add("??????");                   CELL_HEAD_EN.add("id");
        CELL_HEAD_CN.add("????????????");                      CELL_HEAD_EN.add("project_name");
        CELL_HEAD_CN.add("DICI????????????");                     CELL_HEAD_EN.add("DICI_system_num");
        CELL_HEAD_CN.add("?????????/??????");                     CELL_HEAD_EN.add("dept");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("pay_manager");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("pay_assistant");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("contract_num");
        CELL_HEAD_CN.add("????????????(??????)");                     CELL_HEAD_EN.add("project_money");
        CELL_HEAD_CN.add("????????????(?????????)");                     CELL_HEAD_EN.add("project_stage");

        CELL_HEAD_CN.add("????????????(?????????)");                     CELL_HEAD_EN.add("stage_activity");
        CELL_HEAD_CN.add("??????????????????");                     CELL_HEAD_EN.add("time_progress_situation");
        CELL_HEAD_CN.add("??????????????????");                     CELL_HEAD_EN.add("project_manager_name");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("part_leader");
        CELL_HEAD_CN.add("????????????????????????");                     CELL_HEAD_EN.add("project_manager_phone");

        CELL_HEAD_CN.add("??????ICT????????????");                     CELL_HEAD_EN.add("net_ICT_hold_specialist");
        CELL_HEAD_CN.add("????????????????????????");                     CELL_HEAD_EN.add("is_deep_integration");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("hurry_level");
        CELL_HEAD_CN.add("??????");                     CELL_HEAD_EN.add("profession");
        CELL_HEAD_CN.add("???????????????");                     CELL_HEAD_EN.add("is_select");
        CELL_HEAD_CN.add("???????????????");                     CELL_HEAD_EN.add("integration_name");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("money_mode");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("manage_unit");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("pay_mode");
        CELL_HEAD_CN.add("??????");                     CELL_HEAD_EN.add("current_process");
        CELL_HEAD_CN.add("?????????id");                     CELL_HEAD_EN.add("apply_user");
        CELL_HEAD_CN.add("??????????????????");                     CELL_HEAD_EN.add("is_important");
        CELL_HEAD_CN.add("????????????id");                     CELL_HEAD_EN.add("pass_user");
        CELL_HEAD_CN.add("?????????????????????");                     CELL_HEAD_EN.add("choose_dept");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("back_idea");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("verify_idea");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("verify_time");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("back_time");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("apply_time");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("pass_process");
        CELL_HEAD_CN.add("???????????????");                     CELL_HEAD_EN.add("verify_user");
        CELL_HEAD_CN.add("????????????/???????????????");                     CELL_HEAD_EN.add("apply_verify_idea");
        CELL_HEAD_CN.add("??????");                     CELL_HEAD_EN.add("other_file");
        CELL_HEAD_CN.add("???????????????");                     CELL_HEAD_EN.add("client_appraise");
        CELL_HEAD_CN.add("?????????????????????");                     CELL_HEAD_EN.add("need_dept_appraise");
        CELL_HEAD_CN.add("?????????????????????");                     CELL_HEAD_EN.add("collect_dept_appraise");
        CELL_HEAD_CN.add("?????????????????????");                     CELL_HEAD_EN.add("end_dept_appraise");
        CELL_HEAD_CN.add("ICT??????????????????");                     CELL_HEAD_EN.add("ict_no");
        CELL_HEAD_CN.add("??????????????????");                     CELL_HEAD_EN.add("is_apply_budget");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("is_out_account");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("collection_condition");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("collection_progress");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("payment_progress");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("is_owe");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("owe_reason");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("out_account_price");
        CELL_HEAD_CN.add("??????????????????");                     CELL_HEAD_EN.add("contract_sign_time");
        CELL_HEAD_CN.add("??????????????????(???????????????)");                     CELL_HEAD_EN.add("plan_pay_time");
        CELL_HEAD_CN.add("??????????????????");                     CELL_HEAD_EN.add("project_reality_time");
        CELL_HEAD_CN.add("??????????????????");                     CELL_HEAD_EN.add("contract_work_day");
        CELL_HEAD_CN.add("?????????????????????");                     CELL_HEAD_EN.add("worked_day");
        CELL_HEAD_CN.add("???????????????");                     CELL_HEAD_EN.add("time_level_compare");
        CELL_HEAD_CN.add("????????????");                     CELL_HEAD_EN.add("progress_write");
        CELL_HEAD_CN.add("??????");                     CELL_HEAD_EN.add("report_info");

        list.add(CELL_HEAD_CN);
        list.add(CELL_HEAD_EN);
        return list;
    }

    public String getFiles(String files) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Map<String, Object>> fileMaps = new ArrayList<>();
        if (files != null && files.length() > 0) {
            String[] fileStr = files.split(",");
            List<String> fileList = Arrays.asList(fileStr);
            for (Integer i = 0; i < fileList.size(); i++) {
                Map<String, Object> map = new HashMap<>();
                GunsFile file = gunsFileMapper.getGunsFileByfileId(fileList.get(i));
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

    @RequestMapping("/modify")
    @ResponseBody
    public Object modify(Integer id){
        InformationCollect informationCollect=new InformationCollect();
        informationCollect.setId(id);
        informationCollect.setCurrent_process("????????????");
        informationCollect.setModify_user_id(ShiroKit.getUser().getId());
        informationCollectMapper.updateById(informationCollect);
        informationCollectOrderLogService.insertLog(informationCollect.getId(),"??????????????????","??????");
        return new SuccessTip();
    }

    @RequestMapping("/modify_verify_list")
    public String modify_list(){
        return PREFIX+"verify/modify_verify_list.html";
    }

    /**
    *type:1 ?????????
     *  type:2 ?????????
    **/
    @RequestMapping("/get_modify_verify_list")
    @ResponseBody
    public Object get_modify_verify_list(InformationCollect informationCollect,Integer type){
        if(type==1){
            EntityWrapper<InformationCollect> entityWrapper=new EntityWrapper<>();
            entityWrapper.eq("current_process","????????????");
            if(informationCollect.getDept()!=null){
                entityWrapper.like("dept",informationCollect.getDept());
            }
            if(informationCollect.getDICI_system_num()!=null){
                entityWrapper.like("DICI_system_num",informationCollect.getDICI_system_num());
            }
            if (informationCollect.getProject_name()!=null){
                entityWrapper.like("project_name",informationCollect.getProject_name());
            }
            if(informationCollect.getPay_manager()!=null){
                entityWrapper.like("pay_manager",informationCollect.getPay_manager());
            }
            if(informationCollect.getPay_assistant()!=null){
                entityWrapper.like("pay_assistant",informationCollect.getPay_assistant());
            }
            if(informationCollect.getProject_stage()!=null){
                entityWrapper.like("project_stage",informationCollect.getProject_stage());
            }
            if(informationCollect.getTime_progress_situation()!=null){
                entityWrapper.like("time_progress_situation",informationCollect.getTime_progress_situation());
            }
            if(ShiroKit.getUser().getId()!=1){
                informationCollectOrderLogService.insertLog(null,"??????????????????????????????","????????????");
            }
            return informationCollectMapper.selectMaps(entityWrapper);
        }else if(type==2){
            EntityWrapper<InformationCollectOrderLog> wrapper=new EntityWrapper<>();
            wrapper.like("operate","????????????");
            wrapper.eq("user_id",ShiroKit.getUser().getId());
            List<Map<String,Object>> verify_list=informationCollectOrderLogService.selectMaps(wrapper);
            List<String> ids=new ArrayList<>();
            for(Map<String,Object> map:verify_list){
                String order_id=map.getOrDefault("order_id","").toString();
                if(StringUtils.isNotEmpty(order_id)){
                    ids.add(order_id);
                    InformationCollect collect=informationCollectMapper.selectById(order_id);
                    map.put("dept",collect.getDept());
                    map.put("project_name",collect.getProject_name());
                    map.put("pay_manager",collect.getPay_manager());
                }
            }
            if(ShiroKit.getUser().getId()!=1){
                informationCollectOrderLogService.insertLog(null,"?????????????????????????????????","????????????");
            }
            return verify_list;
        }else{
            return null;
        }
    }

    @RequestMapping("/modify_verify_detail")
    public String modify_verify_detail(Model model,Integer id){
        InformationCollect informationCollect=informationCollectMapper.selectById(id);
        model.addAttribute("info",informationCollect);
        return PREFIX+"verify/modify_verify_detail.html";
    }
    @RequestMapping("/pass_modify_verify")
    @ResponseBody
    public Object pass_modify_verify(Integer type,Integer id,String modify_idea){

        InformationCollect temp=informationCollectMapper.selectById(id);
        InformationCollect informationCollect=new InformationCollect();
        informationCollect.setId(id);
        if(type==1){
            informationCollect.setCurrent_process("?????????");
            informationCollectOrderLogService.insertLog(informationCollect.getId(),"????????????"+"-??????","????????????");
        }else if(type==2){
            informationCollect.setCurrent_process("??????");
            informationCollectOrderLogService.insertLog(informationCollect.getId(),"????????????"+"-??????","????????????");
        }else{

        }
        if(StringUtils.isNotEmpty(modify_idea)){
            modify_idea=modify_idea.replaceAll(",","???");
            if(StringUtils.isNotEmpty(temp.getModify_idea())){
                informationCollect.setModify_idea(temp.getModify_idea()+","+modify_idea);
            }else{
                informationCollect.setModify_idea(modify_idea);
            }
        }
        informationCollectMapper.updateById(informationCollect);
        return "success";
    }
    @RequestMapping("/wait_modify_list")
    public String wait_modify_list(Model model){
        return PREFIX+"verify/wait_modify_list.html";
    }
    @RequestMapping("/get_wait_modify_list")
    @ResponseBody
    public Object get_wait_modify_list(){

        EntityWrapper<InformationCollect> wrapper=new EntityWrapper<>();
        wrapper.eq("current_process","?????????");
        wrapper.eq("modify_user_id",ShiroKit.getUser().getId());
        informationCollectOrderLogService.insertLog(null,"???????????????????????????","????????????");

        return informationCollectMapper.selectMaps(wrapper);
    }

    @RequestMapping("/modifyDetail")
    public String modifyDetail(Integer id, Model model){
        if(1==1){
            EntityWrapper<Role> wrapper=new EntityWrapper<>();
            wrapper.eq("name","????????????");
            Integer pay_manager_id = roleMapper.selectList(wrapper).get(0).getId();
            EntityWrapper<User> entityWrapper=new EntityWrapper();
            entityWrapper.like("roleid",pay_manager_id+"");
            entityWrapper.ne("id",1);
            model.addAttribute("payManagerList",userMapper.selectList(entityWrapper));
            EntityWrapper<Role> wrapper1=new EntityWrapper<>();
            wrapper1.eq("name","????????????");
            Integer pay_assistant_id = roleMapper.selectList(wrapper1).get(0).getId();
            EntityWrapper<User> entityWrapper1=new EntityWrapper();
            entityWrapper1.like("roleid",pay_assistant_id+"");
            entityWrapper1.ne("id",1);
            model.addAttribute("payAssistantList",userMapper.selectList(entityWrapper1));
        }
        Role role=new Role();
        role.setName("????????????");
        Integer xj_role=roleMapper.selectOne(role).getId();
        List<Integer> rolelist = ShiroKit.getUser().getRoleList();
        String roleName="";
        if(rolelist.size()>0){
            for(Integer roleid : rolelist){
                if(roleid>xj_role){
                    roleName =roleName + roleMapper.selectById(roleid).getName();
                }
            }
        }
        model.addAttribute("roleName",roleName);

        EntityWrapper<Appraise> entityWrapper=new EntityWrapper();
        InformationCollect informationCollect=informationCollectMapper.selectById(id);
        model.addAttribute("info",informationCollect);
        entityWrapper.eq("order_id",informationCollect.getId());
        if(appraiseMapper.selectList(entityWrapper).size()>0){
            model.addAttribute("appraise",appraiseMapper.selectList(entityWrapper).get(0));
        }else {
            model.addAttribute("appraise",new Appraise());
        }
        EntityWrapper<Prescripti> prescriptiEntityWrapper=new EntityWrapper<>();
        prescriptiEntityWrapper.eq("information_id",informationCollect.getId());
        if(prescriptiMapper.selectList(prescriptiEntityWrapper).size()>0){
            model.addAttribute("prescripti",prescriptiMapper.selectList(prescriptiEntityWrapper).get(0));
        }else {
            model.addAttribute("prescripti",new Prescripti());
        }
        return PREFIX+"modify.html";
    }

    @RequestMapping("/modify_submit")
    @ResponseBody
    public Object modify_submit(InformationCollect informationCollect,Prescripti prescripti){

        Prescripti p=new Prescripti();
        informationCollect.setCurrent_process("??????");
        informationCollectMapper.updateById(informationCollect);
        EntityWrapper<Prescripti> wrapper=new EntityWrapper<>();
        p.setInformation_id(informationCollect.getId());
        p=prescriptiMapper.selectOne(p);
        prescripti.setId(p.getId());
        prescriptiMapper.updateById(prescripti);

        informationCollectOrderLogService.insertLog(informationCollect.getId(),"????????????","??????");

        return new SuccessTip();
    }
}
