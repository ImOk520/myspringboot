package sort;

import cn.hutool.core.lang.Console;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {81, 57, 34, 32, 6, 91, 19, 25, 36, 34};
//        sort(arr);
        enhancedSort(arr);
        Console.log(arr);
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Console.log("第" + i + "趟");
            for (int j=0; j<arr.length - i; j++) {
                if(arr[j] > arr[j+1]){
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
                }
            }
        }
    }

    /**
     *
     * 冒泡排序优化，减少趟数
     */
    private static void enhancedSort(int[] arr) {
        boolean breakFlag = true;
        for (int i = 1; i < arr.length; i++) {
            Console.log("第" + i + "趟");
            breakFlag = true;
            for (int j=0; j<arr.length - i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    breakFlag = false;
                }
            }
            if(breakFlag){
                Console.log("第" + i + "趟break");
                break;
            }
        }
    }
}
