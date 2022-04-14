package suanfa.com.regex;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {

    public static void main(String[] args) {

        Apple apple1 = new Apple("红富士", "Red", 280);
        Apple apple2 = new Apple("冯心", "Yello", 470);
        Apple apple3 = new Apple("哈哈", "Red", 320);
        Apple apple4 = new Apple("小小", "Green", 300);


        List<Apple> appleList = Arrays.asList(apple1, apple2, apple3, apple4);

        //lambda 表达式形式
        //appleList.sort((Apple a1, Apple a2) -> {
        //    return new Double(a1.getWeight() - a2.getWeight()).intValue();
        //});

        //实例方法引用
        AppleComparator comparator = new AppleComparator();
        appleList.sort(comparator::compareByWeight);

        appleList.forEach(apple -> System.out.println(apple));

    }
}
