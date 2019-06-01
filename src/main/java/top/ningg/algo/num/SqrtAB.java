package top.ningg.algo.num;

/**
 * 题目：计算一个数的平方根，保留 b 位小数
 *
 * 参考来源：
 *
 * - http://bigdatadecode.club/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E7%AE%97%E6%B3%95%E4%B9%8Bn%E7%9A%84%E5%B9%B3%E6%96%B9%E6%A0%B9%E4%BF%9D%E7%95%99m%E4%BD%8D%E5%B0%8F%E6%95%B0.html
 * - http://www.voidcn.com/article/p-zaiapvmu-bkd.html
 */
public class SqrtAB {


    public static double sqrt(int x, int precision) {
        if (x == 0 || x == 1) {
            return x;
        }

        // 最小精度
        double precisionValue = 0;
        for (int i = 0; i < precision; i++) {
            precisionValue *= 0.1;
        }

        double low = 1;
        double high = x;
        while (low <= high) {
            double mid = low + (high - low) / 2.0;
            if (Math.abs(mid - x / mid) <= precision) {
                return mid;
            }

            if (mid <= x / mid) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return -1;
    }

}
