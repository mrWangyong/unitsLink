package com.unitsLink.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
 * 说明：日期处理
 * 创建人：FH Q313596790
 * 修改时间：2015年11月24日
 * @version
 */
public class DateUtil {
	
	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
	private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
	private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");
	private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final static SimpleDateFormat sdfTimes = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * 获取YYYY格式
	 * @return
	 */
	public static String getSdfTimes() {
		return sdfTimes.format(new Date());
	}
	
	/**
	 * 获取YYYY格式
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}
	
	/**
	 * 获取YYYYMMDD格式
	 * @return
	 */
	public static String getDays(){
		return sdfDays.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}

    /**
     * @description 获取YYYY-MM-DD HH:mm:ss格式当天开始时间
     * @author chengl
     * @date 2019/5/16 14:55
     * @param  * @param
     * @return java.lang.String
     **/
    public static String getTodayStart() {
        return sdfDay.format(new Date()) + " 00:00:00";
    }

    /**
     * @description 获取YYYY-MM-DD HH:mm:ss格式当天结束时间
     * @author chengl
     * @date 2019/5/16 14:55
     * @param  * @param
     * @return java.lang.String
     **/
    public static String getTodayEnd() {
        return sdfDay.format(new Date()) + " 23:59:59";
    }

    /**
     * @description 获取YYYY-MM-DD HH:mm:ss格式本月第一天的日期
     * @author chengl
     * @date 2019/5/16 13:52
     * @param  * @param
     * @return java.util.Date
     **/
    public static String getFirstDayOfMonth() {
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        // 日期设置为本月第一天
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return sdfd.format(calendar.getTime()) + " 00:00:00";
    }

    /**
     * @description 获取YYYY-MM-DD HH:mm:ss格式本月最后一天的日期
     * @author chengl
     * @date 2019/5/16 13:55
     * @param  * @param
     * @return java.util.Date
     **/
    public static String getLastDayOfMonth() {
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        // 将月份设置到下个月
        calendar.add(Calendar.MONTH, 1);
        // 将日期设置为第一天
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // 下个月第一天减一，则为当月最后一天
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return sdfd.format(calendar.getTime()) + " 23:59:59";
    }

	/**
	 * @description 获取YYYY-MM-DD HH:mm:ss格式本周一的日期
	 * @author chengl
	 * @date 2019/5/16 13:52
	 * @param  * @param
	 * @return java.util.Date
	 **/
	public static String getFirstDayOfWeek() {
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        // 由于系统中一周第一天是周日，所以获取时需要进行逻辑判断
        // 如果为周日，则获取当周周一，会获取明天的时间。所以需要对此进行判断
        // 如果为周日，获取上周周一，否则，获取当周周一
        if (Calendar.SUNDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
            calendar.set(Calendar.DAY_OF_WEEK, -6);
        } else {
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        }
        return sdfd.format(calendar.getTime()) + " 00:00:00";
    }

    /**
     * @description 获取YYYY-MM-DD HH:mm:ss格式本周日的日期
     * @author chengl
     * @date 2019/5/16 13:55
     * @param  * @param
     * @return java.util.Date
     **/
    public static String getLastDayOfWeek() {
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        // 由于系统中一周第一天是周日，所以获取时需要进行逻辑判断
        // 如果为非周日，由于第一天是周日，所以获取时，会获取上周日
        // 如果不为周日，获取下周第一天。否则，直接获取当天数据
        if (Calendar.SUNDAY != calendar.get(Calendar.DAY_OF_WEEK)) {
            calendar.add(Calendar.DATE, 7);
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        }

        return sdfd.format(calendar.getTime()) + " 23:59:59";
    }

	/**
	* @Title: compareDate
	* @Description: (日期比较，如果s>=e 返回true 否则返回false)
	* @param s
	* @param e
	* @return boolean  
	* @throws
	* @author fh
	 */
	public static boolean compareDate(String s, String e) {
		if(fomatDate(s)==null||fomatDate(e)==null){
			return false;
		}
		return fomatDate(s).getTime() >=fomatDate(e).getTime();
	}

	/**
	 * 格式化日期
	 * @return
	 */
	public static Date fomatDate(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 格式化日期
	 * @return
	 */
	public static String formatDateSecond(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
    /**
     * @description 将日期转换为字符串（YYYY-MM-DD）
     * @author chengl
     * @date 2019/4/18 14:53
     * @param  * @param date
     * @return java.lang.String
     **/
    public static String fomatString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	/**
	 * 校验日期是否合法
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}
	
	/**
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//long aa=0;
			int years=(int) (((fmt.parse(endTime).getTime()-fmt.parse(startTime).getTime())/ (1000 * 60 * 60 * 24))/365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}
	 
	/**
     * <li>功能描述：时间相减得到天数
     * @param beginDateStr
     * @param endDateStr
     * @return
     * long 
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr, String endDateStr){
        long day=0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date beginDate = null;
        java.util.Date endDate = null;

            try {
				beginDate = format.parse(beginDateStr);
				endDate= format.parse(endDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
            //System.out.println("相隔的天数="+day);

        return day;
    }

    public static long getTimeSub(String beginDateStr, String endDateStr){
    	long time=0;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
		java.text.SimpleDateFormat bformat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date beginDate = null;
		java.util.Date endDate = null;

		try {
			beginDate = bformat.parse(beginDateStr);
			endDate= format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		time=(endDate.getTime()-beginDate.getTime())/(60*1000);
		//System.out.println("相隔的天数="+day);

		return time;
	}

    /**
     * 得到n天之后的日期（yyyy-MM-dd）
     * @param days （为负则减）
     * @return  返回格式为yyyy-MM-dd
     */
    public static String getAfterDayDate(Integer days) {
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, days); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdfd.format(date);

        return dateStr;
    }

    /**
     * 得到n天之后是周几
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
    	int daysInt = Integer.parseInt(days);
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);
        return dateStr;
    }


    public static String getDataFileName(String time){
		java.text.SimpleDateFormat formatbegin = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
		Date beginDate = null;
		String timeFileName=null;
		try {
			beginDate=formatbegin.parse(time);
			timeFileName=format.format(beginDate);
		}catch (Exception e){
			e.printStackTrace();
		}
		return timeFileName;
	}

	public static String getTimeByMinute(int minute, String time) {
		Date date=null;
    	try {
			date= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
		}catch (Exception e){
			e.printStackTrace();
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minute);

		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

	}
	public static boolean isToday(String time){
		Date date=null;
		try {
			date= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
		}catch (Exception e){
			e.printStackTrace();
		}
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
		if(fmt.format(date).toString().equals(fmt.format(new Date()).toString())){//格式化为相同格式
			return true;
		}else {
			return false;
		}
	}

    /**
     * 获取时间字符串与当前时间的间隔时间（yyyy-MM-dd HH:mm:ss格式）
     * @param dateStr
     * @return
     */
    public static long getNowDiff(String dateStr) {
        long time = 0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date beginDate = null;
        java.util.Date endDate = new Date();

        try {
            beginDate = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        time = (endDate.getTime() - beginDate.getTime()) / (60*1000);

        return time;
    }

    /**
     * 得到n天之前的日期
     * @param days
     * @return
     */
    public static String getBeforeDayDay(String days) {
        int daysInt = Integer.parseInt("-" + days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdfd.format(date);

        return dateStr;
    }

    public static void main(String[] args) {
//    	System.out.println(getDays());
//    	System.out.println(getAfterDayWeek("3"));
//    	String time="2018-06-06 12:12:12";
//		System.out.println(getDataFileName(time));

//        System.out.println(getBeforeDayDay("1"));
    }

}
