package com.unitsLink.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unitsLink.entity.AlarmRecord;
import com.unitsLink.entity.PatrolConfig;
import com.unitsLink.entity.XungengTime;
import com.unitsLink.mapper.AlarmRecordMapper;
import com.unitsLink.service.AlarmRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author chenglei
 * @description 告警服务层实现类
 * @className AlarmRecordServiceImpl
 * @data 2019/5/15 17:04
 */
@Service(value = "alarmRecord")
public class AlarmRecordServiceImpl implements AlarmRecordService {

    @Autowired
    private AlarmRecordMapper alarmRecordMapper;



    /**
     * @description 根据传入的时间，查询该时间段各告警类型的数量
     * @author chengl
     * @date 2019/5/16 13:43
     * @param  * @param map
     * @return java.util.Map
     **/
    @Override
    public List<Map> listByTimeAndGroupType(String startTime, String endTime) {
        return alarmRecordMapper.listByTimeAndGroupType(startTime, endTime);
    }

    /**
     * @description 保存告警数据
     * @author chengl
     * @date 2019/5/16 13:24
     * @param  * @param alarmRecord
     * @return int
     **/
    @Override
    public Integer save(AlarmRecord alarmRecord) {
        return alarmRecordMapper.save(alarmRecord);
    }

    /**
     * @description 接口验证是否重复
     * @author chengl
     * @date 2019/5/16 13:14
     * @param  * @param map
     * @return com.unitsLink.entity.AlarmRecord
     **/
    @Override
    public AlarmRecord checkReapt(Map map) {
        return alarmRecordMapper.checkReapt(map);
    }

    /**
     * 根据条件查询告警列表数据
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<AlarmRecord> listPageAlarmRecord(Map map) {
        int pageNum = Integer.parseInt(map.get("pageNum").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        PageHelper.startPage(pageNum,pageSize);
        List<AlarmRecord> alarmRecordList = alarmRecordMapper.listPageAlarmRecord(map);
        PageInfo<AlarmRecord> pageInfo =new PageInfo<>(alarmRecordList);
        return pageInfo;
    }

    @Override
    public AlarmRecord isExistXungeng(Map map){
        return alarmRecordMapper.isExistXungeng(map);
    }

    @Override
    public Integer updateAlarmRecord(AlarmRecord alarmRecord){
        return alarmRecordMapper.updateAlarmRecord(alarmRecord);
    }

    @Override
    public XungengTime getXungengTime(Map map){
        return alarmRecordMapper.getXungengTime(map);
    }

    @Override
    public Integer updateWorkTypeSingle(Map map){
        return  alarmRecordMapper.updateWorkTypeSingle(map);
    }

    @Override
    public List<PatrolConfig> findPatrolList(Map map){
        return  alarmRecordMapper.findPatrolList(map);
    }
}
