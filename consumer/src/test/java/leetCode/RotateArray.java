package leetCode;

import cn.hutool.core.lang.Console;

/**
 * 旋转数组
 * <p>
 * 描述：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 使用空间复杂度为 O(1) 的 原地 算法解决这个问题
 * <p>
 * 【示例】
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 链接：https://leetcode-cn.com/problems/rotate-array
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        rotate(array, 3);
        Console.log(array);
    }

    /**
     * 双重循环
     * 时间复杂度：O(kn)
     * 空间复杂度：O(1)
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
            Console.log(nums);
        }
    }
//    /**
//     * 翻转
//     * 时间复杂度：O(n)
//     * 空间复杂度：O(1)
//     */
//    public static void rotate(int[] nums, int k) {
//        int n = nums.length;
//        k %= n;
//        reverse(nums, 0, n - 1);
//        Console.log(nums);
//        reverse(nums, 0, k - 1);
//        Console.log(nums);
//        reverse(nums, k, n - 1);
//        Console.log(nums);
//    }
//
//    private static void reverse(int[] nums, int start, int end) {
//        while (start < end) {
//            int temp = nums[start];
//            nums[start++] = nums[end];
//            nums[end--] = temp;
//        }
//    }
}
