package top.ningg.algo.tree;

import top.ningg.algo.common.TreeNodeUtils;
import top.ningg.algo.model.TreeNode;

/**
 * 题目：重构二叉查找树，找出被交换的 2 个节点
 */
public class RecoverTree {

    private static TreeNode firstNode = null;
    private static TreeNode secondNode = null;

    private static TreeNode preNode = null;

    /**
     * 修复二叉查找树。
     *
     * @param root 二叉查找树的根节点。
     */
    public static void recoverTree(TreeNode root) {
        if (null == root) {
            return;
        }

        // 中序遍历：找出 2 个逆序的节点
        inOrderTraverse(root);

        int tmp = firstNode.value;
        firstNode.value = secondNode.value;
        secondNode.value = tmp;
    }

    /**
     * 中序遍历二叉查找树，同时，判断逆序节点
     *
     * @param root 二叉查找树的根节点
     */
    public static void inOrderTraverse(TreeNode root) {
        if (null == root) {
            return;
        }

        inOrderTraverse(root.left);

        if (preNode != null) {
            if (preNode.value > root.value) {
                if (firstNode == null) {
                    firstNode = preNode;
                    secondNode = root;
                } else {
                    secondNode = root;
                }
            }
        }

        preNode = root;

        inOrderTraverse(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode leftOfLevel1 = new TreeNode(1);
        TreeNode rightOfLevel1 = new TreeNode(4);
        TreeNode leftOfLevel2 = new TreeNode(2);

        root.left = leftOfLevel1;
        root.right = rightOfLevel1;
        rightOfLevel1.left = leftOfLevel2;

        recoverTree(root);

        System.out.println(TreeNodeUtils.printBinaryTree(root));;
    }

}
