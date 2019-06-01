package top.ningg.algo.tree;

import java.util.Stack;
import top.ningg.algo.model.TreeNode;

/**
 * 题目：二叉搜索树，转换为「双向链表」
 *
 * TODO：独立的 blog
 */
public class TreeToList {


    public static TreeNode treeToList(TreeNode root) {
        if (null == root) {
            return root;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;

        TreeNode preNode = null, headNode = null;

        while (!stack.isEmpty() || null != currNode) {
            if (null != currNode) {
                // 左子节点，循环入栈
                stack.push(currNode);
                currNode = currNode.left;
            } else {
                // 弹出栈顶元素
                TreeNode topNode = stack.pop();

                // 标记：head
                if (null == headNode) {
                    headNode = topNode;
                }
                if (null != preNode) {
                    preNode.right = topNode;
                }

                // 更新「前驱节点」
                topNode.left = preNode;
                preNode = topNode;

                // 迭代：右子节点，继续迭代
                currNode = topNode.right;
            }
        }
        return headNode;
    }

}
