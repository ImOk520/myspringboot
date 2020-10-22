import entity.A;
import org.junit.Test;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Feng, Ge 2020-10-20 17:28
 */
public class MyTest {

    @Test
    public void test(){
        System.out.println("ppp");
    }

    @Test
    public void test1(){
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

}
