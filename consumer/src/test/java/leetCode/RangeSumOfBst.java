package leetCode;

import cn.hutool.core.lang.Console;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树的范围和
 *
 * 描述：给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 *       10
 *     /   \
 *    5     15
 *   / \     \
 *  3   7    18
 * 示例：
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 */
public class RangeSumOfBst {
    public static void main(String[] args) {
        /**
         *       10
         *     /   \
         *    5     15
         *   / \     \
         *  3   7    18
         */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        Console.log(rangeSumBST(root, 7, 15));
    }

    /**
     * 使用广度优先搜索的方法
     * 用一个队列 q 存储需要计算的节点。
     * 每次取出队首节点时
     */
    public static int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                continue;
            }
            if (node.val > high) {
                q.offer(node.left);
            } else if (node.val < low) {
                q.offer(node.right);
            } else {
                sum += node.val;
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sum;
    }


}
