package sort;

import cn.hutool.core.lang.Console;

/**
 * Feng, Ge 2021/7/20 0020 17:35
 */
public class HeapSortEasy {
    public static void main(String[] args)
    {
        int[] arr = { 2, 3, 4, 1, 100, 44, 22 };
        HeapSort(arr);
        Console.log(arr);
    }

    public static void HeapSort(int[] arr) {
        if (arr.length <= 1) return;
        //先将完全二叉树调整成大顶堆
        HeapAdjustment(arr, arr.length);
        //每一次调整之后都将树的第一个元素和最后一个元素交换并在下次排序中舍去最后一个元素
        for (int i = arr.length - 1; i > 0; i--) {
            swapFirstAndLast(arr, i);
            HeapAdjustment(arr, i);
        }
    }

    //将完全二叉树构造成大顶堆
    public static void HeapAdjustment(int[] arr, int length)
    {
        for (int i = length / 2 - 1; i >= 0; i--) {  //遍历完全二叉树的所有非叶子节点
            for (int j = i * 2 + 1; j <= i * 2 + 2; j++)
            {
                int temp = 0;  //临时交换变量
                if (j < length)
                {
                    if (arr[i] < arr[j])
                    {
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    //交换完全二叉树的第一个元素和最后一个元素
    public static void swapFirstAndLast(int[] arr, int last)
    {
        int temp = arr[0];
        arr[0] = arr[last];
        arr[last] = temp;
    }
}
