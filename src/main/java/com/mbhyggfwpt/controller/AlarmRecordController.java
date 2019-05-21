package com.mbhyggfwpt.controller;

import com.github.pagehelper.PageInfo;
import com.mbhyggfwpt.entity.AlarmRecord;
import com.mbhyggfwpt.service.AlarmRecordService;
import com.mbhyggfwpt.util.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenglei
 * @description 告警
 * @className AlarmRecordController
 * @data 2019/5/15 15:49
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/recordAlarm")
public class AlarmRecordController {

    @Resource(name = "alarmRecord")
    private AlarmRecordService alarmRecordService;
    @Value("${staticIP}")
    private String staticIP;

    /**
     * @description 返回数据列表
     * @author chengl
     * @date 2019/5/16 15:10
     * @param  * @param map
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/listPageAlarmRecord", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Map<String, Object> listPageAlarmRecord(@RequestBody Map<String, String> map) {
        Map<String, Object> result = new HashMap<>(Const.MAPINITSIZE);

        // 验证传入的分页数据（当前页码、每页显示数据）不能为空
        String msg = PageHelper.checkPagePar(map);
        if (EmptyHelper.isNotEmpty(msg)) {
            result.put("code", "500");
            result.put("message", msg);
            return result;
        }
        map.put("staticIP", staticIP);

        // 获取列表数据
        PageInfo<AlarmRecord> alarmRecordList = alarmRecordService.listPageAlarmRecord(map);

        result.put("code", "200");
        result.put("message", "请求成功");
        result.put("alarmRecordList", alarmRecordList);
        return result;
    }

    /**
     * @description 返回告警类型分组数据
     * @author chengl
     * @date 2019/5/16 15:10
     * @param  * @param map
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/alarmRecordCount", method = RequestMethod.GET)
    public Map<String, Object> alarmRecordCount() {
        Map<String, Object> result = new HashMap<>(Const.MAPINITSIZE);

        // 获取本日各告警类型数量
        List<Map> todayCountList = alarmRecordService.listByTimeAndGroupType(DateUtil.getTodayStart(), DateUtil.getTodayEnd());
        // 获取本周各告警类型数量
        List<Map> weekCountList = alarmRecordService.listByTimeAndGroupType(DateUtil.getFirstDayOfWeek(), DateUtil.getLastDayOfWeek());
        // 获取本周各告警类型数量
        List<Map> monthCountList = alarmRecordService.listByTimeAndGroupType(DateUtil.getFirstDayOfMonth(), DateUtil.getLastDayOfMonth());
        // 获取本周各告警类型数量
        List<Map> allCountList = alarmRecordService.listByTimeAndGroupType("", "");
//        List<Map> allCountList = new ArrayList<>();



        result.put("code", "200");
        result.put("message", "请求成功");
        result.put("todayCountList", todayCountList);
        result.put("weekCountList", weekCountList);
        result.put("monthCountList", monthCountList);
        result.put("allCountList", allCountList);
        return result;
    }


    /**
     * 接收告警信息
     * @param alarmRecord
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/addRecord", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public Map<String, Object> addRecord(@RequestBody AlarmRecord alarmRecord) {
        Map<String , Object> result = new HashMap<>(Const.MAPINITSIZE);

        // 验证基础参数
        String msg = this.verificationParm(alarmRecord);
        if (EmptyHelper.isNotEmpty(msg)) {
            result.put("code", "500");
            result.put("message", msg);
            return result;
        }

        // 保存图片
        if (EmptyHelper.isNotEmpty(alarmRecord.getBase64())) {
            saveImg(alarmRecord);
        }

        // 验证重复数据
        Map<String,Object> repeatVer = this.verificationRepeatAlarmRecord(alarmRecord);
        msg = repeatVer.get("msg").toString();
        if(EmptyHelper.isNotEmpty(msg)){
            result.put("code", "500");
            result.put("message", msg);
            return result;
        }
        alarmRecord.setAlarmSite("众力爆破库房");
        // 添加数据
        alarmRecordService.save(alarmRecord);

        result.put("code", "200");
        result.put("message", "告警数据添加成功");
        result.put("id", alarmRecord.getId());
        return result;
    }

    /**
     * 验证基础参数
     *
     * @param alarmRecord
     * @return: java.lang.String
     * @description: verificationParm
     * @author: gaoyou
     * @date: 2019/04/16 15:05
     */
    private String verificationParm(AlarmRecord alarmRecord){
        if (EmptyHelper.isEmpty(alarmRecord)) {
            return "请求参数不能为空！";
        }
        if (EmptyHelper.isEmpty(alarmRecord.getAlarmTime())) {
            return "请输入正确的告警时间！";
        }
        if (EmptyHelper.isEmpty(alarmRecord.getAlarmSite())) {
            return "告警地点不能为空！";
        }
        /*if (EmptyHelper.isEmpty(alarmRecord.getArea_sign())) {
            return "车载园区标记不能为空";
        }
        if (EmptyHelper.isEmpty(alarmRecord.getAlarmCategory())) {
            return "告警信息所属终端类别不能为空！";
        }*/
        if (EmptyHelper.isEmpty(alarmRecord.getTypecode()) && EmptyHelper.isEmpty(alarmRecord.getAlarmType())) {
            return "告警类型不能为空！";
        }
        /*if (EmptyHelper.isEmpty(alarmRecord.getTerminalId())||alarmRecord.getTerminalId()<1) {
            return "终端ID不能为空或负数！";
        }*/
        if (EmptyHelper.isNotEmpty(alarmRecord.getBase64())) {
            if (null == alarmRecord.getImageExt()) {
                return "请指定图片类型:.jpg、.png.....";
            }
        }
        return "";
    }

