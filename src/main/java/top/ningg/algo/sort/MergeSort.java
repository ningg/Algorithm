package top.ningg.algo.sort;

/**
 * 题目: 归并排序.
 *
 * Tips: (二分递归)递归 + 合并
 */
public class MergeSort {

    // 1. 边界判断
    public static void mergeSort(int[] array) {
        if (null == array) {
            return;
        }

        // 2. 递归
        int length = array.length;
        mergeSortLoop(array, 0, length - 1);
    }

    public static void mergeSortLoop(int[] array, int left, int right) {
        // 1. 边界判断
        if (null == array) {
            return;
        }
        if (left >= right) {
            return;
        }

        // 2. 分治
        int middle = (left + right) / 2;
        mergeSortLoop(array, left, middle);
        mergeSortLoop(array, middle + 1, right);

        // 3. 合并
        merge(array, left, middle, right);
    }

    /**
     * 合并 2 个有序数组
     *
     * @param array 数组
     * @param left 左下标
     * @param middle 中间分割下标
     * @param right 最后的下标
     */
    public static void merge(int[] array, int left, int middle, int right) {

        // 1. 边界判断
        if (null == array) {
            return;
        }

        // 2. 预分配空间
        int[] tmp = new int[right - left + 1];

        // 3. 三个指针, 进行 2 有有序数组的归并排序
        int former = left;
        int latter = middle + 1;
        int tmpIndex = 0;

        while (former <= middle && latter <= right) {
            if (array[former] <= array[latter]) {
                tmp[tmpIndex] = array[former];
                former++;
            } else {
                tmp[tmpIndex] = array[latter];
                latter++;
            }
            tmpIndex++;
        }

        // 后续预留的数组内容, 整理
        while (former <= middle) {
            tmp[tmpIndex] = array[former];
            tmpIndex++;
            former++;
        }
        while (latter <= right) {
            tmp[tmpIndex] = array[latter];
            tmpIndex++;
            latter++;
        }

        // 更换空间
        int start = left;
        for (int index = 0; index < tmp.length; index++) {
            array[start] = tmp[index];
            start++;
        }
    }

    public static void main(String[] args) {
        int array[] = {3, 4, 2, 1, 3, 5, 1, 2, 9};

        mergeSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
