package com.unitsLink.controller;

import com.unitsLink.entity.AlarmRecord;
import com.unitsLink.entity.User;
import com.unitsLink.service.AlarmRecordService;
import com.unitsLink.service.UserService;
import com.unitsLink.util.EmptyHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Resource(name = "alarmRecord")
    private AlarmRecordService alarmRecordService;

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

        if(map.containsKey("terminalType")){
            userMap.put("terminalType",map.get("terminalType"));
        }

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

        if("" == (map.get("username")) && "" == (map.get("password"))){
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

    /**
     * 终端心跳检测
     * @param map
     * @return
     */
    @RequestMapping(value="/heartTest")
    @ResponseBody
    public Map<String, Object> heartTest(@RequestBody Map<String,Object> map) {
        Map<String, Object> result = new HashMap<>(8);
        String msg = "";
        try {
            if (EmptyHelper.isEmpty(map.get("serialNum"))) {
                msg = "serialNum不能为空！";
                result.put("msg",msg);
                result.put("code",500);
                return result;
            }else {
                User user = userService.getUserBySerialnum(map);
                if(user != null){
                    if(user.getStatus().equals("0")){
                        String dateFormatPar = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                        AlarmRecord alarmRecord = new AlarmRecord();
                        alarmRecord.setAlarmType("设备连接异常预警");
                        alarmRecord.setAlarmSite("众力爆破库房");
                        alarmRecord.setAlarmTime(dateFormatPar);
                        alarmRecord.setAlarmMsg("视频服务器重新连接");
                        alarmRecordService.save(alarmRecord);
                    }
                }

            }
            if (EmptyHelper.isEmpty(map.get("lastOnlineTime"))) {
                msg = "lastOnlineTime不能为空！";
                result.put("msg",msg);
                result.put("code",500);
                return result;
            }
            try {
                map.put("status","1");
                map.put("lastOnlineTime",System.currentTimeMillis());
                Integer count = userService.updateUser(map);
                msg = "心跳发送成功";
                // 如果影响行数为0，则返回未更新提示
                if (0 == count) {
                    msg = "未找到该序列号对应的数据";
                    result.put("msg",msg);
                    result.put("code",200);
                    return result;
                }
                result.put("msg",msg);
                result.put("code",200);
                return result;
            } catch (Exception e) {
                msg = "更新出错:" + e.getMessage();
                msg = "未找到该序列号对应的数据";
                result.put("msg",msg);
                result.put("code",500);
            }
            return result;
        } catch (Exception e) {
            msg = "接口内部出错:" + e.getMessage();
            result.put("msg",msg);
            result.put("code",500);
            return result;
        }
    }
}
