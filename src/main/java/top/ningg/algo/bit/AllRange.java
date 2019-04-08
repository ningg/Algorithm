package top.ningg.algo.bit;

/**
 * 题目: 全排列
 *
 * 要点:
 *
 * 1. 所有元素, 都出现
 * 2. 元素之间, 有顺序
 *
 * 基本思路:
 *
 * 1. 递归: 转化为子问题
 */
public class AllRange {


    /**
     * 获取输入数组的全排列
     *
     * @param array 输入的数组
     * @param result 已经排列的数组
     */
    public static void allRange(String array, String result) {

        // 1. 边界判断
        if (null == array) {
            return;
        }

        int length = array.length();
        int currLength = result.length();

        // 2. 终止条件
        if (currLength == length) {
            System.out.println(result);
        }

        // 3. 迭代: 不满足条件的分支, 不进行后续处理, 相当于'剪枝'
        for (int i = 0; i < array.length(); i++) {
            if (result.indexOf(array.charAt(i)) < 0) {
                allRange(array, result + array.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        String inputArray = "abc";
        String result = "";

        allRange(inputArray, result);
    }

}
