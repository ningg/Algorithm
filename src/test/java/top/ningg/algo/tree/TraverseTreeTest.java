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
            if (null != currNode.right) {
                stack.push(currNode.right);
            }
            if (null != currNode.left) {
                stack.push(currNode.left);
            }
        }
    }

}
