package top.ningg.algo.array;

public class Fibo {

    public static int fibo(int n){
        // 边界判断
        if(n <= 0){
            throw new RuntimeException("非法输入参数");
        }

        // 终止条件
        if (n == 1 || n == 2){
            return 1;
        }

        // 循环计算
        int a = 1;
        int b = 1;
        int c = 0;

        for (int i = 3; i <= n ; i++){
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    public static boolean fiboContainValue(int destValue){
        // 边界判断
        if(destValue <= 0){
            return false;
        }

        if(destValue == 1){
            return true;
        }

        // 循环判断
        int a = 1, b = 1, c = 0;
        while(true){
            c = a + b;
            // 判断目标值
            if (destValue == c){
                return true;
            } else if (destValue < c){
                return false;
            }

            // 调整指针
            a = b;
            b = c;
        }

    }

    public static void main(String[] args){
        int n = 10;
        int result = fibo(n);

        System.out.println(result);
    }

}
