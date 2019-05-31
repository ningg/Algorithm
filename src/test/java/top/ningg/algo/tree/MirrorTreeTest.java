package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

public class MirrorTreeTest {


    public static TreeNode mirror(TreeNode root) {
        if (null == root) {
            return root;
        }

        if (null == root.left && null == root.right) {
            return root;
        }

        TreeNode tmpNode = mirror(root.left);
        root.left = mirror(root.right);
        root.right = tmpNode;

        return root;
    }

}
