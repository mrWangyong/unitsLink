package com.mbhyggfwpt.controller;

import com.mbhyggfwpt.service.AlarmRecordService;
import com.mbhyggfwpt.service.UserService;
import com.mbhyggfwpt.util.Constant;
import com.mbhyggfwpt.util.EmptyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenglei
 * @description 告警
 * @className AlarmRecordController
 * @data 2019/5/15 15:49
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/register")
public class RegisterController {

    @Resource(name = "user")
    private UserService userService;

    /**
     * 35.用户注册
     *
     * @param map
     * @return
     * @throws Exception
     */
        @RequestMapping(value = "/registerTerminal")
    @ResponseBody
    public Map<String, Object> register(@RequestBody Map<String, Object> map) throws Exception {
        String msg = "";
        Map<String, Object> result = new HashMap<>(8);
        System.out.println(map.get("username"));
        if (EmptyHelper.isEmpty(map.get("username")) || EmptyHelper.isEmpty(map.get("password"))
                || EmptyHelper.isEmpty(map.get("secretKey")) || EmptyHelper.isEmpty(map.get("serialNum"))) {
            msg = "物流中心密钥 或 用户名或密码不能为空! 或者序列号不能为空";
            result.put("code", 500);
            return result;
        }
        if(EmptyHelper.isNotEmpty(map.get("secretKey"))&&!"AAA".equals(map.get("secretKey").toString())){
            msg = "密钥错误!";
            result.put("msg", msg);
            result.put("code", 500);
            return result;
        }
        Map<String, Object> userMap = new HashMap<>(8);
        userMap.put("username",map.get("username"));
        userMap.put("secretKey",map.get("secretKey"));
        userMap.put("password",map.get("password"));
        userMap.put("serialNum",map.get("serialNum"));

        int isRegister = userService.isRegister(userMap);
        if(isRegister >= 1){
            msg = "用户名已经存在或者序列号重复";
            result.put("msg", msg);
            result.put("code", 500);
        }else{
            int res =  userService.register(userMap);
            msg = "注册成功!";
            result.put("code", 200);
        }
        return result;
    }


    /**
     * @param * @param map
     * @return java.util.Map<java.lang.String   ,   java.lang.Object>
     * @description 临时登陆接口（只返回成功）
     * @author chengl
     * @date 2019/5/16 15:10
     **/
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/loadTerminal", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Map<String, Object> loadTerminal(@RequestBody Map<String, String> map) {
        Map<String, Object> result = new HashMap<>(8);
        Map<String, Object> userMap = new HashMap<>(8);
        if(EmptyHelper.isNotEmpty(map.get("secretKey"))&&!"AAA".equals(map.get("secretKey").toString())){
            String msg = "密钥错误!";
            result.put("msg", msg);
            result.put("code", 500);
            return result;
        }
        userMap.put("username",map.get("username"));
        userMap.put("password",map.get("password"));
        userMap.put("serialNum",map.get("serialNum"));

        System.out.println("serialNum="+map.get("serialNum"));
        System.out.println("password="+map.get("password"));
        System.out.println("password="+map.get("password"));

        if(null == (map.get("username")) && null == (map.get("password"))){
            int isRegister = userService.isRegister(userMap);
            if(isRegister == 1){
                result.put("code", 200);
                return result;
            }else {
                result.put("code", 500);
                return result;
            }
        }else{
            int res =  userService.login(userMap);
            if(res == 1){
                result.put("code", 200);
                result.put("message", "登录成功");
            }else {
                result.put("code", 500);
                result.put("message", "账号或者密码错误");
            }
        }
        return result;
    }

}
