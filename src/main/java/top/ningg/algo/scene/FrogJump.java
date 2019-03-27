package top.ningg.algo.scene;

/**
 * 场景1：一只青蛙一次可以跳上 1 级台阶，也可以跳上2 级。求该青蛙跳上一个n 级的台阶总共有多少种跳法？
 *
 * 场景2：一只青蛙一次可以跳上1级台阶，也可以跳上2 级……它也可以跳上 m 级，此时该青蛙跳上一个n级的台阶总共有多少种跳法？
 */
public class FrogJump {

    /**
     * 场景 1: 递归方法
     *
     * @param n 台阶数
     * @return 跳法的数量
     */
    public int jump0(int n) {

        // 1. 边界检查
        if (n <= 0) {
            return -1;
        }

        // 2. 终止条件
        if (n == 1 || n == 2) {
            return n;
        }

        // 3. 递归判断
        return jump0(n - 1) + jump0(n - 2);
    }

    /**
     * 场景 1: 非递归方法
     *
     * @param n 台阶数
     * @return 跳法的数量
     */
    public int jump0For(int n) {
        // 1. 边界判断
        if (n <= 0) {
            return -1;
        }

        // 2. 终止条件
        if (n == 1 || n == 2) {
            return n;
        }

        // 3. 循环计算
        int former = 1;
        int latter = 2;
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = former + latter;
            former = latter;
            latter = result;
        }

        return result;
    }

    /**
     * 场景 2: 递归方法
     *
     * @param n 目标的台阶数
     * @param m 每次做多跳跃台阶数
     * @return 跳法的数量
     */
    public int jumpM(int n, int m) {

        // 1. 边界判断
        if (n <= 0 || m <= 0) {
            return -1;
        }

        // 2. 终止条件
        if (m >= n) {
            return 1 << (n - 1);
        }

        // 3. 迭代条件
        return 2 * jumpM(n - 1, m) - jumpM(n - 1 - m, m);
    }

}
