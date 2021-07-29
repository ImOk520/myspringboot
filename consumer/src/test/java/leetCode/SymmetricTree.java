package leetCode;

import cn.hutool.core.lang.Console;

/**
 * 对称二叉树
 *
 * 描述：给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Console.log(isSymmetric(root));
    }

    /**
     * 如果同时满足下面的条件，两个树互为镜像：
     * ① 它们的两个根结点具有相同的值
     * ② 每个树的右子树都与另一个树的左子树镜像对称
     *
     * 实现这样一个递归函数，通过「同步移动」两个指针的方法来遍历这棵树，p 指针和 q 指针一开始都指向这棵树的根，
     * 随后 p 右移时，q 左移，p 左移时，qq 右移。
     * 每次检查当前 p 和 q 节点的值是否相等，如果相等再判断左右子树是否对称。
     */
    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
