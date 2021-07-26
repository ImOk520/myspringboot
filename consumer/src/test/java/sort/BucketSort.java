package sort;

import cn.hutool.core.lang.Console;

import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {
    public static void main(String[] args) {
        double[] array = {53, 3, 542, 748, 14, 214};
        bucketSort(array);
        Console.log(array);
    }

    public static void bucketSort(double[] arr) {
        // 获取最大值和最小值        
        double max = arr[0];
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            double num = arr[i];
            if (num > max)
                max =num;
            else if (num < min)
                min = num;
        }

        // 桶的数量        
        int bucketNumber = 4;

        // 每个桶的范围        
        double range = (max - min) / bucketNumber;
        // 1.初始化所有桶,每个桶都是LinkedList,方便增加数据        
        LinkedList<Double>[] buckets = new LinkedList[bucketNumber];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        // 2.将所有待排序数据放入到对应的桶中        
        for (int i = 0; i < arr.length; i++) {
            double num = arr[i];
            int index = (int) ((num -min)/range);
            if(index==bucketNumber)
                index-=1;// 如果这个数字正好是最大值,计算出索引就是number,会数组越界,放到最后一个桶中            
            buckets[index].add(num);
        }

        // 3.使用合理的算法对每个非空桶进行子排序
        for(int i=0;i<buckets.length;i++) {
            // 对每个桶中的数据进行排序
            Collections.sort(buckets[i]);
        }

        // 4.按顺序将每个桶中数据进行合并        
        int index =0;
        for(int i=0;i<buckets.length;i++){
            LinkedList<Double> bucket=buckets[i];
            for(int j =0;j< bucket.size();j++){
                arr[index]=bucket.get(j);
                index++;
            }
        }
    }
}
