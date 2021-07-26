package leetCode;

import cn.hutool.core.lang.Console;

/**
 * 两两交换链表中的节点
 *
 * 描述：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *      你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(6);
        ListNode newListNode = swapPairs(l1);
        printValue(newListNode);
    }


    /**
     * 创建哑结点 dummyHead，令 dummyHead.next = head。
     * 令 temp 表示当前到达的节点，初始时 temp = dummyHead。每次需要交换 temp 后面的两个节点。
     * 如果 temp 的后面没有节点或者只有一个节点，则没有更多的节点需要交换，因此结束交换。
     * 否则，获得 temp 后面的两个节点 node1 和 node2，通过更新节点的指针关系实现两两交换节点。
     * 交换之前的节点关系是 temp -> node1 -> node2，交换之后的节点关系要变成 temp -> node2 -> node1，因此需要进行如下操作。
     * temp.next = node2
     * node1.next = node2.next
     * node2.next = node1
     * 完成上述操作之后，节点关系即变成 temp -> node2 -> node1。再令 temp = node1，对链表中的其余节点进行两两交换，直到全部节点都被两两交换。
     * 两两交换链表中的节点之后，新的链表的头节点是 dummyHead.next，返回新的链表的头节点即可。
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
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
