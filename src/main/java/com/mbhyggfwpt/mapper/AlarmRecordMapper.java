package com.mbhyggfwpt.mapper;

import com.mbhyggfwpt.entity.AlarmRecord;
import com.mbhyggfwpt.entity.PatrolConfig;
import com.mbhyggfwpt.entity.XungengTime;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author chenglei
 * @description 告警接口
 * @className AlarmRecordMapper
 * @data 2019/5/16 09:03
 */
public interface AlarmRecordMapper {

    /**
     * @description 根据传入的时间，查询该时间段各告警类型的数量
     * @author chengl
     * @date 2019/5/16 13:43
     * @param  * @param map
     * @return java.util.Map
     **/
    List<Map> listByTimeAndGroupType(@Param("startTime") String startTime, @Param("endTime") String endTime);

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
     * @return com.mbhyggfwpt.entity.AlarmRecord
     **/
    AlarmRecord checkReapt(Map map);

    /**
     * @description 根据条件查询告警分页列表数据
     * @author chengl
     * @date 2019/5/15 17:50
     * @param  * @param map
     * @return java.util.List<com.mbhyggfwpt.entity.AlarmRecord>
     **/
    List<AlarmRecord> listPageAlarmRecord(Map map);

    //在一段时间是否有巡更数据
    AlarmRecord isExistXungeng(Map map);

    Integer updateAlarmRecord(AlarmRecord alarmRecord);

    XungengTime getXungengTime(Map map);

    Integer updateWorkTypeSingle(Map map);

    List<PatrolConfig> findPatrolList(Map map);
}
