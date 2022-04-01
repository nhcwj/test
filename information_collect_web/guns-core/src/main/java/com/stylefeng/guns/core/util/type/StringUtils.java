package com.stylefeng.guns.core.util.type;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by XLKAI on 2017/5/19.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static final char UNDERLINE = '_';

    /**
     * 驼峰格式字符串转换为下划线格式字符串
     *
     * @param param
     * @return
     */
    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                if (i != 0) sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 下划线格式字符串转换为驼峰格式字符串
     *
     * @param param
     * @return
     */
    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String rand_int(int len) {
        String str = "0123456789";
        str += (str + str + str + str);

        List<String> list = Arrays.asList(str.split(""));
        Collections.shuffle(list);

        Random random = new Random();
        int size = list.size();
        String newStr = "";
        for (int i = 0; i < len; i++) {
            newStr += list.get(random.nextInt(size));
        }
        return newStr;
    }

    public static String randLetter(int len) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        str += (str + str + str + str);

        List<String> list = Arrays.asList(str.split(""));
        Collections.shuffle(list);

        Random random = new Random();
        int size = list.size();
        String newStr = "";
        for (int i = 0; i < len; i++) {
            newStr += list.get(random.nextInt(size));
        }
        return newStr;
    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
