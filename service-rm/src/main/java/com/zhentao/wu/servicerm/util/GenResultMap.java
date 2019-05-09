package com.zhentao.wu.servicerm.util;

import com.zhentao.wu.automybatis.model.TMenu;

import javax.persistence.Column;
import java.lang.reflect.Field;

public class GenResultMap {
    /**
     * 1.用于获取结果集的映射关系
     */
    public static String getResultsStr(Class origin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Results({\n");
        for (Field field : origin.getDeclaredFields()) {
            Column annotation = field.getAnnotation(Column.class);
            if (annotation == null){
                continue;
            }
            String property = field.getName();
            //映射关系：对象属性(驼峰)->数据库字段(下划线)
            String column = annotation.name();
            stringBuilder.append(String.format("@Result(property = \"%s\", column = \"%s\"),\n", property, column));
        }
        stringBuilder.append("})");
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        System.out.println(getResultsStr(new TMenu().getClass()));
    }
}
