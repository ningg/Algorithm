package top.ningg.algo.num;

import java.util.Random;

/**
 * 题目：有一个 Random5 随机等概率生成 [1,5] 之间的数字，求构造一个 Random7 随机等概率生成 [1,7] 之间的数字
 *
 * 参考资料：
 *
 * - km 上整理有 https://www.zhihu.com/question/47038069
 */
public class RandomContruct {


    public static int rand5() {
        // 等概率返回 [1,5]
        return new Random().nextInt(5);
    }

    public static int rand7() {
        int result = 0;

        do {
            result = (rand5() - 1) * 5 + (rand5() - 1);
        } while (result > 7 && result <= 0);

        return result;
    }


    public static void main(String[] args) {
        int result = rand7();

        System.out.println(result);
    }

}
