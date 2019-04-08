package top.ningg.algo.bit;

/**
 * 题目: 计算整数的整数次幂.
 *
 * 思路: 将「整数次幂」, 转换为「二进制表示」方式, 然后, 统计基数相乘
 */
public class ExponentCalculate {


    /**
     * 计算一个数的指数幂
     *
     * @param base 基数
     * @param exponent 次幂
     * @return 结果
     */
    public static int power(int base, int exponent) {

        // 1. 边界输入
        if (exponent == 0) {
            return 1;
        }

        // 2. 转换为二进制表示, 计算每一位上的「基础取值」, 然后乘积
        int tmp = base;
        int result = 1;
        // currExponent >> 1: currExponent / 2
        for (int currExponent = exponent; currExponent > 0; currExponent >>= 1) {
            // currExponent & 0x01 : currExponent % 2
            if ((currExponent & 0x01) == 1) {
                result = result * tmp;
            }

            tmp = tmp * tmp;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(3, 3));
    }

}
