package leetCode;

import cn.hutool.core.lang.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前K个高频单词
 *
 * 描述：给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。
 * 如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 *  
 * 示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *      出现次数依次为 4, 3, 2 和 1 次。
 *
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 */
public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        Console.log(topKFrequent(words, 4));
    }

    /**
     * 哈希表 + 排序
     * 可以预处理出每一个单词出现的频率，然后依据每个单词出现的频率降序排序，最后返回前 k 个字符串即可。
     * 具体地，利用哈希表记录每一个字符串出现的频率，然后将哈希表中所有字符串进行排序，
     * 排序时，如果两个字符串出现频率相同，那么让两字符串中字典序较小的排在前面，
     * 否则让出现频率较高的排在前面。
     * 最后只需要保留序列中的前 k 个字符串即可。
     */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> rec = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        Collections.sort(rec, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
        return rec.subList(0, k);
    }
}
