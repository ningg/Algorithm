package top.ningg.algo.sort;

/**
 * 题目: 快速排序
 *
 * 基本思路: 分治思想，递归分为两个分区，则，时间复杂度为O(n*log(n))；对于已经排序好的数组，此时，快排算法的时间复杂度最差，为O(n^2)；
 *
 * 特别说明，快排算法的一个关键点是如何选取基准，巧妙的设计能够降低时间复杂度的细数。
 *
 * 具体步骤要点:
 *
 * 1. 选取的基准为`首元素`
 * 2. 两个指针，`i`从头、`j`从尾
 * 3. 由于选用的是`首元素`，则，从尾部`j`开始移动
 * 4. 如果尾部`j`发现小于`首元素`的内容，则，移动`i`，等到`i`定位到大于`首元素`的内容时，交换`i`和`j`的内容
 * 5. 当`i == j`，即，两个指针相遇时，交换`首元素`与`i`对应位置的内容
 * 6. 以`i`对应下标为分割，分别对两个子数组，进行递归排序
 */
public class QuickSort {

    public static void quickSort(int[] array) {
        // 1. 边界判断
        if (null == array) {
            return;
        }

        // 分治思想: 快排
        int length = array.length;
        quickSortSegment(array, 0, length - 1);
    }

    // 针对「数组」的一段取值, 进行快速排序
    public static void quickSortSegment(int[] array, int left, int right) {

        // 边界判断
        if (left >= right) {
            return;
        }

        // 1. 选取基准
        int pivot = array[left];

        // 2. 分治: 二分,
        // a. 从后向前遍历, 找出比 pivot 小的元素
        // b. 从前向后遍历, 找出比 pivot 大的元素
        // c. 如果两个指针, 不相等, 则, 交换两个指针的取值
        // d. 将取值基准 pivot, 跟二分的中间点, 交换取值
        // e. 迭代上述过程
        int i = left;
        int j = right;

        while (i < j) {
            while (pivot <= array[j] && i < j) {
                j--;
            }

            while (pivot >= array[i] && i < j) {
                i++;
            }

            if (i < j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }

        // 调整
        array[left] = array[i];
        array[i] = pivot;

        quickSortSegment(array, left, i - 1);
        quickSortSegment(array, i + 1, right);
    }

    public static void main(String[] args) {
        int array[] = {3, 4, 2, 1, 3, 5, 1, 2, 9};

        quickSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
