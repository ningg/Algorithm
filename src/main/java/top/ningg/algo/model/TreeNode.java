package top.ningg.algo.model;

/**
 * 二叉树节点.
 */
public class TreeNode {

    // 左子树
    public TreeNode left;
    // 右子树
    public TreeNode right;
    // 取值
    public int value;

    public TreeNode(int value) {
        this.value = value;

        this.left = null;
        this.right = null;
    }
}
