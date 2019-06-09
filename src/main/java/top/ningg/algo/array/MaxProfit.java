package top.ningg.algo.array;

/**
 * 题目：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可获得的最大利润是多少？
 *
 * 例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能获得最大的利润为11.
 *
 * 问题：
 *
 * 1. 只能进行 1 次买卖，最大利润，是多少？
 * 2. 可以进行多次买卖，单日也可以同时进行买卖，则，最大利润，又是多少？
 *
 * 参考资料：
 *
 * - https://blog.csdn.net/Koala_Tree/article/details/79728591
 */
public class MaxProfit {

    /**
     * 题目：只能进行 1 次买卖.
     */
    public static int maxProfitSingle(int[] array) {
        if (null == array) {
            return 0;
        }

        int len = array.length;
        if (0 == len || 1 == len) {
            return 0;
        }

        int minValue = array[0];

        int maxProfitArray[] = new int[len];
        maxProfitArray[0] = 0;

        for (int i = 1; i < len; i++) {
            maxProfitArray[i] = Math.max(maxProfitArray[i - 1], array[i] - minValue);
            minValue = Math.min(minValue, array[i]);
        }

        return maxProfitArray[len - 1];
    }

    /**
     * 题目：可以进行多次买卖
     */
    public static int maxProfitMulti(int[] array) {
        if (null == array) {
            return 0;
        }

        int len = array.length;
        if (len == 0) {
            return 0;
        }

        int maxProfit = 0;
        for (int i = 1; i < len; i++) {
            int currProfit = array[i] - array[i - 1];
            if (currProfit > 0) {
                maxProfit += currProfit;
            }
        }

        return maxProfit;
    }


}
