import cn.hutool.json.JSONUtil;
import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.feng.consumer.util.SpringContextUtil;
import entity.A;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Feng, Ge 2020-10-20 17:28
 */
@SpringBootTest
public class MyTest {

    @Test
    public void test() {
        System.out.println("ppp");
    }

    @Test
    public void test1() {
        List<A> list = new ArrayList<>();
        list.add(new A("李逵"));
        list.add(new A("张飞"));
        list.add(new A("宋江"));
        list.add(new A("鲁智深"));
        list.add(new A("秦明"));
        List<A> list2 = new ArrayList<>();
        list2.add(new A("李逵"));
        list2.add(new A("花荣"));
        list2.add(new A("宋江"));
        list2.add(new A("扈三娘"));
        list2.add(new A("秦明"));

        System.out.println("1==================================");
        list.forEach(diagnosisVO ->
                {
                    List<A> result1 = list2.stream().parallel().filter(df ->
                            df.getName().equals(diagnosisVO.getName())
                    ).collect(Collectors.toList());
                    System.out.println(result1);
                }
        );

        System.out.println("2==================================");
        list.forEach(diagnosisVO ->
                {
                    list2.stream().parallel().filter(df ->
                            df.getName().equals(diagnosisVO.getName())
                    ).forEach(a -> {
                        System.out.println(a);
                    });
                }
        );

        System.out.println("3==================================");
        list.forEach(diagnosisVO ->
                {
                    Optional<A> first = list2.stream().filter(df ->
                            df.getName().equals(diagnosisVO.getName())
                    ).findFirst();
                    System.out.println(first);
                }
        );

        System.out.println("4==================================");
        list.forEach(diagnosisVO ->
                list2.stream().filter(df ->
                        df.getName().equals(diagnosisVO.getName())
                ).findFirst().ifPresent(a ->
                        System.out.println(a)
                )
        );

        System.out.println("5==================================");
        list.forEach(diagnosisVO ->
                list2.stream().filter(df ->
                        df.getName().equals(diagnosisVO.getName())
                ).findFirst().ifPresent(dfs ->
                        System.out.println(dfs))
        );

    }

    @Test
    public void test2() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Long timeOut = ((calendar.getTimeInMillis() - System.currentTimeMillis()) / 1000);
        System.out.println("timeOut:" + timeOut + "秒");
    }

    /**
     * URL编解码
     * Feng, Ge
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String url = "https://www.xtest.com/?key=";
        String wd = "智能+学习";
        String encoderUrl = URLEncoder.encode(wd, "UTF-8");
        System.out.println(url + encoderUrl);
        String decoderUrl = URLDecoder.decode("hhAos5l52rFt4fTPYk6YAwtavBNx5%2FgPkjAMphQjlqdYmkAfivuPLz9l4JSRFb27n3DVDsa6wZCbGo6NfOYc3Cg7G54bEcH%2BQwSOgoj2QlP8Msm5R1Gwd8u07q%2BNCqzSn93pAteTsdVf3Vz7mJG8IfT6YR6RwSwF%2B9cOu%2BqmHKmf8bfCh4EF5nlqU9negPDGP77sXQl1329M13a8dbHqp5m04GhK%2FSjmkWZgV013IR07MKs7qWFM0kRiREm4c5eQh7vjSJCP6Er63uu9D1X3VYM4flDQSqknaJUTwYnJJ03BIGRXB1UVDx4IlTa%2B8YAQ77UyDJZziUxeNacM4JFfbpvTZDhpZ3qlpr2BBFzczcOtCvMyuejAvpFmYFdNdyEdOzCrO6lhTNLCBYPx8Gq9qoe740iQj%2BhK%2Bt7rvQ9V91WDOH5Q0EqpJ2iVE8GJySdNwSBkVwdVFQ8eCJU2vvGAEAZ%2FvHCx15%2BDXjWnDOCRX24ACo0eI4AOXSM8eAJkEciX5%2Bcca6eqNU0%3D=", "UTF-8");
        System.out.println("【decoderUrl:】" + decoderUrl);
    }

    /**
     * URL编解码
     * Feng, Ge
     */
    @Test
    public void test4() {
        List<A> list = new ArrayList<>();
        list.add(new A("李逵"));
        list.add(new A("张飞"));
        list.add(new A("宋江"));
        list.add(new A("鲁智深"));
        list.add(new A("秦明"));
        List<A> list2 = new ArrayList<>();
        list2.add(new A("李逵"));
        list2.add(new A("花荣"));
        list2.add(new A("宋江"));
        list2.add(new A("扈三娘"));
        list2.add(new A("秦明"));
        for (A a : list) {
            boolean flag = false;
            for (A aa : list2) {
                if (a.getName().equals(aa.getName())) {
                    System.out.println(aa.getName());
                    flag = true;
                }
            }
            if (flag) {
                continue;
            }
        }
    }

    @Test
    public void test5() {
        DataSource dataSourceMysql = SpringContextUtil.getBean(DataSource.class);
        // 生成文件配置
        EngineConfig engineConfig = EngineConfig.builder()
                // 生成文件路径，自己mac本地的地址，这里需要自己更换下路径
                .fileOutputDir("D:/")
                // 打开目录
                .openOutputDir(false)
                // 文件类型
                .fileType(EngineFileType.HTML)
                // 生成模板实现
                .produceType(EngineTemplateType.freemarker).build();
        // 生成文档配置（包含以下自定义版本号、描述等配置连接）
        Configuration config = Configuration.builder()
                .version("1.0.3")
                .description("生成文档信息描述")
                .dataSource(dataSourceMysql)
                .engineConfig(engineConfig)
                .produceConfig(getProcessConfig())
                .build();
        // 执行生成
        new DocumentationExecute(config).execute();
    }

    /**
     * 配置想要生成的表+ 配置想要忽略的表
     *
     * @return 生成表配置
     */
    public static ProcessConfig getProcessConfig() {
        // 忽略表名
        List<String> ignoreTableName = Arrays.asList("a", "test_group");
        // 忽略表前缀，如忽略a开头的数据库表
        List<String> ignorePrefix = Arrays.asList("a", "t");
        // 忽略表后缀
        List<String> ignoreSuffix = Arrays.asList("_test", "czb_");
        return ProcessConfig.builder()
                //根据名称指定表生成
                .designatedTableName(Arrays.asList("fire_user"))
                //根据表前缀生成
                .designatedTablePrefix(new ArrayList<>())
                //根据表后缀生成
                .designatedTableSuffix(new ArrayList<>())
                //忽略表名
                .ignoreTableName(ignoreTableName)
                //忽略表前缀
                .ignoreTablePrefix(ignorePrefix)
                //忽略表后缀
                .ignoreTableSuffix(ignoreSuffix).build();
    }

    @Test
    public void test6() {
        System.out.println(JSONUtil.isJson("{'111':'999'}"));
    }


}
