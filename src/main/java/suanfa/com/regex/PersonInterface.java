package suanfa.com.regex;

@FunctionalInterface
public interface PersonInterface {

    /**
     * 1、仅有一个抽象方法
     */
    void say();

    /**
     * 2、java.lang.Object中的方法不算
     */
    @Override
    boolean equals(Object var1);

    /**
     * 3、java8 接口才可以有默认的方法实现 前提是方法名称必须使用default关键字修饰
     */
    default void defaultMethod() {
        System.out.println("haha");
    }

    /**
     * 4、静态方法
     */
    static void staticMethod() {
    }
}
