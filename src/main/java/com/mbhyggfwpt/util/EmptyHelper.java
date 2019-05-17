package com.mbhyggfwpt.util;

import java.util.Collection;
import java.util.Map;

/**
 * @author chenglei
 * @data 2017/11/28 16:38
 */
public class EmptyHelper {
    /**
     * 是否为空
     * @param obj 待处理
     * @return
     */
    public static boolean isEmpty(Object obj){
        if(null == obj){
            return true;}
        return false;
    }
    /**
     * 是否不为空
     * @param obj 待处理
     * @return
     */
    public static boolean isNotEmpty(Object obj){
        return !isEmpty(obj);
    }
    /**
     * 是否为空
     * @param obj 待处理
     * @return
     */
    public static boolean isEmpty(String[] obj){
        if(null == obj || obj.length == 0){
            return true;}
        return false;
    }

    /**
     * 是否不为空
     * @param obj 待处理
     * @return
     */
    public static boolean isNotEmpty(String[] obj){
        return !isEmpty(obj);
    }
    /**
     * 是否为空
     * @param str 待处理
     * @return
     */
    public static boolean isEmpty(String str){
        if(null == str || 0 == str.length()){
            return true;}
        return false;
    }
    /**
     * 是否不为空
     * @param str 待处理
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     * 是否为空
     * @param obj 待处理
     * @return
     */
    public static boolean isEmpty(int obj){
        if(obj == Integer.MIN_VALUE){
            return true;}
        return false;
    }
    /**
     * 是否不为空
     * @param obj 待处理
     * @return
     */
    public static boolean isNotEmpty(int obj){
        return !isEmpty(obj);
    }
    /**
     * 是否为空
     * @param obj 待处理
     * @return
     */
    public static boolean isEmpty(Collection obj){
        if(obj == null || obj.size() == 0){
            return true;}
        return false;
    }
    /**
     * 是否不为空
     * @param obj 待处理
     * @return
     */
    public static boolean isNotEmpty(Collection obj){
        return !isEmpty(obj);
    }

    /**
     * 是否为空
     * @param obj 待处理
     * @return
     */
    public static boolean isEmpty(StringBuffer obj){
        if(obj == null || obj.length() == 0){
            return true;}
        return false;
    }
    /**
     * 是否不为空
     * @param obj 待处理
     * @return
     */
    public static boolean isNotEmpty(StringBuffer obj){
        return !isEmpty(obj);
    }
    /**
     * 是否为空
     * @param obj 待处理
     * @return
     */
    public static boolean isEmpty(Map obj){
        if(obj == null || obj.isEmpty()){
            return true;}
        return false;
    }
    /**
     * 是否不为空
     * @param obj 待处理
     * @return
     */
    public static boolean isNotEmpty(Map obj){
        return !isEmpty(obj);
    }

}
