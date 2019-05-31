package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

public class RecoverTreeTest {

    private static TreeNode preNode = null;
    private static TreeNode firstNode = null;
    private static TreeNode secondNode = null;

    public static TreeNode recoverTree(TreeNode root) {

        if (null == root) {
            return root;
        }

        inOrderTraverse(root);

        int tmp = firstNode.value;
        firstNode.value = secondNode.value;
        secondNode.value = tmp;

        return root;
    }

    public static void inOrderTraverse(TreeNode root) {

        if (null == root) {
            return;
        }

        inOrderTraverse(root.left);

        if (null != preNode) {
            if (root.value < preNode.value) {
                if (firstNode != null) {
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

}
