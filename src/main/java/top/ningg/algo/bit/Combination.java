package top.ningg.algo.bit;

/**
 * TODO
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
