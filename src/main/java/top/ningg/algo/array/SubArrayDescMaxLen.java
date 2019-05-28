package top.ningg.algo.array;

import java.util.Arrays;

/**
 * 题目：最长递减子序列（不要求连续）
 *
 * 分析：动态规划，整理其「状态转移函数」
 *
 * 定义：
 *
 * 1.max[i]：第 i 位之前，最长递减子序列的长度
 * 2.maxSuffix[i]：第 i 位之前，且包含第 i 位的，最长递减子序列的长度
 *
 * 状态转移函数：第 i +1 位，初始 max[i+1]设置为 1
 *
 * 1.max[i + 1] = Max{max[i+1], maxSuffix[i + 1] }，分为 2 个维度（包含 i + 1 位，不包含 i + 1 位）
 * 2.maxSuffix[i + 1] = Max{ max[k] } + 1，其中 k 属于[0, i]，且 max[k] >= array[i + 1]
 *
 */
public class SubArrayDescMaxLen {

    public static int subArrayDescMaxLen(int[] array) {
        // 边界判断
        if (null == array) {
            return 0;
        }

        // 定义：max[i]
        int len = array.length;
        int[] max = new int[len];
        Arrays.fill(max, 1);

        for (int i = 0; i < len; i++) {
            // 状态转移函数：回溯
            for (int j = 0; j < i; j++) {
                if (array[i] <= array[j]) {
                    max[i] = Math.max(max[i], max[j] + 1);
                }
            }
        }

        return max[len - 1];
    }

    public static void main(String[] args) {
        int[] inputArray = {389, 207, 155, 300, 299, 170, 158, 65};
        int result = subArrayDescMaxLen(inputArray);

        System.out.println(result);
    }

}
