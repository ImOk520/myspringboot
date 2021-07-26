package leetCode;

import cn.hutool.core.lang.Console;

/**
 * 【题目】：删除有序数组中的重复项
 *
 * 描述：给你一个有序数组 nums，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。
 *      不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 *
 * 双指针法：
 * 首先注意数组是有序的，那么重复的元素一定会相邻。
 * 要求删除重复元素，实际上就是将不重复的元素移到数组的左侧。
 * 考虑用 2 个指针，一个在前记作 p，一个在后记作 q，算法流程如下：
 *
 * ① 从索引0开始,比较 p 和 q 位置的元素是否相等。
 * ② 如果相等，q 后移 1 位
 *   如果不相等，将 q 位置的元素复制到 p+1 位置上，p 后移一位，q 后移 1 位
 * ③ 重复上述过程，直到 q 等于数组长度。
 * ④ 返回 p + 1，即为新数组长度。
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] array = {0,1,1,2,2,3,4,5,6,6};
        int newArrayLength = removeDuplicates(array);
        Console.log(array);
        Console.log(newArrayLength);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                // 数组中没有重复元素时，
                // 每次比较时 nums[p] 都不等于 nums[q]，
                // 因此就会将 q 指向的元素原地复制一遍
                // 这里判断下，跳过这种无意义的复制
                if(q - p > 1){
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
