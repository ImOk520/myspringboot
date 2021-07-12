package search;

import cn.hutool.core.lang.Console;

/**
 * 二分法查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] data = {3, 6, 50, 100, 181, 191, 217, 221, 300, 400, 681};
        int result = binarySearch(data, 100);
        Console.log(result);
    }

    public static int binarySearch(int[] data, int value) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (value == data[mid]) {
                return mid;
            }
            if (value > data[mid]) {
                low = mid + 1;
            }
            if (value < data[mid]) {
                high = mid - 1;
            }
        }
        return -1;
    }
}
