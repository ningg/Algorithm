package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

/**
 * 题目: 求二叉树中叶子节点的个数
 *
 * 递归解法：
 *
 * 1. 边界判断: 如果二叉树为空，返回0
 * 1. 终止条件: 如果二叉树不为空且左右子树为空，返回1
 * 1. 迭代执行: 如果二叉树不为空，且左右子树不同时为空，返回左子树中叶子节点个数加上右子树中叶子节点个数
 */
public class CountLeafNode {


    /**
     * @param root 二叉树根节点
     * @return 叶子节点个数
     */
    public static int countLeafNode(TreeNode root) {
        // 边界判断
        if (null == root) {
            return 0;
        }

        // 终止条件
        if (null == root.left && null == root.right) {
            return 1;
        }

        // 迭代执行
        return countLeafNode(root.left) + countLeafNode(root.right);
    }

}
