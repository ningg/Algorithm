package top.ningg.algo.array;

import java.util.LinkedList;

/**
 * 题目： 生成窗口最大值数组 【题目】 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个 位置。
 *
 * 更多细节，参考：
 *
 * - https://blog.csdn.net/SUNbrightness/article/details/79502060
 */
public class MaxWindow {

    /**
     * 可以获得每个区域的最大值
     *
     * 【】一个窗口。存放的值全都是坐标
     *
     * 他的左、右边框只能向右移动。
     *
     * 右边框每次移动，把值加进来。加进来的同时判断从右到左判断 比他小与等于的值全部弹出
     *
     * 左边框每次移动 ，判断最左边的坐标是否过期。（越界）越界的话就弹出。
     *
     * 这个窗口无论如何变化，窗口最左边的值，永远是他所包含的范围中最小的值
     */
    public static int[] maxWindow(int[] array, int windowSize) {
        if (null == array) {
            return array;
        }

        if (windowSize < 1 || windowSize >= array.length) {
            return null;
        }

        int[] res = new int[array.length - windowSize + 1];

        LinkedList<Integer> qmax = new LinkedList<>();
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            while (!qmax.isEmpty() && array[qmax.peekLast()] <= array[i]) {
                qmax.pollLast();
            }
            qmax.add(i);

            //i-w i=3 w=0;i=4 w= 1 ;i=5 w2
            //小于三的范围就是小于窗口范围（过期）
            if (qmax.peekFirst() == i - windowSize) {
                qmax.pollFirst();
            }

            //先调整完窗口。窗口最左边的左边就是最小值的坐标
            if (i >= windowSize - 1) {
                res[index++] = array[qmax.peekFirst()];
            }

        }
        return res;
    }

}
