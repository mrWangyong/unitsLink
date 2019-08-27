package com.unitsLink.service;

import com.github.pagehelper.PageInfo;
import com.unitsLink.entity.AlarmRecord;
import com.unitsLink.entity.PatrolConfig;
import com.unitsLink.entity.XungengTime;

import java.util.List;
import java.util.Map;

/**
 * @author chenglei
 * @description 告警接口
 * @className AlarmRecordService
 * @data 2019/5/15 17:03
 */
public interface AlarmRecordService {



    /**
     * @description 根据传入的时间，查询该时间段各告警类型的数量
     * @author chengl
     * @date 2019/5/16 13:43
     * @param  * @param map
     * @return java.util.Map
     **/
    List<Map> listByTimeAndGroupType(String startTime, String endTime);

    /**
     * @description 保存告警数据
     * @author chengl
     * @date 2019/5/16 13:24
     * @param  * @param alarmRecord
     * @return int
     **/
    Integer save(AlarmRecord alarmRecord);

    /**
     * @description 接口验证是否重复
     * @author chengl
     * @date 2019/5/16 13:14
     * @param  * @param map
     * @return com.unitsLink.entity.AlarmRecord
     **/
    AlarmRecord checkReapt(Map map);

    /**
     * @description 根据条件查询告警分页列表数据
     * @author chengl
     * @date 2019/5/15 17:50
     * @param  * @param map
     * @return java.util.List<com.unitsLink.entity.AlarmRecord>
     **/
    PageInfo<AlarmRecord> listPageAlarmRecord(Map map);

    AlarmRecord isExistXungeng(Map map);

    Integer updateAlarmRecord(AlarmRecord alarmRecord);

    XungengTime getXungengTime(Map map);

    Integer updateWorkTypeSingle(Map map);

    List<PatrolConfig> findPatrolList(Map map);

}
