package com.stylefeng.guns.modular.informationCollect;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.base.tips.ErrorTip;
import com.stylefeng.guns.core.base.tips.SuccessTip;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.core.bean.FileBean;
import com.stylefeng.guns.core.bean.FileParam;
import com.stylefeng.guns.core.bean.FileType;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.core.util.FileUtil;
import com.stylefeng.guns.core.util.PathUtils;
import com.stylefeng.guns.core.util.crypt.MD5;
import com.stylefeng.guns.core.util.ffmpeg.VideoUtils;
import com.stylefeng.guns.core.util.type.StringUtils;
import com.stylefeng.guns.core.util.type.TypeUtils;
import com.stylefeng.guns.modular.gunsFile.controller.service.IGunsFileService;
import com.stylefeng.guns.modular.system.dao.informationCollect.OrderInfoMapper;
import com.stylefeng.guns.modular.system.model.Dept;
import com.stylefeng.guns.modular.system.model.GunsFile;
import com.stylefeng.guns.modular.system.model.Role;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.model.informationCollect.OrderInfo;
import com.stylefeng.guns.modular.system.service.IDeptService;
import com.stylefeng.guns.modular.system.service.IRoleService;
import com.stylefeng.guns.modular.system.service.IUserService;
import com.stylefeng.guns.util.ExportUtilFormwork;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author gjx
 * @description
 * @date 2022/1/4
 */
@Controller
@RequestMapping("/orderInfo_temp")
public class OrderInfoController {

    private String PREFIX = "/informationCollect/alfred";
    private String PREFIX2= "/informationCollect/edit2";
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IDeptService deptService;

    @RequestMapping("/Alfred")
    public String Alfred(){

        return PREFIX+"/alfred.html";
    }

    @RequestMapping("/openAlfredPage")
    public String openAlfredPage(Integer alfred_id, Model model){
        model.addAttribute("alfred_id", alfred_id);
        return PREFIX+"/openAlfredPage.html";
    }

    @Autowired
    IGunsFileService fileService;

    @RequestMapping("/openAlfredDetailPage")
    public String openAlfredDetailPage(Integer alfred_id, Model model){
        OrderInfo orderInfo =
                orderInfoMapper.selectById(alfred_id);
        if (orderInfo == null){
            orderInfo = new OrderInfo();
        }

        StringBuilder names = new StringBuilder();
        StringBuilder fileIds = new StringBuilder();
        if (!StringUtils.isBlank(orderInfo.getFiles())){
            String[] split = orderInfo.getFiles().split(",");
            for (String str : split){
                GunsFile gunsFileByfileId = fileService.getGunsFileByfileId(str);
                if (gunsFileByfileId!=null){
                    names.append(gunsFileByfileId.getFilename());
                    names.append(",");
                    fileIds.append(gunsFileByfileId.getFileId());
                    fileIds.append(",");
                }
            }

        }
        String namess = names.toString();
        String fileIdss = fileIds.toString();
        if (namess.indexOf(",")!=-1){
            model.addAttribute("names", namess.substring(0, namess.length()-1));
            model.addAttribute("fileIds", fileIdss.substring(0, fileIdss.length()-1));
        }else{
            model.addAttribute("names", namess);
            model.addAttribute("fileIds", fileIdss);
        }
        model.addAttribute("orderInfo", orderInfo);
        return PREFIX+"/alfredDetailPage.html";
    }

    @RequestMapping("/alfredList")
    @ResponseBody
    public List<OrderInfo> alfredList(String status, String custom_name, String company_name, String customer_manager,String quyu){
        EntityWrapper<OrderInfo> infoEntityWrapper = new EntityWrapper<>();
        if(!StringUtils.isBlank(customer_manager)){
            EntityWrapper<User> wrapper = new EntityWrapper<>();
            wrapper.like("name", customer_manager);
            List<User> userList = userService.selectList(wrapper);
            if (userList.size()>0){

                List<Integer> collect = userList.stream().map(User::getId).collect(Collectors.toList());
                infoEntityWrapper.in("client_manager_id", collect);
            }
        }

        if (!StringUtils.isBlank(status)){
            infoEntityWrapper.eq("order_status", status);
        }else{
            infoEntityWrapper.eq("order_status", "待转派");
        }

        if (!StringUtils.isBlank(custom_name)){
            infoEntityWrapper.like("custom_name", custom_name);
        }

        if (!StringUtils.isBlank(company_name)){
            infoEntityWrapper.like("company_name", company_name);
        }

        if (!StringUtils.isBlank(quyu)){
            infoEntityWrapper.like("company_city", quyu);
        }

        List<OrderInfo> orderInfos = orderInfoMapper.selectList(infoEntityWrapper);
        return orderInfos;
    }

