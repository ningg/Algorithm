package top.ningg.algo.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目： 两个有序数组，求其交集
 *
 * 分析：
 *
 * 1. 最暴力的方式：遍历，从数组 A 中(m 个元素)，取出一个元素，在 数组 B 中（n 个元素），逐个比对，存在，则作为交集，时间复杂度 O(m*n)
 * 2. 借助外部存储：将数组 A 中元素，放置到一个 Set 中，然后，遍历数组 B 中元素，判断其是否存在于 Set 中。空间复杂度 O(max(n,m)), 时间复杂度 O(m+n)
 * 3. 使用 2 个指针：因为是有序数组，逐个遍历即可
 *
 * 更多细节，参考： https://blog.csdn.net/codingisforlife/article/details/84309011
 */
public class TwoSortedArrayIntersection {


    /**
     * 获取 2 个数组的交集
     *
     * @param firstArray 第一个数组
     * @param secondArray 第二个数组
     * @return 两个数组的交集
     *
     */
    public static Set<Integer> retrieveIntersection(int[] firstArray, int[] secondArray) {
        // 1. 边界判断
        if (null == firstArray || null == secondArray) {
            return null;
        }

        int firstLen = firstArray.length;
        int secondLen = secondArray.length;

        if (0 == firstLen || 0 == secondLen) {
            return null;
        }

        Set<Integer> intersectionResult = new HashSet<>();

        // 2. 设置 2 个指针，判断两个数，是否相等
        // a. 若取值相等， 则，属于交集中的元素
        int i = 0, j = 0;
        while (i < firstLen && j < secondLen) {
            int firstValue = firstArray[i];
            int secondValue = secondArray[j];

            if (firstValue == secondValue) {
                intersectionResult.add(firstValue);
                i++;
                j++;
            } else if (firstValue < secondValue) {
                i++;
            } else {
                j++;
            }
        }

        return intersectionResult;
    }


    /**
     * 获取 2 个数组的交集(借助外部 Set 存储)
     *
     * @param firstArray 第一个数组
     * @param secondArray 第二个数组
     * @return 两个数组的交集
     */
    public static Set<Integer> retrieveIntersectionWithSet(int[] firstArray, int[] secondArray) {

        // 1. 边界判断
        if (null == firstArray || null == secondArray) {
            return null;
        }

        int firstLen = firstArray.length;
        int secondLen = secondArray.length;
        if (0 == firstLen || 0 == secondLen) {
            return null;
        }

        // 2. 遍历：存储 firstArray
        Set<Integer> currSet = new HashSet<>();
        for (int i = 0; i < firstLen; i++) {
            currSet.add(firstArray[i]);
        }

        Set<Integer> intersectionResult = new HashSet<>();
        // 3. 获取交集
        for (int i = 0; i < secondLen; i++) {
            if (currSet.contains(secondArray[i])) {
                intersectionResult.add(secondArray[i]);
            }
        }

        return intersectionResult;
    }

}
