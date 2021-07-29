package hutool;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Editor;
import cn.hutool.core.lang.WeightRandom;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.math.MathUtil;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.EnumUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import entity.A;
import entity.B;
import entity.HisPrescriptionDemoVo;
import entity.PrescribingInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
        long[] b = {1, 2, 3, 4, 5};
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
        String[] b = {"1", "2", "3", "2147483647"};
        Integer[] intArray = Convert.toIntArray(b);
        long[] c = {1, 2, 3, 4, 5};
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
        String today = DateUtil.today();
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
        DateTime yesterday = DateUtil.yesterday();
        Console.log(yesterday);
        String formatYesterday = DateUtil.format(DateUtil.yesterday(), DatePattern.NORM_DATE_PATTERN);
        Console.log(formatYesterday);
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
        int[] c = {1, 2};
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
        Integer[] a = {1, 2, 3, 4, 5, 6};
        Integer[] filter = ArrayUtil.filter(a, new Editor<Integer>() {

            @Override
            public Integer edit(Integer t) {
                return (t % 2 == 0) ? t : null;
            }

        });
        Assert.assertArrayEquals(filter, new Integer[]{2, 4, 6});
        Console.log(filter);
    }

    @ApiOperation("判断对象是否为数组 & 转为字符串")
    @Test
    public void test22() {
        // ArrayUtil.toString 通常原始类型的数组输出为字符串时无法正常显示，
        // 于是封装此方法可以完美兼容原始类型数组和包装类型数组的转为字符串操作
        Integer[] a = {1, 2, 3, 4, 5, 6};
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

    /**********  数字工具-NumberUtil  **********************************************************************/
    @ApiOperation("加减乘除——针对double类型做加减乘除")
    @Test
    public void test24() {
        // 以上四种运算都会将double转为BigDecimal后计算，
        // 解决float和double类型无法进行精确计算的问题。
        // 这些方法常用于商业计算。
        double d1 = 8989.02;
        float d2 = (float) 8989.2;
        double add = NumberUtil.add(d1, d2);
        double sub = NumberUtil.sub(d1, d2);
        double mul = NumberUtil.mul(d1, d2);
        double div = NumberUtil.div(d1, d2);
        Console.log(add);
        Console.log(sub);
        Console.log(mul);
        Console.log(div);
    }

    @ApiOperation("保留小数")
    @Test
    public void test25() {
        // NumberUtil.round 方法主要封装BigDecimal中的方法来保留小数，
        // 返回double，这个方法更加灵活，可以选择四舍五入或者全部舍弃等模式。
        double te1 = 123456.123456;
        double te2 = 123456.128456;
        BigDecimal bigDecimal1 = NumberUtil.round(te1, 4);
        BigDecimal bigDecimal2 = NumberUtil.round(te2, 4);
        Console.log(bigDecimal1);
        Console.log(bigDecimal2);
        String s = NumberUtil.roundStr(te1, 2);
        String s1 = NumberUtil.roundStr(te2, 2);
        Console.log(s);
        Console.log(s1);
    }

    @ApiOperation("double或long类型的数字做格式化操作")
    @Test
    public void test26() {
        // NumberUtil.round 方法主要封装BigDecimal中的方法来保留小数，
        // 返回double，这个方法更加灵活，可以选择四舍五入或者全部舍弃等模式。
        double te1 = 123456.123456;
        double te2 = 123456.128456;
        BigDecimal bigDecimal1 = NumberUtil.round(te1, 4);
        BigDecimal bigDecimal2 = NumberUtil.round(te2, 4);
        Console.log(bigDecimal1);
        Console.log(bigDecimal2);
        String s = NumberUtil.roundStr(te1, 2);
        String s1 = NumberUtil.roundStr(te2, 2);
        Console.log(s);
        Console.log(s1);
    }

    @ApiOperation("double或long类型的数字做格式化操作")
    @Test
    public void test27() {
        long c = 299792458;//光速
        String formatStr = NumberUtil.decimalFormat(",###", c);
        Console.log(formatStr);
        // 格式中主要以 # 和 0 两种占位符号来指定数字长度。0 表示如果位数不足则以 0 填充，# 表示只要有可能就把数字拉上这个位置。
        // 0 -> 取一位整数
        // 0.00 -> 取一位整数和两位小数
        // 00.000 -> 取两位整数和三位小数
        // # -> 取所有整数部分
        // #.##% -> 以百分比方式计数，并取两位小数
        // #.#####E0 -> 显示为科学计数法，并取五位小数
        // ,### -> 每三位以逗号进行分隔，例如：299,792,458
        // 光速大小为每秒,###米 -> 将格式嵌入文本
        DecimalFormat df1 = new DecimalFormat("0.0");
        DecimalFormat df2 = new DecimalFormat("#.#");
        DecimalFormat df3 = new DecimalFormat("000.000");
        DecimalFormat df4 = new DecimalFormat("###.###");
        System.out.println(df1.format(12.34));
        System.out.println(df2.format(12.34));
        System.out.println(df3.format(12.34));
        System.out.println(df4.format(12.34));
        DecimalFormat format = new DecimalFormat("###,####.000");
        System.out.println(format.format(111111123456.1227222));
        Locale.setDefault(Locale.US);
        DecimalFormat usFormat = new DecimalFormat("###,###.000");
        System.out.println(usFormat.format(111111123456.1227222));
        DecimalFormat addPattenFormat = new DecimalFormat();
        addPattenFormat.applyPattern("##,###.000");
        System.out.println(addPattenFormat.format(111111123456.1227));
        DecimalFormat zhiFormat = new DecimalFormat();
        zhiFormat.applyPattern("0.000E0000");
        System.out.println(zhiFormat.format(10000));
        System.out.println(zhiFormat.format(12345678.345));
        DecimalFormat percentFormat = new DecimalFormat();
        percentFormat.applyPattern("#0.000%");
        System.out.println(percentFormat.format(0.3052222));
    }

    @ApiOperation("随机数")
    @Test
    public void test28() {
        // 生成不重复随机数 根据给定的最小数字和最大数字，以及随机数的个数，产生指定的不重复的数组。
        int[] ints = NumberUtil.generateRandomNumber(1, 100, 6);
        Integer[] integers = NumberUtil.generateBySet(1, 100, 6);
        Console.log(ints);
        Console.log(integers);
    }

    @ApiOperation("方法根据范围和步进，生成一个有序整数列表")
    @Test
    public void test29() {
        // 方法根据范围和步进，生成一个有序整数列表。
        int[] range = NumberUtil.range(10, 100, 6);
        Console.log(range);
        // 阶乘
        long factorial = NumberUtil.factorial(3);
        // 平方根
        long sqrt = NumberUtil.sqrt(4);
        Console.log(factorial);
        Console.log(sqrt);
        //NumberUtil.divisor 最大公约数
        //NumberUtil.multiple 最小公倍数
        //NumberUtil.getBinaryStr 获得数字对应的二进制字符串
        //NumberUtil.binaryToInt 二进制转int
        //NumberUtil.binaryToLong 二进制转long
        //NumberUtil.compare 比较两个值的大小
        //NumberUtil.toStr 数字转字符串，自动并去除尾小数点儿后多余的0
    }

    /**********  网络工具-NetUtil  **********************************************************************/

    @ApiOperation("方法根据范围和步进，生成一个有序整数列表")
    @Test
    public void test30() {

        //isInner 指定IP的long是否在指定范围内
        String ip = "127.0.0.1";
        long iplong = 2130706433L;
        //根据long值获取ip v4地址
        String ip1 = NetUtil.longToIpv4(iplong);
        //根据ip地址计算出long型的数据
        long ip2 = NetUtil.ipv4ToLong(ip);
        //检测本地端口可用性
        boolean result = NetUtil.isUsableLocalPort(6379);
        //是否为有效的端口
        boolean result2 = NetUtil.isValidPort(6379);
        //hideIpPart 隐藏掉IP地址的最后一部分为 * 代替
        String result3 = NetUtil.hideIpPart(ip);
        //isInnerIP 判定是否为内网IP
        boolean innerIP = NetUtil.isInnerIP("10.5.163.154");
        //localIpv4s 获得本机的IP地址列表
        LinkedHashSet<String> localIpv4s = NetUtil.localIpv4s();
        //toAbsoluteUrl 相对URL转换为绝对URL
        String absoluteUrl = NetUtil.toAbsoluteUrl("http://www.baidu.com/image", "/baobao.gif");
        //getIpByHost 通过域名得到IP
        String ipByHost = NetUtil.getIpByHost("www.bbsmax.com");
        Console.log(ip1);
        Console.log(ip2);
        Console.log(result);
        Console.log(result2);
        Console.log(result3);
        Console.log(innerIP);
        Console.log(localIpv4s);
        Console.log(absoluteUrl);
        Console.log(ipByHost);
    }

    /**********  随机工具-RandomUtil **********************************************************************/

    @ApiOperation("随机工具")
    @Test
    public void test31() {
        // 获得指定范围内的随机数
        int i = RandomUtil.randomInt(1, 66);
        // 随机bytes
        byte[] bytes = RandomUtil.randomBytes(6);
        // 随机获得列表中的元素
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("PHP");
        languages.add("Python");
        String randomEle = RandomUtil.randomEle(languages);
        // 随机获得列表中的一定量的不重复元素，返回Set
        Set<String> strings = RandomUtil.randomEleSet(languages, 2);
        // 获得一个随机的字符串（只包含数字和字符）
        String ok = RandomUtil.randomString("ok", 6);
        // 获得一个只包含数字的字符串
        String s = RandomUtil.randomNumbers(6);
        Console.log(i);
        Console.log(bytes);
        Console.log(randomEle);
        Console.log(strings);
        Console.log(ok);
        Console.log(s);
    }

    @ApiOperation("权重随机生成器，传入带权重的对象，然后根据权重随机获取对象")
    @Test
    public void test32() {
        List<WeightRandom.WeightObj<String>> weightList = new ArrayList<WeightRandom.WeightObj<String>>();
        WeightRandom.WeightObj<String> a = new WeightRandom.WeightObj<String>("A", 1);
        WeightRandom.WeightObj<String> b = new WeightRandom.WeightObj<String>("B", 2);
        WeightRandom.WeightObj<String> c = new WeightRandom.WeightObj<String>("C", 3);
        WeightRandom.WeightObj<String> d = new WeightRandom.WeightObj<String>("D", 4);
        weightList.add(a);
        weightList.add(b);
        weightList.add(c);
        weightList.add(d);
        WeightRandom wr = RandomUtil.weightRandom(weightList);
        String str = "";
        int num_a = 0, num_b = 0, num_c = 0, num_d = 0;
        for (int i = 0; i < 100000; i++) {
            str = wr.next().toString();
            switch (str) {
                case "A":
                    num_a = num_a + 1;
                    break;
                case "B":
                    num_b = num_b + 1;
                    break;
                case "C":
                    num_c = num_c + 1;
                    break;
                case "D":
                    num_d = num_d + 1;
                    break;
            }
            //System.out.println(str);
        }
        System.out.println("A---------" + num_a);
        System.out.println("B---------" + num_b);
        System.out.println("C---------" + num_c);
        System.out.println("D---------" + num_d);
    }

    /**********  对象工具-ObjectUtil **********************************************************************/

    @ApiOperation("比较两个对象是否相等")
    @Test
    public void test33() {
        // 比较两个对象是否相等，相等需满足以下条件之一：
        // obj1 == null && obj2 == null
        // obj1.equals(obj2)
        Object o1 = null;
        Object o2 = 1;
        Object o3 = null;
        boolean equal = ObjectUtil.equal(o1, o2);
        boolean equal2 = ObjectUtil.equal(o1, o3);
        Console.log(equal);
        Console.log(equal2);
    }

    /**********  字符串工具-StrUtil **********************************************************************/
    @ApiOperation("hasBlank、hasEmpty方法")
    @Test
    public void test34() {
        // 这两个方法的区别是hasEmpty只判断是否为null或者空字符串（""），
        // hasBlank则会把不可见字符也算做空，isEmpty和isBlank同理。
        Console.log(StrUtil.isBlank(""));
        Console.log(StrUtil.isBlank(" "));
        Console.log(StrUtil.isEmpty(""));
        Console.log(StrUtil.isEmpty(" "));
        Console.log(StrUtil.hasBlank(" "));
        Console.log(StrUtil.hasEmpty(" "));
    }

    @ApiOperation("hasBlank、hasEmpty方法")
    @Test
    public void test35() {
        // 这两个方法的区别是hasEmpty只判断是否为null或者空字符串（""），
        // hasBlank则会把不可见字符也算做空，isEmpty和isBlank同理。
        StringUtils.isBlank("");
    }

    @ApiOperation("去掉字符串的前缀后缀")
    @Test
    public void test36() {
        // removePrefix、removeSuffix去掉字符串的前缀后缀
        String fileName = StrUtil.removeSuffix("pretty_girl.jpg", ".jpg");
        String fileName1 = StrUtil.removeSuffix("pretty_girl.jpg", ".JPG");
        String fileName2 = StrUtil.removeSuffix("pretty_girl.JPG", ".jpg");
        Console.log(fileName);
        Console.log(fileName1);
        Console.log(fileName2);
        // 忽略大小写的removePrefixIgnoreCase和removeSuffixIgnoreCase
        String s = StrUtil.removeSuffixIgnoreCase("pretty_girl.jpg", ".JPG");
        String s1 = StrUtil.removeSuffixIgnoreCase("pretty_girl.JPG", ".jpg");
        Console.log(s);
        Console.log(s1);
    }

    @ApiOperation("format方法")
    @Test
    public void test37() {
        String template = "{}爱{}，就像老鼠爱大米";
        String str = StrUtil.format(template, 1, "你");
        Console.log(str);
    }

    /**********  枚举工具-EnumUtil **********************************************************************/
    @ApiOperation("获取枚举类中所有枚举对象的name列表")
    @Test
    public void test38() {
        List<String> names = EnumUtil.getNames(TestEnum.class);
        Console.log(names);
    }

    @ApiOperation("枚举类中各枚举对象下指定字段的值")
    @Test
    public void test39() {
        List<Object> types = EnumUtil.getFieldValues(TestEnum.class, "type");
        Console.log(types);
    }

    @ApiOperation("获取枚举字符串值和枚举对象的Map对应")
    @Test
    public void test40() {
        Map<String, Object> enumMap = EnumUtil.getNameFieldMap(TestEnum.class, "type");
        Console.log(enumMap);
        Console.log(enumMap.get("TEST1"));
    }

    /**********  Bean工具-BeanUtil **********************************************************************/
    @ApiOperation("是否为Bean对象")
    @Test
    public void test41() {
        // 通常Java中对Bean的定义是包含setXXX和getXXX方法的对象，
        // 在Hutool中，采取一种简单的判定Bean的方法：是否存在只有一个参数的setXXX方法。
        boolean isBean = BeanUtil.isBean(HashMap.class);
        Console.log(isBean);
        boolean isBean2 = BeanUtil.isBean(TestEnum.class);
        Console.log(isBean2);
        boolean isBean3 = BeanUtil.isBean(A.class);
        Console.log(isBean3);
    }

    @ApiOperation("内省")
    @Test
    public void test42() {
        // 把一类中需要进行设置和获得的属性访问权限设置为private（私有的）
        // 让外部的使用者看不见摸不着，而通过public（共有的）set和get方法来
        // 对其属性的值来进行设置和获得，而内部的操作具体是怎样的？外界使用的人不用不知道，这就称为内省。
        // 获得Bean字段描述数组
        PropertyDescriptor[] propertyDescriptors_B = BeanUtil.getPropertyDescriptors(B.class);
        // 获得字段名和字段描述Map
        Map<String, PropertyDescriptor> propertyDescriptorMap = BeanUtil.getPropertyDescriptorMap(B.class, true);
        //获得Bean类指定属性描述
        PropertyDescriptor age = BeanUtil.getPropertyDescriptor(B.class, "age");
        Console.log(propertyDescriptors_B);
        Console.log("######################################");
        Console.log(propertyDescriptorMap);
        Console.log("######################################");
        Console.log(age);
    }

    @ApiOperation("Bean转为Map")
    @Test
    public void test43() {
        // 将一个Bean对象转为Map对象。
        Map<String, Object> map = BeanUtil.beanToMap(B.class);
        Console.log(map);
    }

    @ApiOperation("Bean转Bean")
    @Test
    public void test44() {
        // Bean之间的转换主要是相同属性的复制
        PrescribingInfo prescribingInfo = new PrescribingInfo();
        prescribingInfo.setAge("6");
        prescribingInfo.setId("6666");
        HisPrescriptionDemoVo hisPrescriptionDemoVo = BeanUtil.copyProperties(prescribingInfo, HisPrescriptionDemoVo.class);
        Console.log(hisPrescriptionDemoVo);
    }

    /**********  集合工具 CollUtil **********************************************************************/

    @ApiOperation("join 方法")
    @Test
    public void test45() {
        String[] col = new String[]{"a", "b", "c", "d", "e"};
        List<String> colList = CollUtil.newArrayList(col);
        String str = CollUtil.join(colList, "#");
        Console.log(str);
    }

    /**********  数学相关-MathUtil **********************************************************************/


    @ApiOperation("排列/组合")
    @Test
    public void test46() {
        // 排列
        // 计算排列数
        long count = MathUtil.arrangementCount(3);
        String[] strs = {"1", "2", "3", "4", "5"};
        // 排列选择（从列表中选择n个排列）
        List<String[]> strings = MathUtil.arrangementSelect(strs, 2);
        // 组合
        // 计算组合数，即C(n, m) = n!/((n-m)! * m!)
        long count1 = MathUtil.combinationCount(3, 6);
        //  组合选择（从列表中选择n个组合）
        List<String[]> strings1 = MathUtil.combinationSelect(strs, 2);
        Console.log(count);
        Console.log(strings);
        Console.log(count1);
        Console.log(strings1);
    }

    /**********  Hutool-json **********************************************************************/

    @ApiOperation("创建")
    @Test
    public void test47() {
        JSONObject obj = JSONUtil.createObj();
        obj.append("a", "value1");
        obj.append("b", "value2");
        obj.append("c", "value3");
        String s = obj.toString();
        Console.log(obj);
        Console.log(s);
    }

    @ApiOperation("对象转json字符串")
    @Test
    public void test412() {
        A a = new A("11");
        String s = JSONUtil.toJsonStr(a);
        Console.log(s);
    }

    /**********  http客户端(Hutool-http) **********************************************************************/
    @ApiOperation("get请求")
    @Test
    public void test48() {
        // 最简单的HTTP请求，可以自动通过header等信息判断编码，不区分HTTP和HTTPS
        String result1= HttpUtil.get("https://www.baidu.com");
        // 当无法识别页面编码的时候，可以自定义请求页面的编码
        String result2= HttpUtil.get("https://www.baidu.com", Charset.forName("UTF-8"));
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");
        String result3= HttpUtil.get("https://www.baidu.com", paramMap);
        Console.log(result1);
        Console.log(result2);
        Console.log(result3);
    }

    @ApiOperation("post请求")
    @Test
    public void test49() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");
        String result= HttpUtil.post("https://www.baidu.com", paramMap);
        //文件上传只需将参数中的键指定（默认file），值设为文件对象即可，对于使用者来说，文件上传与普通表单提交并无区别
        paramMap.put("file", FileUtil.file("D:\\face.jpg"));
        String result1= HttpUtil.post("https://www.baidu.com", paramMap);
    }

    @ApiOperation("获取某月的开始时间/获取某月的结束时间")
    @Test
    public void test50() {
        String dateStr1 = "2021-02";
        Date date1 = DateUtil.parse(dateStr1, DatePattern.NORM_MONTH_PATTERN);
        Console.log("年月：{}",DateUtil.format(date1, DatePattern.NORM_MONTH_PATTERN));
        DateTime dateTime = DateUtil.beginOfMonth(date1);
        Console.log("月开始：{}",DateUtil.format(dateTime, DatePattern.NORM_DATETIME_PATTERN));
        DateTime dateTime1 = DateUtil.endOfMonth(date1);
        Console.log("月结束：{}",DateUtil.format(dateTime1, DatePattern.NORM_DATETIME_PATTERN));
    }

    @ApiOperation("查找指定字符串是否包含指定字符串列表中的任意一个字符串")
    @Test
    public void test51() {
        boolean hasContains = StrUtil.containsAny("20月", "岁", "月", "天");
        System.out.println(hasContains);
        String s = " 1";
        System.out.println(StrUtil.isNotBlank(s));
        Integer i =  2147483647;
        int totalCount = 0;
        int size = 10;
        int k = totalCount%10==0 ? (totalCount / size):(totalCount / size + 1);
        System.out.println(k);
    }

    @ApiOperation("查找指定字符串是否包含指定字符串列表中的任意一个字符串")
    @Test
    public void test52() {
        try {
            System.out.println("[]" + DESUtil.encrypt("fpva1234","18989772057,zyzl123456,9C-5C-8E-6F-C9-89"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("map操作")
    @Test
    public void test53() {
        Map<Object, Object> map = MapUtil.builder()
                .put("id", 1)
                .put("username", 1)
                .put("avatar", 1)
                .put("email", 1)
                .map();
        Console.log(map);
    }

    @ApiOperation("ArrayUtil")
    @Test
    public void test54() {
        String [] s ={"GEELY", "CHANGAN","BMW"};
        boolean bmw = ArrayUtil.contains(s, "BMW");
        Console.log(bmw);
    }

    @ApiOperation("获取日期字符")
    @Test
    public void test55() {
        Date date = new Date();
        String format = DateUtil.format(date, DatePattern.PURE_DATE_FORMAT);
        Console.log(format);
    }

    @ApiOperation("时间")
    @Test
    public void test56() {
        TimeInterval timer = DateUtil.timer();
        // 模拟对应的执行过程
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(timer.interval());
    }

    @ApiOperation("正则表达式")
    @Test
    public void test57() {
        String content = "632123198209270517";
        Console.log(content.length());

        // 身份证号
//        String regex = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";
        String regex_18 = "^([1-6][1-9]|50)\\d{4}(18|19|20)\\d{2}((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        String regex_15 = "^([1-6][1-9]|50)\\d{4}\\d{2}((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)\\d{3}$";
        boolean isMatch_18 = ReUtil.isMatch(regex_18, "632123198209270517");
        boolean isMatch_15 = ReUtil.isMatch(regex_15, "632123820927051");
        Console.log(isMatch_18);
        Console.log(isMatch_15);
    }

//    private boolean isValid(String cardNo) {
//        String regex = null;
//        if (cardNo.length() != 18 && cardNo.length() != 15) {
//            return false;
//        }
//        if (cardNo.length() == 18) {
//            regex = CheckCodeConstants.CARD_NO_18_REGEX;
//        }
//        if (cardNo.length() == 15) {
//            regex = CheckCodeConstants.CARD_NO_15_REGEX;
//        }
//        return ReUtil.isMatch(regex, cardNo);
//    }


}
