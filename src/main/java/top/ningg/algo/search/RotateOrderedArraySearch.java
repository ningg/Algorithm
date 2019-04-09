package top.ningg.algo.search;

/**
 * 题目: 有序的旋转数组, 查找目标取值.
 *
 * 更多细节: https://blog.csdn.net/lclansefengbao/article/details/37591609
 */
public class RotateOrderedArraySearch {

    /**
     * 从有序的「旋转数组」中, 查找指定的取值, 返回对应的下标。
     *
     * @param array 有序的旋转数组
     * @param destValue 目标值
     * @return 如果目标值存在, 则, 返回指定的下标
     */
    public static int findValue(int[] array, int destValue) {
        // 1. 边界判断
        if (null == array) {
            return -1;
        }

        // 2. 查找目标取值
        return binarySearch(array, 0, array.length - 1, destValue);
    }

    public static int binarySearch(int[] array, int start, int end, int destValue) {
        // 1. 边界判断
        if (null == array) {
            return -1;
        }

        // 2. 终止判断
        if (start > end) {
            return -1;
        }

        // 3. 递归
        int middle = (start + end) / 2;
        // a. 找到目标取值
        if (array[middle] == destValue) {
            return middle;
        }

        // b. 判断循环数组的左右
        if (array[middle] > array[start]) {// 左边有序
            if (array[middle] > destValue && destValue >= array[start]) {
                return binarySearch(array, start, middle - 1, destValue);
            } else {
                return binarySearch(array, middle + 1, end, destValue);
            }
        } else { // 右边有序
            if (array[middle] < destValue && destValue <= array[end]) {
                return binarySearch(array, middle + 1, end, destValue);
            } else {
                return binarySearch(array, start, middle - 1, destValue);
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {5,6,7,8,9,1,2,2,2};
        int destValue = 7;

        System.out.println(findValue(array, destValue));
    }

}
