package top.ningg.algo;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：判断一个数字，是否存在斐波那契数列中。
 *
 * 分析： 从头遍历 斐波那契数列，
 *
 * 1. 如果出现等于设定的数字，则，存在；
 *
 * 2. 如果出现数字大于设定的数字，则，不存在；
 */
public class FiboContainValue {

    public static void main(String[] args) {
        List<Integer> valueList = new LinkedList<>();
        valueList.add(1);
        valueList.add(2);
        valueList.add(3);
        valueList.add(4);
        valueList.add(5);
        valueList.add(100);
        valueList.add(201);
        valueList.add(8);

        System.out.println("方案 A: 迭代方式, 逐个计算");
        for (Integer single : valueList) {
            System.out
                .println(
                    String.format("Value: %s, 属于 Fibo 数列: %s", single, fiboContainValue(single)));
        }

        System.out.println("方案 B: 循环方式, 融合 Fibo 数列的计算和取值判断");
        for (Integer single : valueList) {
            System.out
                .println(
                    String
                        .format("Value: %s, 属于 Fibo 数列: %s", single, fiboContainValueLoop(single)));
        }

    }

    // 方案 A:
    // 1. 逐个计算并遍历 fibo 数列
    public static boolean fiboContainValue(int destValue) {
        // 边界检查
        if (destValue <= 0) {
            return false;
        }

        int currIndex = 1;
        while (true) {
            int currValue = fibo(currIndex);

            if (currValue == destValue) {
                return true;
            } else if (currValue > destValue) {
                return false;
            }

            // 计算下一个
            currIndex++;
        }

    }


    public static int fibo(int n) {
        // 边界检查
        if (n <= 0) {
            return -1;
        }

        // 终止条件
        if (1 == n || 2 == n) {
            return 1;
        }

        // 递归迭代
        return fibo(n - 1) + fibo(n - 2);
    }

    // 方案 B:
    // 1. 采用循环方式, 实现 Fibo 数列
    // 2. 生成 Fibo 数列时, 进行判断
    public static boolean fiboContainValueLoop(int n) {
        // 边界判断
        if (n <= 0) {
            return false;
        }

        // 起始的两个数
        if (1 == n) {
            return true;
        }

        // 循环方式, 构造 Fibo 数列
        int a = 1;
        int b = 1;
        int c = 0;
        while (true) {
            c = a + b;
            a = b;
            b = c;

            if (c == n) {
                return true;
            } else if (c > n) {
                return false;
            }
        }
    }

}
