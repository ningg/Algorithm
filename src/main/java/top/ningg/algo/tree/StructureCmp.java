package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

/**
 * 题目: 判断两棵「二叉树」, 是否结构相同
 *
 * 递归解法：
 *
 * 1. 如果两棵二叉树都为空，返回真
 * 2. 如果两棵二叉树一棵为空，另一棵不为空，返回假
 * 3. 如果两棵二叉树都不为空：
 * a. 判断节点取值是否相同，若不相同，则返回假
 * b. 若节点取值相同，则判断对应的「左子树」和「右子树」都同构返回真，其他返回假
 *
 */
public class StructureCmp {


    public static boolean structureCmp(TreeNode pRootA, TreeNode pRootB) {

        // 1. 终止条件
        if (null == pRootA && null == pRootB) {
            return true;
        } else if (null == pRootA || null == pRootB) {
            return false;
        }

        // 2. 迭代
        if (pRootA.value == pRootB.value) {
            boolean leftStructure = structureCmp(pRootA.left, pRootB.left);
            boolean rightStructure = structureCmp(pRootA.right, pRootB.right);

            return leftStructure && rightStructure;
        }

        return false;
    }

}
