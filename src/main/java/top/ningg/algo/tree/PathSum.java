package top.ningg.algo.tree;

import java.util.ArrayList;
import top.ningg.algo.model.TreeNode;

/**
 * 题目：二叉树，路径和为固定值
 *
 * 1. 判断：是否存在路径
 * 2. 输出满足条件的路径
 */
public class PathSum {

    /**
     * 判断：是否存在路径，路径和为指定值.
     */
    public static boolean hasPathSatisfySum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }

        // 终止条件：叶子节点
        if (root.left == null && root.right == null) {
            if (sum == root.value) {
                return true;
            }
        }

        // 迭代判断
        int delta = sum - root.value;
        boolean leftResult = hasPathSatisfySum(root.left, delta);
        boolean rightResult = hasPathSatisfySum(root.right, delta);

        return leftResult || rightResult;
    }

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    /**
     * 输出满足条件的路径
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }

        list.add(root.value);

        // 终止条件
        int delta = target - root.value;
        if (delta == 0) {
            if (root.left == null && root.right == null) {
                listAll.add(new ArrayList<Integer>(list));
            }
        }

        // 迭代
        FindPath(root.left, target);
        FindPath(root.right, target);

        // 移除当前节点
        list.remove(list.size() - 1);
        return listAll;
    }

}
