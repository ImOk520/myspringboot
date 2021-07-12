package sort;

import cn.hutool.core.lang.Console;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26};
        shellSort(arr);
        Console.log(arr);
    }

    public static void shellSort(int[] array) {
        // 第一层循环控制间隔
        for (int step = array.length / 2; step > 0; step = step / 2) {
            // 第二层循环控制同一间隔内各子数组的排序
            for (int i = step; i < array.length; i++) {
                // j是一个子数组进行插入排序时的游标
                int j = i;
                int temp = array[j];
                // 第三次循环为子数组的插入排序
                while (j - step >= 0 && array[j] < array[j - step]) {
                    array[j] = array[j - step];
                    j = j - step;
                }
                array[j] = temp;
            }
        }
    }
}
