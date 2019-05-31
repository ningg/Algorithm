package top.ningg.algo.tree;

import top.ningg.algo.model.TreeNode;

public class StructCmpTest {


    public static boolean structCmp(TreeNode pRootA, TreeNode pRootB){
        if (null == pRootA && null == pRootB){
            return true;
        } else if (null == pRootA || null == pRootB){
            return false;
        }

        if (pRootA.value == pRootB.value){
            boolean leftEqual = structCmp(pRootA.left, pRootB.left);
            boolean rightEqual = structCmp(pRootA.right, pRootB.right);

            return leftEqual && rightEqual;
        }

        return false;
    }

}
