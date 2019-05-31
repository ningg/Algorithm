package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

public class CountLeafNodeTest {


    public static int countLeafNode(TreeNode root) {
        if (null == root) {
            return 0;
        }

        if (null == root.right && null == root.left) {
            return 1;
        }

        int rightLeafNum = countLeafNode(root.right);
        int leftLeafNum = countLeafNode(root.left);

        return rightLeafNum + leftLeafNum;
    }

}
