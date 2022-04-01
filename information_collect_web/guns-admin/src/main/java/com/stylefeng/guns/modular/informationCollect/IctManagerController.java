package com.stylefeng.guns.modular.informationCollect;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.base.tips.ErrorTip;
import com.stylefeng.guns.core.base.tips.SuccessTip;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.shiro.ShiroUser;
import com.stylefeng.guns.core.util.type.StringUtils;
import com.stylefeng.guns.modular.gunsFile.controller.service.IGunsFileService;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.IctInfoMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.IctLogMapper;
import com.stylefeng.guns.modular.system.dao.informationCollect.IctOrderMapper;
import com.stylefeng.guns.modular.system.dao.informationTest.OrderInfoTestMapper;
import com.stylefeng.guns.modular.system.model.GunsFile;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.model.informationCollect.IctInfo;
import com.stylefeng.guns.modular.system.model.informationCollect.IctLog;
import com.stylefeng.guns.modular.system.model.informationCollect.IctOrder;
import com.stylefeng.guns.modular.system.model.informationCollect.OrderInfo;
import com.stylefeng.guns.modular.system.model.informationTest.OrderInfoTest;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * @Auther: biu
 * @Date: 2022/1/13 15:37
 * @Description:
 */
@Controller
@RequestMapping("/IctManager")
@CrossOrigin
public class IctManagerController {
    public static final int WIDTH = 120;//生成的图片的宽度
    public static final int HEIGHT = 30;//生成的图片的高度

    private String PREFIX = "/informationCollect/ict_manager";
    @Autowired
    IGunsFileService fileService;
    @Autowired
    private OrderInfoTestMapper orderInfoTestMapper;
    @Autowired
    private IctOrderMapper ictOrderMapper;
    @Autowired
    private IctInfoMapper ictInfoMapper;
    @Autowired
    private IctLogMapper ictLogMapper;
    @Autowired
    private UserMapper userMapper;

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
     * 获取订单列表
     *
     * @return
     */
    @RequestMapping("/getOrderList")
    @ResponseBody
    public java.util.List<Map<String, Object>> getOrderList(String order_number, String order_time, String current_process, String company_name, String custom_name,
                                                            String custom_phone, String custom_manager, String custom_manager_phone,
                                                            String group_code) {
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
        wrapper.orderBy("order_time",false);
        mapList = ictOrderMapper.selectMaps(wrapper);
        return mapList;
    }

    /**
     * 订单日志列表
     *
     * @return 订单日志页
     */
    @RequestMapping("/orderLogList")
    public String orderLogList() {
        return PREFIX + "/orderLogList.html";
    }

    @RequestMapping("/getOrderLogList")
    @ResponseBody
    public List<Map<String, Object>> getOrderLogList(String name, String startTime, String endTime) {
        EntityWrapper<IctLog> ictLogEntityWrapper = new EntityWrapper<>();
        List<Map<String, Object>> orderMapList = ictOrderMapper.selectMaps(null);
        if (StringUtils.isNotEmpty(name)) {
            ictLogEntityWrapper.like("name", name);
        }
        if (StringUtils.isNotEmpty(startTime)) {
            ictLogEntityWrapper.ge("operate_time", startTime);
        }
        if (StringUtils.isNotEmpty(endTime)) {
            ictLogEntityWrapper.le("operate_time", endTime);
        }
        List<Map<String, Object>> mapList = ictLogMapper.selectMaps(ictLogEntityWrapper);
        for (Map<String, Object> m : mapList) {
            if (m.get("order_id") != null) {
                IctOrder ictOrder = ictOrderMapper.selectById(m.get("order_id").toString());
                if (ictOrder != null) {
                    m.put("order_no", ictOrder.getOrder_no());
                }
            }
        }
        return mapList;
    }

