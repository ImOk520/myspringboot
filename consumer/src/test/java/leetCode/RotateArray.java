package leetCode;

import cn.hutool.core.lang.Console;

/**
 * 旋转数组
 *
 * 描述：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *      使用空间复杂度为 O(1) 的 原地 算法解决这个问题
 *
 *【示例】
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 链接：https://leetcode-cn.com/problems/rotate-array
 *
 *
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6};
        rotate(array, 2);
        Console.log(array);
    }

    /**
     * 循环交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // 第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换
        for (int start = 0; start < nums.length && k != 0; n -= k, start += k, k %= n) {
            for (int i = 0; i < k; i++) {
                swap(nums, start + i, nums.length - k + i);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
