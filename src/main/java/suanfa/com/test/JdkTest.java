package suanfa.com.test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.*;
import java.util.*;

public class JdkTest {
    public static void main(String[] args){

        // Pre-JDK 6
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

        // Pre-JDK 7
        List<String> lst1 = new ArrayList<String>();
        // JDK 7 supports limited type inference for generic instance creation
        List<String> lst2 = new ArrayList<>();

        lst1.add("Mon");
        lst1.add("Tue");
        lst2.add("Wed");
        lst2.add("Thu");

        for (String item: lst1) {
            System.out.println(item);
        }

        for (String item: lst2) {
            System.out.println(item);
        }

        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in  = new BufferedReader(new FileReader("in.txt"));
            out = new BufferedWriter(new FileWriter("out.txt"));
            int charRead;
            while ((charRead = in.read()) != -1) {
                System.out.printf("%c ", (char)charRead);
                out.write(charRead);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {            // always close the streams
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try {
            in.read();   // Trigger IOException: Stream closed
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Pre-JDK 8
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        Collections.sort(names, (a, b) -> b.compareTo(a));
    }
}
