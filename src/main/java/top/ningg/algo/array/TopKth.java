package top.ningg.algo.array;

import top.ningg.algo.sort.QuickSort;

/**
 * 题目: 一个数组, 求其中最大的 k 个数。
 *
 * 分析:
 *
 * 方案 A: 先排序, 然后取其中 k 个数, 时间复杂度 O(n*lg(n))
 *
 * 方案 B: 直接选择排序, 选择出其中 k 个数, 时间复杂度 O(k*n)
 *
 * 方案 C: 利用快排思想，定位出其中的 k 个数, 时间复杂度 O(lg(k)*n)
 *
 * 方案 D: 利用堆排序, 当 N 特别大时, 用此方法, 时间复杂度 O(lg(k)*n)
 *
 *
 * 参考资料:
 *
 * - https://blog.csdn.net/jnulzl/article/details/50989430
 * - http://www.cnblogs.com/mengdd/archive/2013/03/12/2954914.html
 *
 */
public class TopKth {



    public static int getTopKth(int[] array, int left, int right, int k){
        // 边界判断
        if (null == array || left > right || k <= 0){
            throw new RuntimeException("Error: input error");
        }

        int currPosition = quickSort(array, left, right);
        int foundLen = (currPosition - left) + 1;

        if (foundLen == k){
            return array[currPosition];
        } else if ( foundLen < k){
            return getTopKth(array, currPosition + 1, right, k - foundLen);
        } else {
            return getTopKth(array, left, currPosition - 1, k);
        }

    }


    // 针对「数组」的一段取值, 进行快速排序
    public static int quickSort(int[] array, int left, int right) {

        // 边界判断
        if (left >= right) {
            return left;
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

        // 放开下述注释代码, 同时, 设置返回值为 void, 则, 就是完整的「快排代码」
        // quickSortSegment(array, left, i - 1);
        // quickSortSegment(array, i + 1, right);

        return i;
    }

    public static void main(String[] args) {
        int array[] = {3, 4, 2, 1, 3, 5, 1, 2, 9};

        int result = getTopKth(array, 0, array.length - 1, 3);

        System.out.println(result);
    }

}