    /**
     * 保存告警图片，如果为实时监控图不保存缩略图，否则保存缩略图
     * @param alarmRecord
     * @return: void
     * @description: saveImg
     * @author: gaoyou
     * @date: 2019/04/16 16:24
     */
    private void saveImg(AlarmRecord alarmRecord){
        Base64topic base64topic = new Base64topic();
        Map<String, Object> map = base64topic.encodeBase64(alarmRecord.getBase64(), Constant.UPLOADFILE, alarmRecord.getImageExt());
        alarmRecord.setImgPath(map.get("filePath").toString());
        alarmRecord.setImageName(map.get("fileName").toString());
        // 生成缩略图
        File file = new File(map.get("sjPath").toString());
        if (file.exists()) {
            String destpath = map.get("sjPath").toString().substring(0, map.get("sjPath").toString().lastIndexOf(".")) + "_" + Constant.IMGSIZE + alarmRecord.getImageExt();
            System.out.println("destpath" + destpath);
            String strtemp = destpath.substring(destpath.indexOf("uploadfiles"));
            System.out.println("strtemp" + strtemp);
            System.out.println("11111");
            alarmRecord.setThumbnailPath(strtemp.substring(strtemp.indexOf("/")));
//            alarmRecord.setThumbnailPath(strtemp.substring(strtemp.indexOf("\\")).replaceAll("\\\\", "/"));
            System.out.println("222222");
        }
    }

    /**
     * 验证告警数据是否重复
     *
     * @param alarmRecord
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @description: verificationRepeatAlarmRecord
     * @author: gaoyou
     * @date: 2019/04/16 17:07
     */
    private Map<String,Object> verificationRepeatAlarmRecord(AlarmRecord alarmRecord) {
        Map<String,Object> map = new HashMap<>(4);
        try {
            // 根据告警时间、告警类型、告警地址查询该条数据的唯一性，如果有重复，则返回报错
            Map<String, String> repeatPar = new HashMap<>(8);
            repeatPar.put("alarmTimePar", alarmRecord.getAlarmTime());
            repeatPar.put("alarmTypePar", alarmRecord.getAlarmType());
            repeatPar.put("alarmSitePar", alarmRecord.getAlarmSite());
            AlarmRecord alarmRecordRepreat = alarmRecordService.checkReapt(repeatPar);
            if (EmptyHelper.isNotEmpty(alarmRecordRepreat)) {
                map.put("id",alarmRecordRepreat.getId());
                map.put("msg", "数据重复，该数据已存在");
                return map;
            }
        } catch (Exception e) {
            map.put("id",0);
            map.put("msg", "告警数据查询失败");
            return map;
        }
        map.put("msg", "");
        return map;
    }

}
