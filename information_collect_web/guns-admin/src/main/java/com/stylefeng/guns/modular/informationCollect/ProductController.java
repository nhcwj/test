package com.stylefeng.guns.modular.informationCollect;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.modular.system.dao.GunsFileMapper;
import com.stylefeng.guns.modular.system.dao.RoleMapper;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.OrderInfoMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.ProductMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.WarrantyMapper;
import com.stylefeng.guns.modular.system.model.GunsFile;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.model.informationCollect.OrderInfo;
import com.stylefeng.guns.modular.system.model.informationCollect.Product;
import com.stylefeng.guns.modular.system.model.informationCollect.Warranty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/*
* 此Controller已使用redis,后续更新请注意
* */

@Controller
@RequestMapping("/qyw/app")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private WarrantyMapper warrantyMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("/getProduct")
    @ResponseBody
    public Product getProduct(String product){

//        if(redisTemplate.opsForValue().get(product)!=null){
//            System.out.println(redisTemplate.boundHashOps(product).getExpire());
//            if(redisTemplate.boundHashOps(product).getExpire()<0){
//                redisTemplate.delete(product);
//            }else {
//                return (Product) redisTemplate.opsForValue().get(product);
//            }
//
//        }
        EntityWrapper<Product> productEntityWrapper=new EntityWrapper<>();
        productEntityWrapper.eq("product",product);
        List<Product> productList=productMapper.selectList(productEntityWrapper);
//        if(productList.size()>0){
//            redisTemplate.opsForValue().set(product,productList.get(0),60*5, TimeUnit.SECONDS);
//            return productList.get(0);
//        }else {
//            return new Product();
//        }
        return productList.get(0);

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
                EntityWrapper<OrderInfo> wrapper = new EntityWrapper<>();
                wrapper.like("order_number", today);
                wrapper.orderBy("id", false);
                wrapper.last("limit 1");
                List<OrderInfo> orderInfos = orderInfoMapper.selectList(wrapper);
                if (orderInfos == null || orderInfos.size() == 0) {
                    countMap.put(today, 1);
                    orderNumb.append("0001");
                } else {
                    String order_num = orderInfos.get(0).getOrder_number();
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

    @RequestMapping("/insertOrder")
    @ResponseBody
    public String insertOrder(@RequestBody OrderInfo orderInfo){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String today = simpleDateFormat.format(new Date());
        orderInfo.setOrder_number(getNum());
        String phone=orderInfo.getCustom_manager_phone();
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
                orderInfo.setCustom_manager(user.getName());
                orderInfo.setClient_manager_id(user.getId()+"");
                orderInfo.setOrder_status("待转派");
            }else {
                orderInfo.setCustom_manager_phone("");
            }
        }else {
            orderInfo.setCustom_manager_phone("");
            orderInfo.setOrder_status("待转派");
        }
        orderInfo.setCurren_process("初步订单审核");
        orderInfo.setApply_time(today);
        orderInfo.setIs_read("未读");
        orderInfoMapper.insert(orderInfo);
        return "success";
    }

    @RequestMapping("/get_order_list")
    @ResponseBody
    public Object get_order_list(String phone){
        EntityWrapper<OrderInfo> wrapper=new EntityWrapper<>();
        wrapper.eq("applyer_phone",phone);
        wrapper.or();
        wrapper.eq("custom_phone",phone);
        wrapper.orderBy("is_read",false);
        return orderInfoMapper.selectList(wrapper);
    }

    @RequestMapping("/get_order_list_for_custom_manager")
    @ResponseBody
    public Object get_order_list_for_custom_manager(Integer client_manager_id){
        EntityWrapper<OrderInfo> wrapper=new EntityWrapper<>();
        wrapper.eq("client_manager_id",client_manager_id);
        wrapper.orderBy("is_read",false);
        return orderInfoMapper.selectList(wrapper);
    }

    @RequestMapping("/get_order_detail_by_id")
    @ResponseBody
    public Object get_order_detail_by_id(Integer id){
        return orderInfoMapper.selectById(id);
    }

    @RequestMapping("/update_order_is_read_by_id")
    @ResponseBody
    public String update_order_is_read_by_id(OrderInfo orderInfo){
        orderInfo.setIs_read("已读");
        orderInfoMapper.updateById(orderInfo);
        return "success";
    }

    @RequestMapping("/insert_warranty")
    @ResponseBody
    public String insert_warranty(Warranty warranty){
        warrantyMapper.insert(warranty);
        return "success";
    }
    @Autowired
    private GunsFileMapper gunsFileMapper;

    @RequestMapping("/uploadOrder")
    @ResponseBody
    public String uploadOrder(@RequestBody OrderInfo orderInfo){
        orderInfo.setCurren_process("正式订单审核");
        orderInfoMapper.updateById(orderInfo);
        return "success";
    }

    @RequestMapping("/getfiles")
    @ResponseBody
    public List<GunsFile> getfiles(String orderId,String type){
        List<GunsFile> gunsFile = new ArrayList<GunsFile>();
        OrderInfo orderInfo=orderInfoMapper.selectById(orderId);
        String fileid="";
        if(orderInfo!=null){
            if(type.equals("项目方案")){
                fileid=orderInfo.getProject_file();
            }else if(type.equals("预算")){
                fileid=orderInfo.getMoney_file();
            }else if(type.equals("合同")){
                fileid=orderInfo.getContract_file();
            }
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





        return gunsFile;
    }

}
