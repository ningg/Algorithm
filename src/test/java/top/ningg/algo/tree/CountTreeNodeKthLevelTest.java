package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

public class CountTreeNodeKthLevelTest {

    public static int countTreeNodeKthLevel(TreeNode root, int k) {
        if (null == root) {
            return 0;
        }

        if (k < 1) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        return countTreeNodeKthLevel(root.right, k - 1) + countTreeNodeKthLevel(root.left, k - 1);
    }

}
