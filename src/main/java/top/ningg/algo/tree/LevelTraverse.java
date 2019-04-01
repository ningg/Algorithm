package top.ningg.algo.tree;

import java.util.LinkedList;
import top.ningg.algo.model.TreeNode;

/**
 * 题目: 层次遍历二叉树
 *
 * 与树的**前中后序遍历**的 `DFS` 思想不同，**层次遍历** 用到的是`BFS`思想。
 *
 * **DFS** 用`递归`去实现（也可以用`栈`实现）
 * **BFS** 需要用`队列`去实现。
 *
 * 层次遍历的步骤是：
 *
 * 1. 对于不为空的结点，先把该结点加入到队列中
 * 2. 从队中拿出结点，如果该结点的左右结点不为空，就分别把左右结点加入到队列中
 * 3. 重复以上操作直到队列为空
 */
public class LevelTraverse {

    public static void levelTraverse(TreeNode root) {
        // 1. 边界判断
        if (null == root) {
            return;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        // add: 在 end, 增加一个元素
        nodeList.add(root);

        while (!nodeList.isEmpty()) {
            // poll: 在 head , 获取一个元素, 同时, 删除 head 上的元素
            TreeNode currNode = nodeList.poll();
            System.out.print(currNode.value);
            if (null != currNode.left) {
                nodeList.add(currNode.left);
            }
            if (null != currNode.right) {
                nodeList.add(currNode.right);
            }
        }
    }

}
