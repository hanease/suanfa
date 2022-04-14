package suanfa.com.pak;

import java.math.BigDecimal;
import java.util.*;

public class MakDemo {

    public static void main(String args[]){
        HashSet<String> subject = new HashSet<String>();
        subject.add(null);
        subject.add(null);
        System.out.println(subject);

        TreeSet<String> subject1 = new TreeSet<String>();
        subject1.add("232");
        subject1.add("23");
        subject1.add("111");
        subject1.add("23");
        System.out.println(subject1);

        PriorityQueue<Integer> qi = new PriorityQueue<Integer>();
        qi.offer(5);
        qi.offer(2);
        qi.offer(1);
        qi.offer(10);
        qi.offer(3);
        while (!qi.isEmpty()){
            System.out.print(qi.poll() + ",");
        }
        System.out.println();

        //采用降序排列的方式，越小的越排在队尾
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        };
        //这里是初始容量3，当我们超过3个会自动扩容，所以说它是个无边界容器
        PriorityQueue<Integer> q2 = new PriorityQueue<Integer>(3,cmp);
        q2.offer(2);
        q2.offer(8);
        q2.offer(9);
        q2.offer(1);
        while (!q2.isEmpty()){
            System.out.print(q2.poll() + ",");
        }

        //1、基本数据类型
        int[] a11 = {0, 1, 2, 3};
        // Arrays.copyOf拷贝
        int[] copy = Arrays.copyOf(a11, a11.length);
        a11[0] = 1;
        System.out.println(Arrays.toString(copy));
        System.out.println(Arrays.toString(a11));

        //2、对象数组
        Student[]  stuArr = {new Student("小小", 3, "女"),new Student("小小爸", 29, "男"),new Student("小小妈", 27, "女")};
        // Arrays.copyOf拷贝
        Student[] copyStuArr = Arrays.copyOf(stuArr, stuArr.length);
        copyStuArr[0].setName("小小爷爷");
        System.out.println(Arrays.toString(stuArr));
        System.out.println(Arrays.toString(copyStuArr));

        //正常 3.3
        System.out.println("加法结果："+(1.1+2.2));
        //正常 -7.9
        System.out.println("减法结果："+(2.2-10.1));
        //正常 2.42
        System.out.println("乘法结果："+(1.1*2.2));
        //正常 0.44
        System.out.println("除法结果："+(4.4/10));


        BigDecimal intDecimal = new BigDecimal(10);
        BigDecimal doubleDecimal = new BigDecimal(4.3);
        BigDecimal longDecimal = new BigDecimal(10L);
        BigDecimal stringDecimal = new BigDecimal("4.3");
        System.out.println("intDecimal=" + intDecimal);
        System.out.println("doubleDecimal=" + doubleDecimal);
        System.out.println("longDecimal=" + longDecimal);
        System.out.println("stringDecimal=" + stringDecimal);

        String string = Double.toString(4.3);
        BigDecimal stringBigDecimal = new BigDecimal(string);
        BigDecimal bigDecimal = BigDecimal.valueOf(4.3);
        System.out.println("stringBigDecimal = " + stringBigDecimal);
        System.out.println("bigDecimal = " + bigDecimal);

        BigDecimal a = new BigDecimal("4.5");
        BigDecimal b = new BigDecimal("1.5");
        BigDecimal c = new BigDecimal("-10.5");

        BigDecimal add_result = a.add(b);
        BigDecimal subtract_result = a.subtract(b);
        BigDecimal multiply_result = a.multiply(b);
        BigDecimal divide_result = a.divide(b);
        BigDecimal remainder_result = a.remainder(b);
        BigDecimal max_result = a.max(b);
        BigDecimal min_result = a.min(b);
        BigDecimal abs_result = c.abs();
        BigDecimal negate_result = a.negate();

        System.out.println("4.5+1.5=" + add_result);
        System.out.println("4.5-1.5=" + subtract_result);
        System.out.println("4.5*1.5=" + multiply_result);
        System.out.println("4.5/1.5=" + divide_result);
        System.out.println("4.5/1.5余数=" + remainder_result);
        System.out.println("4.5和1.5最大数=" + max_result);
        System.out.println("4.5和1.5最小数=" + min_result);
        System.out.println("-10.5的绝对值=" + abs_result);
        System.out.println("4.5的相反数=" + negate_result);
    }
}
