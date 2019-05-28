package top.ningg.algo.array;

import java.util.HashMap;

public class SubArraySumKeyTest {

    public static int subArraySumKey(int[] array, int destKey) {
        if (null == array) {
            return -1;
        }

        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1);

        int len = array.length;

        int prefixSum = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            prefixSum += array[i];

            int deltaValue = prefixSum - destKey;
            if (prefixSumMap.containsKey(deltaValue)) {
                int index = prefixSumMap.get(deltaValue);
                maxLen = Math.max(maxLen, i - index + 1);
            }

            // 维护前缀和数列
            if (!prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.put(prefixSum, i);
            }
        }

        return maxLen;
    }

}
