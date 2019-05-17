package com.mbhyggfwpt.util;

import org.mybatis.spring.annotation.MapperScan;

import java.util.Map;

/**
 * @author chenglei
 * @description 分页帮助类
 * @className PageHelper
 * @data 2019/5/16 10:43
 */
public class PageHelper {

    public static String checkPagePar(Map map) {
        if (EmptyHelper.isEmpty(map.get("pageNum"))) {
            return "当前页码不能为空";
        } else {
            if (EmptyHelper.isEmpty(map.get("pageNum").toString())) {
                return "当前页码不能为空";
            }
        }
        if (EmptyHelper.isEmpty(map.get("pageSize"))) {
            return "每页显示数量不能为空";
        } else {
            if (EmptyHelper.isEmpty(map.get("pageSize").toString())) {
                return "每页显示数量不能为空";
            }
        }
        return "";
    }

}
