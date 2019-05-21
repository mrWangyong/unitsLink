package com.mbhyggfwpt.controller;

import com.mbhyggfwpt.util.Constant;
import com.mbhyggfwpt.util.EmptyHelper;
import org.springframework.web.bind.annotation.*;

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

        System.out.println(map.get("keyusername"));

        if (EmptyHelper.isEmpty(map.get("keyusername")) || EmptyHelper.isEmpty(map.get("keypassword"))
                || EmptyHelper.isEmpty(map.get("keysecretKey"))) {
            msg = "物流中心密钥或用户名或密码不能为空!";
            result.put("msg", msg);
            result.put("code", 500);
            return result;
        }
        if (EmptyHelper.isEmpty(map.get("username"))) {
            msg = "用户名不能为空!";
            result.put("msg", msg);
            result.put("code", 500);
            return result;
        }
        if (EmptyHelper.isEmpty(map.get("password"))) {
            msg = "密码不能为空!";
            result.put("msg", msg);
            result.put("code", 500);
            return result;
        }
        if(EmptyHelper.isNotEmpty(map.get("keysecretKey"))&&!"AAA".equals(map.get("keysecretKey").toString())){
            msg = "密钥错误!";
            result.put("msg", msg);
            result.put("code", 500);
            return result;
        }
        if (EmptyHelper.isEmpty(map.get("name"))) {
            map.put("name", map.get("username"));
        }
        if ("2".equals(Constant.isRegister)) {
            msg = "已经注册，不要重复注册!";
            result.put("msg", msg);
            result.put("code", 500);
            return result;
        }
        Constant.isRegister = "2";
        msg = "注册成功!";
        result.put("msg", msg);
        result.put("code", 200);
        result.put("id",1);
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
        result.put("code", "200");
        result.put("message", "请求成功");
        result.put("data", "1");
        return result;
    }

}