    /**
     * 订单详情及日志合页
     *
     * @return 跳转至订单详情及日志合页
     */
//    @RequestMapping("/order_log_edit_see")
//    public String order_log_edit_see(String id, Model model) {
//        EntityWrapper<IctLog> logEntityWrapper = new EntityWrapper<>();
//        if (id != null) {
//            IctOrder ictOrder = ictOrderMapper.selectById(id);
//            logEntityWrapper.eq("order_id", id);
//            logEntityWrapper.orderBy("operate_time", false);
//            List<IctLog> logList = ictLogMapper.selectList(logEntityWrapper);
//            model.addAttribute("log", CollectionUtils.isNotEmpty(logList) ? logList : new ArrayList<IctLog>());
//            model.addAttribute("order", ictOrder != null ? ictOrder : new IctOrder());
//        }
//        return PREFIX + "/order_log_edit_see.html";
//    }
//
    @RequestMapping("/order_log_edit_see")
    public String order_log_edit_see(Model model, Integer id) {
        OrderInfoTest orderInfoTest = new OrderInfoTest();

        IctOrder ictOrder = new IctOrder();
        IctInfo ictInfo = new IctInfo();
        ictOrder = ictOrderMapper.selectById(id);
        String info_order_id = ictOrder.getInfo_order_id();
        if (StringUtils.isNotEmpty(info_order_id)) {
            String[] temp = info_order_id.split(",");
            ictInfo = ictInfoMapper.selectById(Integer.parseInt(temp[0]));
            BeanUtils.copyProperties(ictInfo, orderInfoTest);
        }
        BeanUtils.copyProperties(ictOrder, orderInfoTest);

//        orderInfoTest = orderInfoTestMapper.selectById(id);
        if (orderInfoTest != null) {
            model.addAttribute("orderInfo", orderInfoTest);
            model.addAttribute("project_scheme_files", getFiles(orderInfoTest.getProject_scheme_files()));
            model.addAttribute("project_quote_files", getFiles(orderInfoTest.getProject_quote_files()));
            model.addAttribute("client_contract_files", getFiles(orderInfoTest.getClient_contract_files()));
            model.addAttribute("own_company_files", getFiles(orderInfoTest.getOwn_company_files()));
            model.addAttribute("client_receive_files", getFiles(orderInfoTest.getClient_receive_files()));

            model.addAttribute("client_pay_files", getFiles(orderInfoTest.getClient_pay_files()));

            model.addAttribute("order_confirm_files", getFiles(orderInfoTest.getOrder_confirm_files()));
            model.addAttribute("last_pay_files", getFiles(orderInfoTest.getLast_pay_files()));

            //账户信息上传时间
            if (StringUtils.isNotEmpty(orderInfoTest.getOwn_company_files())) {
                EntityWrapper<GunsFile> wrapper = new EntityWrapper<>();
                wrapper.eq("file_id", orderInfoTest.getOwn_company_files());
                List<GunsFile> gunsFileList = fileService.selectList(wrapper);
                if (gunsFileList.size() > 0) {
                    String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(gunsFileList.get(0).getAddTime());
                    model.addAttribute("own_add_time", date);
                }
            } else {
                model.addAttribute("own_add_time", "");
            }
            //验收证明信息上传时间
            if (StringUtils.isNotEmpty(orderInfoTest.getClient_receive_files())) {
                EntityWrapper<GunsFile> wrapper = new EntityWrapper<>();
                wrapper.eq("file_id", orderInfoTest.getClient_receive_files());
                List<GunsFile> gunsFileList = fileService.selectList(wrapper);
                if (gunsFileList.size() > 0) {
                    String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(gunsFileList.get(0).getAddTime());
                    model.addAttribute("receive_add_time", date);
                }
            } else {
                model.addAttribute("receive_add_time", "");
            }
        } else {
            model.addAttribute("orderInfo", new OrderInfoTest());
            model.addAttribute("project_scheme_files", "");
            model.addAttribute("project_quote_files", "");
            model.addAttribute("client_contract_files", "");
            model.addAttribute("own_company_files", "");
            model.addAttribute("client_receive_files", "");
            model.addAttribute("client_pay_files", "");
            model.addAttribute("order_confirm_files", "");
            model.addAttribute("last_pay_files", "");
            model.addAttribute("own_add_time", "");
            model.addAttribute("receive_add_time", "");
        }
        EntityWrapper<IctLog> logEntityWrapper = new EntityWrapper<>();
        if (id != null) {
            ictOrder = ictOrderMapper.selectById(id);
            logEntityWrapper.eq("order_id", id);
            logEntityWrapper.orderBy("operate_time", false);
            List<IctLog> logList = ictLogMapper.selectList(logEntityWrapper);
            model.addAttribute("log", CollectionUtils.isNotEmpty(logList) ? logList : new ArrayList<IctLog>());
            model.addAttribute("order", ictOrder != null ? ictOrder : new IctOrder());
        }
        return PREFIX + "/order_log_edit_see.html";
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

    /**
     * 编辑订单
     *
     * @param orderInfo
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Tip edit(OrderInfoTest orderInfo) {
        IctOrder ictOrder = new IctOrder();
        IctInfo ictInfo = new IctInfo();
        ictOrder = ictOrderMapper.selectById(orderInfo.getId());
        BeanUtils.copyProperties(orderInfo, ictOrder);
        String info_order_id = ictOrder.getInfo_order_id();
        if (StringUtils.isNotEmpty(info_order_id)) {
            String[] temp = info_order_id.split(",");
            ictInfo = ictInfoMapper.selectById(Integer.parseInt(temp[0]));
            BeanUtils.copyProperties(orderInfo, ictInfo);
            ictInfo.setId(Integer.parseInt(temp[0]));
            ictInfoMapper.updateById(ictInfo);
        } else {
            BeanUtils.copyProperties(orderInfo, ictInfo);
            ictInfoMapper.insert(ictInfo);
            ictOrder.setInfo_order_id(ictInfo.getId().toString());
        }
        Integer temp = ictOrderMapper.updateById(ictOrder);
//        Integer temp = orderInfoTestMapper.updateById(orderInfo);
        if (temp > 0) {
            //插入保存日志
            User user = userMapper.selectById(ShiroKit.getUser().getId());
            IctLog ictLog = new IctLog();
            ictLog.setOperate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            ictLog.setName(user.getName());
            ictLog.setPhone(user.getPhone());
            ictLog.setOrder_id(orderInfo.getId().toString());
            ictLog.setContent("总控");
            ictLogMapper.insert(ictLog);
            return new SuccessTip();
        } else {
            return new ErrorTip(500, "保存失败");
        }
    }


    @CrossOrigin
    @RequestMapping("/getVerifyImg")
    @ResponseBody
    public void getVerifyImg(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String createTypeFlag = request.getParameter("createTypeFlag");//接收客户端传递的createTypeFlag标识
        //1.在内存中创建一张图片
        BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        //2.得到图片
        Graphics g = bi.getGraphics();
        //3.设置图片的背影色
        setBackGround(g);
        //4.设置图片的边框
        setBorder(g);
        //5.在图片上画干扰线
        drawRandomLine(g);
        //6.写在图片上随机数
        //String random = drawRandomNum((Graphics2D) g,"ch");//生成中文验证码图片
        //String random = drawRandomNum((Graphics2D) g,"nl");//生成数字和字母组合的验证码图片
        //String random = drawRandomNum((Graphics2D) g,"n");//生成纯数字的验证码图片
        //String random = drawRandomNum((Graphics2D) g,"l");//生成纯字母的验证码图片
        String random = drawRandomNum((Graphics2D) g, createTypeFlag);//根据客户端传递的createTypeFlag标识生成验证码图片
        //7.将随机数存在session中
        request.getSession().setAttribute("checkcode", random);
        //8.设置响应头通知浏览器以图片的形式打开
        response.setContentType("image/jpeg");//等同于response.setHeader("Content-Type", "image/jpeg");
        //9.设置响应头控制浏览器不要缓存
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        //10.将图片写给浏览器
        ImageIO.write(bi, "jpg", response.getOutputStream());
    }

    private void setBackGround(Graphics g) {
        // 设置颜色
        g.setColor(Color.WHITE);
        // 填充区域
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    private void setBorder(Graphics g) {
        // 设置边框颜色
        g.setColor(Color.WHITE);
        // 边框区域
        g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
    }

    private void drawRandomLine(Graphics g) {
        // 设置颜色
        Color[] colors = new Color[]{Color.green, Color.ORANGE, Color.BLUE};
        for (int i = 0; i < colors.length; i++) {
            g.setColor(colors[i]);
            // 设置线条个数并画线
            for (int j = 0; j < 3; j++) {
                int x1 = new Random().nextInt(WIDTH);
                int y1 = new Random().nextInt(HEIGHT);
                int x2 = new Random().nextInt(WIDTH);
                int y2 = new Random().nextInt(HEIGHT);
                g.drawLine(x1, y1, x2, y2);
            }
        }
    }

    private String drawRandomNum(Graphics2D g, String... createTypeFlag) {
        // 设置颜色
        g.setColor(Color.RED);
        // 设置字体
        g.setFont(new Font("宋体", Font.BOLD, 20));
        //常用的中国汉字
        String baseChineseChar = "\u7684\u4e00\u4e86\u662f\u6211\u4e0d\u5728\u4eba\u4eec\u6709\u6765\u4ed6\u8fd9\u4e0a\u7740\u4e2a\u5730\u5230\u5927\u91cc\u8bf4\u5c31\u53bb\u5b50\u5f97\u4e5f\u548c\u90a3\u8981\u4e0b\u770b\u5929\u65f6\u8fc7\u51fa\u5c0f\u4e48\u8d77\u4f60\u90fd\u628a\u597d\u8fd8\u591a\u6ca1\u4e3a\u53c8\u53ef\u5bb6\u5b66\u53ea\u4ee5\u4e3b\u4f1a\u6837\u5e74\u60f3\u751f\u540c\u8001\u4e2d\u5341\u4ece\u81ea\u9762\u524d\u5934\u9053\u5b83\u540e\u7136\u8d70\u5f88\u50cf\u89c1\u4e24\u7528\u5979\u56fd\u52a8\u8fdb\u6210\u56de\u4ec0\u8fb9\u4f5c\u5bf9\u5f00\u800c\u5df1\u4e9b\u73b0\u5c71\u6c11\u5019\u7ecf\u53d1\u5de5\u5411\u4e8b\u547d\u7ed9\u957f\u6c34\u51e0\u4e49\u4e09\u58f0\u4e8e\u9ad8\u624b\u77e5\u7406\u773c\u5fd7\u70b9\u5fc3\u6218\u4e8c\u95ee\u4f46\u8eab\u65b9\u5b9e\u5403\u505a\u53eb\u5f53\u4f4f\u542c\u9769\u6253\u5462\u771f\u5168\u624d\u56db\u5df2\u6240\u654c\u4e4b\u6700\u5149\u4ea7\u60c5\u8def\u5206\u603b\u6761\u767d\u8bdd\u4e1c\u5e2d\u6b21\u4eb2\u5982\u88ab\u82b1\u53e3\u653e\u513f\u5e38\u6c14\u4e94\u7b2c\u4f7f\u5199\u519b\u5427\u6587\u8fd0\u518d\u679c\u600e\u5b9a\u8bb8\u5feb\u660e\u884c\u56e0\u522b\u98de\u5916\u6811\u7269\u6d3b\u90e8\u95e8\u65e0\u5f80\u8239\u671b\u65b0\u5e26\u961f\u5148\u529b\u5b8c\u5374\u7ad9\u4ee3\u5458\u673a\u66f4\u4e5d\u60a8\u6bcf\u98ce\u7ea7\u8ddf\u7b11\u554a\u5b69\u4e07\u5c11\u76f4\u610f\u591c\u6bd4\u9636\u8fde\u8f66\u91cd\u4fbf\u6597\u9a6c\u54ea\u5316\u592a\u6307\u53d8\u793e\u4f3c\u58eb\u8005\u5e72\u77f3\u6ee1\u65e5\u51b3\u767e\u539f\u62ff\u7fa4\u7a76\u5404\u516d\u672c\u601d\u89e3\u7acb\u6cb3\u6751\u516b\u96be\u65e9\u8bba\u5417\u6839\u5171\u8ba9\u76f8\u7814\u4eca\u5176\u4e66\u5750\u63a5\u5e94\u5173\u4fe1\u89c9\u6b65\u53cd\u5904\u8bb0\u5c06\u5343\u627e\u4e89\u9886\u6216\u5e08\u7ed3\u5757\u8dd1\u8c01\u8349\u8d8a\u5b57\u52a0\u811a\u7d27\u7231\u7b49\u4e60\u9635\u6015\u6708\u9752\u534a\u706b\u6cd5\u9898\u5efa\u8d76\u4f4d\u5531\u6d77\u4e03\u5973\u4efb\u4ef6\u611f\u51c6\u5f20\u56e2\u5c4b\u79bb\u8272\u8138\u7247\u79d1\u5012\u775b\u5229\u4e16\u521a\u4e14\u7531\u9001\u5207\u661f\u5bfc\u665a\u8868\u591f\u6574\u8ba4\u54cd\u96ea\u6d41\u672a\u573a\u8be5\u5e76\u5e95\u6df1\u523b\u5e73\u4f1f\u5fd9\u63d0\u786e\u8fd1\u4eae\u8f7b\u8bb2\u519c\u53e4\u9ed1\u544a\u754c\u62c9\u540d\u5440\u571f\u6e05\u9633\u7167\u529e\u53f2\u6539\u5386\u8f6c\u753b\u9020\u5634\u6b64\u6cbb\u5317\u5fc5\u670d\u96e8\u7a7f\u5185\u8bc6\u9a8c\u4f20\u4e1a\u83dc\u722c\u7761\u5174\u5f62\u91cf\u54b1\u89c2\u82e6\u4f53\u4f17\u901a\u51b2\u5408\u7834\u53cb\u5ea6\u672f\u996d\u516c\u65c1\u623f\u6781\u5357\u67aa\u8bfb\u6c99\u5c81\u7ebf\u91ce\u575a\u7a7a\u6536\u7b97\u81f3\u653f\u57ce\u52b3\u843d\u94b1\u7279\u56f4\u5f1f\u80dc\u6559\u70ed\u5c55\u5305\u6b4c\u7c7b\u6e10\u5f3a\u6570\u4e61\u547c\u6027\u97f3\u7b54\u54e5\u9645\u65e7\u795e\u5ea7\u7ae0\u5e2e\u5566\u53d7\u7cfb\u4ee4\u8df3\u975e\u4f55\u725b\u53d6\u5165\u5cb8\u6562\u6389\u5ffd\u79cd\u88c5\u9876\u6025\u6797\u505c\u606f\u53e5\u533a\u8863\u822c\u62a5\u53f6\u538b\u6162\u53d4\u80cc\u7ec6";
        //数字和字母的组合
        String baseNumLetter = "0123456789ABCDEFGHJKLMNOPQRSTUVWXYZ";
        //纯数字
        String baseNum = "0123456789";
        //纯字母
        String baseLetter = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
        //createTypeFlag[0]==null表示没有传递参数
//        if (createTypeFlag.length > 0 && null != createTypeFlag[0]) {
//            if (createTypeFlag[0].equals("ch")) {
//                // 截取汉字
//                return createRandomChar(g, baseChineseChar);
//            }else if (createTypeFlag[0].equals("nl")) {
//                // 截取数字和字母的组合
//                return createRandomChar(g, baseNumLetter);
//            }else if (createTypeFlag[0].equals("n")) {
//                // 截取数字
//                return createRandomChar(g, baseNum);
//            }else if (createTypeFlag[0].equals("l")) {
//                // 截取字母
//                return createRandomChar(g, baseLetter);
//            }
//        }else {
        // 默认截取数字和字母的组合
        return createRandomChar(g, baseNumLetter);
//        }

//        return "";
    }

    private String createRandomChar(Graphics2D g, String baseChar) {
        StringBuffer sb = new StringBuffer();
        int x = 5;
        String ch = "";
        // 控制字数
        for (int i = 0; i < 4; i++) {
            // 设置字体旋转角度
            int degree = new Random().nextInt() % 30;
            ch = baseChar.charAt(new Random().nextInt(baseChar.length())) + "";
            sb.append(ch);
            // 正向角度
            g.rotate(degree * Math.PI / 180, x, 20);
            g.drawString(ch, x, 20);
            // 反向角度
            g.rotate(-degree * Math.PI / 180, x, 20);
            x += 30;
        }
        return sb.toString();
    }


}
