package top.ningg.algo.bit;

/**
 * 基本思路：求全组合，则假设原有元素n个，则最终组合结果是2^n个。
 *
 * 原因是：
 *
 * 1. 用位操作方法：假设元素原本有：a,b,c三个，则1表示取该元素，0表示不取。故去a则是001，取ab则是011.
 * 2. 所以一共三位，每个位上有两个选择0,1.所以是2^n个结果。
 * 3. 这些结果的位图值都是0,1,2....2^n。
 *
 * 所以从值0到值2^n依次输出结果：即：
 *
 * - 000,001,010,011,100,101,110,111 。
 *
 * 对应输出组合结果为：
 *
 * - 空,a, b ,ab,c,ac,bc,abc.
 */
public class Combination {


    public static void combination(String[] strArray) {
        // 1.边界判断
        if (null == strArray) {
            return;
        }

        // 2. 基础准备
        int len = strArray.length;
        int bitMax = 1 << len;

        // 3. 逐个数字, 获取二进制表示格式, 并获取对应的排列
        for (int index = 0; index < bitMax; index++) {
            StringBuffer strBuffer = new StringBuffer();
            for (int currBit = 0; currBit < len; currBit++) {
                int currValue = (1 << currBit);
                if ((index & currValue) != 0) {
                    strBuffer.append(strArray[currBit]);
                }
            }
            System.out.println(strBuffer);
        }

    }

    public static void main(String[] args) {
        String[] inputArray = {"1", "2", "3"};

        // combination
        combination(inputArray);
    }

}
