package leetCode;

import cn.hutool.core.lang.Console;

import java.util.Arrays;

/**
 * 有效的字母异位词
 *
 * 描述：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        Console.log(isAnagram(s, t));
    }

    /**
     * ① t 是 ss 的异位词等价于「两个字符串排序后相等」。
     * ② 因此我们可以对字符串 ss 和 tt 分别排序，看排序后的字符串是否相等即可判断。
     * ③ 此外，如果 ss 和 tt 的长度不同，tt 必然不是 ss 的异位词。
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
