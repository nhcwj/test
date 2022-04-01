package com.stylefeng.guns.core.util;

import com.stylefeng.guns.core.constant.TableEnum;

/**
 * @Auther: biu
 * @Date: 2019/7/15 11:02
 * @Description:
 */
public class BeanFactoryUtil {
    public static Class convertSheetNameToClass(String sheetName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String packageName =TableEnum.getEnumBysheetName(sheetName).getPackageName();
        Class c = Class.forName(packageName);//这里的类名是全名。。有包的话要加上包名
        return c;
    }


}
