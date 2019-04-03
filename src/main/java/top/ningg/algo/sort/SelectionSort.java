package top.ningg.algo.sort;

/**
 * 题目: 选择排序
 *
 * 基本思路: '从前向后'遍历
 *
 * 1. 每次从数组的后续元素中, 选择一个最小的数字；
 * 1. 递归上述步骤；
 */
public class SelectionSort {


    public static int[] selectionSort(int array[]) {
        // 1. 边界判断
        if (null == array) {
            return null;
        }

        int length = array.length;

        // 2. 从前向后遍历
        // a. 基于当前元素触发, 每次选择出最小的元素下标
        // b. 交换当前元素,跟最小下标元素
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }

            // 判断是否需要交换元素
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int array[] = {3, 4, 5, 1, 2, 9};

        selectionSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
