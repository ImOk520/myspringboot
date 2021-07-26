package leetCode;

import cn.hutool.core.lang.Console;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * <p>
 * 描述：
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * <p>
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * <p>
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] array1 = {0, 1, 1, 2, 2, 0, 0, 0, 0, 0};
        int[] array2 = {3, 4, 5, 6, 6};
        merge(array1, 5, array2, 5);
        Console.log(array1);
    }

    /**
     * 直接将第二个数组接到第一个数组然后对第一个数组进行排序
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int gg = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[gg++];    // 将第二个数组逐个放到第一个数组尾端
        }
        Arrays.sort(nums1, 0, n + m);
    }
}
