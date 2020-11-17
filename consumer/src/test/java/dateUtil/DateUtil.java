package dateUtil;

import jdk.internal.dynalink.beans.StaticClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Feng, Ge 2020-11-12 14:21
 */
public class DateUtil {

    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String SHORT_FORMAT = "yyyy-MM-dd";
    public static final String SHORTER_FORMAT = "yyyy-MM";

    /**
     * 获取两个日期之间的月份
     * Feng, Ge
     */
    public static List<String> getMonthBetween(String minDate, String maxDate, String format) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat(format);//格式化为年月
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }

    /**
     * 获取当前时间字符串
     * Feng, Ge
     */
    public static String getNowStr(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        String nowStr = df.format(new Date());
        System.out.println(nowStr);
        return nowStr;
    }

    /**
     * 获取某月的最后一天
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_FORMAT);
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth;
    }

    /**
     * 获取某个日期的年份数值
     */
    public static int getYear(String dateStr, String format) throws ParseException {
        Calendar calendar = processCalendar(dateStr, format);
        int year = calendar.get(Calendar.YEAR);
        return year;
    }

    /**
     * 获取某个日期是一年中的第几天
     */
    public static int getDayOfYear(String dateStr, String format) throws ParseException {
        Calendar calendar = processCalendar(dateStr, format);
        int day = calendar.get(Calendar.DAY_OF_YEAR);
        return day;
    }

    /**
     * 获取某个日期是一年中的第几周
     */
    public static int getWeekOfYear(String dateStr, String format) throws ParseException {
        Calendar calendar = processCalendar(dateStr, format);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        return week;
    }

    /**
     * 获取某个日期是一年中的第几个月
     */
    public static int getMonthOfYear(String dateStr, String format) throws ParseException {
        Calendar calendar = processCalendar(dateStr, format);
        int month = calendar.get(Calendar.MONTH) + 1;
        return month;
    }

    private static Calendar processCalendar(String dateStr, String format) throws ParseException {
        Date date = new SimpleDateFormat(format).parse(dateStr);
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca;
    }

    /**
     * 获取昨天日期字符串
     */
    public static String getYesterdayDate(){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat(SHORT_FORMAT);
        return sp.format(d);
    }




}
