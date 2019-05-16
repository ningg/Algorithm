package top.ningg.algo.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import top.ningg.algo.model.TreeNode;

/**
 * 题目: 遍历二叉树
 */
public class TraverseTree {


    public static List<TreeNode> traverse(TreeNode root) {
        // 1. 存储返回的数据
        List<TreeNode> result = new LinkedList<>();
        // 2. 遍历：中序
        inOrderTraverse(root, result);
        // 3. 返回
        return result;
    }


    /**
     * 遍历：中序
     *
     * @param root 二叉树的根节点
     * @param result 返回的遍历结果
     */
    public static void inOrderTraverse(TreeNode root, List<TreeNode> result) {
        // 边界判断
        if (null == root) {
            return;
        }

        // 中序遍历
        inOrderTraverse(root.left, result);
        result.add(root);
        inOrderTraverse(root.right, result);
    }

    /**
     * 遍历：中序（非递归，循环方式）
     *
     * @param root 二叉树根节点
     * @param result 中序遍历的结果
     */
    public static void inOrderTraverseLoop(TreeNode root, List<TreeNode> result) {
        Stack<TreeNode> stack = new Stack<>();


    }

    /**
     * 遍历：前序（非递归，循环方式）
     *
     * TODO：增加示意图描述，done
     *
     * @param root 二叉树根节点
     * @param result 中序遍历的结果
     */
    public static void preOrderTraverseLoop(TreeNode root, List<TreeNode> result) {
        Stack<TreeNode> stack = new Stack<>();

        // 基本逻辑：
        // 1. 初始化：root 入栈
        // 2. 循环逻辑：弹出一个节点，并将右、左子节点入栈
        // 3. 终止条件：节点为 null，不再入栈，stack 为空，终止处理

        if (null == root) {
            return;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            // a. 弹出元素
            TreeNode currNode = stack.pop();

            // b. 子节点入栈：右、左节点，入栈
            if (null != currNode.right) {
                stack.push(currNode.right);
            }
            if (null != currNode.left) {
                stack.push(currNode.left);
            }

            // c. 节点增加到返回队列
            result.add(currNode);
        }

    }


}
