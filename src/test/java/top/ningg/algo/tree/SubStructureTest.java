package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

public class SubStructureTest {

    public static boolean subStructure(TreeNode root, TreeNode subTree) {
        if (null == root) {
            return false;
        }
        if (null == subTree) {
            return true;
        }

        if (root.value == subTree.value) {
            boolean isSubTree = hasSubTree(root, subTree);

            if (isSubTree) {
                return true;
            }
        }

        boolean found = subStructure(root.left, subTree);
        if (!found) {
            found = subStructure(root.right, subTree);
        }

        return found;
    }


    public static boolean hasSubTree(TreeNode rootA, TreeNode rootB) {
        if (rootB == null) {
            return true;
        }

        if (rootA == null) {
            return false;
        }

        if (rootA.value == rootB.value) {
            return hasSubTree(rootA.left, rootB.left) && hasSubTree(rootA.right, rootB.right);
        }

        return false;
    }

}
