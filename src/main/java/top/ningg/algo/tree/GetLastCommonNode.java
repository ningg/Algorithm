package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

/**
 * 场景: 求二叉树中两个节点的最低公共祖先节点
 *
 * 递归解法：
 *
 * 1. 如果两个节点分别在根节点的左子树和右子树，则返回根节点
 * 1. 如果两个节点都在左子树，则递归处理左子树；如果两个节点都在右子树，则递归处理右子树
 */
public class GetLastCommonNode {


    public static TreeNode getLastCommonNode(TreeNode pRoot, TreeNode pNode1, TreeNode pNode2) {
        // 边界判断
        if (null == pRoot || null == pNode1 || null == pNode2) {
            return null;
        }

        if (findNode(pRoot.left, pNode1)) {
            if (findNode(pRoot.right, pNode2)) {
                return pRoot;
            } else {
                return getLastCommonNode(pRoot.left, pNode1, pNode2);
            }
        } else if (findNode(pRoot.right, pNode1)) {
            if (findNode(pRoot.left, pNode2)) {
                return pRoot;
            } else {
                return getLastCommonNode(pRoot.right, pNode1, pNode2);
            }
        }

        return null;
    }

    /**
     * 判断 Node 是否属于二叉树:
     *
     * 1. 边界判断: 二叉树和 Node, 有一个为 null, 则, 不属于
     * 2. 终止条件: 二叉树上节点跟目标 Node 的引用完全相等, 则, 属于
     * 3. 迭代执行: 分别判断 Node 是否属于二叉树的左子树、右子树
     *
     * @param pRoot 二叉树根节点
     * @param pNode 目标 Node
     * @return Node 是否属于二叉树
     */
    public static boolean findNode(TreeNode pRoot, TreeNode pNode) {

        // 1. 边界判断
        if (null == pRoot || null == pNode) {
            return false;
        }

        // 2. 终止条件
        if (pRoot == pNode) {
            return true;
        }

        // 3. 迭代: 先判断左子树, 再判断右子树
        boolean found = findNode(pRoot.left, pNode);
        if (!found) {
            found = findNode(pRoot.right, pNode);
        }

        return found;
    }
}
