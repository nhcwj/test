package com.stylefeng.guns.util;
import com.stylefeng.guns.core.util.type.StringUtils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author gjx
 * @description 工具类
 * @date 2021/5/14
 */
public class GlobalUtil {
    /**
     * @param
     * @return
     * @desc: 将英文字符串首字母大写
     * @author gjx
     * @date
     */
    public static String firstLetterToUpper(String str) {
        // 进行字母的ascii编码前移，效率要高于截取字符串进行转换的操作
        char[] cs = str.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

    /**
     * @param
     * @return
     * @desc: 浅拷贝key-value值
     * @author gjx
     * @date
     */
    public static Map<String, Object> copyKeyAndValueToNewMap(Map<String, Object> paramMap) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        //开始从paramMap中复制到resultMap中
        Iterator it = paramMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            if (key != null && paramMap.get(key) != null) {
                resultMap.put(key.toString(), paramMap.get(key));
            }
        }
        return resultMap;
    }

    /**
     * @param
     * @return
     * @desc: 隐藏姓名为*，艾*、艾**
     * @author gjx
     * @date
     */
    public static String checkUser(String name) {
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(name)) {
            name = name.trim();
            if (name.length() >= 2) {
                String temp = "";
                for (int i = 1; i <= name.length() - 1; i++) {
                    temp += "*";
                }
                name = name.charAt(0) + temp;
            }
        } else {
            return "";
        }
        return name;
    }

    public static String calculateDayDistance(String last, String act) {
        if (com.stylefeng.guns.core.util.type.StringUtils.isBlank(last) || com.stylefeng.guns.core.util.type.StringUtils.isBlank(act)) {
            return "";
        }
        String lastStr = last;
        String actStr = act;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date last_date = simpleDateFormat.parse(lastStr);
            Date act_date = simpleDateFormat.parse(actStr);

            long diff = (last_date.getTime() - act_date.getTime()) / 1000 / 60;
            if (diff < 0) {
                return "";
            }
            double temp = new Double(diff);
            double hour = temp / (60 * 24);

            NumberFormat nbfm = NumberFormat.getNumberInstance();
            nbfm.setMaximumFractionDigits(2);
            String format = nbfm.format(hour);

            return format;
        } catch (Exception e) {

        }
        return "";
    }

    public static boolean judgeDayIsHoliday() {
        String dc = "http://tool.bitefu.net/jiari/?d=";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        String dateFlag = getHoliday(dc+sdf.format(new Date()));
//        if ("1".equals(dateFlag) || "2".equals(dateFlag)) {
//            logger.info("今天是法定节假日");
//        }else {
//            logger.info("今天是工作日");
//        }
        return true;
    }
//    public static judgeHave

    /**
     * 通过传入YYYY-MM~YYYY-MM字符串的月份时间筛选工单
     *
     * @param maps       要筛选的工单map，传入maps必须带工单号
     * @param timePicker YYYY-MM~YYYY-MM格式的字符串，判断在此时间中的工单
     * @param process    主要区分cover表的工单号字段为order_num
     * @return 筛选后的工单
     */
    public static List<Map<String, Object>> selectListByTimePicker(List<Map<String, Object>> maps, String timePicker, String process) {
        if (!StringUtils.isBlank(timePicker)) {
            String startTime = timePicker.split("~")[0];
            String endTime = timePicker.split("~")[1];
            int startYear = 0;
            int startMonth = 0;
            int endMonth = 0;
            int endYear = 0;
            if (startTime != null && endTime != null) {
                startYear = Integer.parseInt(startTime.split("-")[0]);
                startMonth = Integer.parseInt(startTime.split("-")[1]);
                endYear = Integer.parseInt(endTime.split("-")[0]);
                endMonth = Integer.parseInt(endTime.split("-")[1]);
                if (startYear != 0 && startMonth != 0 && endYear != 0 && endMonth != 0) {
                    Iterator<Map<String, Object>> iterator = maps.iterator();
                    while (iterator.hasNext()) {
                        Map<String, Object> map = iterator.next();
                        String serviceNo;
                        if (map.get("full_service_no")== null) {
                            serviceNo = map.get("order_num").toString();
                        }else{
                            serviceNo=map.get("full_service_no").toString();
                        }
                        String time = serviceNo.split("-")[1];
                        int year = Integer.parseInt(time.substring(0, 4));
                        int month = Integer.parseInt(time.substring(4, 6));
                        if (year < startYear || (year == startYear && month < startMonth) || year > endYear || (year == endYear && month > endMonth)) {
                            iterator.remove();
                        }
                    }
                }
            }
        }
        return maps;
    }

}
