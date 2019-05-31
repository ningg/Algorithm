package top.ningg.algo.tree;

import java.util.LinkedList;
import top.ningg.algo.model.TreeNode;

public class GetWidth {

    /**
     * 计算二叉树的宽度
     *
     * @param root 二叉树的根节点
     * @return 二叉树的宽度（所有分层中，节点数最多的分层）
     */
    public static int getWidth(TreeNode root) {

        if (null == root){
            return 0;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);

        int maxWidth = 0;

        while (true){
            int currLevelSize = nodeList.size();

            if (0 == currLevelSize){
                break;
            }

            // 内部分层遍历
            while (currLevelSize > 0){
                TreeNode currNode = nodeList.poll();
                currLevelSize --;
                if (null != currNode.left){
                    nodeList.add(currNode.left);
                }
                if (null != currNode.right){
                    nodeList.add(currNode.right);
                }
            }

            maxWidth = Math.max(maxWidth, nodeList.size());
        }

        return maxWidth;

    }

}
