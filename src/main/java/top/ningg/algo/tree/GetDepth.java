package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

/**
 * 题目: 求二叉树的深度
 *
 * 递归解法：
 *
 * 1. 如果二叉树为空，二叉树的深度为0
 * 1. 如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1
 */
public class GetDepth {

    /**
     * 求二叉树的深度。
     *
     * @param root 二叉树根节点
     * @return 二叉树的深度
     */
    public static int getDepth(TreeNode root) {
        // 终止条件
        if (null == root) {
            return 0;
        }

        // 迭代条件
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }

}
