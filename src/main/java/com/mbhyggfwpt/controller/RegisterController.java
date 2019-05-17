package com.mbhyggfwpt.controller;

import com.mbhyggfwpt.util.Const;
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
     * @description 临时登陆接口（只返回成功）
     * @author chengl
     * @date 2019/5/16 15:10
     * @param  * @param map
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/loadTerminal", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Map<String, Object> loadTerminal(@RequestBody Map<String, String> map){
        Map<String , Object> result = new HashMap<>(8);
        result.put("code", "200");
        result.put("message", "请求成功");
        result.put("data", "1");
        return result;
    }

}
