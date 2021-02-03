package hutool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.BetweenFormater;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Editor;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.json.JSONUtil;
import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.alibaba.fastjson.JSONObject;
import com.feng.consumer.util.SpringContextUtil;
import entity.A;
import entity.HisPrescriptionDemoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Feng, Ge 2020-10-20 17:28
 */
@SpringBootTest
public class HuToolTest {

    @ApiOperation("转换为字符串")
    @Test
    public void test1() {
        // 有了这个以后再也不用循环打印数组或者list了
        int a = 1;
        String aStr = Convert.toStr(a);
        long[] b = {1,2,3,4,5};
        String bStr = Convert.toStr(b);
        System.out.println(aStr);
        System.out.println(bStr);
        System.out.println(String.valueOf(a));
        System.out.println(b.toString());
    }

    @ApiOperation("转换为指定类型数组")
    @Test
    public void test2() {
        // Integer类取值和 int 类型取值一致,取值范围是从-2147483648 至 2147483647
        // 包括-2147483648 和 2147483647
        String[] b = { "1", "2", "3", "2147483647" };
        Integer[] intArray = Convert.toIntArray(b);
        long[] c = {1,2,3,4,5};
        Integer[] intArray2 = Convert.toIntArray(c);
        System.out.println(Convert.toStr(intArray));
        System.out.println(Convert.toStr(intArray2));
    }

    @ApiOperation("转换为日期对象")
    @Test
    public void test3() {
        String a = "2021-05-06";
        Date value = Convert.toDate(a);
        System.out.println(a);
        System.out.println(value);
    }

    @ApiOperation("转换为集合")
    @Test
    public void test4() {
        Object[] a = {"a", "你", "好", "", 1};
        List<?> list = Convert.convert(List.class, a);
        //从4.1.11开始可以这么用
        List<?> list2 = Convert.toList(a);
        System.out.println(Convert.toStr(list));
        System.out.println(Convert.toStr(list2));
    }

    @ApiOperation("时间单位转换")
    @Test
    public void test5() {
        // Convert.convertTime方法主要用于转换时长单位，
        // 比如一个很大的毫秒，我想获得这个毫秒数对应多少分
        long a = 4535345;
        long minutes = Convert.convertTime(a, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);
        System.out.println(minutes);
    }

    @ApiOperation("金额大小写转换")
    @Test
    public void test6() {
        // 转换为大写只能精确到分（小数点儿后两位,四舍五入），之后的数字会被忽略。
        double a = 675126.369;
        String digitUppercase = Convert.digitToChinese(a);
        System.out.println(digitUppercase);
    }

    @ApiOperation("Date、long、Calendar之间的相互转换")
    @Test
    public void test7() {
        //当前时间
        DateTime date = DateUtil.date();
        //当前时间
        DateTime date2 = DateUtil.date(Calendar.getInstance());
        //当前时间
        DateTime date3 = DateUtil.date(System.currentTimeMillis());
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        //当前日期字符串，格式：yyyy-MM-dd
        String today= DateUtil.today();
        System.out.println(date);
        System.out.println(date2);
        System.out.println(date3);
        System.out.println(now);
        System.out.println(today);
    }

