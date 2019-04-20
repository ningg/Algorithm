package top.ningg.algo.array;

/**
 * 题目: 在一个二维数组中，每一行都按照从左到右递增的顺序排列，每一列都按照从上到下递增的顺序排列。
 *
 * 实现一个函数:
 *
 * 1. 输入为「这样的二维数组」和「一个整数」
 * 2. 判断数组中是否含有该整数。
 */
public class SearchOrderedArray {

    /**
     * 从「有序」的二维数组, 查找目标值是否存在。
     *
     * @param array 有序的二维数组
     * @param destValue 目标值
     * @return 目标值, 是否存在二维数组中.
     */
    public static boolean searchOrderedArray(int array[][], int destValue) {

        // 边界判断
        if (null == array) {
            return false;
        }

        int rows = array.length;
        int columns = array[0].length;
        boolean hasFound = false;

        // 1. 按行: 判断所属的行
        int currRow = 0;
        int nextRow = 1;
        while (nextRow < rows) {
            if (array[currRow][0] == destValue) {
                hasFound = true;
                break;
            }
            if (array[currRow][0] > destValue) {
                break;
            }

            if (array[currRow][0] < destValue && array[nextRow][0] > destValue) {
                break;
            }

            currRow++;
            nextRow++;
        }

        if (hasFound) {
            return hasFound;
        }

        // 2. 行内: 逐个遍历元素, 并进行比较
        for (int i = 0; i < columns; i++) {
            if (array[currRow][i] == destValue) {
                hasFound = true;
                break;
            } else if (array[currRow][i] > destValue) {
                hasFound = false;
                break;
            }
        }

        return hasFound;
    }

    /**
     * 从「有序」的二维数组, 查找目标值是否存在。
     *
     * @param array 有序的二维数组
     * @param destValue 目标值
     * @return 目标值, 是否存在二维数组中.
     */
    public static boolean searchOrderedArrayAnother(int array[][], int destValue) {
        // 1. 边界判断
        if (null == array) {
            return false;
        }

        // 获取基本参数
        int rowNum = array.length;
        int columnNum = array[0].length;

        // 从左下角遍历:
        // a. 相等:找到
        // b. 比目标值大: 行减一
        // c. 比目标值小: 行加一
        int currRow = rowNum - 1;
        int currColumn = 0;
        while (currRow >= 0 && currColumn < columnNum) {
            if (array[currRow][currColumn] == destValue) {
                return true;
            } else if (array[currRow][currColumn] < destValue) {
                currColumn++;
            } else {
                currRow--;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int array[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int destValue = 10;

        boolean result = searchOrderedArray(array, destValue);
        System.out.println(result);

        boolean resultOfAnother = searchOrderedArrayAnother(array, destValue);
        System.out.println(resultOfAnother);
    }
}
