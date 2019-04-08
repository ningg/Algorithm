package top.ningg.algo.bit;

/**
 * 题目: 一个整数, 换算为二进制表示, 统计其中 1 的个数.
 *
 * 分析:
 *
 * 1. 输入: 整数, 可能为正、也可能为负
 * 2. 统计: 统计二进制中的 1 个数, 本质就是转换为二进制方式, 然后, 逐位计数
 * 3. 要点: 计算中, 一个整数, 本质就是二进制的展示方式, 可以直接使用「按位运算」
 */
public class CountOneBit {

    /**
     * 统计一个整数, 对应二进制表示中, 1 的个数。
     *
     * @param destValue 输入的整数
     * @return 二进制 1 的个数
     */
    public static int countOneBit(int destValue) {
        int num = 0;
        int flag = 1;
        while (flag != 0) {
            int currValue = destValue & flag;
            if (currValue != 0) {
                num++;
            }
            flag <<= 1;
        }
        return num;
    }

    public static void main(String[] args) {
        for (int i = -1; i < 10; i++) {
            int destValue = i;
            System.out.println(countOneBit(destValue));
        }
    }

}
