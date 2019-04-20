package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

/**
 * 题目: 二叉树, 计算节点之间的最大距离。
 *
 * 分析: 从 一个节点、2 个节点、3 个节点, 画图进行分析。
 *
 *
 * 方案 A: 迭代的角度, 从结果来看
 *
 * 1. 两个节点: 分别位于 2 个子树上, 则, 两个子树的深度 + 2
 * 2. 两个节点: 位于同一个子树上, 则, 迭代即可
 *
 *
 * 方案 B: 最终特征,来看
 *
 * 1. 最远的两个节点, 一定以「某个节点」作为 root, 分布在其两个子树上, 求 2 个子树深度, 然后求和即可。
 *
 * 参考:
 *
 * - https://caoxyemail.iteye.com/blog/2129866
 * - https://blog.csdn.net/liuyi1207164339/article/details/50898902
 */
public class MaxDistance {


    public static int maxLen = -1;


    /**
     * 以当前节点作为「root」完整二叉树, 其距离其下所有节点的最远距离
     *
     * @param root 根节点
     * @return 当前二叉树下, 距离 root 节点的最远距离
     */
    public static int calculateMaxDistance(TreeNode root) {

        // 只有 1 个节点时, 距离为 0; 因此, 为 null 时, 距离为 -1;
        // 终止条件
        if (null == root) {
            return -1;
        }

        // 分别计算: 左子树、右子树的最大距离
        int leftDistance = calculateMaxDistance(root.left);
        int rightDistance = calculateMaxDistance(root.right);

        //如果以该节点为根的子树中有最大的距离，那就更新最大距离
        int sumDistance = leftDistance + rightDistance + 2;
        if (sumDistance > maxLen) {
            maxLen = sumDistance;
        }

        return Math.max(leftDistance, rightDistance) + 1;
    }

}
