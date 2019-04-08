package top.ningg.algo.search;

/**
 * 题目: 二分查找
 *
 * 要点:
 *
 * 1. 二分查找，针对已经排序好的数组
 * 2. 时间复杂度：`O(logn)`
 */
public class BinarySearch {

    /**
     * 从「有序数组」(升序)中, 查询是否存在指定的数字
     *
     * @param array 有序数组, 升序
     * @param start 前置下标
     * @param end 末位下标
     * @param destValue 目标数值
     * @return 数组中, 是否存在目标数值
     */
    public static boolean binarySearch(int[] array, int start, int end, int destValue) {
        // 1. 边界判断
        if (null == array) {
            return false;
        }
        if (start > end) {
            return false;
        }

        int middle = (start + end) / 2;

        if (array[middle] == destValue) {
            return true;
        } else if (array[middle] > destValue) {
            return binarySearch(array, start, middle - 1, destValue);
        } else {
            return binarySearch(array, middle + 1, end, destValue);
        }
    }

    public static boolean binarySearchLoop(int[] array, int start, int end, int destValue) {
        // 1. 边界判断
        if (null == array) {
            return false;
        }
        if (start > end) {
            return false;
        }

        while (start <= end) {
            int middle = (start + end) / 2;
            if (array[middle] == destValue) {
                return true;
            } else if (array[middle] > destValue) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6, 7, 8, 9, 10};
        int destValue = 4;

        System.out.println(binarySearchLoop(array, 0, array.length - 1, destValue));
    }

}
