package suanfa.com.hello;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

            List<String> strList = new ArrayList<String>();
            strList.add("jigang");
            strList.add("nana");
            strList.add("jigang");
            strList.add("jigang");
            strList.add("nana2");

            System.out.println(strList.size());
            strList.remove("jigang");
            System.out.println(strList.size());
            for (int i=0; i<strList.size(); i++) {
                if (strList.get(i).equals("jigang")) {
                    strList.remove(i);
                    i--;
                }
            }
            Iterator<String> it = strList.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
