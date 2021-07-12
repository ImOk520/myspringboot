package sort;

import cn.hutool.core.lang.Console;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {81, 57, 34, 32, 6, 91, 19, 25, 36, 34};
        sort(arr);
        Console.log(arr);
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j=0; j<arr.length - i; j++) {
                if(arr[j] > arr[j+1]){
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
                }
            }
        }
    }
}
