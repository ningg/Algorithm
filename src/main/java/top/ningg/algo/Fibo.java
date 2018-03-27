package top.ningg.algo;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：输出斐波那契数列。
 *
 * 分析：2种思路 1. 递归 2. 循环
 */
public class Fibo {

  public static void main(String[] args) {
    int length = 40;
    List<String> fiboList = new LinkedList<>();
    for (int single = 1; single <= length; single++) {
      fiboList.add(String.valueOf(fiboLoop(single)));
    }

    String fiboListStr = String.join(",", fiboList);
    System.out.println(String.format("Fibo: %s", fiboListStr));
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
