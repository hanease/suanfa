package suanfa.com.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaBasic {
    public static void main(String[] args) {
        double[] myList = {1.9, 2.9, 3.4, 3.5};
        int[] input = new int[]{3, 1, 2, 6, -4, 2};
        int[] nums = new int[]{1, 1, 2, 3, 4, 4, 5};
        int[] nums1 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        //Character
        System.out.println(Character.isLetter('c'));
        System.out.println(Character.isDigit('5'));
        System.out.println(Character.isWhitespace('c'));
        System.out.println(Character.isWhitespace(' '));
        System.out.println(Character.isWhitespace('\n'));
        System.out.println(Character.isWhitespace('\t'));
        System.out.println( Character.isUpperCase('c'));
        System.out.println( Character.isUpperCase('C'));
        System.out.println( Character.isLowerCase('c'));
        System.out.println( Character.isLowerCase('C'));
        System.out.println(Character.toUpperCase('a'));
        System.out.println(Character.toUpperCase('A'));
        System.out.println(Character.toLowerCase('a'));
        System.out.println(Character.toLowerCase('A'));
        System.out.println(Character.toString('a'));
        System.out.println(Character.toString('A'));

        //String类
        //1	char charAt(int index)
        //返回指定索引处的 char 值。
        String s = "www.runoob.com";
        char result = s.charAt(6);
        System.out.println(result);

        //2	int compareTo(Object o)
        //把这个字符串和另一个对象比较。
        String str1 = "Strings";
        String str2 = "Strings";
        String str3 = "Strings123";
        int result1 = str1.compareTo( str2 );
        System.out.println(result);
        result1 = str2.compareTo( str3 );
        System.out.println(result);

        //3	int compareTo(String anotherString)
        //按字典顺序比较两个字符串。

        //4	int compareToIgnoreCase(String str)
        //按字典顺序比较两个字符串，不考虑大小写。
        String str41 = "STRINGS";
        String str42 = "Strings";
        String str43 = "Strings123";

        int result4 = str1.compareToIgnoreCase( str42 );
        System.out.println(result);
        result4 = str42.compareToIgnoreCase( str43 );
        System.out.println(result);

        //5	String concat(String str)
        //将指定字符串连接到此字符串的结尾。
        String s5 = "菜鸟教程：";
        s5 = s5.concat("www.runoob.com");

        //6	boolean contentEquals(StringBuffer sb)
        //当且仅当字符串与指定的StringBuffer有相同顺序的字符时候返回真。

        //7	static String copyValueOf(char[] data)
        //返回指定数组中表示该字符序列的 String。
        //8	static String copyValueOf(char[] data, int offset, int count)
        //返回指定数组中表示该字符序列的 String。
        char[] Str1 = {'h', 'e', 'l', 'l', 'o', ' ', 'r', 'u', 'n', 'o', 'o', 'b'};
        String Str2 = "";

        Str2 = Str2.copyValueOf( Str1 );
        System.out.println("返回结果：" + Str2);

        Str2 = Str2.copyValueOf( Str1, 2, 6 );
        System.out.println("返回结果：" + Str2);

        //9	boolean endsWith(String suffix)
        //测试此字符串是否以指定的后缀结束。
        String Str = new String("菜鸟教程：www.runoob.com");
        boolean retVal;

        retVal = Str.endsWith( "runoob" );
        System.out.println("返回值 = " + retVal );

        //10	boolean equals(Object anObject)
        //将此字符串与指定的对象比较。
        //11	boolean equalsIgnoreCase(String anotherString)
        //将此 String 与另一个 String 比较，不考虑大小写。
        retVal = Str.equalsIgnoreCase( Str );
        System.out.println("返回值 = " + retVal );
        //12	byte[] getBytes()
        // 使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
        String Str12 = new String("runoob");
        byte[] Str123 = Str12.getBytes();
        //13	byte[] getBytes(String charsetName)
        //使用指定的字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
        //14	void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
        //将字符从此字符串复制到目标字符数组。
        String Str1234 = new String("www.runoob.com");
        //char[] Str2 = new char[6];
        //Str1.getChars(4, 10, Str2, 0);
        //15	int hashCode()
        //返回此字符串的哈希码。
        //16	int indexOf(int ch)
        //返回指定字符在此字符串中第一次出现处的索引。
        //17	int indexOf(int ch, int fromIndex)
        //返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索。
        String string = "aaa456ac";
        //查找指定字符是在字符串中的下标。在则返回所在字符串下标；不在则返回-1.
        System.out.println(string.indexOf("b")); // indexOf(String str); 返回结果：-1，"b"不存在

        // 从第四个字符位置开始往后继续查找，包含当前位置
        System.out.println(string.indexOf("a",3));//indexOf(String str, int fromIndex); 返回结果：6
        //18	int indexOf(String str)
        // 返回指定子字符串在此字符串中第一次出现处的索引。
        //19	int indexOf(String str, int fromIndex)
        //返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。
        //20	String intern()
        // 返回字符串对象的规范化表示形式。
        //21	int lastIndexOf(int ch)
        // 返回指定字符在此字符串中最后一次出现处的索引。
        //22	int lastIndexOf(int ch, int fromIndex)
        //返回指定字符在此字符串中最后一次出现处的索引，从指定的索引处开始进行反向搜索。
        String SubStr1 = new String("runoob");
        String SubStr2 = new String("com");
        System.out.println( Str.lastIndexOf( SubStr1, 15 ));
        System.out.print("子字符串 SubStr2 最后出现的位置 :" );
        System.out.println(Str.lastIndexOf( SubStr2 ));
        //23	int lastIndexOf(String str)
        //返回指定子字符串在此字符串中最右边出现处的索引。
        //24	int lastIndexOf(String str, int fromIndex)
        // 返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索。
        //25	int length()
        //返回此字符串的长度。
        System.out.print("字符串 Str1 长度 :");
        System.out.println(Str2.length());
        //26	boolean matches(String regex)
        //告知此字符串是否匹配给定的正则表达式。
        //27	boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)
        //测试两个字符串区域是否相等。
        //28	boolean regionMatches(int toffset, String other, int ooffset, int len)
        //测试两个字符串区域是否相等。
        //29	String replace(char oldChar, char newChar)
        //返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
        System.out.print("返回值 :" );
        System.out.println(Str.replace('o', 'T'));
        //30	String replaceAll(String regex, String replacement)
        //使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
        Str = new String("www.google.com");
        System.out.print("匹配成功返回值 :" );
        System.out.println(Str.replaceAll("(.*)google(.*)", "runoob" ));
        System.out.print("匹配失败返回值 :" );
        System.out.println(Str.replaceAll("(.*)taobao(.*)", "runoob" ));
        //31	String replaceFirst(String regex, String replacement)
        // 使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
        Str = new String("hello runoob，I am from runoob。");
        System.out.print("返回值 :" );
        System.out.println(Str.replaceFirst("runoob", "google" ));
        //32	String[] split(String regex)
        //根据给定正则表达式的匹配拆分此字符串。
        String str = new String("Welcome-to-Runoob");
        System.out.println("- 分隔符返回值 :" );
        for (String retval: str.split("-")){
            System.out.println(retval);
        }
        System.out.println("");
        System.out.println("- 分隔符设置分割份数返回值 :" );
        for (String retval: str.split("-", 2)){
            System.out.println(retval);
        }
        //33	String[] split(String regex, int limit)
        //根据匹配给定的正则表达式来拆分此字符串。
        //34	boolean startsWith(String prefix)
        //测试此字符串是否以指定的前缀开始。
        Str = new String("www.runoob.com");
        System.out.print("返回值 :" );
        System.out.println(Str.startsWith("www") );
        //35	boolean startsWith(String prefix, int toffset)
        //测试此字符串从指定索引开始的子字符串是否以指定前缀开始。
        //36	CharSequence subSequence(int beginIndex, int endIndex)
        // 返回一个新的字符序列，它是此序列的一个子序列。
        //37	String substring(int beginIndex)
        //返回一个新的字符串，它是此字符串的一个子字符串。
        //38	String substring(int beginIndex, int endIndex)
        //返回一个新字符串，它是此字符串的一个子字符串。
        Str = new String("This is text");
        System.out.print("返回值 :" );
        System.out.println(Str.substring(4) );

        System.out.print("返回值 :" );
        System.out.println(Str.substring(4, 10) );
        //39	char[] toCharArray()
        //将此字符串转换为一个新的字符数组。
        Str = new String("www.runoob.com");

        System.out.print("返回值 :" );
        System.out.println( Str.toCharArray() );
        //40	String toLowerCase()
        //使用默认语言环境的规则将此 String 中的所有字符都转换为小写。
        Str = new String("WWW.RUNOOB.COM");
        System.out.print("返回值 :" );
        System.out.println( Str.toLowerCase() );
        //41	String toLowerCase(Locale locale)
        // 使用给定 Locale 的规则将此 String 中的所有字符都转换为小写。
        //42	String toString()
        // 返回此对象本身（它已经是一个字符串！）。
        //43	String toUpperCase()
        //使用默认语言环境的规则将此 String 中的所有字符都转换为大写。
        //44	String toUpperCase(Locale locale)
        //使用给定 Locale 的规则将此 String 中的所有字符都转换为大写。
        //45	String trim()
        //返回字符串的副本，忽略前导空白和尾部空白。
        Str = new String("    www.runoob.com    ");
        System.out.print("原始值 :" );
        System.out.println( Str );
        //46	static String valueOf(primitive data type x)
        //返回给定data type类型x参数的字符串表示形式。
        //47	contains(CharSequence chars)
        //判断是否包含指定的字符系列。
        String myStr = "Runoob";
        System.out.println(myStr.contains("Run"));
        System.out.println(myStr.contains("o"));
        System.out.println(myStr.contains("s"));
        //48	isEmpty()
        //判断字符串是否为空。

        //Java StringBuffer 和 StringBuilder 类
        //StringBuffer 方法
        //以下是 StringBuffer 类支持的主要方法：
        //
        //序号	方法描述
        //1	public StringBuffer append(String s)
        //将指定的字符串追加到此字符序列。
        //2	public StringBuffer reverse()
        // 将此字符序列用其反转形式取代。
        //3	public delete(int start, int end)
        //移除此序列的子字符串中的字符。
        //4	public insert(int offset, int i)
        //将 int 参数的字符串表示形式插入此序列中。
        //5	insert(int offset, String str)
        //将 str 参数的字符串插入此序列中。
        //6	replace(int start, int end, String str)
        //使用给定 String 中的字符替换此序列的子字符串中的字符。
        //以下列表列出了 StringBuffer 类的其他常用方法：
        //
        //序号	方法描述
        //1	int capacity()
        //返回当前容量。
        //2	char charAt(int index)
        //返回此序列中指定索引处的 char 值。
        //3	void ensureCapacity(int minimumCapacity)
        //确保容量至少等于指定的最小值。
        //4	void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
        //将字符从此序列复制到目标字符数组 dst。
        //5	int indexOf(String str)
        //返回第一次出现的指定子字符串在该字符串中的索引。
        //6	int indexOf(String str, int fromIndex)
        //从指定的索引处开始，返回第一次出现的指定子字符串在该字符串中的索引。
        //7	int lastIndexOf(String str)
        //返回最右边出现的指定子字符串在此字符串中的索引。
        //8	int lastIndexOf(String str, int fromIndex)
        //返回 String 对象中子字符串最后出现的位置。
        //9	int length()
        // 返回长度（字符数）。
        //10	void setCharAt(int index, char ch)
        //将给定索引处的字符设置为 ch。
        //11	void setLength(int newLength)
        //设置字符序列的长度。
        //12	CharSequence subSequence(int start, int end)
        //返回一个新的字符序列，该字符序列是此序列的子序列。
        //13	String substring(int start)
        //返回一个新的 String，它包含此字符序列当前所包含的字符子序列。
        //14	String substring(int start, int end)
        //返回一个新的 String，它包含此序列当前所包含的字符子序列。
        //15	String toString()
        //返回此序列中数据的字符串表示形式。

        //Java 数组  Arrays 类
        // 定义数组
        double[] myList1 = new double[4];
        double[] myList2 = {1.9, 2.9, 3.4, 3.5};
        myList1[0] = 5.6;
        myList1[1] = 4.5;
        double[] myList3 = {1.9, 2.9, 3.4, 3.5};
        // 打印所有数组元素
        for (double element: myList3) {
            System.out.println(element);
        }
        for (int i = 0; i < myList3.length; i++) {
            System.out.print(myList3[i] + " ");
        }
        String[][] strqqq2 = new String[3][4];
        String[][] strqqq = new String[2][];
        strqqq[0] = new String[2];
        strqqq[1] = new String[3];
        strqqq[0][0] = new String("Good");
        strqqq[0][1] = new String("Luck");
        strqqq[1][0] = new String("to");
        strqqq[1][1] = new String("you");
        strqqq[1][2] = new String("!");

        //Java 正则表达式
        //Pattern 类：
        //pattern 对象是一个正则表达式的编译表示。Pattern 类没有公共构造方法。要创建一个 Pattern 对象，你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。该方法接受一个正则表达式作为它的第一个参数。
        //
        //Matcher 类：
        //Matcher 对象是对输入字符串进行解释和匹配操作的引擎。与Pattern 类一样，Matcher 也没有公共构造方法。你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。
        //
        //PatternSyntaxException：
        //PatternSyntaxException 是一个非强制异常类，它表示一个正则表达式模式中的语法错误。
        String content = "I am noob " +
                "from runoob.com.";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }

        //Java 日期时间
        //1	boolean after(Date date)
        //若当调用此方法的Date对象在指定日期之后返回true,否则返回false。
        //2	boolean before(Date date)
        //若当调用此方法的Date对象在指定日期之前返回true,否则返回false。
        //3	Object clone( )
        //返回此对象的副本。
        //4	int compareTo(Date date)
        //比较当调用此方法的Date对象和指定日期。两者相等时候返回0。调用对象在指定日期之前则返回负数。调用对象在指定日期之后则返回正数。
        //5	int compareTo(Object obj)
        //若obj是Date类型则操作等同于compareTo(Date) 。否则它抛出ClassCastException。
        //6	boolean equals(Object date)
        //当调用此方法的Date对象和指定日期相等时候返回true,否则返回false。
        //7	long getTime( )
        //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
        //8	int hashCode( )
        // 返回此对象的哈希码值。
        //9	void setTime(long time)
        //
        //用自1970年1月1日00:00:00 GMT以后time毫秒数设置时间和日期。
        //10	String toString( )
        //把此 Date 对象转换为以下形式的 String： dow mon dd hh:mm:ss zzz yyyy 其中： dow 是一周中的某一天 (Sun, Mon, Tue, Wed, Thu, Fri, Sat)。

        //Java Scanner 类
        //next() 与 nextLine() 区别
        //next():
        //
        //1、一定要读取到有效字符后才可以结束输入。
        //2、对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
        //3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
        //next() 不能得到带有空格的字符串。
        //nextLine()：
        //
        //1、以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
        //2、可以获得空白。
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // nextLine方式接收字符串
        System.out.println("nextLine方式接收：");
        // 判断是否还有输入
        if (scan.hasNextLine()) {
            str2 = scan.nextLine();
            System.out.println("输入的数据为：" + str2);
        }
        scan.close();

        //Arrays类api详解
        //前言-Arrays介绍
        //一、toString() 打印数组
        int arr[] = {1,3,5,2,9};
        String arrString = Arrays.toString(arr);
        System.out.println(arrString);
        //二、fill() 填充数组
        int[] arr1 = new int[4];
        int[][] arr2 = new int[4][4];
        Arrays.fill(arr1, 1); //填充一维数组
        for (int[] value : arr2) { //填充二维数组
            Arrays.fill(value, 1);
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println("============");
        for (int[] ints : arr2) {
            System.out.println(Arrays.toString(ints));
        }
        //三、equals() 比较数组元素是否相等
        int[] arr3 = new int[]{1, 2, 3, 4};
        int[] arr4 = new int[]{1, 2, 3, 4};
        int[] arr5 = new int[]{1, 2, 3, 5};
        System.out.println("============");
        System.out.println("arr3和arr4是否相等?"+Arrays.equals(arr3, arr4));
        System.out.println("arr3和arr5是否相等?"+Arrays.equals(arr3, arr5));

        //四、asList() 数组转列表
        String[] arr6 = {"aa", "bb", "cc"};
        Integer[] arr7 = {1, 2, 3, 5}; //注意这里不能用int
        List<String> list1 = Arrays.asList(arr6);
        List<Integer> list2 = Arrays.asList(arr7);
        //list1.add("c"); UnsupportedOperationException
        //推荐写法：将asList返回的对象转换为List对象
        String[] arr8 = {"a", "b", "c"};
        List<String> list3 = new ArrayList<>(Arrays.asList(arr8));
        list3.add("d"); //正常使用
        System.out.println(list3);
        //五、copyOf() 和 copyOfRange() 拷贝数组
        String[] arr9 = {"a1", "b1", "c1"};
        String[] arr10 = Arrays.copyOf(arr9, arr9.length); //参数1是原数组，参数2是新数组长度，多的用null补全
        String[] arr11 = Arrays.copyOfRange(arr9, 0, 1); //拷贝数组的某个范围
        System.out.println(Arrays.toString(arr10)); //[a1, b1, c1]
        System.out.println(Arrays.toString(arr11)); //[a1]
        //六、sort() 数组排序
        int[] intArray = new int[] { 4, 1, 3, -23 };
        Arrays.sort(intArray);//输出： [-23, 1, 3, 4]
        String[] strArray = new String[] { "z", "a", "C" };
        Arrays.sort(strArray);//输出： [C, a, z]
        //补充：parallelSort()
        //七、binarySearch() 二分查找法找指定元素的索引（下标）
        int[] arrq = {10,20,30,40,50};
        System.out.println(Arrays.binarySearch(arrq, 30)); //输出：2 （下标索引值从0开始）
        System.out.println(Arrays.binarySearch(arrq, 36));//输出：-4 （找不到元素，返回-x，从-1开始数，如题，返回-4）
        System.out.println(Arrays.binarySearch(arrq, 0,3,30));//输出：2 （从0到3位（不包括）找30，找到了，在第2位，返回2）
        System.out.println(Arrays.binarySearch(arrq, 0,3,40));//输出：-4 （从0到3位（不包括）找40，找不到，从-1开始数，返回-4）

        //ArraysList接口所有方法
        List<String> list = new ArrayList<>();
        //boolean add(E e)
        //将指定的元素追加到此列表的末尾
        list.add("张三");
        list.add("张三");
        //void add(int index, E element)
        //在此列表中的指定位置插入指定的元素。
        list.add(3,"李四");
        //.addAll(index, c);
        //将指定集合中的所有元素插入到此列表中，从指定的位置开始。
        Collection list22 = new ArrayList();
        System.out.println(list.addAll(list22));
        //==.clear(); ==
        list.clear();
        //==.contains(Object o); ==
        list.contains(8);
        //.get(int index);
        //返回此列表中指定位置的元素。
        System.out.println(list.get(3));
        //.indexOf(Object o);
        //返回此列表中指定元素的第一次出现的索引，如果此列表不包含元素，则返回-1。
        System.out.println(list.indexOf(3));
        //.isEmpty();
        //如果此列表不包含元素，则返回 true 。
        System.out.println(list.isEmpty());
        //.iterator();
        //以正确的顺序返回该列表中的元素的迭代器。
        System.out.println(list.iterator());
        //== .lastIndexOf(Object o);==
        //返回此列表中指定元素的最后一次出现的索引，如果此列表不包含元素，则返回-1。
        System.out.println(list.lastIndexOf(9));
        //.remove(5); 根据下标进行删除数据
        list.remove(5);
        //== .removeAll©; ==
        //从此列表中删除指定集合中包含的所有元素。
        System.out.println(list.removeAll(list22));
        //retainAll仅保留此列表中包含在指定集合中的元素。
        list.retainAll(list2);
        //set(int index, E element)
        //用指定的元素替换此列表中指定位置的元素。
        System.out.println(list.set(3,"yuot"));
        //.size() ;
        //返回此列表中的元素数。
        System.out.println("list的个数："+list.size());
        //.sort((Comparator)list);
        //使用提供的 Comparator对此列表进行排序以比较元素
        list.sort((Comparator)list);
        //== .subList(int fromIndex, int toIndex) ;==
        //返回此列表中指定的 fromIndex （包括）和 toIndex之间的独占视图
        System.out.println(list.subList(4, 6));
        //. toArray() ；
        //以正确的顺序（从第一个到最后一个元素）返回一个包含此列表中所有元素的数组。
        //将List对象转换成数组
        Object[] obj = list.toArray();
        for(Object i:obj) {
            System.out.print(i + " ");
        }
        //.replaceAll(UnaryOperator operator);
        //将该列表的每个元素替换为将该运算符应用于该元素的结果
        System.out.print("匹配成功返回值 :" );
        System.out.println(Str.replaceAll("(.*)google(.*)", "runoob" ));

        // set api
        // 1、创建对象
        Set<String> set = new HashSet<>();
        // 2、常用方法
        set.add("Jane");  // 如果此 set 中尚未包含指定元素，则添加指定元素。
        set.add("Rose");
        set.add("NBA");
        System.out.println(set); // 没有顺序
        set.add("Rose");
        System.out.println(set); //不允许有重复元素
        set.add(null);
        System.out.println(set); // [null, Rose, NBA, Jane]
        //        set.clear();// 从此 set 中移除所有元素。
        System.out.println(set.contains("Rose")); // true 如果此 set 包含指定元素，则返回 true。
        System.out.println(set.equals("Rose")); // false 该集合与指定对象是否相同
        System.out.println(set.hashCode());  // 4931530 哈希值
        System.out.println(set.isEmpty()); // false 如果此 set 不包含任何元素，则返回 true。
        System.out.println(set.remove("Rose")); // true
        System.out.println(set.size()); // 3
        System.out.println(Arrays.toString(set.toArray()));  // [null, NBA, Jane]

        //Map接口
        //常用方法
        //添加元素
        //Vput(K key, V value)  将指定的值与此映射中的指定键关联（可选操作）。　
        //void putAll(Map<? extends K,? extends V> m)  从指定映射中将所有映射关系复制到此映射中（可选操作）。
        //删除元素
        //V remove(Object key)  如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。　
        //void clear()从此映射中移除所有映射关系（可选操作）。
        //获取元素
        //V clear()从此映射中移除所有映射关系（可选操作）。
        //其它
        //void clear()从此映射中移除所有映射关系（可选操作）。
        //boolean containsKey(Object key)如果此映射包含指定键的映射关系，则返回 true。
        //boolena containsKey(Object key)如果此映射包含指定键的映射关系，则返回 true。
        //boolean equals(Object o)比较指定的对象与此映射是否相等。
        //int hashCode()返回此映射的哈希码值。
        //boolean isEmpty()如果此映射未包含键-值映射关系，则返回 true。
        //int size() 返回此映射中的键-值映射关系数。
        //Collection<V> values()  返回此映射中包含的值的 Collection 视图。
        //Set<K> keySet()返回此映射中包含的键的 Set 视图。
        //Set<Map.Entry<K,V>> entrySet() 返回此映射中包含的映射关系的 Set 视图。
        // map里的元素是一对映射关系的数据，其中key和value可以泛型约束
        Map<String,Integer> map = new HashMap<>();
        map.put("3", 300);  // 向map中添加数据时，需要同时指定Key和Value
        map.put("4", 400);
        map.put("1", 100);
        map.put("2", 200);
        // map数据无序
        System.out.println(map); // {1=1, 2=2, 3=3, 4=4}

        map.put("1",100);
        System.out.println(map);  // map中的key不可以重复，否则key对应的value值将会被覆盖

        //  map.clear(); // 从此映射中移除所有映射关系（可选操作）。
        System.out.println(map.containsKey("1")); // true  如果此映射包含指定键的映射关系，则返回 true。
        System.out.println(map.containsKey("100")); //false
        System.out.println(map.containsValue(2)); // true  如果此映射将一个或多个键映射到指定值，则返回 true。
        System.out.println(map.containsValue(100)); // false

        System.out.println(map.entrySet()); // [1=100, 2=200, 3=300, 4=400] 返回此映射中包含的映射关系的 Set 视图。
        System.out.println(map.hashCode());  // 1042  返回此映射的哈希码值。
        System.out.println(map.get("3"));  // 300 返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
        System.out.println(map.equals("110")); // false 比较指定的对象与此映射是否相等。
        System.out.println(map.isEmpty()); // false 如果此映射未包含键-值映射关系，则返回 true。
        System.out.println(map.remove("1")); // 100 如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。
        System.out.println(map); // {2=200, 3=300, 4=400}
        System.out.println(map.size()); // 3 返回此映射中的键-值映射关系数。
        System.out.println(map.values()); // [[200, 300, 400] 返回此映射中包含的值的 Collection 视图。

        //map中的几种迭代方式
        map = new HashMap<>();
        map.put("3", 300);  // 2、向map中添加数据时，需要同时指定Key和Value
        map.put("4", 400);
        map.put("1", 100);
        map.put("2", 200);

        System.out.println(map);
        // 第一种方式
        // Set<k> keySet() // 把map中的key数据收集到set集合里
        Set<String> set1 = map.keySet();
        Iterator<String> it = set1.iterator();
        while(it.hasNext()) {
            Object key= it.next();
            System.out.println("Key:" + key + ",Value:" + map.get(key));
        }

        // 第二种方式
        // Set<Map.Entry<K,V>> entrySet() --> 把map中的每条记录封装成Entry对象存入set
        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        for(Map.Entry<String,Integer> entry : entries ) {
            System.out.println("Key:" + entry.getKey() + ",Value:" + entry.getValue());
        }

        // 第三种方式
        Iterator it2 = entries.iterator();
        while(it2.hasNext()) {
            Map.Entry<String,Integer> entry = (Map.Entry<String, Integer>) it2.next();
            System.out.println("Key:" + entry.getKey() + ",Value:" + entry.getValue());
        }

        //

    }

    public static void main1(String[] args) throws IOException {
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }

    public static void main3(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // next方式接收字符串
        System.out.println("next方式接收：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }
        scan.close();
    }

}
