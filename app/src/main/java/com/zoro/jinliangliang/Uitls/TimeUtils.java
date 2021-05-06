package com.zoro.jinliangliang.Uitls;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by lzw on 2016/11/19.
 * 根据时间戳返回现实的额时间内容
 */

public class TimeUtils {

    private static TimeUtils instance;
    private static final int YESTERDY = -1;
    private static final int TODAY = 0;
    private static ThreadLocal<SimpleDateFormat> DateLocal = new ThreadLocal<SimpleDateFormat>();

    private TimeUtils() {
    }

    public static TimeUtils getInstance() {
        if (null == instance) {
            instance = new TimeUtils();
        }
        return instance;
    }

    /**
     * 根据时间显示内容
     *
     * @param time
     */
    public String getTime(String time) {
        try {
            return getFormatTime(time);
        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断是否为昨天(效率比较高)
     *
     * @param day 传入的 时间  "2016-06-28 10:10:30" "2016-06-28" 都可以
     * @return true昨天 false不是
     */
    public boolean IsYesterday(String day) throws ParseException {
        Calendar pre = Calendar.getInstance();
        Date predate = new Date(System.currentTimeMillis());
        pre.setTime(predate);
        Calendar cal = Calendar.getInstance();
        Date date = getDateFormat().parse(day);
        cal.setTime(date);
        if (cal.get(Calendar.YEAR) == (pre.get(Calendar.YEAR))) {
            int diffDay = cal.get(Calendar.DAY_OF_YEAR) - pre.get(Calendar.DAY_OF_YEAR);
            if (diffDay == YESTERDY) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否为今天(效率比较高)
     *
     * @param day 传入的 时间  "2016-06-28 10:10:30" "2016-06-28" 都可以
     * @return true今天 false不是
     */
    public boolean IsToday(String day) throws ParseException {
        Calendar pre = Calendar.getInstance();
        Date predate = new Date(System.currentTimeMillis());
        pre.setTime(predate);
        Calendar cal = Calendar.getInstance();
        Date date = getDateFormat().parse(day);
        cal.setTime(date);
        if (cal.get(Calendar.YEAR) == (pre.get(Calendar.YEAR))) {
            int diffDay = cal.get(Calendar.DAY_OF_YEAR) - pre.get(Calendar.DAY_OF_YEAR);
            if (diffDay == TODAY) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据时间显示内容
     *
     * @param time
     */
    public String getDate(String time) {
        try {
            if (IsToday(getFormatYear(time))) {
                return "今天";
            } else if (IsYesterday(getFormatYear(time))) {
                return "昨天";
            } else {
                return getFormatDate(time);
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取日期的格式
     */
    public SimpleDateFormat getDateFormat() {
        if (null == DateLocal.get()) {
            DateLocal.set(new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA));
        }
        return DateLocal.get();
    }

    /**
     * 时间戳转换为String
     *
     * @param time
     */
    private String getFormatYear(String time) {
        if (null != time && time.length() > 0) {
            String timeString = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            long l = Long.valueOf(time);
            timeString = sdf.format(new Date(l));//单位秒
            return timeString;
        } else {
            return "";
        }
    }

    /**
     * 时间戳转换为String
     *
     * @param time
     */
    public String getFormatYearTime(String time) {
        if (null != time && time.length() > 0) {
            String timeString = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            long l = Long.valueOf(time);
            timeString = sdf.format(new Date(l));//单位秒
            return timeString;
        } else {
            return "";
        }
    }


    /**
     * 时间戳转换为String
     *
     * @param time
     */
    private String getFormatDate(String time) {
        if (null != time && time.length() > 0) {
            String timeString = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            long l = Long.valueOf(time);
            timeString = sdf.format(new Date(l));//单位秒
            return timeString;
        } else {
            return "";
        }
    }

    /**
     * 时间戳转换为String
     *
     * @param time
     */
    private String getFormatTime(String time) {
        if (null != time && time.length() > 0) {
            String timeString = null;
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            long l = Long.valueOf(time);
            timeString = sdf.format(new Date(l));//单位秒
            return timeString;
        } else {
            return "";
        }
    }
}
