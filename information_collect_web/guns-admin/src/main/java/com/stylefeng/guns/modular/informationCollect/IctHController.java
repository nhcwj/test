package com.stylefeng.guns.modular.informationCollect;

import cn.hutool.crypto.asymmetric.SignAlgorithm;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.util.AES;
import com.stylefeng.guns.core.util.LySign;
import com.stylefeng.guns.core.util.type.StringUtils;
import com.stylefeng.guns.modular.system.dao.GunsFileMapper;
import com.stylefeng.guns.modular.system.dao.RoleMapper;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.*;
import com.stylefeng.guns.modular.system.model.GunsFile;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.model.informationCollect.*;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 此处狗标不能进入
 * */

@CrossOrigin
@Controller
@RequestMapping("/ict")
public class IctHController {
    @Autowired
    private IctInfoMapper ictInfoMapper;

    @Autowired
    private IctOrderMapper ictOrderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private GunsFileMapper gunsFileMapper;

    @Autowired
    private IctCountMapper ictCountMapper;

    @Autowired
    private IctLogMapper ictLogMapper;

    @Autowired
    private IctPVMapper ictPVMapper;

    @Autowired
    private IctRemarkMapper remarkMapper;

    public static Map<String, Integer> countMap = new HashMap<>();

    public String getNum() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String today = simpleDateFormat.format(new Date());
        StringBuilder orderNumb = new StringBuilder("FS-DJ-").append(today).append("-");
        synchronized (this) {
            if (countMap.containsKey(today)) {
                Integer orderCount = countMap.get(today);
                orderCount += 1;
                countMap.put(today, orderCount);
                if (orderCount < 10) {
                    orderNumb.append("000").append(orderCount);
                } else if (orderCount < 100) {
                    orderNumb.append("00").append(orderCount);
                } else if (orderCount < 1000) {
                    orderNumb.append("0").append(orderCount);
                } else {
                    orderNumb.append(orderCount);
                }
            } else {
                EntityWrapper<IctOrder> wrapper = new EntityWrapper<>();
                wrapper.like("order_no", today);
                wrapper.orderBy("id", false);
                wrapper.last("limit 1");
                List<IctOrder> orderInfos = ictOrderMapper.selectList(wrapper);
                if (orderInfos == null || orderInfos.size() == 0) {
                    countMap.put(today, 1);
                    orderNumb.append("0001");
                } else {
                    String order_num = orderInfos.get(0).getOrder_no();
                    order_num = order_num.substring(order_num.length() - 4);
                    Integer orderCount = Integer.valueOf(order_num);
                    orderCount += 1;
                    countMap.put(today, orderCount);
                    if (orderCount < 10) {
                        orderNumb.append("000").append(orderCount);
                    } else if (orderCount < 100) {
                        orderNumb.append("00").append(orderCount);
                    } else if (orderCount < 1000) {
                        orderNumb.append("0").append(orderCount);
                    } else {
                        orderNumb.append(orderCount);
                    }
                }
            }
        }
        return orderNumb.toString();
    }

    //    UV
    @RequestMapping("/login")
    @ResponseBody
    public Object login(String role, String user_id, String phone) {
        String enter_time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        IctCount ictCount = new IctCount();
        ictCount.setEnter_time(enter_time);
        ictCount.setRole(role);
        ictCountMapper.insert(ictCount);
        IctLog ictLog = new IctLog();
        ictLog.setContent("登录");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = simpleDateFormat.format(new Date());
        ictLog.setOperate_time(today);
        if (role.equals("客户经理")) {
            User user = userMapper.selectById(user_id);
            ictLog.setName(user.getName());
            ictLog.setPhone(user.getPhone());
        } else {
            ictLog.setClient_phone(phone);
        }
        ictLogMapper.insert(ictLog);
        return "success";
    }

    // PV
    @RequestMapping("/click_in")
    @ResponseBody
    public Object click_in() {
        String enter_time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        EntityWrapper<IctPV> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("count_time", enter_time);
        synchronized (this) {
            List<IctPV> ictPVList = ictPVMapper.selectList(entityWrapper);
            if (ictPVList != null && ictPVList.size() > 0) {
                IctPV ictPV = ictPVList.get(0);
                Integer count = ictPV.getCount() + 1;
                ictPV.setCount(count);
                ictPVMapper.updateById(ictPV);
            } else {
                IctPV ictPV = new IctPV();
                ictPV.setCount(1);
                ictPV.setCount_time(enter_time);
                ictPVMapper.insert(ictPV);
            }
        }
        return "success";
    }

    //    建单
    @RequestMapping("/insertOrder")
    @ResponseBody
    public String insertOrder(@RequestBody IctOrder ictOrder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = simpleDateFormat.format(new Date());
        ictOrder.setOrder_no(getNum());
        String phone = ictOrder.getClient_manager_phone();
        IctLog ictLog = new IctLog();
        EntityWrapper<User> userEntityWrapper = new EntityWrapper<>();
        userEntityWrapper.eq("phone", phone);
        List<User> userList = userMapper.selectList(userEntityWrapper);
        User user =new User();
        if (userList.size() > 0) {
            if(userList.size()>1){
                for(User u:userList){
                    String rolestr = "";
                    List<String> rolelist = Arrays.asList(u.getRoleid().split(","));
                    for (String role : rolelist) {
                        rolestr += roleMapper.selectById(role);
                    }
                    if(rolestr.contains("客户经理")){
                        user = u;
                        break;
                    }
                }
            }else {
                user = userList.get(0);
            }

            String rolestr = "";
            List<String> rolelist = Arrays.asList(user.getRoleid().split(","));
            for (String role : rolelist) {
                rolestr += roleMapper.selectById(role);
            }
            if (rolestr.contains("客户经理")) {
                ictOrder.setClient_manager(user.getName());
                ictOrder.setClient_manager_id(user.getId());
                ictLog.setName(user.getName());
                ictLog.setPhone(user.getPhone());
            } else {
                ictOrder.setClient_manager_phone("");
            }
        } else {
            ictOrder.setClient_manager_phone("");
        }
        ictOrder.setOrder_status("初步订单审核");
        ictOrder.setOrder_time(today);
        ictOrder.setIs_change_client("是");
        ictOrder.setIs_change("否");
        ictOrder.setStatus("1");
        ictOrderMapper.insert(ictOrder);
        ictLog.setClient_phone(ictOrder.getApply_phone());
        ictLog.setOrder_id(ictOrder.getId() + "");
        ictLog.setContent("下单");
        ictLog.setOperate_time(today);
        ictLogMapper.insert(ictLog);
        return "success";
    }

    @RequestMapping("/uploadOrder")
    @ResponseBody
    public String uploadOrder(@RequestBody IctOrder ictOrder) {
        ictOrderMapper.updateById(ictOrder);
        return "success";
    }

    @Autowired
    private OrderTypeMapper orderTypeMapper;

    @RequestMapping("/getTypeList")
    @ResponseBody
    public List<OrderType> getTypeList(Integer orderId){
        EntityWrapper entityWrapper=new EntityWrapper();
        entityWrapper.eq("ict_order_id",orderId);
        List<OrderType> orderTypeList=orderTypeMapper.selectList(entityWrapper);
        return orderTypeList;
    }

    @RequestMapping("/uploadOrder_confirm")
    @ResponseBody
    public String uploadOrder_confirm(IctOrder ictOrder,String remark) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = simpleDateFormat.format(new Date());
