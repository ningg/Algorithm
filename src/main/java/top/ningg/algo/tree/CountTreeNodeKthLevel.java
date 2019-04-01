package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

/**
 * 题目: 求二叉树第K层的节点个数
 *
 * 分析:
 *
 * 输入为
 *
 * a. 二叉树
 * b. k 层参数
 *
 * 思路: 迭代解法
 *
 * a. 两棵子树: k-1 层节点个数, 求和
 * b. 终止条件: k = 1, 且, 当前节点不为 null, 则, 返回 1
 */
public class CountTreeNodeKthLevel {


    /**
     * 求二叉树第 k 层节点个数
     *
     * @param root 二叉树根节点
     * @param k 第 k 层
     */
    public static int countTreeNodeKthLevel(TreeNode root, int k) {

        // 边界判断
        if (null == root) {
            return 0;
        }

        if (k <= 0) {
            return 0;
        }

        // 终止条件
        if (1 == k) {
            return 1;
        }

        // 迭代求和
        return countTreeNodeKthLevel(root.left, k - 1) + countTreeNodeKthLevel(root.right, k - 1);
    }
}
