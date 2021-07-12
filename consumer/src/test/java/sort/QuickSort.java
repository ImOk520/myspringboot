package sort;

import cn.hutool.core.lang.Console;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {81, 57, 34, 32, 6, 91, 19, 25, 36, 34};
        quickSort(arr, 0, arr.length - 1);
        Console.log(arr);
    }

    /**
     * 快速排序
     * low 和 high 代表每段区间最最左边和最右边的元素，每次结束是会变动的
     */
    public static void quickSort(int[] arr, int low, int high) {
        // 两个移动的索引
        int i, j;
        // 选定的基准
        int temp;
        int t;
        if (low > high) {
            return;
        }
        // i指向最左边的元素， j指向最右边的元素
        i = low;
        j = high;
        // temp就是基准位，这里默认选择每段区间最左边的元素为基准元素
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减，直到遇到比基准元素小的停下，记录索引位置
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增，直到遇到比基准元素大的停下，记录索引位置
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }

}
