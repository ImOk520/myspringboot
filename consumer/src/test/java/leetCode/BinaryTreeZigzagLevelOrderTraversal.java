package leetCode;

import cn.hutool.core.lang.Console;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的锯齿形层序遍历
 *
 * 描述：给定一个二叉树，返回其节点值的锯齿形层序遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        // 初步思路
//        levelOrder(root);
        // 最终方案
        Console.log(zigzagLevelOrder(root));
    }

    /**
     * 二叉树的BFS打印，就是一层一层的往下打印
     */
    public static void levelOrder(TreeNode tree) {
        if (tree == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);//相当于把数据加入到队列尾部
        while (!queue.isEmpty()) {
            //poll方法相当于移除队列头部的元素
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    /**
     * 因为上面每次都是从左边开始打印，但这题要求的是先从左边，下一层从右边，在下一次从左边……左右交替的
     * 我们可以使用一个变量leftToRight，如果是true就表示从左边开始打印，否则就从右边开始打印，
     * 只需要把上面代码修改下即可，来看下
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        //创建队列，保存节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//先把节点加入到队列中
        boolean leftToRight = true;//第一步先从左边开始打印
        while (!queue.isEmpty()) {
            //记录每层节点的值
            List<Integer> level = new ArrayList<>();
            //统计这一层有多少个节点
            int count = queue.size();
            //遍历这一层的所有节点，把他们全部从队列中移出来，顺便
            //把他们的值加入到集合level中，接着再把他们的子节点（如果有）
            //加入到队列中
            for (int i = 0; i < count; i++) {
                //poll移除队列头部元素（队列在头部移除，尾部添加）
                TreeNode node = queue.poll();
                //判断是从左往右打印还是从右往左打印。
                if (leftToRight) {
                    //如果从左边打印，直接把访问的节点值加入到列表level的末尾即可
                    level.add(node.val);
                } else {
                    //如果是从右边开始打印，每次要把访问的节点值
                    //加入到列表的最前面
                    level.add(0, node.val);
                }
                //左右子节点如果不为空会被加入到队列中
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            //把这一层的节点值加入到集合res中
            res.add(level);
            //改变下次访问的方向
            leftToRight = !leftToRight;
        }
        return res;
    }
}
