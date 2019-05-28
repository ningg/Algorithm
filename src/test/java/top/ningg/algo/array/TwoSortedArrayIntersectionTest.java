package top.ningg.algo.array;

import com.alibaba.fastjson.JSON;
import java.util.HashSet;
import java.util.Set;

public class TwoSortedArrayIntersectionTest {


    public static Set<Integer> twoSortedArrayIntersection(int[] firstArray, int[] secondArray) {
        // 1. 边界判断
        if (null == firstArray || null == secondArray) {
            return null;
        }

        Set<Integer> resultSet = new HashSet<>();

        int firstLen = firstArray.length;
        int secondLen = secondArray.length;

        int first = 0, second = 0;
        while (first < firstLen && second < secondLen) {
            if (firstArray[first] == secondArray[second]) {
                resultSet.add(firstArray[first]);
                first++;
                second++;
            } else if (firstArray[first] < secondArray[second]) {
                first++;
            } else {
                second++;
            }
        }

        return resultSet;
    }

    public static void main(String[] args) {
        int firstArray[] = {1, 2, 3, 4, 5, 6, 7};
        int secondArray[] = {5, 6, 7, 8, 9, 10};

        Set<Integer> result = twoSortedArrayIntersection(firstArray, secondArray);

        System.out.println(JSON.toJSON(result));
    }
}
