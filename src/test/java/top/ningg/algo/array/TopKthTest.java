package top.ningg.algo.array;

import com.alibaba.fastjson.JSON;

public class TopKthTest {

    // 方法 A： 选择排序，时间复杂度 O(kn)
    public static int[] topKth(int[] array, int k) {

        if (null == array || k <= 0) {
            return null;
        }

        int length = array.length;
        if (k >= length) {
            return array;
        }

        // 选择排序：选择 k 次，每次选择最大的元素
        for (int i = 0; i < k; i++) {
            int tmp = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] > array[tmp]) {
                    tmp = j;
                }
            }

            // 交换元素
            if (i != tmp) {
                int tmpValue = array[i];
                array[i] = array[tmp];
                array[tmp] = tmpValue;
            }
        }

        return array;
    }

    /**
     * 方法 B：快速排序, 时间复杂度 O(n * log(k))
     *
     * @param array 输入数组
     * @param k 目标 top k 的值
     * @return 对应数组的下标位置
     */
    public static int topKthQuickSort(int[] array, int left, int right, int k) {
        if (null == array) {
            return -1;
        }

        int len = array.length;
        if (k >= len) {
            return len - 1;
        }

        int currIndex = quickSort(array, left, right);
        int foundLen = (currIndex - left) + 1;

        if (foundLen == k) {
            return currIndex;
        } else if (foundLen < k) {
            return topKthQuickSort(array, currIndex + 1, right, k - foundLen);
        } else {
            return topKthQuickSort(array, left, currIndex - 1, k);
        }

    }

    public static int quickSort(int[] array, int left, int right) {

        if (null == array) {
            return -1;
        }

        if (left >= right) {
            return left;
        }

        int pivot = array[left];
        int i = left;
        int j = right;

        while (i < j) {
            while (array[j] < pivot && i < j) {
                j--;
            }
            while (array[i] > pivot && i < j) {
                i++;
            }

            if (i != j) {
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
            }
        }

        // 外侧交换取值
        array[left] = array[i];
        array[i] = pivot;

        // 真正的快速排序
        // quickSort(array, left, i -1);
        // quickSort(array, i + 1, right);

        return i;
    }


    public static void main(String[] args) {
        int[] array = {5, 6, 8, 2, 3, 4, 5};
        int k = 4;

        int result = topKthQuickSort(array, 0, array.length - 1, k);

        System.out.println(JSON.toJSON(array));
        System.out.println(JSON.toJSON(result));
    }

}
