package sort;

import cn.hutool.core.lang.Console;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        mergeSort(arr, 0, 5);
        Console.log(arr);
    }

    public static void mergeSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int a[], int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= high) {
            temp[k++] = a[j++];
        }
        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
    }

}
