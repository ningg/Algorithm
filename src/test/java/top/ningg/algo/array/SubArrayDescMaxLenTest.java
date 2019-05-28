package top.ningg.algo.array;

public class SubArrayDescMaxLenTest {

    public static int subArrayDescMaxLen(int[] array) {
        if (null == array) {
            return -1;
        }

        int len = array.length;
        int max[] = new int[len];

        for (int i = 0; i < len; i++) {
            max[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] <= array[j]) {
                    max[i] = Math.max(max[i], max[j] + 1);
                }
            }
        }

        return max[len - 1];
    }

    public static void main(String[] args){
        int[] inputArray = {389, 207, 155, 300, 299, 170, 158, 65};
        int result = subArrayDescMaxLen(inputArray);

        System.out.println(result);
    }

}