    @RequestMapping("/custom_list")
    @ResponseBody
    public Object custom_list(String quyu, String custom_name){
        EntityWrapper<Role> wrapper = new EntityWrapper<>();
        wrapper.like("name", "客户经理");
        List<Role> roles = roleService.selectList(wrapper);
        if (!StringUtils.isBlank(quyu)){
            List<Role> rolex = new ArrayList<>();
            List<Role> collect = new ArrayList<>();
            String[] split = quyu.split(",");
            for (int i=0;i<split.length;i++){
                String s = split[i];
                if (s.equals("市")){
                    collect = roles.stream().filter(x -> x.getName().indexOf(s) != -1 && x.getName().indexOf("省") == -1).collect(Collectors.toList());
                }else{
                    collect = roles.stream().filter(x -> x.getName().indexOf(s) != -1).collect(Collectors.toList());
                }
                rolex.addAll(collect);
            }
            roles = rolex;
        }
        List<Map<String, Object>> list = new ArrayList();

        for (Role role: roles){
            List<User> userList = userService.selectByRoleid(role.getId());
            for (User user : userList){
                Map<String, Object> map = new HashMap<>();
                Dept dept = deptService.selectById(user.getDeptid());

                map.put("id", user.getId());
                map.put("role_name", role.getName().substring(0, role.getName().length()-4));
                map.put("dept", dept.getFullname());
                map.put("custom_name", user.getName());
                map.put("custom_phone", user.getPhone());
                list.add(map);
            }
        }

        if (!StringUtils.isBlank(custom_name)){
            list = list.stream().filter(x -> x.get("custom_name").toString().indexOf(custom_name)!=-1).collect(Collectors.toList());
        }

        return list;
    }

    @RequestMapping("/alfredCustom")
    @ResponseBody
    public Tip alfredCustom(Integer user_id, Integer alfred_id, String qk_info, String ss_info){

        User user = userService.selectById(user_id);
        if (user!=null){
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setId(alfred_id);
            orderInfo.setClient_manager_id(user_id.toString());
            orderInfo.setCustom_manager(user.getName());
            orderInfo.setCustom_manager_phone(user.getPhone());
            orderInfo.setOrder_status("已指定");
            orderInfo.setQk_info(qk_info);
            orderInfo.setSs_info(ss_info);
            orderInfo.setIs_read("未读");
            orderInfoMapper.updateById(orderInfo);
        }

        return new SuccessTip();
    }

    @RequestMapping("/downloadFile")
    @ResponseBody
    public void downloadFile(HttpServletRequest request, HttpServletResponse response, String fileId) throws IOException {
        EntityWrapper<GunsFile> fileWrapper=new EntityWrapper<>();
        fileWrapper.eq("file_id",fileId);
        GunsFile file=fileService.selectOne(fileWrapper);
        String fileName=file.getFilename();
        String filePath=file.getFilePath();
        String realPath = OrderInfoController.class.getResource("/").getPath()+filePath.substring(1);
        downloadFile(request, response, realPath,fileName);
    }

