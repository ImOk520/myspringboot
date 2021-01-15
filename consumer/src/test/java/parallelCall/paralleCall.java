package parallelCall;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Feng, Ge 2021/1/14 0014 16:54
 */
public class paralleCall {

    @Test
    public void test() {
        long currentTimeMillis = System.currentTimeMillis();
        normalDemo();
//        paralleDemo();
        long timeDiff = System.currentTimeMillis() - currentTimeMillis;
        System.out.println("时间差：" + timeDiff);
    }

    public List normalDemo() {
        List resultList = new ArrayList();
        List<Long> list1 = addNumber(1L, 1000000L);
        List<Long> list2 = addNumber(1000000L, 2000000L);
        List<Long> list3 = addNumber(2000000L, 3000000L);
        List<Long> list4 = addNumber(3000000L, 4000000L);
        List<Long> list5 = addNumber(4000000L, 5000000L);
        List<Long> list6 = addNumber(5000000L, 6000000L);
        List<Long> list7 = addNumber(6000000L, 7000000L);
        List<Long> list8 = addNumber(7000000L, 8000000L);

        resultList.addAll(list1);
        resultList.addAll(list2);
        resultList.addAll(list3);
        resultList.addAll(list4);
        resultList.addAll(list5);
        resultList.addAll(list6);
        resultList.addAll(list7);
        resultList.addAll(list8);
        return resultList;
    }

    public List paralleDemo() {
        CompletableFuture<List<Long>> future1 = CompletableFuture.supplyAsync(() ->
                addNumber(1L, 1000000L)
        );
        CompletableFuture<List<Long>> future2 = CompletableFuture.supplyAsync(() ->
                addNumber(1000000L, 2000000L)
        );
        CompletableFuture<List<Long>> future3 = CompletableFuture.supplyAsync(() ->
                addNumber(2000000L, 3000000L)
        );
        CompletableFuture<List<Long>> future4 = CompletableFuture.supplyAsync(() ->
                addNumber(3000000L, 4000000L)
        );
        CompletableFuture<List<Long>> future5 = CompletableFuture.supplyAsync(() ->
                addNumber(4000000L, 5000000L)
        );
        CompletableFuture<List<Long>> future6 = CompletableFuture.supplyAsync(() ->
                addNumber(5000000L, 6000000L)
        );
        List resultList = new ArrayList();
        try {
            //获取并行执行任务结果
            List<Long> list1 = future1.get();
            List<Long> list2 = future2.get();
            List<Long> list3 = future3.get();
            List<Long> list4 = future4.get();
            List<Long> list5 = future5.get();
            List<Long> list6 = future6.get();
            //放入结果
            resultList.addAll(list1);
            resultList.addAll(list2);
            resultList.addAll(list3);
            resultList.addAll(list4);
            resultList.addAll(list5);
            resultList.addAll(list6);
        } catch (Exception e) {
            System.out.println("异常：" + e);
        }
        return resultList;
    }

    public List<Long> addNumber(Long startNum, Long endNum) {
        List<Long> list = new ArrayList<>();
        for (Long i= startNum; i<endNum ; i++) {
            list.add(i);
        }
        return list;
    }


}
