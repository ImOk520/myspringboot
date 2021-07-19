package sort;

import cn.hutool.core.lang.Console;

import java.util.ArrayList;
import java.util.List;

public class BasicSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        basicSort(arr);
        Console.log(arr);
    }


    public static void basicSort(int a[]) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        Console.log("数组中最大值:{}", max);

        int times = 0;
        while (max > 0) {
            max = max / 10;
            times++;
        }
        Console.log("需要排序的轮数:{}", times);

        // 准备10个桶， 每个桶也是一个ArrayList， 能存储多个数字
        List<ArrayList> queen = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList q = new ArrayList();
            queen.add(q);
        }

        for (int i = 0; i < times; i++) {
            for (int j = 0; j < a.length; j++) {
                int x = a[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                Console.log(x);
                ArrayList q = queen.get(x);
                q.add(a[j]);
            }
            int count = 0;
            for (int z = 0; z < 10; z++) {
                while (queen.get(z).size() > 0) {
                    ArrayList<Integer> c = queen.get(z);
                    a[count] = c.get(0);
                    c.remove(0);
                    count++;
                }
            }
        }


    }


}
