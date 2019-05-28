package top.ningg.algo.array;

public class CoinChangeTest {

    public static int coinChange(int[] coins, int amount) {
        if (null == coins) {
            return -1;
        }
        if (amount <= 0) {
            return -1;
        }

        int len = coins.length;
        for (int i = 0; i < len; i++) {
            if (coins[i] == amount) {
                return 1;
            }
        }

        int deltaAmounts[] = new int[len];
        for (int i = 0; i < len; i++) {
            deltaAmounts[i] = coinChange(coins, amount - coins[i]);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int deltaAmount = deltaAmounts[i];
            if (deltaAmount > 0) {
                min = Math.min(min, deltaAmount);
            }
        }

        return (min == Integer.MAX_VALUE) ? -1 : (min + 1);
    }

}