    @ApiOperation("字符串转日期")
    @Test
    public void test8() {
        String dateStr = "2021-03-01";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);
        String dateStr2 = "2021-03-01 00:09:09";
        Date date2 = DateUtil.parse(dateStr2, DatePattern.NORM_DATETIME_FORMAT);
        System.out.println(date2);
        String dateStr3 = "2021-03-01 00:09:09";
        Date date3 = DateUtil.parse(dateStr3);
        System.out.println(date3);
    }

    @ApiOperation("获取Date对象的某个部分")
    @Test
    public void test9() {
        Date date = DateUtil.date();
        //获得年的部分
        int year = DateUtil.year(date);
        //获得月份，从0开始计数
        int month = DateUtil.month(date);
        //获得月份枚举
        Month monthEnum = DateUtil.monthEnum(date);
        System.out.println(date);
        System.out.println(year);
        System.out.println(month);
        System.out.println(monthEnum);
    }

    @ApiOperation("开始和结束时间")
    @Test
    public void test10() {
        String dateStr = "2021-03-01 22:33:23";
        Date date = DateUtil.parse(dateStr);
        //一天的开始，结果：2021-03-01 00:00:00
        Date beginOfDay = DateUtil.beginOfDay(date);
        //一天的结束，结果：2021-03-01 23:59:59
        Date endOfDay = DateUtil.endOfDay(date);
        System.out.println(beginOfDay);
        System.out.println(endOfDay);
    }

    @ApiOperation("日期时间偏移")
    @Test
    public void test11() {
        // 日期或时间的偏移指针对某个日期增加或减少分、小时、天等等，达到日期变更的目的
        String dateStr = "2021-03-01 22:33:23";
        Date date = DateUtil.parse(dateStr);
        //结果：2021-03-03 22:33:23
        Date newDate = DateUtil.offset(date, DateField.DAY_OF_MONTH, 2);
        //常用偏移，结果：2021-03-04 22:33:23
        DateTime newDate2 = DateUtil.offsetDay(date, 3);
        //常用偏移，结果：2021-03-01 19:33:23(负数按小时算)
        DateTime newDate3 = DateUtil.offsetHour(date, -2);
        System.out.println(newDate);
        System.out.println(newDate2);
        System.out.println(newDate3);
    }

    @ApiOperation("日期时间偏移——针对当前时间，提供了简化的偏移方法")
    @Test
    public void test12() {
        //昨天
        DateTime yesterday = DateUtil.yesterday();
        //明天
        DateTime tomorrow = DateUtil.tomorrow();
        //上周
        DateTime lastWeek = DateUtil.lastWeek();
        //下周
        DateTime nextWeek = DateUtil.nextWeek();
        //上个月
        DateTime lastMonth = DateUtil.lastMonth();
        //下个月
        DateTime nextMonth = DateUtil.nextMonth();
        System.out.println(yesterday);
        System.out.println(tomorrow);
        System.out.println(lastWeek);
        System.out.println(nextWeek);
        System.out.println(lastMonth);
        System.out.println(nextMonth);
    }

    @ApiOperation("日期时间差")
    @Test
    public void test13() {
        String dateStr1 = "2019-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);
        String dateStr2 = "2019-04-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr2);
        //相差一个月，31天
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        long betweenMS = DateUtil.between(date1, date2, DateUnit.MS);
        System.out.println(betweenDay);
        System.out.println(betweenMS);
        // 有时候我们希望看到易读的时间差，比如XX天XX小时XX分XX秒，此时使用DateUtil.formatBetween
        String formatBetween = DateUtil.formatBetween(betweenMS);
        Console.log(formatBetween);
    }

    @ApiOperation("计时器")
    @Test
    public void test14() {
        TimeInterval timer = DateUtil.timer();
        //--------start-------------------------
        //-------这是执行过程
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //--------end-------------------------

        // 花费毫秒数
        long interval = timer.interval();
        Console.log("花费毫秒数:" + interval);
        // 返回花费时间，并重置开始时间
//        long intervalRestart = timer.intervalRestart();
//        Console.log(intervalRestart);
        // 花费分钟数
        long intervalMinute = timer.intervalMinute();
        long intervalSecond = timer.intervalSecond();
        long intervalMs = timer.intervalMs();
        Console.log("分钟：" + intervalMinute);
        Console.log("秒：" + intervalSecond);
        Console.log("毫秒：" + intervalMs);
    }

    @ApiOperation("年龄 & 是否闰年")
    @Test
    public void test15() {
        //年龄
        int ageOfNow = DateUtil.ageOfNow("1990-05-20");
        //是否闰年
        boolean leapYear = DateUtil.isLeapYear(2021);
        Console.log("年龄：" + ageOfNow);
        Console.log("是否闰年：" + leapYear);
    }

    @ApiOperation("DateTime对象")
    @Test
    public void test16() {
        DateTime dateTime = new DateTime("2021-01-05 12:34:23", DatePattern.NORM_DATETIME_FORMAT);
        int year = dateTime.year();
        //月份，结果：Month.JANUARY
        Month month = dateTime.monthEnum();
        //日，结果：5
        int day = dateTime.dayOfMonth();
        Console.log(year);
        Console.log(day);
    }

    /**********  ArrayUtil  **********************************************************************/

    @ApiOperation("判断空")
    @Test
    public void test17() {
        // 数组的判空类似于字符串的判空，标准是null或者数组长度为0，
        // ArrayUtil中封装了针对原始类型和泛型数组的判空和判非空
        int[] a = {};
        int[] b = null;
        boolean empty = ArrayUtil.isEmpty(a);
        boolean empty1 = ArrayUtil.isEmpty(b);
        Console.log(empty);
        Console.log(empty1);
        int[] c = {1,2};
        boolean empty2 = ArrayUtil.isNotEmpty(c);
        Console.log(empty2);
        boolean empty3 = ArrayUtil.isNotEmpty(b);
        Console.log(empty3);
    }

    @ApiOperation("新建泛型数组 & 重置数组大小 & 合并数组")
    @Test
    public void test19() {
        String[] newArray = ArrayUtil.newArray(String.class, 3);
        newArray[1] = "hihi";
        Console.log(newArray);
        String[] resizeArr = ArrayUtil.resize(newArray, 6);
        Console.log(resizeArr);
        String[] allArr = ArrayUtil.addAll(newArray, resizeArr);
        Console.log(allArr);
    }

    @ApiOperation("新建泛型数组 & 重置数组大小 & 合并数组")
    @Test
    public void test20() {
        String[] newArray = ArrayUtil.newArray(String.class, 3);
        newArray[1] = "hihi";
        Console.log(newArray);
        String[] resizeArr = ArrayUtil.resize(newArray, 6);
        Console.log(resizeArr);
        String[] allArr = ArrayUtil.addAll(newArray, resizeArr);
        Console.log(allArr);
    }

    @ApiOperation("过滤")
    @Test
    public void test21() {
        Integer[] a = {1,2,3,4,5,6};
        Integer[] filter = ArrayUtil.filter(a, new Editor<Integer>(){
            @Override
            public Integer edit(Integer t) {
                return (t % 2 == 0) ? t : null;
            }});
        Assert.assertArrayEquals(filter, new Integer[]{2,4,6});
        Console.log(filter);
    }

    @ApiOperation("判断对象是否为数组 & 转为字符串")
    @Test
    public void test22() {
        // ArrayUtil.toString 通常原始类型的数组输出为字符串时无法正常显示，
        // 于是封装此方法可以完美兼容原始类型数组和包装类型数组的转为字符串操作
        Integer[] a = {1,2,3,4,5,6};
        Console.log(a.toString());
        String s = ArrayUtil.toString(a);
        Console.log(s);
        // ArrayUtil.join 方法使用间隔符将一个数组转为字符串，
        // 比如[1,2,3,4]这个数组转为字符串，间隔符使用“-”的话，
        // 结果为 1-2-3-4，join方法同样支持泛型数组和原始类型数组。
        String s1 = ArrayUtil.join(a, "-");
        Console.log(s1);
    }

    /**********  身份证工具-IdcardUtil  **********************************************************************/
    @ApiOperation("过滤")
    @Test
    public void test23() {
        String ID_18 = "342422199205200497";
        String ID_15 = "150102880730303";
        //是否有效
        boolean valid = IdcardUtil.isValidCard(ID_18);
        boolean valid15 = IdcardUtil.isValidCard(ID_15);
        Console.log(valid);
        Console.log(valid15);
        //转换
        String convert15To18 = IdcardUtil.convert15To18(ID_15);
        Assert.assertEquals(convert15To18, "150102198807303035");
        //年龄
        DateTime date = DateUtil.parse("2021-05-20");
        int age = IdcardUtil.getAgeByIdCard(ID_18, date);
        Console.log(age);
        //生日
        String birth = IdcardUtil.getBirthByIdCard(ID_18);
        String birth2 = IdcardUtil.getBirthByIdCard(ID_15);
        //省份
        String province = IdcardUtil.getProvinceByIdCard(ID_18);
        String province2 = IdcardUtil.getProvinceByIdCard(ID_15);
        Console.log(birth);
        Console.log(birth2);
        Console.log(province);
        Console.log(province2);
    }

}
