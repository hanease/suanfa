package suanfa.com.biancheng;

import com.sun.deploy.util.StringUtils;
import suanfa.com.test.BinTree;

import java.util.regex.Pattern;

public class Digui {

    public static int factorial(int n) {
        //递归的出口
        if (n == 1 || n == 0) {
            return 1;
        }
        //函数调用自身
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {

        //int arr[] = {8, 5, 3, 2, 4};
        int n = 6;
        System.out.println(n);
        System.out.println(factorial(n));
    }
}
