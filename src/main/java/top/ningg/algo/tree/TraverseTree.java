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
     * 遍历：后续（非递归，循环方式）
     *
     * @param root 二叉树根节点
     * @param result 遍历输出的结果
     */
    public static void postOrderTraverseLoop(TreeNode root, List<TreeNode> result) {
        Stack<TreeNode> stack = new Stack<>();

        // 基本逻辑：非空「左子树」循环入栈，顶点不出栈，右子树有效则继续「左子树循环入栈」，若子节点全部出栈则顶部节点出栈
        // 1. 初始化：记录当前节点，为 root 节点
        // 2. 循环逻辑：
        // a. 「当前节点」非 null，则，入栈，并将「左子节点」设置为「当前节点」
        // b. 如果「当前节点」为 null，则，查询顶部节点（不弹出），判断其「右子节点」是否为 null or 为「上次输出」的节点，若满足，则，弹出「顶部节点」并输出
        // c. 如果「当前节点」为 null，且顶部节点（不弹出），其「右子节点」不为 null，且「未被输出」，则，将其作为「当前节点」，进入循环逻辑
        // 3. 终止条件：「栈」为空，且，「当前节点」也为空

        if (null == root) {
            return;
        }

        TreeNode currNode = root;
        TreeNode lastRecordNode = null;

        while (!stack.isEmpty() || currNode != null) {
            // a. 「当前节点」不为 null，则，入栈，并以「左子节点」作为当前节点，继续迭代
            if (null != currNode) {
                stack.push(currNode);
                currNode = currNode.left;
            } else {
                // b. 当前节点为 null，则，查询顶部节点
                TreeNode topNode = stack.peek();

                if (null != topNode.right && lastRecordNode != topNode.right) {
                    // 1. 「顶部节点」可以「右子节点」进行递归，则继续递归
                    currNode = topNode.right;
                } else {
                    // 2. 「顶部节点」满足「出栈条件」，则出栈访问
                    topNode = stack.pop();
                    lastRecordNode = topNode;
                    result.add(topNode);
                }

            }
        }
    }

    /**
     * 遍历：中序（非递归，循环方式）
     *
     * @param root 二叉树根节点
     * @param result 中序遍历的结果
     */
    public static void inOrderTraverseLoop(TreeNode root, List<TreeNode> result) {
        Stack<TreeNode> stack = new Stack<>();

        // 基本逻辑：非空「左子树」循环入栈，顶点出栈，「右子树」继续「左子树循环入栈」
        // 1. 初始化：记录当前节点，为 root 节点
        // 2. 循环逻辑：
        // a. 「当前节点」非 null，则入栈，并，将「左子节点」设置为「当前节点」
        // b. 如果「当前节点」为 null，则，弹出一个节点，记录到结果中
        // c. 以「弹出的节点」的「右子节点」为基准，设置为「当前节点」
        // 3. 终止条件：「栈」为空，且，「当前节点」也为空

        if (null == root) {
            return;
        }

        TreeNode currNode = root;

        while (!stack.isEmpty() || null != currNode) {
            if (null != currNode) {
                stack.push(currNode);
                currNode = currNode.left;
            } else {
                TreeNode validNode = stack.pop();
                result.add(validNode);
                currNode = validNode.right;
            }
        }

    }

    /**
     * 遍历：前序（非递归，循环方式）
     *
     * Note：有独立的示意图
     *
     * @param root 二叉树根节点
     * @param result 前序遍历的结果
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