package top.ningg.algo.array;

/**
 * 题目：数组的连续子数组最大和.
 *
 * 分析: 动态规划
 *
 * - 迭代:
 * -- a. 涵盖当前节点
 * -- b. 不涵盖当前节点
 *
 * 参考:
 *
 * - https://blog.csdn.net/u013132035/article/details/80697338
 * - https://bylijinnan.iteye.com/blog/1343170
 *
 */
public class SubArrayMaxSum {


    public static int maxSum(int[] array) {
        // 边界判断
        if (null == array) {
            throw new RuntimeException("Error: input is null");
        }

        int len = array.length;

        int[] maxSum = new int[len];
        int[] maxSumContains = new int[len];

        maxSum[0] = array[0];
        maxSumContains[0] = array[0];

        for (int i = 1; i < len; i++) {
            maxSumContains[i] = Math.max(array[i], maxSumContains[i - 1] + array[i]);
            maxSum[i] = Math.max(maxSum[i - 1], maxSumContains[i]);
        }

        return maxSum[len - 1];
    }

    public static void main(String[] args) {
        int[] array = {-1, -2, -3, -10};

        System.out.println(maxSum(array));
    }
}
