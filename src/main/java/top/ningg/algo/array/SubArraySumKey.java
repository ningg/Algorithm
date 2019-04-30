package top.ningg.algo.array;

import java.util.HashMap;

/**
 * 题目: 连续子数组，和为固定值 key，求连续子数组的最大长度
 *
 * TODO: 整理独立的博文
 *
 * 备注:
 * 下述代码, 「Map中」只保留了「第一次出现取值的 prefixSum」, 这并不会影响最终的 maxLen,
 * 因为 maxLen 计算过程中, 利用了「后续出现取值的 prefixSum」。
 */
public class SubArraySumKey {

    public static int subArraySumKeyMaxLen(int[] array, int destKey) {
        // 1. 边界判断
        if (null == array) {
            return -1;
        }

        // 2. 求数组的「前缀和」,并保存到 Map 中, 同时, 统计最大的 Len
        HashMap<Integer, Integer> prefixSumArray = new HashMap<>();
        int prefixSum = 0;
        // a. 设置基准点
        prefixSumArray.put(0, -1);

        int maxLen = 0;

        for (int index = 0; index < array.length; index++) {
            prefixSum += array[index];
            // b. 判断目标取值是否存在, 若存在, 则,更新 maxLen
            int delta = prefixSum - destKey;
            if (prefixSumArray.containsKey(delta)) {
                int deltaIndex = prefixSumArray.get(delta);
                maxLen = Math.max(index - deltaIndex, maxLen);
            }

            // c. 判断当前「前缀和」, 是否存在, 若不存在, 则, 添加到 HashMap 中
            if (!prefixSumArray.containsKey(prefixSum)) {
                prefixSumArray.put(prefixSum, index);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] inputArray = {1, 3, 4, 5, 8, 5};
        int destValue = 13;

        int result = subArraySumKeyMaxLen(inputArray, destValue);
        System.out.println(result);
    }
}
