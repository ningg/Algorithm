package top.ningg.algo.tree;

import java.util.LinkedList;
import java.util.List;
import top.ningg.algo.model.TreeNode;

/**
 * 题目： 二叉树，从右侧观察，看到的元素。
 *
 * 参考： https://blog.csdn.net/jmspan/article/details/51311464
 */
public class RightMost {

    public static List<TreeNode> rightMost(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();

        if (null == root) {
            return null;
        }

        rightMost(root, 0, list);

        return list;
    }


    public static void rightMost(TreeNode currNode, int depth, List<TreeNode> list) {
        if (list.size() == depth) {
            list.add(currNode);
        }

        // 右侧优先
        if (currNode.right != null) {
            rightMost(currNode.right, depth + 1, list);
        }
        if (currNode.left != null) {
            rightMost(currNode.left, depth + 1, list);
        }

    }

}
