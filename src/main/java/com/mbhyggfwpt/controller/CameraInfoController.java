package com.mbhyggfwpt.controller;

import com.mbhyggfwpt.service.AlarmRecordService;
import com.mbhyggfwpt.util.EmptyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping(value="/cameraInfoAPI")
public class CameraInfoController {

    @Resource(name = "alarmRecord")
    private AlarmRecordService alarmRecordService;

    /**
     * 50:更新巡更摄像头
     * @param map
     * @return
     */
    @ResponseBody
    @CrossOrigin
    @RequestMapping(value="/updateWorkType", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Map<String, Object> updateWorkType(@RequestBody Map<String, Object> map) {
        String msg = "";
        Map<String, Object> result = new HashMap<>(8);
        try {
            if (EmptyHelper.isEmpty(map.get("terminalId"))) {
                result.put("msg","终端编号不能为空");
                result.put("code",400);
                return result;
            }
            if (EmptyHelper.isEmpty(map.get("workType"))) {
                result.put("msg","摄像头作用类型不能为空");
                result.put("code",400);
                return result;
            }
            if (EmptyHelper.isEmpty(map.get("oper"))) {
                result.put("msg","操作不能为空");
                result.put("code",400);
                return result;
            }
            if (EmptyHelper.isEmpty(map.get("ip"))) {
                result.put("msg","ip不能为空");
                result.put("code",400);
                return result;
            }
            Map<String, Object> mapPar = new HashMap<>(8);
            int oper = Integer.parseInt(String.valueOf(map.get("oper")));
            if(1==oper){ //新增
                mapPar.put("workType", map.get("workType"));
            }else if(2==oper){ //删除
                mapPar.put("workType",0);
            }else{
                result.put("msg","操作不符合规范");
                result.put("code",400);
                return result;
            }
            mapPar.put("ip",map.get("ip"));
            alarmRecordService.updateWorkTypeSingle(mapPar);
            result.put("msg","更新成功");
            result.put("code",200);
            return result;
        } catch (Exception e) {
            msg = "接口内部出错:" + e.getMessage();
            result.put("msg",msg);
            result.put("code",400);
            return result;
        }
    }

}
