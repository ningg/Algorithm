package top.ningg.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import top.ningg.algo.model.TreeNode;

public class PathSumTest {

    public static boolean pathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }

        if (null == root.left && null == root.right) {
            if (root.value == sum) {
                return true;
            }
        }

        boolean leftFound = pathSum(root.left, sum - root.value);
        boolean rightFound = pathSum(root.right, sum - root.value);

        return leftFound || rightFound;
    }

    public static List<TreeNode> list = new ArrayList<>();
    public static List<List<TreeNode>> listAll = new LinkedList<>();

    public static List<List<TreeNode>> findPath(TreeNode root, int sum) {
        if (null == root) {
            return listAll;
        }

        list.add(root);

        if (null == root.left && null == root.right) {
            if (root.value == sum) {
                listAll.add(new ArrayList<>(list));
            }
        }

        findPath(root.left, sum - root.value);
        findPath(root.right, sum - root.value);

        list.remove(list.size() - 1);

        return listAll;
    }

}
