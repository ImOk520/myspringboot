package leetCode;

import cn.hutool.core.lang.Console;

/**
 * 最大子序和
 * 描述：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 示例 1：
 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 输出：6
 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

 示例 2：
 输入：nums = [1]
 输出：1

 示例 3：
 输入：nums = [0]
 输出：0

 示例 4：
 输入：nums = [-1]
 输出：-1

 示例 5：
 输入：nums = [-100000]
 输出：-100000

 链接：https://leetcode-cn.com/problems/maximum-subarray
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Console.log(maxSubArray(arr));
    }

    /*
        动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
        如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
        如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
        每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
    * */
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
