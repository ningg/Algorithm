package top.ningg.algo.string;

/**
 * 题目: 实现一个函数，将字符串中空格替换为`%20`，例如输入`We are happy.`，则，输出`We%20are%20happy.`。
 */
public class StringReplaceBlank {


    /**
     * 将字符数组中的空格, 替换为'%20'字符
     *
     * @param array 字符数组
     * @return 字符数组的替换结果
     */
    public static char[] replaceBlank(char array[]) {
        // 1. 边界判断
        if (null == array){
            return null;
        }

        // 2. 统计其中空格字符的数量
        // FIXME: java 中, 数组是不可原地扩容, 需要依赖 C 语言中写法, 进行扩容
        // 细节参考: https://github.com/ningg/computer-science-basic
        return  null;
    }

}
