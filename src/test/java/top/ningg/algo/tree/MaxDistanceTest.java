package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

public class MaxDistanceTest {

    public static int maxDistance = -1;


    /**
     * 计算「根节点」到子节点的最大距离
     *
     * @param root 根节点
     */
    public static int calculateMaxDistance(TreeNode root) {
        if (null == root) {
            return -1;
        }

        if (null == root.right && null == root.left) {
            return 0;
        }

        int maxDistanceOfLeft = calculateMaxDistance(root.left);
        int maxDistanceOfRight = calculateMaxDistance(root.right);

        maxDistance = Math.max(maxDistance, maxDistanceOfLeft + maxDistanceOfRight + 2);

        return Math.max(maxDistanceOfLeft, maxDistanceOfRight);
    }

}
