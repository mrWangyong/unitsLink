package com.unitsLink.controller;

import com.unitsLink.entity.PatrolConfig;
import com.unitsLink.service.AlarmRecordService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping(value="/patrolConfig")
public class PatrolConfigController {

    @Resource(name = "alarmRecord")
    private AlarmRecordService alarmRecordService;

    @Value("${imgdirPath}")
    private String imgdirPath;

    @RequestMapping(value="/findPatrolConfigList")
    @ResponseBody
    public Map<String, Object> findPatrolConfigList(@RequestBody Map<String,Object> map) {
        Map<String, Object> result = new HashMap<>(8);
        String msg = "";
        try {
            Map<String,String> mapPar= new HashMap<>();
            mapPar.put("imgdirPath",imgdirPath);
            List<PatrolConfig> list=alarmRecordService.findPatrolList(mapPar);
            for (PatrolConfig p :list) {
                p.setFeatureList(getAllFeatur(p.getUserId()));
            }
            result.put("msg","更新成功");
            result.put("data",list);
            result.put("code",200);
            result.put("message","true");
            return result;
        }  catch (Exception e) {
            msg = "接口内部出错:" + e.getMessage();
            result.put("msg",msg);
            result.put("code",400);
            return result;
        }
    }

    private List<Map> getAllFeatur(String userId){
        List<Map> list=new ArrayList<>();
        if("1".equals(userId)){
            //雷建中
            Map map1=new HashMap();
            map1.put("id","1");
            map1.put("userName","雷建中");
            map1.put("bean_path",imgdirPath+"1.bin");

            Map map2=new HashMap();
            map2.put("id","2");
            map2.put("userName","雷建中1");
            map2.put("bean_path",imgdirPath+"2.bin");

            list.add(map1);
            list.add(map2);
        }else if("2".equals(userId)){
            //刘锡和
            Map map3=new HashMap();
            map3.put("id","3");
            map3.put("userName","刘锡和");
            map3.put("bean_path",imgdirPath+"3.bin");

            Map map6=new HashMap();
            map6.put("id","6");
            map6.put("userName","刘锡和1");
            map6.put("bean_path",imgdirPath+"6.bin");

            Map map11=new HashMap();
            map11.put("id","11");
            map11.put("userName","刘锡和2");
            map11.put("bean_path",imgdirPath+"11.bin");

            list.add(map3);
            list.add(map6);
            list.add(map11);
        }else if("3".equals(userId)){
            //王道军
            Map map4=new HashMap();
            map4.put("id","4");
            map4.put("userName","王道军");
            map4.put("bean_path",imgdirPath+"4.bin");

            list.add(map4);
        }else if("4".equals(userId)){
            //杨通学
            Map map5= new HashMap();
            map5.put("id","5");
            map5.put("userName","杨通学");
            map5.put("bean_path",imgdirPath+"5.bin");

            list.add(map5);
        }else if("5".equals(userId)){
            //熊玉春
            Map map7= new HashMap();
            map7.put("id","7");
            map7.put("userName","熊玉春");
            map7.put("bean_path",imgdirPath+"7.bin");

            Map map8= new HashMap();
            map8.put("id","8");
            map8.put("userName","熊玉春1");
            map8.put("bean_path",imgdirPath+"8.bin");

            list.add(map7);
            list.add(map8);
        }else if("6".equals(userId)){
            //文安平
            Map map9= new HashMap();
            map9.put("id","9");
            map9.put("userName","文安平");
            map9.put("bean_path",imgdirPath+"9.bin");

            Map map10= new HashMap();
            map10.put("id","10");
            map10.put("userName","文安平1");
            map10.put("bean_path",imgdirPath+"10.bin");

            list.add(map9);
            list.add(map10);
        }else if("7".equals(userId)){
            //冷静（测试）
            Map map12= new HashMap();
            map12.put("id","7");
            map12.put("userName","冷静");
            map12.put("bean_path",imgdirPath+"12.bin");

            list.add(map12);
        }else if("8".equals(userId)){
            //陈彦文（测试）
            Map map13= new HashMap();
            map13.put("id","13");
            map13.put("userName","陈彦文");
            map13.put("bean_path",imgdirPath+"13.bin");

            Map map14= new HashMap();
            map14.put("id","14");
            map14.put("userName","陈彦文1");
            map14.put("bean_path",imgdirPath+"14.bin");

            list.add(map13);
            list.add(map14);
        }
        return list;
    }
}
