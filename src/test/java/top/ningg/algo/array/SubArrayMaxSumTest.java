package top.ningg.algo.array;

public class SubArrayMaxSumTest {


    public static int subArrayMaxSum(int[] array) {
        if (null == array) {
            return -1;
        }

        int len = array.length;
        int maxSum[] = new int[len];
        int maxSumSuffix[] = new int[len];

        maxSum[0] = array[0];
        maxSumSuffix[0] = array[0];

        // 动态规划：无后效性
        for (int i = 1; i < len; i++) {
            maxSumSuffix[i] = Math.max(array[i], maxSumSuffix[i - 1] + array[i]);
            maxSum[i] = Math.max(maxSum[i - 1], maxSumSuffix[i]);
        }

        return maxSum[len - 1];
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, -1, -3, 1, 2, 1};
        int result = subArrayMaxSum(array);

        System.out.println(result);
    }

}
