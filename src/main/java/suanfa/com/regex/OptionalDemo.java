package suanfa.com.regex;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        //1、创建Optional实例，传入的对象不能为null
        Optional<String> nameOptional = Optional.of("张三");

        //2、创建Optional实例，传入对象可以为null,也可以不weinull
        Optional emptyOptional = Optional.ofNullable(null);

        //3、isPresent方法用来检查Optional实例是否有值。
        if (nameOptional.isPresent()) {
            //调用get()返回Optional值。
            System.out.println("1、" + nameOptional.get());
        }

        try {
            //4、在Optional实例上调用get()抛出NoSuchElementException。
            System.out.println("2、" + emptyOptional.get());
        } catch (NoSuchElementException ex) {
            System.out.println("3、异常" + ex.getMessage());
        }

        //
        //5、如果Optional值不为空，lambda表达式会处理并在其上执行操作。(这里x代表就是nameOptional中的对象)
        nameOptional.ifPresent((x) -> {
            System.out.println("4、字符串长度为: " + x.length());
        });

        //6、如果有值orElse方法会返回Optional实例，没值则返回当前值
        System.out.println("5、"+ emptyOptional.orElse("如果是空容器则返回李四"));
        System.out.println("6、"+nameOptional.orElse("如果是空容器则返回王五"));

        //7、orElseGet与orElse类似，区别在于传入的参数不同，一个是直接传入对象，这个是传入Supplier函数式接口
        System.out.println("7、" + emptyOptional.orElseGet(() -> "李四"));
        System.out.println("8、" + nameOptional.orElseGet(() -> "王五"));

        try {
            //8、如果是空容器,则可以抛出自定义异常。
            emptyOptional.orElseThrow(() -> new NullPointerException("空容器异常"));
        } catch (Throwable ex) {
            System.out.println("9、" + ex.getMessage());
        }

        Optional<String> ageOptional = Optional.of("10");
        //9、这里入参是Function,所以可以转换容器中的对象 好比将String对象转为Integer对象
        Optional<Integer> age = ageOptional.map((value) -> Integer.parseInt(value));
        /**
         * 10、flatMap与map（Funtion）非常相似，不同在于 map返回可以将String对象转为Integer对象,但flatMap转换后一定还是String对象
         */
        Optional<String> upperName = nameOptional.flatMap((value) -> Optional.of(value.toUpperCase()));

        //11、filter方法检查Optiona值是否满足给定条件。如果满足返回Optional实例值，否则返回空Optional。
        Optional<String> longName = nameOptional.filter((value) -> value.length() > 6);
        System.out.println("10、" + longName.orElse("longName容器的名字长度小于6位"));

        //12、另一个示例，Optional满足给定条件。
        Optional<String> anotherName = Optional.of("乌啦啦市长公主");
        Optional<String> shortName = anotherName.filter((value) -> value.length() > 6);
        System.out.println("11、" + shortName.orElse("anotherName容器的名字长度小于6位"));

    }
}
