package leetCode;

import cn.hutool.core.lang.Console;

/**
 * 二叉搜索树节点最小距离
 *
 * 描述：给你一个二叉搜索树的根节点 root，返回树中任意两不同节点值之间的最小差值 。
 *
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 *
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 */
public class MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Console.log(minDiffInBST(root));
    }

    static int pre;
    static int ans;

    public static int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
