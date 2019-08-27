package com.unitsLink.entity;

import java.util.List;
import java.util.Map;

/**
 * @projectName: ajspdsj
 * @package: com.fh.entity.ycxg
 * @className: PatrolCOnfig$
 * @description: 巡更检测配置对象
 * @author: 高优
 * @createDate: 2019/5/21/021 10:01
 * @updateUser: 更新者
 * @updateDate: 2019/5/21/021 10:01
 * @updateRemark: 更新内容
 * @version: 1.0
 */
public class PatrolConfig {
    /**
     * 配置编号
     */
    private Integer configId;
    /**
     * 绑定的特征用户编号
     */
    private String userId;
    /**
     * 绑定的特征用户姓名
     */
    private String userName;
    /**
     * 巡更开始时间
     */
    private String startDate;
    /**
     * 巡更结束时间
     */
    private String endDate;
    /**
     * 巡更绑定设备ip
     */
    private String cameraIp;


    /**
     * 巡更绑定地点
     */
    private String cameraSite;

    private List<Map> featureList;

    public List<Map> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<Map> featureList) {
        this.featureList = featureList;
    }

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCameraIp() {
        return cameraIp;
    }

    public void setCameraIp(String cameraIp) {
        this.cameraIp = cameraIp;
    }

    public String getCameraSite() {
        return cameraSite;
    }

    public void setCameraSite(String cameraSite) {
        this.cameraSite = cameraSite;
    }
}
