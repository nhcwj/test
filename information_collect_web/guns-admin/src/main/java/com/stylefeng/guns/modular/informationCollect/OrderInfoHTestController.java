package com.stylefeng.guns.modular.informationCollect;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.modular.system.dao.GunsFileMapper;
import com.stylefeng.guns.modular.system.dao.RoleMapper;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.IctCountMapper;
import com.stylefeng.guns.modular.system.dao.informationTest.OrderInfoTestMapper;
import com.stylefeng.guns.modular.system.model.GunsFile;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.model.informationCollect.IctCount;
import com.stylefeng.guns.modular.system.model.informationCollect.OrderInfo;
import com.stylefeng.guns.modular.system.model.informationTest.OrderInfoTest;
import org.beetl.ext.fn.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@Controller
@RequestMapping("/orderInfoHTest")
public class OrderInfoHTestController {

    @Autowired
    private OrderInfoTestMapper orderInfoTestMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private GunsFileMapper gunsFileMapper;

    @Autowired
    private IctCountMapper ictCountMapper;

    @RequestMapping("/get_order_detail_by_id")
    @ResponseBody
    public Object get_order_detail_by_id(Integer id){
        return orderInfoTestMapper.selectById(id);
    }

    @RequestMapping("/login")
    @ResponseBody
    public Object login(String role){
        String enter_time=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        IctCount ictCount=new IctCount();
        ictCount.setEnter_time(enter_time);
        ictCount.setRole(role);
        ictCountMapper.insert(ictCount);
        return "success";
    }

    @RequestMapping("/insertOrder")
    @ResponseBody
    public String insertOrder(@RequestBody OrderInfoTest orderInfo){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = simpleDateFormat.format(new Date());
        orderInfo.setOrder_no(getNum());
        String phone=orderInfo.getClient_manager_phone();
        EntityWrapper<User> userEntityWrapper=new EntityWrapper<>();
        userEntityWrapper.eq("phone",phone);
        List<User> userList=userMapper.selectList(userEntityWrapper);
        if(userList.size()>0){
            User user=userList.get(0);
            String rolestr="";
            List<String> rolelist= Arrays.asList(user.getRoleid().split(","));
            for(String role :rolelist){
                rolestr+= roleMapper.selectById(role);
            }
            if(rolestr.contains("客户经理")){
                orderInfo.setClient_manager(user.getName());
                orderInfo.setClient_manager_id(user.getId());
            }else {
                orderInfo.setClient_manager_phone("");
            }
        }else {
            orderInfo.setClient_manager_phone("");
        }
        orderInfo.setOrder_status("初步订单审核");
        orderInfo.setOrder_time(today);
        orderInfoTestMapper.insert(orderInfo);
        return "success";
    }

    @RequestMapping("/uploadOrder")
    @ResponseBody
    public String uploadOrder(@RequestBody OrderInfoTest orderInfo){
        orderInfoTestMapper.updateById(orderInfo);
        return "success";
    }

    @RequestMapping("/get_order_list")
    @ResponseBody
    public Object get_order_list(String phone){
        EntityWrapper<OrderInfoTest> wrapper=new EntityWrapper<>();
        wrapper.eq("apply_phone",phone);
        wrapper.or();
        wrapper.eq("client_link_phone",phone);
        return orderInfoTestMapper.selectList(wrapper);
    }

    @RequestMapping("/get_order_list_for_custom_manager")
    @ResponseBody
    public Object get_order_list_for_custom_manager(Integer client_manager_id){
        EntityWrapper<OrderInfoTest> wrapper=new EntityWrapper<>();
        wrapper.eq("client_manager_id",client_manager_id);
        return orderInfoTestMapper.selectList(wrapper);
    }

    public static Map<String, Integer> countMap = new HashMap<>();
    public String getNum(){
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
                EntityWrapper<OrderInfoTest> wrapper = new EntityWrapper<>();
                wrapper.like("order_no", today);
                wrapper.orderBy("id", false);
                wrapper.last("limit 1");
                List<OrderInfoTest> orderInfos = orderInfoTestMapper.selectList(wrapper);
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

    @RequestMapping("/getfiles")
    @ResponseBody
    public List<GunsFile> getfiles(String orderId, String type){
        List<GunsFile> gunsFile = new ArrayList<GunsFile>();
        OrderInfoTest orderInfo=orderInfoTestMapper.selectById(orderId);
        String fileid="";
        if(orderInfo!=null){
            if(type.equals("项目方案")){
                fileid=orderInfo.getProject_scheme_files();
            }else if(type.equals("预算")){
                fileid=orderInfo.getProject_quote_files();
            }else if(type.equals("合同")){
                fileid=orderInfo.getClient_contract_files();
            }else if(type.equals("移动")){
                fileid=orderInfo.getOwn_company_files();
            }else if(type.equals("首款")){
                fileid=orderInfo.getClient_pay_files();
            }
            if(fileid.length()>1){
                String file[]=fileid.split(",");
                for(int i=0;i<file.length;i++){
                    GunsFile gunsFile1=new GunsFile();
                    gunsFile1.setFileId(file[i]);
                    GunsFile g=gunsFileMapper.selectOne(gunsFile1);
                    if(g!=null){
                        g.setFilePath(g.getFilePath().substring(1));
                        gunsFile.add(g);
                    }

                }
            }

        }
        return gunsFile;
    }
    @RequestMapping("/getJson")
    @ResponseBody
    public Object getJson(String user){
        if(user.equals("Z7gy3060d*")){
            EntityWrapper entityWrapper=new EntityWrapper();
            List<OrderInfoTest> orderInfoTestList = orderInfoTestMapper.selectList(entityWrapper);
            JSONArray array = new JSONArray();
            orderInfoTestList.forEach(res->{
                JSONObject jsonObject = JSONObject.parseObject(res.toString());
                array.add(jsonObject);
            });
//            JSONArray array = new JSONArray();
//            array.add(stringList);
            return array;
        }else {
            return "认证错误";
        }

    }
}
