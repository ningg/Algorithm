package top.ningg.algo.tree;

import top.ningg.algo.common.TreeNodeUtils;
import top.ningg.algo.model.TreeNode;

/**
 * 题目: 二叉树节点, 进行镜像.
 *
 */
public class MirrorTree {

    /**
     * 输入一棵二叉树, 返回二叉树的镜像
     *
     * @param root 二叉树的根节点
     * @return 返回二叉树的镜像
     */
    public static TreeNode mirror(TreeNode root) {
        // 1. 边界判断
        if (null == root) {
            return null;
        }

        // 2. 递归处理：下述逻辑，涵盖了「叶子节点」的剪枝逻辑
        TreeNode currLeftTree = root.left;
        TreeNode currRightTree = root.right;
        root.left = mirror(currRightTree);
        root.right = mirror(currLeftTree);

        return root;
    }

    public static void main(String[] args) {
        TreeNode currTreeNode = TreeNodeUtils.constructBinaryTree(3);

        System.out.println(TreeNodeUtils.printBinaryTree(currTreeNode));

        TreeNode mirrorTree = mirror(currTreeNode);

        System.out.println(TreeNodeUtils.printBinaryTree(mirrorTree));
    }
}
