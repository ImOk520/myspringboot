package leetCode;

import cn.hutool.core.lang.Console;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *  
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * 链接：https://leetcode-cn.com/problems/powx-n
 */
public class PowxN {
    public static void main(String[] args) {

    }

    /**
     * 当 x = 0.0时：直接返回 0.0 ，以避免后续 1 除以 0 操作报错。分析： 数字 0 的正数次幂恒为 0 ； 0 的 0 次幂和负数次幂没有意义，因此直接返回 0.00 即可。
     * 初始化 res = 1。
     * 当 n < 0 时：把问题转化至 n≥0 的范围内，即执行 x = 1/x，n = -n。
     * 循环计算：当 n = 0时跳出。
     * 当  n & 1 = 1n&1=1 时：将当前 xx 乘入 resres （即 res *= xres∗=x ）。
     * 执行 x = x^2x=x
     * 2
     *   （即 x *= xx∗=x ）。
     * 执行 nn 右移一位（即 n >>= 1n>>=1）。
     * 返回 resres 。
     */



}
