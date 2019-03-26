package top.ningg.algo.common;

import top.ningg.algo.model.TreeNode;

/**
 * 二叉树节点工具类。
 */
public class TreeNodeUtils {

    /**
     * 根据输入的层数, 构造一棵二叉树
     *
     * @param depthLevel 二叉树的层数
     * @return 二叉树.
     */
    public static TreeNode constructBinaryTree(int depthLevel) {
        // 终止条件
        if (depthLevel <= 0) {
            return null;
        }

        // 构造节点
        int randomValue = (int) (Math.random() * 100);
        TreeNode currNode = new TreeNode(randomValue);

        currNode.left = constructBinaryTree(depthLevel - 1);
        currNode.right = constructBinaryTree(depthLevel - 1);

        return currNode;
    }

    /**
     * 前序遍历: 输出整棵二叉树
     *
     * @param root 二叉树根节点
     * @return 二叉树前序遍历, 结果输出
     */
    public static String printBinaryTree(TreeNode root) {
        // 边界判断
        if (null == root) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        // 前序遍历
        stringBuilder.append(root.value);
        stringBuilder.append("-");

        // 递归
        String leftStr = printBinaryTree(root.left);
        String rightStr = printBinaryTree(root.right);

        if (null != leftStr) {
            stringBuilder.append(leftStr);
            stringBuilder.append("-");
        }

        if (null != rightStr) {
            stringBuilder.append(rightStr);
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }
}
