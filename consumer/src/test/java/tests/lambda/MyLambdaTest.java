package tests.lambda;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import entity.B;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Lambda 示例代码
 * Feng, Ge 2020年01月16日14:42:43
 */

/**
 * （1）Intermediate（中间操作）：
 * 一个流可以后面跟随零个或多个 intermediate 操作。
 * 其目的主要是打开流，做出某种程度的数据映射/过滤，然后返回一个新的流，交给下一个操作使用。
 * 这类操作都是惰性化的（lazy），就是说，仅仅调用到这类方法，并没有真正开始流的遍历。
 * map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、
 * limit、 skip、 parallel、 sequential、 unordered
 * <p>
 * （2）Terminal（终止操作）：
 * 一个流只能有一个 terminal 操作，当这个操作执行后，流就被使用“光”了，无法再被操作。
 * 所以这必定是流的最后一个操作。Terminal 操作的执行，才会真正开始流的遍历，并且会生成一个结果，或者一个 side effect。
 * forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator
 * <p>
 * （3）short-circuiting（短路操作）。
 * 用以指：
 * • 对于一个 intermediate 操作，如果它接受的是一个无限流，它可以返回一个有限的新 Stream。
 * • 对于一个 terminal 操作，如果它接受的是一个无限流，但能在有限的时间计算出结果。
 * anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
 * <p>
 * Feng, Ge 2020-10-20 17:28
 */
public class MyLambdaTest {

    @Test
    public void test1() {
        List list = StreamAPI.getStringList();
        Stream distinct = list.stream().distinct();
        System.out.println("【1】:" + distinct);
        Object collect = distinct.collect(Collectors.toList());
        System.out.println("【2】:" + collect);
        long count = list.stream().distinct().count();
        System.out.println("【3】:" + count);
    }

    @Test
    public void test2() {
        List<Integer> intList = StreamAPI.getIntegerList();
        Stream<Integer> stream1 = intList.stream().filter(element -> element > 5);
        stream1.forEach(System.out::println);
        System.out.println("==============================================================");
        List<String> strList = StreamAPI.getStringList();
        Stream<String> stream2 = strList.stream().filter(element -> Integer.valueOf(element).intValue() > 5);
        stream2.forEach(System.out::println);
        System.out.println("==============================================================");
        List<String> list = StreamAPI.getStringList();
        Stream<String> stream = list.stream().filter(element -> !element.contains("8"));
        stream.forEach(System.out::println);

        boolean hasDiagInfo = false;
        if (!org.springframework.util.CollectionUtils.isEmpty(StreamAPI.getBNullList())) {
            List<B> diagnoseInfos = StreamAPI.getBNullList().stream().filter(dia -> StringUtils.isNotEmpty(dia.getName())).collect(Collectors.toList());
            if (diagnoseInfos != null && diagnoseInfos.size() > 0){
                hasDiagInfo = true;
            }
            System.out.println(diagnoseInfos);
            System.out.println(hasDiagInfo);
        }
    }

    @Test
    public void test3() {
        List<String> strList = StreamAPI.getStringList();
        Stream<Integer> stream = strList.stream().map(String::length);
        stream.forEach(System.out::println);
        System.out.println("==============================================================");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> collect = numbers.stream().map(num -> num * 2).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
        System.out.println("==============================================================");
        List<B> bList = StreamAPI.getBList();
        List<String> nameList = bList.stream().map(b -> b.getName()).collect(Collectors.toList());
        nameList.stream().forEach(System.out::println);
    }

    /**
     * anyMatch()，只要有一个元素匹配传入的条件，就返回 true。
     * allMatch()，只有有一个元素不匹配传入的条件，就返回 false；如果全部匹配，则返回 true。
     * noneMatch()，只要有一个元素匹配传入的条件，就返回 false；如果全部匹配，则返回 true。
     */
    @Test
    public void test4() {
        List<B> bList = StreamAPI.getBList();
        boolean anyMatchFlag = bList.stream().anyMatch(element -> element.getName().contains("小"));
        boolean allMatchFlag = bList.stream().allMatch(element -> element.getName().length() > 1);
        boolean noneMatchFlag = bList.stream().noneMatch(element -> element.getName().startsWith("小"));
        System.out.println(anyMatchFlag);
        System.out.println(allMatchFlag);
        System.out.println(noneMatchFlag);
    }

