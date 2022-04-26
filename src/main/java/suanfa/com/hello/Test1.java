package suanfa.com.hello;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Test1 {
    public static void main(String[] args){
        byte b = 'b';

        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        String script;
        try {
            script = "print('Hello')";
            engine.eval(script);// 执行脚本
            script = "1-23*9/3+77";
            System.out.println(engine.eval(script).toString());// 不用对字符串做解析便可得到算式结果
            engine.put("a", "一个字符串");
            script = "print(a)";
            engine.eval(script);// 脚本调用java对象
            script = "function hello(name) { return 'Hello,' + name;}";
            engine.eval(script);
            Invocable inv = (Invocable) engine;
            System.out.println(inv.invokeFunction("hello", "Scripting"));//java调用脚本方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
