package top.ningg.algo.array;

import java.util.Arrays;

/**
 * 题目： 给定不同面额的硬币 coins 和一个总金额 amount。
 * 1. 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 2. 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 思路：总金额为 n 的最少硬币兑换： f(n) = min{f(n - j)} +1，其中 j 取值（不同的硬币面额）
 *
 * 本质就是：amount 目标金额是否属于上述「序列」。
 *
 * 整体，2 种实现思路：
 *
 * 1. 自顶向下：迭代计算，需要设定终止条件
 * 2. 自底向上：从前向后，逐个存储并计算
 */
public class CoinChange {

    /**
     * 自顶向下，迭代计算。
     *
     * @param coins 不同面额的数组
     * @param amount 兑换金额
     * @return 所需硬币的最少数量
     */
    public static int coinChangeLoop(int[] coins, int amount) {
        // 边界判断
        if (null == coins || amount <= 0) {
            return -1;
        }

        // 终止条件
        int len = coins.length;
        for (int coin : coins) {
            if (coin == amount) {
                return 1;
            }
        }

        // 迭代
        int[] deltaAmounts = new int[len];
        for (int i = 0; i < len; i++) {
            deltaAmounts[i] = coinChangeLoop(coins, amount - coins[i]);
        }

        // 返回结果
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int currValue = deltaAmounts[i];
            // 此处有：合规匹配
            if (currValue > 0) {
                if (currValue < min) {
                    min = currValue;
                }
            }
        }

        return (min == Integer.MAX_VALUE) ? -1 : (min + 1);
    }

    /**
     * 自底向上，逐个计算潜在金额，并匹配目标金额.
     *
     * 实现：使用「外部存储」，下标表示目标金额，存储值表示最少硬币数量.
     *
     * @param coins 不同面额的数组
     * @param amount 兑换金额
     * @return 所需硬币的最少数量
     */
    public static int coinChange(int[] coins, int amount) {
        // 边界判断
        if (null == coins || amount <= 0) {
            return -1;
        }

        // 借助外部存储: 存储金额对应的硬币数量
        int max = amount + 1;
        int[] dps = new int[amount + 1];
        Arrays.fill(dps, max);
        // 设置起始条件
        dps[0] = 0;

        // 从前向后，逐步更新
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                int delta = i - coin;
                if (delta < 0) {
                    continue;
                }
                dps[i] = Math.min(dps[i], dps[delta] + 1);
            }
        }

        return (dps[amount] > amount) ? -1 : dps[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50};
        int amount = 7;

        int result = coinChangeLoop(coins, amount);
        System.out.println(result);

        int resultWithLoop = coinChange(coins, amount);
        System.out.println(resultWithLoop);
    }

}
