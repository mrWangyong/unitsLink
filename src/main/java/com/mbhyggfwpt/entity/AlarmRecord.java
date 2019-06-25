package com.mbhyggfwpt.entity;

/**
 * @description 告警信息
 * @author chengl
 * @date 2019/5/16 10:03
 * @param  * @param null
 * @return
 **/
public class AlarmRecord {

	private Integer id;				//告警记录编号
	private Integer terminalId;		//终端编号
	private String imgPath;			//告警图片路径
	private String base64;			//图片base64编码流
	private String alarmMsg;		//告警信息
	private String alarmTime;		//告警时间
	private String alarmSite;		//告警地点
	private String alarmType;		//告警类型
	private String alarmCategory;	//告警类别/车载还是NVR 
	private String status;			//标识
	private String remark;			//标记
	private String area_sign;		//数据来源 1为车载 2为园区 3为手机
	private String typecode;		//告警类型编码
	
	private String imageMd5;	//图片MD5值
	private Long imageSize;		//图片大小
	private String imageName;	//图片名字
	private String imageExt;  	//图片类型后缀
	private String thumbnailPath;	//缩略图路径

    private String dealStatus;  //告警处理状态（0：已完成，其它：待处理）
    private String dealRole;    //当前待处理角色，存入能处理的角色ID

    private String addId;    //添加人ID
    private String addName;    //添加人名称
    private Integer aqjcId;             //映射的安全检查ID
    private String aqjcDetailIds;       //映射的安全检查明细ID（可能多个）
    private String depId;    //组织机构ID
    private String depBianma;    //组织机构编码
    private String depName;    //组织机构名称

	private String taskId;
	private String processId;
	private String videoPath;

	// 20190124:BMP图片的存储路径
	private String bmpimgPath;

	private String sign;

	// 20190221:产生告警的终端编号

	private Integer alarmTerminalId;
    @Override
    public String toString() {
        return "AlarmRecord{" +
                "id=" + id +
                ", terminalId=" + terminalId +
                ", imgPath='" + imgPath + '\'' +
                ", base64='" + base64 + '\'' +
                ", alarmMsg='" + alarmMsg + '\'' +
                ", alarmTime='" + alarmTime + '\'' +
                ", alarmSite='" + alarmSite + '\'' +
                ", alarmType='" + alarmType + '\'' +
                ", alarmCategory='" + alarmCategory + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", area_sign='" + area_sign + '\'' +
                ", imageMd5='" + imageMd5 + '\'' +
                ", imageSize=" + imageSize +
                ", imageName='" + imageName + '\'' +
                ", imageExt='" + imageExt + '\'' +
                ", dealStatus='" + dealStatus + '\'' +
                ", typecode='" + typecode + '\'' +
                ", dealRole='" + dealRole + '\'' +
                ", thumbnailPath='" + thumbnailPath + '\'' +
                '}';
    }

    public Integer getAlarmTerminalId() {
        return alarmTerminalId;
    }

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

    public void setAlarmTerminalId(Integer alarmTerminalId) {
        this.alarmTerminalId = alarmTerminalId;
    }

    public String getBmpimgPath() {
        return bmpimgPath;
    }

    public void setBmpimgPath(String bmpimgPath) {
        this.bmpimgPath = bmpimgPath;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepBianma() {
        return depBianma;
    }

    public void setDepBianma(String depBianma) {
        this.depBianma = depBianma;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Integer getAqjcId() {
        return aqjcId;
    }

    public void setAqjcId(Integer aqjcId) {
        this.aqjcId = aqjcId;
    }

    public String getAqjcDetailIds() {
        return aqjcDetailIds;
    }

    public void setAqjcDetailIds(String aqjcDetailIds) {
        this.aqjcDetailIds = aqjcDetailIds;
    }

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getAddId() {
        return addId;
    }

    public void setAddId(String addId) {
        this.addId = addId;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    public String getImageMd5() {
		return imageMd5;
	}
	public void setImageMd5(String imageMd5) {
		this.imageMd5 = imageMd5;
	}
	public Long getImageSize() {
		return imageSize;
	}
	public void setImageSize(Long imageSize) {
		this.imageSize = imageSize;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageExt() {
		return imageExt;
	}
	public void setImageExt(String imageExt) {
		this.imageExt = imageExt;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(Integer terminalId) {
		this.terminalId = terminalId;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	public String getAlarmMsg() {
		return alarmMsg;
	}
	public void setAlarmMsg(String alarmMsg) {
		this.alarmMsg = alarmMsg;
	}
	public String getAlarmTime() {
		return alarmTime;
	}
	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}
	public String getAlarmSite() {
		return alarmSite;
	}
	public void setAlarmSite(String alarmSite) {
		this.alarmSite = alarmSite;
	}
	public String getAlarmType() {
		return alarmType;
	}
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}
	public String getAlarmCategory() {
		return alarmCategory;
	}
	public void setAlarmCategory(String alarmCategory) {
		this.alarmCategory = alarmCategory;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getArea_sign() {
		return area_sign;
	}

	public void setArea_sign(String area_sign) {
		this.area_sign = area_sign;
	}

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getDealRole() {
        return dealRole;
    }

    public void setDealRole(String dealRole) {
        this.dealRole = dealRole;
    }

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}
	
}
