package sort;

import cn.hutool.core.lang.Console;

public class CountSort {
    public static void main(String[] args) {
        int[] array = {53, 3, 542, 748, 14, 214};
        countSort(array);
        Console.log(array);
    }

    protected static void countSort(int[] array) {
        //找出最大值和最小值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i]>max) {
                max= array[i];
            }
            if (array[i]<min) {
                min= array[i];
            }
        }// O(n)

        // 开辟内存空间，存储次数
        int[] counts = new int[max-min+1];
        // 统计每个整数出现的次数
        for (int i = 0; i < array.length; i++) {
            counts[array[i]-min]++;
        }// O(n)

        // 累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i]+= counts[i-1];
        }

        //从后向前遍历元素，将她放在有序数组中的合适位置
        int[] newArray = new int[array.length];
        for (int i = array.length-1; i >=0 ; i--) {
            //获取元素在counts中的索引
            int index = array[i]-min;
            //获取元素在counts中的值
            //counts[index];
            //放在合适位置
            newArray[--counts[index]] = array[i];
        }

        // 将有序数组赋值到array
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }
    }

}
