package top.ningg.algo.array;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 题目：输出斐波那契数列。
 *
 * 分析：2种思路
 *
 * 1. 递归: 3 部分分析
 * a. 核心递归逻辑, f(n) = f(n-1) + f(n-2), 时间复杂度 O(2^n)
 * b. 终止条件: 终止的判断
 * c. 边界判断: 输入参数校验
 *
 * 2. 循环: 时间复杂度 O(n)
 */
public class Fibo {

    public static void main(String[] args) {
        int length = 40;
        List<String> fiboList = new LinkedList<>();
        for (int single = 1; single <= length; single++) {
            fiboList.add(String.valueOf(fiboLoop(single)));
        }

        String fiboListStr = String.join(",", fiboList);
        System.out.println(String.format("fibo: %s", fiboListStr));

        // 测试函数式写法
        String fiboListStrBak = fiboList
            .stream()
            .collect(Collectors.joining(","));
        System.out.println(String.format("fibo: %s", fiboListStrBak));
    }


    // 方法1: 递归方式
    public static int fibo(int n) {

        // 边界判断
        if (n <= 0) {
            return -1;
        }

        // 终止条件
        if (n == 1 || n == 2) {
            return 1;
        }

        return fibo(n - 1) + fibo(n - 2);
    }

    // 方法2: 循环
    public static int fiboLoop(int n) {
        // 边界检查
        if (n <= 0) {
            return -1;
        }

        // 终止条件
        if (n == 1 || n == 2) {
            return 1;
        }

        // 循环处理
        int a = 1;
        int b = 1;
        int result = 0;
        for (int index = 3; index <= n; index++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }

}
