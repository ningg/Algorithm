package top.ningg.algo.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import top.ningg.algo.model.TreeNode;

public class TraverseTreeTest {


    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> resultList = new LinkedList<>();

        inOrderTraverse(root, resultList);

        return resultList;
    }

    // 迭代方式
    public static void inOrderTraverse(TreeNode root, List<TreeNode> resultList) {
        if (null == root) {
            return;
        }

        inOrderTraverse(root.left, resultList);

        resultList.add(root);

        inOrderTraverse(root.right, resultList);
    }


    // 二叉树：循环方式，实现遍历
    public static void preOrderTraverse(TreeNode root, List<TreeNode> result) {
        if (null == root) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            result.add(currNode);

            if (null != currNode.right) {
                stack.push(currNode.right);
            }
            if (null != currNode.left) {
                stack.push(currNode.left);
            }
        }
    }

    // 二叉树：循环方式，实现遍历，中序遍历
    public static void inOrderTraverseLoop(TreeNode root, List<TreeNode> result) {
        if (null == root) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;

        while (!stack.isEmpty() || currNode != null) {
            if (null != currNode) {
                stack.push(currNode);
                currNode = currNode.left;
            } else {
                TreeNode popNode = stack.pop();
                result.add(popNode);

                currNode = popNode.right;
            }
        }

    }


    // 二叉树：循环方式，实现遍历，后序遍历
    public static void postOrderTraverseLoop(TreeNode root, List<TreeNode> result) {
        if (null == root) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        TreeNode lastRecordNode = null;

        while (!stack.isEmpty() || null != currNode) {
            if (null != currNode) {
                stack.push(currNode);
                currNode = currNode.left;
            } else {
                TreeNode topNode = stack.peek();
                if (null == topNode.right) {
                    topNode = stack.pop();
                    result.add(topNode);
                    lastRecordNode = topNode;
                } else {
                    if (lastRecordNode == topNode.right) {
                        topNode = stack.pop();
                        result.add(topNode);
                        lastRecordNode = topNode;
                    } else {
                        currNode = topNode.right;
                    }
                }
            }
        }
    }

}
