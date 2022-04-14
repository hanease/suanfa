package suanfa.com.pak;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface AnCode {
    //如果只有一个属性 强烈建议取名为value
    String value() default "";
}
