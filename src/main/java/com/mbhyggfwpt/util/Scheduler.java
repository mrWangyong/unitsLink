package com.mbhyggfwpt.util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mbhyggfwpt.entity.AlarmRecord;
import com.mbhyggfwpt.entity.User;
import com.mbhyggfwpt.service.AlarmRecordService;
import com.mbhyggfwpt.service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Scheduler{

    @Resource(name = "user")
    private UserService userService;
    @Resource(name = "alarmRecord")
    private AlarmRecordService alarmRecordService;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    //每隔5分钟执行一次
    @Scheduled(fixedRate = 1000*60*5)
    public void testTasks() {
        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
        Map<String,Object> map=new HashMap<String,Object>(16);
        getTerminalStatus();
    }

    public void getTerminalStatus(){
        Map<String,Object> map=new HashMap<String,Object>(16);
        map.put("chainPharmacyId",1);
        List<User> userList = userService.getUserList(map);
        int num=0;
        for(User user:userList){
            String statustime = user.getLastOnlineTime();
            if(null!=statustime&&!"".equals(statustime)){
                long curTime=System.currentTimeMillis();
                long subTime=(curTime-Long.parseLong(statustime))/ (1000 * 60);
//                System.out.println("设备编号为"+user.getSerialNum()+"的当前时间"+curTime +"数据库时间"+statustime+"结果"+subTime);
                String dateFormatPar = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//                System.out.println("当前时间="+dateFormatPar);
                if(Integer.parseInt(String.valueOf(subTime))>5){
                    num++;
                    if(null!=user.getSerialNum()&&!"".equals(user.getSerialNum())){
                        if(user.getStatus().equals("1")){  //如果间隔大于5分钟且设备为在线状态，改为离线状态
                            System.out.println("设备编号为：" + user.getSerialNum()+"离线");
                            Map<String,Object> mapPar=new HashMap<String,Object>(16);
                            mapPar.put("status","0");
                            mapPar.put("serialNum",user.getSerialNum());
                            userService.updateUser(mapPar);

                            AlarmRecord alarmRecord = new AlarmRecord();
                            alarmRecord.setAlarmType("设备连接异常预警");
                            alarmRecord.setAlarmSite("众力爆破库房");
                            alarmRecord.setAlarmTime(dateFormatPar);
                            alarmRecord.setAlarmMsg("视频服务器掉线");
                            alarmRecordService.save(alarmRecord);

                        }
                    }
                }
            }
        }
    }
}
