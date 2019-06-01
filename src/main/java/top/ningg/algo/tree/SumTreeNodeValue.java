package top.ningg.algo.tree;

import top.ningg.algo.common.TreeNodeUtils;
import top.ningg.algo.model.TreeNode;

/**
 * 题目： 给一颗二叉树，树的每个节点的值是一个0-9的个位整数，这样，从根节点到所有叶子节点会构成很多个十进制整数，要求算出所有这些整数的和。
 *
 * 参考： https://blog.csdn.net/u010513059/article/details/79562357
 */
public class SumTreeNodeValue {

    private static int sum = 0;


    public static void sumCount(TreeNode root, int depth, int factor) {
        if (null == root) {
            return;
        }

        sum = sum + root.value * factor;

        if (null != root.left) {
            sumCount(root.left, depth + 1, factor * 10);
        }
        if (null != root.right) {
            sumCount(root.right, depth + 1, factor * 10);
        }
    }

    public static int sumCount(TreeNode root) {
        if (null == root) {
            return 0;
        }

        sumCount(root, 0, 1);

        return sum;
    }

    public static void main(String[] args) {
        TreeNode currTreeNode = TreeNodeUtils.constructBinaryTree(3);

        System.out.println(TreeNodeUtils.printBinaryTree(currTreeNode));

        int result = sumCount(currTreeNode);

        System.out.println(result);
    }
}