    /**
     * Stream.reduce()合并流的元素并产生单个值。
     */
    @Test
    public void test5() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;
        for (int i : numbers) {
            sum += i  ;
        }
        System.out.println("sum : " + sum); // 55
        System.out.println("==============================================================");
        int sum1 = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
        System.out.println("sum : " + sum1); // 55
        System.out.println("==============================================================");
        int sum2 = Arrays.stream(numbers).reduce(0, Integer::sum);
        System.out.println("sum : " + sum2); // 55
        System.out.println("==============================================================");
        int max = Arrays.stream(numbers).reduce(0, (a, b) -> a > b ? a : b);  // 10
        int max1 = Arrays.stream(numbers).reduce(0, Integer::max);            // 10
        System.out.println("max : " + max);
        System.out.println("max1 : " + max1);
        System.out.println("==============================================================");
        int min = Arrays.stream(numbers).reduce(0, (a, b) -> a < b ? a : b);  // 0
        int min1 = Arrays.stream(numbers).reduce(0, Integer::min);            // 0
        System.out.println("min : " + min);
        System.out.println("min1 : " + min1);
        System.out.println("==============================================================");
        String[] strings = {"a", "b", "c", "d", "e"};
        // |a|b|c|d|e , the initial | join is not what we want
        String reduce = Arrays.stream(strings).reduce("", (a, b) -> a + "|" + b);
        System.out.println("reduce : " + reduce);
        // a|b|c|d|e, filter the initial "" empty string
        String reduce2 = Arrays.stream(strings).reduce("", (a, b) -> {
            if (!"".equals(a)) {
                return a + "|" + b;
            } else {
                return b;
            }
        });
        System.out.println("reduce2 : " + reduce2);
        // a|b|c|d|e , better uses the Java 8 String.join :)  （最好使用 Java 8 的 String.join）
        String join = String.join("|", strings);
        System.out.println("join : " + join);
    }

    /**
     * 根据limit(n)，直接截断流，后续操作不继续，限制其流中元素个数为n，此操作称为短路操作，提高效率时可以考虑短路操作
     */
    @Test
    public void test6() {
        List<B> bList = StreamAPI.getBList();
        bList.stream().filter(b -> b.getAge() > 3).limit(2).forEach(System.out::println);
    }

    /**
     * averagingDouble-求平均值并转换成Double类型，同理还有averagingInt、averagingLong
     */
    @Test
    public void test7() {
        List<B> bList = StreamAPI.getBList();
        Double ageAve = bList.stream().collect(Collectors.averagingDouble(B::getAge));
        System.out.println(ageAve);
    }

    /**
     * summingDouble-求和转换成Double类型，同理还有summingInt、summingLong
     */
    @Test
    public void test8() {
        List<B> bList = StreamAPI.getBList();
        Double ageAve = bList.stream().collect(Collectors.summingDouble(B::getAge));
        System.out.println(ageAve);
    }

    /**
     * maxBy-根据函数条件求最大值 ，minBy-根据函数条件求最小值
     */
    @Test
    public void test9() {
        List<B> bList = StreamAPI.getBList();
        Optional<B> stuOptional = bList.stream().collect(Collectors.maxBy((a, b) -> Double.compare(a.getAge(), b.getAge())));
        System.out.println(stuOptional.get());
    }

    /**
     * groupingBy-分组，支持多级分组
     */
    @Test
    public void test10() {
        List<B> bList = StreamAPI.getBList();
        Map<Integer, List<B>> ageGroup = bList.stream().collect(Collectors.groupingBy(B::getAge));
        Object single = JSONObject.toJSON(ageGroup);
        System.out.println(ageGroup);
        System.out.println(single);
        System.out.println("===================多级分组（先姓名后年龄）====================");
        Map<String, Map<String, List<B>>> groupmap = bList.stream()
                .collect(Collectors.groupingBy(B::getName, Collectors.groupingBy((e) -> {
                    if (e.getAge() <= 20) {
                        return "年轻人";
                    } else if (e.getAge() <= 50) {
                        return "中年人";
                    } else {
                        return "老年人";
                    }
                })));
        System.out.println(groupmap);
        Object mul = JSONObject.toJSON(groupmap);
        System.out.println(mul);
        System.out.println("===================多级分组（先姓名后年龄）====================");
        Map<Integer, Map<String, List<B>>> groupmap1 = bList.stream()
                .collect(Collectors.groupingBy(B::getAge, Collectors.groupingBy(B::getName)));
        System.out.println(groupmap1);
        Object mul1 = JSONObject.toJSON(groupmap1);
        System.out.println(mul1);

        System.out.println("===================Map分组====================");
        List<Map<String, Object>> resultList = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "ok");
        map1.put("age", 6);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "okok");
        map2.put("age", 66);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("name", "okokok");
        map3.put("age", 666);
        Map<String, Object> map4 = new HashMap<>();
        map4.put("name", "ok");
        map4.put("age", 16);
        resultList.add(map1);
        resultList.add(map2);
        resultList.add(map3);
        resultList.add(map4);
        Map<String, List<Map<String, Object>>> result = resultList.stream().collect(Collectors.groupingBy(MyLambdaTest::getGroupKey));
        System.out.println(JSONUtils.toJSONString(result));
    }

    private static String getGroupKey (Map<String, Object> map) {
        return map.get("name").toString();
    }

    /**
     * partitioningBy-分区
     */
    @Test
    public void test11() {
        List<B> bList = StreamAPI.getBList();
        Map<Boolean, List<B>> booleanGroup = bList.stream()
                .collect(Collectors.partitioningBy((e) -> e.getAge() > 9));
        System.out.println(booleanGroup);
    }

    /**
     * joining-连接字符串
     */
    @Test
    public void test12() {
        List<B> bList = StreamAPI.getBList();
        String nameStr = bList.stream().map(B::getName)
                .collect(Collectors.joining());
        System.out.println(nameStr);
        System.out.println("=======================================");
        String nameSplitStr = bList.stream().map(B::getName)
                .collect(Collectors.joining(","));
        System.out.println(nameSplitStr);
    }

    /**
     * sorted-排序，和reversed结合使用实现正序、倒序
     */
    @Test
    public void test13() {
        List<B> bList = StreamAPI.getBList();
        bList.stream()
                .sorted(Comparator.comparing(B::getAge).reversed()).forEach(e -> {
            System.out.println(e);
        });
        System.out.println("=================Map比较排序======================");
        List<Map<String, Object>> resultList = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "ok");
        map1.put("age", 6);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "okok");
        map2.put("age", 66);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("name", "okokok");
        map3.put("age", 666);
        resultList.add(map1);
        resultList.add(map2);
        resultList.add(map3);
        Stream<Map<String, Object>> sorted = resultList.stream().sorted(Comparator.comparing(MyLambdaTest::comparedByAge).reversed());
        List<Map<String, Object>> collect = sorted.collect(Collectors.toList());
        System.out.println(JSONUtils.toJSONString(collect));
    }

    private static long comparedByAge(Map<String, Object> map) {
        return Long.parseLong(map.get("age").toString());
    }

    /**
     * Stream流中的常用方法skip：用于跳过元素
     * 如果希望跳过前几个元素，可以使用skip方法获取一个截取之后的新流
     * 如果流的当前长度大于n，则跳过前n个，否则会得到一个长度为0的空流
     */
    @Test
    public void test14() {
        List<String> strings = StreamAPI.getStringList();
        Stream stream = strings.stream();
        Stream streamLimit = stream.skip(2);
        streamLimit.forEach(s -> System.out.println(s));
    }

    /**
     * parallelStream() <===>  stream().parallel()
     * parallelStream提供了流的并行处理，它是Stream的另一重要特性，其底层使用Fork/Join框架实现。
     * 简单理解就是多线程异步任务的一种实现。
     * 我们可以通过虚拟机启动参数 -Djava.util.concurrent.ForkJoinPool.common.parallelism=N 来设置worker的数量。
     * <p>
     * 并行可能带来的问题：
     * 由于并行流使用多线程，则一切线程安全问题都应该是需要考虑的问题，如：资源竞争、死锁、事务、可见性等等。
     * 如果某个生产者生产了许多重量级的任务（耗时很长），那么其他任务毫无疑问将会没有工作线程可用；更可怕的事情是这些工作线程正在进行IO阻塞。
     * 串行流：适合存在线程安全问题、阻塞任务、重量级任务，以及需要使用同一事务的逻辑。
     * 并行流：适合没有线程安全问题、较单纯的数据处理任务。
     */
    @Test
    public void test15() {
        List<B> bList = StreamAPI.getBList();
        bList.parallelStream().forEach(num ->
                System.out.println(Thread.currentThread().getName() + ">>" + num.getName()));
        System.out.println("=======================================");
        bList.stream().parallel().forEach(num ->
                System.out.println(Thread.currentThread().getName() + ">>" + num.getName()));
    }

    /**
     * 加上.sequential(), 将并行流变成顺序流(串行流)
     * 串行流：适合存在线程安全问题、阻塞任务、重量级任务，以及需要使用同一事务的逻辑。
     */
    @Test
    public void test16() {
        List<B> bList = StreamAPI.getBList();
        bList.parallelStream().sequential().forEach(num ->
                System.out.println(Thread.currentThread().getName() + ">>" + num.getName()));
    }

    /**
     * forEach 和  forEachOrdered
     * 因为是并行处理
     * 第一种输出的情况不确定
     * 第二行输出的一直是确定的
     */
    @Test
    public void test17() {
        Stream.of("AAA", "BBB", "CCC").parallel().forEach(s -> System.out.println("Output:" + s));
        System.out.println("=======================================");
        Stream.of("AAA", "BBB", "CCC").parallel().forEachOrdered(s -> System.out.println("Output:" + s));
    }

    @Test
    public void test18() {
        int[] array = {1, 2, 5, 5, 5, 5, 6, 6, 7, 2, 9, 2};
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        /*int[]转list*///java8及以上版本
        List<Integer> list1 = Arrays.stream(array).boxed().collect(Collectors.toList());

        /*list转int[]*/
        //方法一：
        Integer[] intArr = numbers.toArray(new Integer[numbers.size()]);
        //方法二：java8及以上版本
        int[] intArr1 = numbers.stream().mapToInt(Integer::valueOf).toArray();
    }


}
