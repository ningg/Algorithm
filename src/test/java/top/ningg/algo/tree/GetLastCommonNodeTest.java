package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

public class GetLastCommonNodeTest {


    public static TreeNode getLastCommonNode(TreeNode pRoot, TreeNode pRootA, TreeNode pRootB) {

        if (null == pRoot) {
            return null;
        }

        boolean aOfLeft = hasSubTree(pRoot.left, pRootA);
        boolean bOfLeft = hasSubTree(pRoot.right, pRootB);

        if (aOfLeft && bOfLeft) {
            return getLastCommonNode(pRoot.left, pRootA, pRootB);
        } else if (!aOfLeft && !bOfLeft) {
            return getLastCommonNode(pRoot.right, pRootA, pRootB);
        } else {
            return pRoot;
        }

    }


    public static boolean hasSubTree(TreeNode root, TreeNode subTree) {
        // 边界判断
        if (null == root) {
            return false;
        }

        if (null == subTree) {
            return true;
        }

        if (root == subTree) {
            return true;
        }

        boolean left = hasSubTree(root.left, subTree);
        boolean right = hasSubTree(root.right, subTree);

        return left || right;
    }


    public static TreeNode getLowestCommonAncestor(TreeNode root, TreeNode p1, TreeNode p2) {
        if (null == root) {
            return null;
        }
        // 终止条件
        if (root == p1 || root == p2) {
            return root;
        }

        // 迭代
        TreeNode left = getLowestCommonAncestor(root.left, p1, p2);
        TreeNode right = getLowestCommonAncestor(root.right, p1, p2);

        if (null == left) {
            return right;
        }
        if (null == right) {
            return left;
        }

        return root;
    }
}
