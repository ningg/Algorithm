package top.ningg.algo.tree;

import java.util.LinkedList;
import top.ningg.algo.model.TreeNode;

public class levelTraverseTest {


    public static void levelTraverse(TreeNode root, LinkedList<TreeNode> result) {
        if (null == root) {
            return;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();

        // 尾部增加一个节点
        nodeList.add(root);

        while (!nodeList.isEmpty()) {
            // 头部获取一个节点
            TreeNode currNode = nodeList.poll();
            result.add(currNode);

            if (null != currNode.right) {
                nodeList.add(currNode.right);
            }
            if (null != currNode.left) {
                nodeList.add(currNode.left);
            }
        }

    }

}
