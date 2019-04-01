package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

/**
 * 题目: 二叉树的节点个数
 *
 * 递归解法：
 *
 * 1. 如果二叉树为空，节点个数为0
 * 1. 如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
 */
public class CountTreeNode {

    /**
     * 统计「二叉树」的节点个数
     *
     * @param root 二叉树的根节点
     */
    public static int countTreeNode(TreeNode root) {

        // 终止条件
        if (null == root) {
            return 0;
        }

        // 迭代条件
        return countTreeNode(root.left) + countTreeNode(root.right) + 1;

    }

}
