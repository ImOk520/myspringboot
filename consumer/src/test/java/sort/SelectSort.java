package sort;

import cn.hutool.core.lang.Console;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {81, 57, 34, 32, 6, 91, 19, 25, 36, 34};
        selectSort(arr);
        Console.log(arr);
    }

    public static int[] selectSort(int[] data) {
        if (data.length == 0 || data.length == 1) {
            return data;
        }
        for (int i = 0; i < data.length - 1; i++) {
            // 假设最开始时，i位置的数最小
            int min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[min] > data[j]) {
                    // 此时最小的位置移动到j，最小的数即data[j]
                    min = j;
                }
            }
            // 调换min位置和i位置的值（若一轮比较下来都没有变更最小值的索引，即min==i，则无需调换顺序）
            if (min != i) {
                int temp = data[min];
                data[min] = data[i];
                data[i] = temp;
            }
        }
        return data;
    }
}
