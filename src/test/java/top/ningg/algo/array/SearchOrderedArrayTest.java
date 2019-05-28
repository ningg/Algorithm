package top.ningg.algo.array;

public class SearchOrderedArrayTest {

    public static boolean searchOrderedArray(int[][] array, int destValue){
        // 边界判断
        if (null == array){
            return false;
        }

        int rowNum = array.length;
        int columnNum = array[0].length;

        int rowCurr = 0;
        int columnCurr = columnNum -1;

        // 从右上角，进行遍历
        while (rowCurr < rowNum && columnCurr >= 0){
            int currValue = array[rowCurr][columnCurr];

            if (currValue == destValue){
                return true;
            } else if (currValue < destValue){
                rowCurr ++;
            } else {
                columnCurr --;
            }
        }

        return false;
    }

    public static void main(String[] args){
        int array[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
        int destValue = 8;

        boolean result = searchOrderedArray(array, destValue);

        System.out.println(result);
    }

}
