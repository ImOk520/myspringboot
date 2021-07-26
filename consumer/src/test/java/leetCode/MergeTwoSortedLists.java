package leetCode;

import cn.hutool.core.lang.Console;

/**
 * 合并两个有序链表
 * <p>
 * 描述：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/hua-jie-suan-fa-21-he-bing-liang-ge-you-xu-lian-bi/
 * <p>
 * 示例1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * 示例2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * 示例3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(6);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(6);
        ListNode newListNode = mergeTwoLists(l1, l2);
        printValue(newListNode);
    }

    /**
     * 标签：链表、递归
     * 这道题可以使用递归实现，新链表也不需要构造新节点，我们下面列举递归三个要素
     * 终止条件：两条链表分别名为 l1 和 l2，当 l1 为空或 l2 为空时结束
     * 返回值：每一层调用都返回排序好的链表头
     * 本级递归内容：如果 l1 的 val 值更小，则将 l1.next 与排序好的链表头相接，l2 同理
     * O(m+n)O(m+n)，mm 为 l1的长度，nn 为 l2 的长度
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static void printValue(ListNode listNode) {
        Console.log(listNode.val);
        if(listNode.next != null){
            printValue(listNode.next);
        }
    }

}
