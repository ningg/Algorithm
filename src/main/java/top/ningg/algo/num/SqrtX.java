package top.ningg.algo.num;

/**
 * 题目： 计算整型数字 x 的开根号取值， sqrt(int x).
 *
 * 更多细节，参考：https://www.cnblogs.com/springfor/p/3857772.html
 */
public class SqrtX {

    public static int sqrt(int x) {

        if (x == 0 || x == 1){
            return x;
        }

        int high = x;
        int low = 1;
        int awnser = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid <= x/mid) {
                awnser = mid;
                low = mid +1;
            } else {
                high = mid - 1;
            }
        }

        return awnser;
    }

}
