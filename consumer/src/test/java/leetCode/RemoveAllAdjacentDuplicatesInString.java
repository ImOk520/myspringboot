package leetCode;

import cn.hutool.core.lang.Console;

/**
 * 删除字符串中的所有相邻重复项
 *
 * 描述：给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *      在 S 上反复执行重复项删除操作，直到无法继续删除。在完成所有重复项删除操作后返回最终的字符串。
 *      答案保证唯一。
 *
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：abbaca -> aaca  -> ca
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，
 * 这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，
 * 其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 */
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        String s = "abbaca";
        Console.log(removeDuplicates(s));
    }

    /**
     * 多组相邻重复项，我们无论先删除哪一项，都不会影响最终结果。
     * 删除当前项是需要拿上一项出来对比的，所以我们需要用临时栈存放之前的内容。
     * 当前项和栈顶一致，弹出栈顶抵消即可。若不一致，压入栈留存，供后续使用。
     */
    public static String removeDuplicates(String S) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }
}
