package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

/**
 * 题目: 输入两棵二叉树A和B，判断B是不是A的子结构。
 *
 * 分为几点：遍历二叉树、判断两个二叉树是包含；
 *
 * 1. 边界判断: 二叉树 B 为 null, 则, true
 * 2. 边界判断: 二叉树 A 为 null, 则, false
 * 3. 终止条件: 二叉树 A 和 二叉树 B, 当前节点 value 相等, 则, 以当前版本为基点, 判断二叉树 B 是否属于二叉树 A
 * 4. 迭代执行: 二叉树 B 是否属于二叉树 A 左子树的子结构 or 二叉树 A 的右子树
 */
public class SubStructure {


    public static boolean isSubStructure(TreeNode pTreeA, TreeNode pTreeB) {
        // 1. 边界判断
        if (null == pTreeB) {
            return true;
        }

        if (null == pTreeA) {
            return false;
        }

        // 2. 终止条件
        if (pTreeA.value == pTreeB.value) {
            return doesTreeAhaveTreeB(pTreeA, pTreeB);
        }

        boolean result = isSubStructure(pTreeA.left, pTreeB);
        if (!result) {
            result = isSubStructure(pTreeA.right, pTreeB);
        }

        return result;
    }

    public static boolean doesTreeAhaveTreeB(TreeNode pRootA, TreeNode pRootB) {
        // 1. 边界判断
        if (null == pRootB) {
            return true;
        }
        if (null == pRootA) {
            return false;
        }

        // 2. 迭代
        if (pRootA.value == pRootB.value) {
            return doesTreeAhaveTreeB(pRootA.left, pRootB.left) && doesTreeAhaveTreeB(pRootA.right, pRootB.right);
        }

        return false;
    }
}
