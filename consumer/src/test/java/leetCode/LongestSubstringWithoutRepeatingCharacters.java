package leetCode;

import cn.hutool.core.lang.Console;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 *
 * 描述：给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 *
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        Console.log(lengthOfLongestSubstring(s));
    }

    /**
     * ”abcabcbb”, 要怎么找到没有重复的字串呢？
     *
     * 应该是先一个一个字符的遍历，先a,b,c,然后重复出现a，去掉第一次出现的a，
     * 继续遍历, 遇到重复的b，去掉之前出现过的b，
     * 以此类推。最后得到无重复字符的字串长度为3。
     *
     * 因此，需要记录的其实是之前出现过的字符。
     * 而实际上，其实是一个sliding window（滑动窗口），
     * 窗口内是没有出现过的字符，需要尽可能的扩展窗口的大小。
     * 窗口在向右滑动的过程中，只要知道每个字符最后出现的位置，以此建立映射。 
     * 最后这个滑动窗口的大小size就是的result。
     *
     * 为了求出这个result，需要一个left变量来指向滑动窗口的左边界，
     * 如果遍历到的字符没有出现过，扩大右边界。
     *
     * 如果出现过，分两种情况讨论。
     * 一是当前字符已经出现在滑动窗口内，需要把已在滑动窗口内的字符去掉，再加进来。
     * 去掉的方法是通过移动left指针，因为之前的Hashmap已经保存了该重复字符最后出现的位置，所以只要移动left指针的位置即可。
     * 第二种情况是该字符已经存储在Hashmap内但没有在滑动窗口内，这时可以直接加到滑动窗口内。
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