    private void downloadFile(HttpServletRequest request, HttpServletResponse response, String path, String realName) throws IOException {
        String[] split = path.split("/");
        String fileName = split[split.length - 1];
        byte[] decodeByte= FileUtil.downloadFile(path);
        // 对文件进行url编码
        if (realName != null && realName != ""){
            fileName = realName;
        }
        if (request.getHeader("user-agent").toLowerCase().contains("msie")
                || request.getHeader("user-agent").toLowerCase().endsWith("like gecko")// ie10以上取消了msie用户代理字符串
                ) {
            // IE
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } else {
            // 非IE
            fileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
        }

        if(decodeByte!=null){
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" +fileName);// 设置文件名
            InputStream fis = null;
            OutputStream os=null;
            try {
                fis = new ByteArrayInputStream(decodeByte);
                os = response.getOutputStream();
                int len = 0;
                byte[] b = new byte[1024];
                while ((len = fis.read(b)) > 0) {
                    os.write(b, 0, len);
                }
                fis.close();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 订单列表
     *
     * @return 订单页
     */
    @RequestMapping("/orderList")
    public String orderList() {
        return PREFIX + "/orderList.html";
    }

    /**
     * 跳转至订单编辑页
     *
     * @param model    model
     * @param orderNum 订单编号
     * @return 订单编辑页
     */
    @RequestMapping("/orderEdit")
    public String orderEdit(Model model, String orderNum) {
        OrderInfo orderInfo = orderInfoMapper.selectOrderByOrderNumber(orderNum);
        if (orderInfo != null) {
            model.addAttribute("orderInfo", orderInfo);
            model.addAttribute("orderFiles",getFiles(orderInfo.getFiles()));
        }else {
            model.addAttribute(new OrderInfo());
        }
        return PREFIX + "/orderEdit.html";
    }

    /**
     * 获取订单列表
     * @return
     */
    @RequestMapping("/getOrderList")
    @ResponseBody
    public List<Map<String, Object>> getOrderList(String order_number, String order_time, String current_process, String company_name, String custom_name,
                               String custom_phone, String custom_manager, String custom_manager_phone,
                               String ICT_product,String group_code) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        EntityWrapper<OrderInfo> wrapper = new EntityWrapper<>();
        if (!StringUtils.isBlank(order_number)){
            wrapper.like("order_number", order_number);
        }
        if (!StringUtils.isBlank(current_process)){
            wrapper.like("current_process", current_process);
        }
        if (!StringUtils.isBlank(company_name)){
            wrapper.like("company_name", company_name);
        }
        if (!StringUtils.isBlank(custom_name)){
            wrapper.like("custom_name", custom_name);
        }
        if (!StringUtils.isBlank(custom_phone)){
            wrapper.like("custom_phone", custom_phone);
        }
        if (!StringUtils.isBlank(custom_manager)){
            wrapper.like("custom_manager", custom_manager);
        }
        if (!StringUtils.isBlank(custom_manager_phone)){
            wrapper.like("custom_manager_phone", custom_manager_phone);
        }
        if (!StringUtils.isBlank(ICT_product)){
            wrapper.like("ICT_product", ICT_product);
        }
        if (!StringUtils.isBlank(group_code)){
            wrapper.like("group_code", group_code);
        }
        if (!StringUtils.isBlank(order_time)){
            wrapper.like("down_order_time", order_time);
        }

        mapList = orderInfoMapper.selectMaps(wrapper);
        return mapList;
    }

    @RequestMapping("/exportData")
    @ResponseBody
    public void exportData(HttpServletResponse response,String order_number,
                           String order_time, String current_process, String company_name, String custom_name,
                           String custom_phone, String custom_manager, String custom_manager_phone,
                           String ICT_product,String group_code) {
        List<Map<String, Object>> orderList = getOrderList(order_number, order_time, current_process, company_name, custom_name, custom_phone, custom_manager, custom_manager_phone, ICT_product, group_code);

        List<String> CELL_HEAD_CN = new ArrayList<>();
        List<String> CELL_HEAD_EN = new ArrayList<>();
        CELL_HEAD_CN.add("序号");         CELL_HEAD_EN.add("id");
        CELL_HEAD_CN.add("订单状态");         CELL_HEAD_EN.add("order_status");
        CELL_HEAD_CN.add("所在环节");         CELL_HEAD_EN.add("curren_process");
        CELL_HEAD_CN.add("订单编号");         CELL_HEAD_EN.add("order_number");
        CELL_HEAD_CN.add("下单时间");         CELL_HEAD_EN.add("down_order_time");
        CELL_HEAD_CN.add("公司名");         CELL_HEAD_EN.add("company_name");
        CELL_HEAD_CN.add("客户姓名");         CELL_HEAD_EN.add("custom_name");
        CELL_HEAD_CN.add("客户联系方式");         CELL_HEAD_EN.add("custom_phone");
        CELL_HEAD_CN.add("详细地址");         CELL_HEAD_EN.add("company_address");
        CELL_HEAD_CN.add("公司区域");         CELL_HEAD_EN.add("company_city");
        CELL_HEAD_CN.add("客户经理");         CELL_HEAD_EN.add("custom_manager");
        CELL_HEAD_CN.add("客户经理电话");         CELL_HEAD_EN.add("custom_manager_phone");
        CELL_HEAD_CN.add("需求描述");         CELL_HEAD_EN.add("request_describe");
        CELL_HEAD_CN.add("ICT产品类型");         CELL_HEAD_EN.add("ICT_product");
        CELL_HEAD_CN.add("ICT产品名称");         CELL_HEAD_EN.add("ICT_product_name");
        CELL_HEAD_CN.add("ICT产品数量");         CELL_HEAD_EN.add("ICT_product_quantity");
        CELL_HEAD_CN.add("集团编码");         CELL_HEAD_EN.add("group_code");
        CELL_HEAD_CN.add("提单人电话");         CELL_HEAD_EN.add("applyer_phone");
        CELL_HEAD_CN.add("下单时间");         CELL_HEAD_EN.add("apply_time");
        CELL_HEAD_CN.add("设计环节时间");         CELL_HEAD_EN.add("design_time");
        CELL_HEAD_CN.add("施工时间");         CELL_HEAD_EN.add("work_time");
        CELL_HEAD_CN.add("验收时间");         CELL_HEAD_EN.add("end_time");
        CELL_HEAD_CN.add("前勘人员信息");         CELL_HEAD_EN.add("qk_info");
        CELL_HEAD_CN.add("实施人员信息");         CELL_HEAD_EN.add("ss_info");

        ExportUtilFormwork.exportData(orderList, CELL_HEAD_CN, CELL_HEAD_EN, response, "导出数据.xlsx");

//        ExportUtilFormwork.exportFormwork(response, "导出数据.xlsx", workbook);
    }

    /**
     * 获取订单详情
     *
     * @param model
     * @param orderNum
     * @return
     */
    @RequestMapping("/getOrderDetail")
    public String getOrderDetail(Model model, String orderNum) {
        OrderInfo orderInfo = orderInfoMapper.selectOrderByOrderNumber(orderNum);
        if (orderInfo != null) {
            model.addAttribute("orderInfo", orderInfo);
            model.addAttribute("orderFiles",getFiles(orderInfo.getFiles()));
        }else {
            model.addAttribute(new OrderInfo());
        }
        return PREFIX + "/orderDetail.html";
    }

    /**
     * 编辑订单
     *
     * @param orderInfo
     * @param orderNum
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Tip edit(OrderInfo orderInfo) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        orderInfo.setDesign_time(simpleDateFormat.format(new Date()));
        orderInfo.setOrder_status("待转派");
        orderInfo.setIs_read("未读");
        Integer temp = orderInfoMapper.updateById(orderInfo);
        if (temp > 0) {
            return new SuccessTip();
        } else {
            return new ErrorTip(500, "保存失败");
        }
    }

    @RequestMapping("/edit2")
    public String edit2(Integer id, Model model){
        OrderInfo orderInfo=orderInfoMapper.selectById(id);
        model.addAttribute("orderInfo",orderInfoMapper.selectById(id));
        String project_file = orderInfo.getProject_file()==null?"":orderInfo.getProject_file(); //项目方案
        String money_file = orderInfo.getMoney_file()==null?"":orderInfo.getMoney_file(); //项目报价
        String contract_file = orderInfo.getContract_file()==null?"":orderInfo.getContract_file();  //项目合同
        String client_contract_file=orderInfo.getClient_contract_file()==null?"":orderInfo.getClient_contract_file();   //客户附件
        model.addAttribute("project_file", project_file==""?"":getFiles(project_file));
        model.addAttribute("money_file", money_file==""?"":getFiles(money_file));
        model.addAttribute("contract_file", contract_file==""?"":getFiles(contract_file));
        model.addAttribute("client_contract_file", client_contract_file==""?"":getFiles(client_contract_file));
        return PREFIX2+"/edit.html";
    }

    @RequestMapping("/first_submit")
    @ResponseBody
    public Tip first_submit(OrderInfo orderInfo) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        orderInfo.setDesign_time(simpleDateFormat.format(new Date()));
        orderInfo.setOrder_status("待转派");
        orderInfo.setIs_read("未读");
        orderInfo.setCurren_process("设计环节");
        Integer temp = orderInfoMapper.updateById(orderInfo);
        if (temp > 0) {
            return new SuccessTip();
        } else {
            return new ErrorTip(500, "提交失败");
        }
    }

    @RequestMapping("/second_submit")
    @ResponseBody
    public Tip second_submit(OrderInfo orderInfo) {

        Integer temp = orderInfoMapper.updateById(orderInfo);
        if (temp > 0) {
            return new SuccessTip();
        } else {
            return new ErrorTip(500, "提交失败");
        }
    }

    //上传文件
    @RequestMapping("/uploadFiles")
    @ResponseBody
    @CrossOrigin
    public Object uploadFiles(@RequestParam("file") MultipartFile[] fileList) throws ParseException {
        List<String> fileStr = addFileAndReturnFileIds(fileList);
        Map<String, Object> returnData = new HashMap<String, Object>();
        returnData.put("code", 200);
        returnData.put("fileList", fileStr);
        return returnData;
    }

    public List<String> addFileAndReturnFileIds(MultipartFile[] fileList) {
        List<String> fileStr = new ArrayList<String>();
        if (fileList != null && fileList.length > 0) {
            //组合image名称，“;隔开”
            List<String> fileName = new ArrayList<String>();
            for (MultipartFile m : fileList) {
                //1.文件不为空
                //定义文件参数类，获取文件后缀，保存文件到t_sys_file表中
                FileParam fileParam = new FileParam();
                String ext = PathUtils.getSuffix(m).substring(1);
                fileParam.setThumb(true);
//                fileParam.setType(ext);
                GunsFile gunsFile = this.addFile(m, fileParam);
                fileStr.add(gunsFile.getFileId());
            }
        }
        return fileStr;
    }

    public GunsFile addFile(MultipartFile f, FileParam param) {
        try {
            String fileId = StringUtils.uuid();
            File toFile = PathUtils.getUpload(fileId, f);
            FileBean fileBean = new FileBean(f, fileId);
            fileBean.setSaveFile(toFile);
            return addFile(fileBean, param);
        } catch (IOException e) {
            throw new GunsException("上传失败");
        }
    }

    public GunsFile addFile(FileBean file, FileParam param) throws IOException {
        String md5 = MD5.getFileMD5(file.getSaveFile());
        EntityWrapper<GunsFile> entityWrapper = new EntityWrapper<>();
        Wrapper<GunsFile> wrapper = entityWrapper.eq("md5", md5);
        GunsFile gunsFile = fileService.selectOne(wrapper);
        if (gunsFile == null || !gunsFile.getSize().equals(file.getSize())) {
            String thumb = "";
            if (file.getContentType().contains("jpeg") || file.getContentType().contains("png") || file.getContentType().contains("jpg")) {
                thumb = createThumb(param, file.getSaveFile()); //创建略缩图
            }
            gunsFile = new GunsFile();
            gunsFile.setFileId(file.getFileId());
            gunsFile.setFilename(file.getFilename());
            gunsFile.setFilePath(PathUtils.getPath(file.getSaveFile()));
            gunsFile.setMimeType(file.getContentType());
            gunsFile.setThumbPath(thumb);
            gunsFile.setSize(file.getSize());
            gunsFile.setMd5(md5);
            gunsFile.setAddTime(new Date());
            gunsFile.setType(param == null ? "" : param.getType());
//            gunsFile.setUpload_people(ShiroKit.getUser().getName());
            fileService.insert(gunsFile);
        }
        return gunsFile;
    }

    public String createThumb(FileParam param, File toFile) throws FileNotFoundException {
        File thumbFile = null;
        try {
            if (param != null && param.getThumb() != null && param.getThumb()) {
                //图片略缩图
                if (FileType.IMAGE.getType().equals(param.getType())) {
                    Thumbnails.Builder<File> builder = Thumbnails.of(toFile);
                    if (!TypeUtils.empty(param.getSize())) {
                        String[] size = param.getSize().split("x");
                        if (size.length == 1) {
                            builder.width(Integer.valueOf(size[0]));
                        } else if (size.length == 2) {
                            builder.size(Integer.valueOf(size[0]), Integer.valueOf(size[1]));
                        }
                    }
                    thumbFile = PathUtils.getThumb(toFile, ".jpg");
                    builder.toFile(thumbFile);

                    //视频文件略缩图
                } else if (FileType.VIDEO.getType().equals(param.getType())) {
                    thumbFile = PathUtils.getThumb(toFile, ".jpg");
                    VideoUtils.getVideoImage(toFile.getAbsolutePath(),
                            thumbFile.getAbsolutePath());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PathUtils.getPath(thumbFile);
    }

    //    获取文件
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

}