//        解决decimal update后值为0问题
        IctOrder ictOrder1 = ictOrderMapper.selectById(ictOrder.getId());
        ictOrder.setProject_budget(ictOrder1.getProject_budget());
        ictOrder.setService_price(ictOrder1.getService_price());
        ictOrder.setService_total_price(ictOrder1.getService_total_price());
        ictOrder.setProject_total_price(ictOrder1.getProject_total_price());

        if(ictOrder.getOrder_is_pass().equals("是")){
            ictOrder.setOrder_status("正式订单审核");
            ictOrder.setConfirm_time(today);
            ictOrder.setIs_change_client("是");
            ictOrderMapper.updateById(ictOrder);
            IctLog ictLog = new IctLog();
            ictLog.setOperate_time(today);
            ictLog.setProcess("订单确认");
            ictLog.setContent("提交");
            ictLog.setOrder_id(ictOrder.getId() + "");
            ictLog.setClient_phone(ictOrderMapper.selectById(ictOrder.getId()).getClient_link_phone());

            ictLogMapper.insert(ictLog);
        }else {
            ictOrder.setOrder_status("业务审核");
            ictOrder.setIs_change_client("是");
            ictOrderMapper.updateById(ictOrder);
            IctLog ictLog = new IctLog();
            ictLog.setOperate_time(today);
            ictLog.setProcess("订单确认");
            ictLog.setContent("不通过退回-"+ictOrder.getOrder_pass_suggest());
            ictLog.setOrder_id(ictOrder.getId() + "");
            ictLog.setClient_phone(ictOrderMapper.selectById(ictOrder.getId()).getClient_link_phone());

            ictLogMapper.insert(ictLog);
        }


        //插入日志
        if(ictOrder.getOrder_is_pass().equals("是")){
            if(StringUtils.isNotEmpty(remark)){
                IctReamrkInfo reamrkInfo=new IctReamrkInfo();
                reamrkInfo.setName(ictOrder1.getClient_name());
                reamrkInfo.setPhone(ictOrder1.getClient_link_phone());
                reamrkInfo.setOperate_time(today);
                reamrkInfo.setProcess(ictOrder1.getOrder_status());
                reamrkInfo.setOrder_id(ictOrder1.getId()+"");
                reamrkInfo.setRemark(remark);
                remarkMapper.insert(reamrkInfo);
            }
        }else{
            if(StringUtils.isNotEmpty(ictOrder.getOrder_pass_suggest())){
                IctReamrkInfo reamrkInfo=new IctReamrkInfo();
                reamrkInfo.setName(ictOrder1.getClient_name());
                reamrkInfo.setPhone(ictOrder1.getClient_link_phone());
                reamrkInfo.setOperate_time(today);
                reamrkInfo.setProcess(ictOrder1.getOrder_status());
                reamrkInfo.setOrder_id(ictOrder1.getId()+"");
                reamrkInfo.setRemark(ictOrder.getOrder_pass_suggest());
                remarkMapper.insert(reamrkInfo);
            }
        }



        return "success";
    }

    @RequestMapping("/star_insert")
    @ResponseBody
    public IctOrder star_insert(Integer order_id,String star_value,String star_idea){
        IctOrder ictOrder=ictOrderMapper.selectById(order_id);
        ictOrder.setStar_value(star_value);
        ictOrder.setStar_idea(star_idea);
        ictOrder.setIs_star("是");
        ictOrderMapper.updateById(ictOrder);
        return ictOrder;
    }

    @RequestMapping("/uploadOrder_money")
    @ResponseBody
    public String uploadOrder_money(String order_id, IctInfo ictInfo,String remark) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = simpleDateFormat.format(new Date());
        IctOrder ictOrder = ictOrderMapper.selectById(order_id);

        //插入日志
        if(StringUtils.isNotEmpty(remark)){
            IctReamrkInfo reamrkInfo=new IctReamrkInfo();
            reamrkInfo.setName(ictOrder.getClient_name());
            reamrkInfo.setPhone(ictOrder.getClient_link_phone());
            reamrkInfo.setOperate_time(today);
            reamrkInfo.setProcess(ictOrder.getOrder_status());
            reamrkInfo.setOrder_id(ictOrder.getId()+"");
            reamrkInfo.setRemark(remark);
            remarkMapper.insert(reamrkInfo);
        }

        ictInfo.setWait_pay_time(today);
        ictInfoMapper.insert(ictInfo);
        ictOrder.setInfo_order_id(ictInfo.getId() + "");
        ictOrder.setOrder_status("首款/全款确认");
        ictOrder.setIs_change_client("是");
        ictOrderMapper.updateById(ictOrder);
        IctLog ictLog = new IctLog();
        ictLog.setOperate_time(today);
        ictLog.setProcess("待付首款/全款");
        ictLog.setContent("提交");
        ictLog.setOrder_id(ictOrder.getId() + "");
        ictLog.setClient_phone(ictOrderMapper.selectById(ictOrder.getId()).getClient_link_phone());

        ictLogMapper.insert(ictLog);


        return "success";
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/uploadOrder_over")
    @ResponseBody
    public String uploadOrder_over(String order_id, IctInfo ictInfo,String remark) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = simpleDateFormat.format(new Date());
        IctOrder ictOrder = ictOrderMapper.selectById(order_id);

        //插入日志
        if(StringUtils.isNotEmpty(remark)){
            IctReamrkInfo reamrkInfo=new IctReamrkInfo();
            reamrkInfo.setName(ictOrder.getClient_name());
            reamrkInfo.setPhone(ictOrder.getClient_link_phone());
            reamrkInfo.setOperate_time(today);
            reamrkInfo.setProcess(ictOrder.getOrder_status());
            reamrkInfo.setOrder_id(ictOrder.getId()+"");
            reamrkInfo.setRemark(remark);
            remarkMapper.insert(reamrkInfo);
        }

        ictInfo.setOver_pay_time(today);
        ictInfoMapper.updateById(ictInfo);
        ictOrder.setOrder_status("尾款确认");
        ictOrder.setIs_change_client("是");
        ictOrderMapper.updateById(ictOrder);
        IctLog ictLog = new IctLog();
        ictLog.setOperate_time(today);
        ictLog.setProcess("已验收待尾款");
        ictLog.setContent("提交");
        ictLog.setOrder_id(ictOrder.getId() + "");
        ictLog.setClient_phone(ictOrderMapper.selectById(ictOrder.getId()).getClient_link_phone());

        ictLogMapper.insert(ictLog);
        return "success";
    }

    @RequestMapping("/get_order_list")
    @ResponseBody
    public Object get_order_list(String phone) {
        EntityWrapper<IctOrder> wrapper = new EntityWrapper<>();
        wrapper.eq("apply_phone", phone);
        wrapper.or();
        wrapper.eq("client_link_phone", phone);
        return ictOrderMapper.selectList(wrapper);
    }

    @RequestMapping("/getfiles")
    @ResponseBody
    public List<GunsFile> getfiles(String orderId, String type) {
        List<GunsFile> gunsFile = new ArrayList<GunsFile>();
        IctOrder orderInfo = ictOrderMapper.selectById(orderId);
        String fileid = "";
        if (orderInfo != null) {
            if (type.equals("项目方案")) {
                fileid = orderInfo.getProject_scheme_files();
            } else if (type.equals("预算")) {
                fileid = orderInfo.getProject_quote_files();
            } else if (type.equals("合同")) {
                fileid = orderInfo.getClient_contract_files();
            } else if (type.equals("确认合同")) {
                fileid = orderInfo.getOrder_confirm_files();
            } else if (type.equals("移动")) {
                fileid = orderInfo.getOwn_company_files();
            } else if (type.equals("首款")) {
                if (orderInfo.getInfo_order_id() != null && !orderInfo.getInfo_order_id().equals("")) {
                    fileid = ictInfoMapper.selectById(orderInfo.getInfo_order_id()).getClient_pay_files();
                }
            } else if (type.equals("尾款")) {
                if (orderInfo.getInfo_order_id() != null && !orderInfo.getInfo_order_id().equals("")) {
                    fileid = ictInfoMapper.selectById(orderInfo.getInfo_order_id()).getLast_pay_files();
                }
            }else if(type.equals("客户验收证明")){
                EntityWrapper<OrderType> orderTypeEntityWrapper=new EntityWrapper<>();
                orderTypeEntityWrapper.eq("ict_order_id",orderId);
                List<OrderType> orderTypes =orderTypeMapper.selectList(orderTypeEntityWrapper);
                for(OrderType orderType : orderTypes){
                    if(orderType.getOver_files()!=null && !orderType.getOver_files().equals("")){
                        if(fileid.equals("")){
                            fileid=orderType.getOver_files();
                        }else {
                            fileid=fileid+","+orderType.getOver_files();
                        }
                    }

                }
            }
            if (fileid != null && fileid.length() > 1) {
                String file[] = fileid.split(",");
                for (int i = 0; i < file.length; i++) {
                    GunsFile gunsFile1 = new GunsFile();
                    gunsFile1.setFileId(file[i]);
                    GunsFile g = gunsFileMapper.selectOne(gunsFile1);
                    if (g != null) {
                        g.setFilePath(g.getFilePath().substring(1));
                        gunsFile.add(g);
                    }

                }
            }

        }
        return gunsFile;
    }

    @RequestMapping("/get_order_list_for_custom_manager")
    @ResponseBody
    public Object get_order_list_for_custom_manager(Integer client_manager_id) {
        EntityWrapper<IctOrder> wrapper = new EntityWrapper<>();
        wrapper.eq("client_manager_id", client_manager_id);
        wrapper.ne("order_status", "订单结束");
        return ictOrderMapper.selectList(wrapper);
    }

    @RequestMapping("/get_order_list_for_custom_manager_over")
    @ResponseBody
    public Object get_order_list_for_custom_manager_over(Integer client_manager_id) {
        EntityWrapper<IctOrder> wrapper = new EntityWrapper<>();
        wrapper.eq("client_manager_id", client_manager_id);
        wrapper.eq("order_status", "订单结束");
        return ictOrderMapper.selectList(wrapper);
    }

    @RequestMapping("/get_info")
    @ResponseBody
    public Object get_info(String info_id) {
        return ictInfoMapper.selectById(info_id);
    }

    @RequestMapping("/get_order_detail_by_id")
    @ResponseBody
    public Object get_order_detail_by_id(Integer id) {
        return ictOrderMapper.selectById(id);
    }

    /**
     * 通过ict_order获取ict_info
     * ict_order的id在json中key值为order_id
     * ict_info的id在json中key值为id
     *
     * @return ict_order+ict_info的json字符串
     */
    @RequestMapping("/get_order_info")
    @ResponseBody
    public Object get_order_info() {
//        if(redisTemplate.opsForValue().get("order_info")!=null){
//            System.out.println(redisTemplate.boundHashOps("order_info").getExpire());
//            if(redisTemplate.boundHashOps("order_info").getExpire()<0){
//                redisTemplate.delete("order_info");
//            }else {
//                return redisTemplate.opsForValue().get("order_info");
//            }
//
//        }

        List<OrderInfoJSON> orderInfoJSONList = new ArrayList<>();
        List<IctLog> ictLogList = ictLogMapper.selectList(null);
        List<IctInfo> ictInfoList = ictInfoMapper.selectList(null);
        List<IctOrder> ictOrderList = ictOrderMapper.selectList(null);
//        int flag=0;
//        Field[] fields=orderInfoJSON.getClass().getDeclaredFields();
//        for (Map<String, Object> map : orderList) {
//            orderInfoJSON=new OrderInfoJSON();
//            for(Map.Entry<String,Object> entry:map.entrySet()){
//                for (Field field : fields) {
//                    if (field.getName().equals(entry.getKey())) {
//                        String name=field.getName();
//                        name=name.substring(0,1).toUpperCase()+name.substring(1);
//                        String type=field.getGenericType().toString();
//                        Method method=null;
//                        if(type.equals("class java.lang.String")){
//                            method=orderInfoJSON.getClass().getMethod("set"+name,String.class);
//                            method.invoke(orderInfoJSON,entry.getValue().toString());
//                        }
//                        if(type.equals("class java.lang.Integer")){
//                            method=orderInfoJSON.getClass().getMethod("set"+name,Integer.class);
//                            method.invoke(orderInfoJSON,Integer.parseInt(entry.getValue().toString()));
//                        }
//
//                        System.out.println(name+"----"+type);
//                        flag++;
//                        break;
//                    }
//                }
//            }
//            orderInfoJSONList.add(orderInfoJSON);
//        }
        for (IctOrder ictOrder : ictOrderList) {
            OrderInfoJSON orderInfoJSON = new OrderInfoJSON();
            BeanUtils.copyProperties(ictOrder, orderInfoJSON);
            List<LogJSON> list = new ArrayList<>();
            LogJSON logJSON;
            for (IctLog ictLog : ictLogList) {
                if(StringUtils.isNotEmpty(ictLog.getOrder_id())){
                    logJSON=new LogJSON();
                    String orderId = orderInfoJSON.getId().toString();
                    if (ictLog.getOrder_id().equals(orderId)) {
                        BeanUtils.copyProperties(ictLog,logJSON);
                        list.add(logJSON);
                    }
                }

            }
            orderInfoJSON.setLogList(list);
            String info_order_id = ictOrder.getInfo_order_id();
            if (StringUtils.isNotEmpty(info_order_id)) {
                if (info_order_id.contains(",")) {
                    String[] splitArray = info_order_id.split(",");
                    info_order_id = splitArray[0];
                }
                for (IctInfo ictInfo : ictInfoList) {
                    if (ictInfo.getId().toString().equals(info_order_id)) {
                        BeanUtils.copyProperties(ictInfo, orderInfoJSON);
                    }
                }
            }

            orderInfoJSONList.add(orderInfoJSON);
        }
        JSONArray array = new JSONArray();
        orderInfoJSONList.forEach(res->{
            array.add(res);
        });
//        redisTemplate.opsForValue().set("order_info",array,60*30, TimeUnit.SECONDS);
        return array;
    }

