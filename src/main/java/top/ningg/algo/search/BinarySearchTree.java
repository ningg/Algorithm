package top.ningg.algo.search;

import top.ningg.algo.model.TreeNode;

/**
 * 题目: 二叉查找树, 查找目标取值
 */
public class BinarySearchTree {


    /**
     * 查找目标取值对应的节点
     *
     * @param root 二叉查找树的根节点
     * @param destValue 目标取值
     * @return 二叉查找树的节点
     */
    public static TreeNode binarySearchTree(TreeNode root, int destValue) {
        // 1. 边界判断
        if (null == root) {
            return null;
        }

        // 2. 查找
        if (destValue == root.value) {
            return root;
        } else if (destValue < root.value) {
            return binarySearchTree(root.left, destValue);
        } else {
            return binarySearchTree(root.right, destValue);
        }

    }
    
}
