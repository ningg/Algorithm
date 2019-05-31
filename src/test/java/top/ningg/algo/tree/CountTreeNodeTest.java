package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

public class CountTreeNodeTest {


    public static int countTreeNode(TreeNode root) {
        if (null == root) {
            return 0;
        }

        if (null == root.right && null == root.left) {
            return 1;
        }

        return countTreeNode(root.right) + countTreeNode(root.left) + 1;
    }
}