//    以下为移动首版一键登录代码

    static boolean hexStr = false;
//    公钥
    static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC9ct1zy/r2NtF1hFpzx0Kpl5LTAYHy2u0Vx77mqOTtaXVZjVfvj84/CU+hkTczhg0UYpPXAqicvkcIcvBmVIYS+2WKXE526VrFgbxOW4tVqqupWLvxy+oIpjYS2HJ1/XiNjirsuoWSMBWn6GMDbLwjuhz8WzV6TFHR1ZkuGtF17wIDAQAB";
//  app的密钥
    static String appkey = "9595B7B21123606DB71797C33C897517";
//    私钥
    static String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAL1y3XPL+vY20XWEWnPHQqmXktMBgfLa7RXHvuao5O1pdVmNV++Pzj8JT6GRNzOGDRRik9cCqJy+Rwhy8GZUhhL7ZYpcTnbpWsWBvE5bi1Wqq6lYu/HL6gimNhLYcnX9eI2OKuy6hZIwFafoYwNsvCO6HPxbNXpMUdHVmS4a0XXvAgMBAAECgYEAguln/Ae9kPxKe4GNG6pa92RFUkgdaxs7b6yKz0twflo8fDh+xo1CAS9G9qepVJJSYX7JGG++4ileXolGc//+cNkhpplLCI+O1YN68sBE6jk5Nb9spA13dwBXjjawShO+LcORnwopFW/dfWsrRvRopXURazEOClFtf1AoWmFDHXECQQDfVgK9CyWe9GM3qULxiSvkgH6pVM9SzWAP04Trb32S/dyV+RqaIH0gZdPJhbNDX8bRJ5D3DHUggc3VOnzQ8sYHAkEA2SgR/KZffiwKZbPtvEgesZnlCHGz6J3rV8bTsRa0rBLFt4M/GPXuzZx6MnnVdQyDABuUkFdsFvXVpm9mNyUW2QJAD967yRUusjHpjv3/HMzDirQ6y+uT4+1mIxnDuzsr8DML5rhR1Jv0aEX0G8DdcS8wIJKwMW34MLwolTtXvT1TJwJAMR2uC835lUkSxPQQVmCdiJ/9PI6zGW72dvECmnA/Rxgr3hjyYYvmilzVCquhywqcap7SWF9dlEfgHffeT6S06QJBAIwBsi+RNenMoSAFzPI68zxCEJHxcO7RRaMjbkSvk19xFLERwn7qup9syd8C877hhrXJLo+RKM/BTypDg4d6QOc=";


    @RequestMapping({"/getsign"})
    @ResponseBody
    public String getsign(String token) {
        String appId = "300012122034";
        String traceId = "78be31760e824862816b2ae9a3a220e1";
        String timestamp = "20220303100113649";
        String version = "1.0";
        String data = appId + traceId + timestamp + token + version;
        LySign lySign = LySign.of(SignAlgorithm.SHA256withRSA, privateKey, publicKey, hexStr);
        String sign = lySign.sign(data);
        lySign.verify(data, sign);
        return sign;
    }

    @RequestMapping("/getPhone_ase")
    @ResponseBody
    public Map<String,Object> getPhone_ase(String msisdn){
        Map<String,Object> map =new HashMap<>();
        AES aes = new AES(getAesKey(appkey));
        String phone = new String(aes.decryptBase64(msisdn));
        EntityWrapper<User> userEntityWrapper = new EntityWrapper();
        userEntityWrapper.eq("phone",phone);
        List<User> userList = userMapper.selectList(userEntityWrapper);
        if(userList.size()>0){
            for(User user : userList){
                String rolestr = "";
                List<String> rolelist = Arrays.asList(user.getRoleid().split(","));
                for (String role : rolelist) {
                    rolestr += roleMapper.selectById(role);
                }
                if(rolestr.contains("客户经理") || rolestr.contains("网格经理")){
                    map.put("phone",phone);
                    map.put("role","客户经理");
                    map.put("user_id",user.getId());
                    break;
                }
            }
        }else {
            map.put("phone",phone);
            map.put("role","客户");
        }

        return map;
    }

    public static String getAesKey(String key) {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(key)) {
            return key.length() > 16 ? key.substring(0, 16) : org.apache.commons.lang3.StringUtils.rightPad(key, 16, "0");
        } else {
            return "";
        }
    }
}
