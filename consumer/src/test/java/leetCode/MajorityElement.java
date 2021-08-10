package leetCode;

import cn.hutool.core.lang.Console;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 多数元素
 * 描述：给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 *
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：3
 *
 *  示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1,1,1,2,2};
        Console.log(majorityElement(arr));
    }

    /*
    * 遍历整个数组，对记录每个数值出现的次数(利用HashMap，其中key为数值，value为出现次数)；
      接着遍历HashMap中的每个Entry，寻找value值> nums.length / 2的key即可。
    */
    public static int majorityElement(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long limit = nums.length >> 1;
        for (Map.Entry<Integer, Long> entry : map.entrySet())
            if (entry.getValue() > limit)
                return entry.getKey();
        return -1;
    }
}
