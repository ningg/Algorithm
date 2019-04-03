package top.ningg.algo.sort;

/**
 * 题目: 冒泡排序
 *
 * 基本思路，相邻的两个元素进行比较，将较大的元素后移，一次遍历，能够得到最大的元素，递归下去；具体过程：
 *
 * 1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 1. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 1. 针对所有的元素重复以上的步骤，除了最后一个。
 * 1. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
 *
 * 最优时间：`O(n^2)`，最差时间：`O(n^2)`
 */
public class BubbleSort {


    public static int[] bubbleSort(int[] array) {
        // 1. 边界判断
        if (null == array) {
            return array;
        }

        // 冒泡思路:
        // 1. 逐个遍历
        // a. 从后向前冒泡, 最小的取值
        // b. 遍历的位置, 后移一位

        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int array[] = {3, 4, 5, 1, 2, 9};

        bubbleSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
