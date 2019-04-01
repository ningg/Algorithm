package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

/**
 * 题目: 遍历二叉树
 */
public class TraverseTree {


    /**
     * 先序遍历
     *
     * @param root 二叉树的根节点
     */
    public static void traverse(TreeNode root) {
        // 边界判断
        if (null == root) {
            return;
        }

        // 先序遍历
        System.out.print(root.value);
        traverse(root.left);
        traverse(root.right);
    }


}
