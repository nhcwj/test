package com.stylefeng.guns.modular.informationCollect;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.util.type.StringUtils;
import com.stylefeng.guns.modular.system.dao.informationCollect.WarrantyMapper;
import com.stylefeng.guns.modular.system.model.informationCollect.Warranty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/warrantyOrder")
public class WarrantyOrderController {

    private final String PREFIX = "/informationCollect/warranty_order/";

    @Autowired
    private WarrantyMapper warrantyMapper;

    @RequestMapping("/index")
    public String index() {
        return PREFIX + "warranty_order_list.html";
    }

    @RequestMapping("/getWarrantyOrderList")
    @ResponseBody
    public List<Map<String, Object>> getWarrantyOrderList(String orderNum, String type, String applerName, String applerPhone) {
        EntityWrapper<Warranty> warrantyEntityWrapper = new EntityWrapper<>();
        boolean flag = false;//判断是否需要加and
        if (StringUtils.isNotEmpty(applerName)) {
            warrantyEntityWrapper.like("appler_name", applerName);
            flag = true;
        }
        if (StringUtils.isNotEmpty(applerPhone)) {
            warrantyEntityWrapper.like("appler_phone", applerPhone);
            flag = true;
        }
        if (StringUtils.isNotEmpty(orderNum)) {
            warrantyEntityWrapper.like("order_num", orderNum);
            flag = true;
        }
        if (StringUtils.isNotEmpty(type)) {
            if (type.contains(",")) {
                String[] splitArray = type.split(",");
                if (flag) {
                    warrantyEntityWrapper.andNew();
                }
                for (int i = 0; i < splitArray.length; i++) {
                    if (i != splitArray.length - 1) {
                        warrantyEntityWrapper.like("type", splitArray[i]).or();
                    } else {
                        warrantyEntityWrapper.like("type", splitArray[i]);
                    }
                }
            } else {
                warrantyEntityWrapper.like("type", type);
            }
        }
        return warrantyMapper.selectMaps(warrantyEntityWrapper);
    }

    @RequestMapping("/getWarrantyDetail")
    public String getWarrantyDetail(Model model, String orderNum) {
        Warranty warranty = null;
        if (StringUtils.isNotEmpty(orderNum)) {
            Warranty w = new Warranty();
            w.setOrder_num(orderNum);
            warranty = warrantyMapper.selectOne(w);
        }
        model.addAttribute("warranty", warranty != null ? warranty : new Warranty());
//        System.out.println(warranty.getProblem());
        return PREFIX + "warranty_order_detail.html";
    }
}
