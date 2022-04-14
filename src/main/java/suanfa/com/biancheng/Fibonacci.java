package suanfa.com.biancheng;

public class Fibonacci {
    public static int fibonacci(int index) {
        //递归的出口
        if (index == 1 || index == 2) {
            return 1;
        }
        //函数调用自身
        return fibonacci(index - 1) + fibonacci(index - 2);
    }

    public static void main(String[] args) {

        //int arr[] = {8, 5, 3, 2, 4};
        int n = 6;
        // 输出前 10 个数
        for (int i = 1; i <= 10; i++) {
            System.out.println(fibonacci(i));
        }
        System.out.println(fibonacci(n));
        System.out.println(fibonacci(4));
    }
}
