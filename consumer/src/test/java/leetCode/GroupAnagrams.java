package leetCode;

import cn.hutool.core.lang.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词分组
 *
 * 描述：给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。
 *      字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 *
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] s = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Console.log(groupAnagrams(s));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            // Map.getOrDefault(Object key, V defaultValue)
            // 当Map集合中有这个key时，就使用这个key值；如果没有就使用默认值defaultValue
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
