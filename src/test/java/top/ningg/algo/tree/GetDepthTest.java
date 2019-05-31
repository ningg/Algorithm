package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

public class GetDepthTest {


    public static int getDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        if (null == root.right && null == root.left) {
            return 1;
        }

        int maxDepthLeft = getDepth(root.left);
        int maxDepthRight = getDepth(root.right);

        return Math.max(maxDepthLeft, maxDepthRight) + 1;
    }

}
