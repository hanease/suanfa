package suanfa.com.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringTest {
    public static void main(String args[]) throws IOException {
        String str = new String("Welcome-to-Runoob");
        String s1111 = "Let's take LeetCode contest";
        String abssss = reverseWords4(s1111);

        System.out.println("- 分隔符返回值 :" );
        for (String retval: str.split("-")){
            System.out.println(retval);
        }

        System.out.println("");
        System.out.println("- 分隔符设置分割份数返回值 :" );
        for (String retval: str.split("-", 1)){
            System.out.println(retval);
        }

        System.out.println("");
        String str2 = new String("www.runoob.com");
        System.out.println("转义字符返回值 :" );
        for (String retval: str2.split("\\.", 2)){
            System.out.println(retval);
        }

        System.out.println("");
        String str3 = new String("acount=? and uu =? or n=?");
        System.out.println("多个分隔符返回值 :" );
        for (String retval: str3.split("and|or")){
            System.out.println(retval);
        }

        String string = "1+2+3+4+5+6+7+8";
        String[] split = string.split("\\+", 3);
        System.out.println("数组长度：" + split.length);
        for (String s : split){
            System.out.print(s + "!\t");
        }


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

    // 翻转字符串里的单词
    // 方法一;思路：数组的翻转
    // 时间复杂度;O（n）
    // 空间复杂度：O（）
    public String reverseWords_1(String s) {
        String[] wordArray = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        int len = wordArray.length;
        // len-- 先执行表达式后赋值
        // --len 先赋值后执行表达式
        while (len-- > 0) {

            if (!wordArray[len].isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(" ");
                }
                stringBuffer.append(wordArray[len]);
            }
        }
        return stringBuffer.toString();
    }

    // 方法二：双指针，原地解法
    // 时间复杂度：O(n)，n = s.length
    // 空间复杂度：O（1）
    public String reverseWords_2(String s) {
        // 删除任何前导和尾随空格。
        s = s.trim();
        // 字符串长度
        int len = s.length();
        // 单词起止坐标
        int begin = len, end = len;
        while (len-- > 0) {
            // 遇到非单词分隔的空格符的情况
            // 去掉空格符
            if (s.charAt(len) == ' ' && begin == end) {
                // 新的字符串
                s = s.substring(0, len) + s.substring(len + 1, s.length());
                begin--;
                end--;
                // 遇到单词分隔的空格符的情况
            } else if (s.charAt(len) == ' ' && begin != end) {
                String word = s.substring(begin, end);
                s = s.substring(0, len) + (end < s.length() ? s.substring(end, s.length()) : "") + word + " ";
                begin--;
                end = begin;
                // 非空格符的情况，寻找单词起始坐标
            } else {
                begin--;
            }
        }
        // 处理最后一个单词
        String word = s.substring(0, end);
        s = s.substring(end, s.length()) + word;
        return s;
    }

    // 方法三：双指针,和方法二差不多，把需要返回的单词逐个加在s后面，最后截取s中需要返回的片段即可，比方法二简单很多
    // 时间复杂度：O(n)，n = s.length
    // 空间复杂度：O（1）
    // 方法四：递归
    public String reverseWords_4(String s) {
        s = s.trim();
        int len = s.length();
        while (len-- > 0) {
            if (s.charAt(len) == ' ') {
                String word = s.substring(len + 1, s.length());
                return word + " " + reverseWords(s.substring(0, len));
            }
        }
        return s;
    }

    //反转字符串
    //示例 1：
    //
    //输入：s = ["h","e","l","l","o"]
    //输出：["o","l","l","e","h"]
    public void reverseString(char[] s) {
        // 双指针解决
        if(s == null || s.length < 2){
            return;
        }
        int l = 0;
        int r = s.length -1;
        while(l < r){
            char c = s[l];
            s[l] = s[r];
            s[r] = c;
            l++;
            r--;
        }
    }

    //  翻转字符串里的单词
    public String reverseWords(String s) {
        // 设置一个栈存放单词
        Stack<String> stack = new Stack<>();
        s.trim();
        String[] wordArray = s.split(" ");
        for (String word : wordArray) {
            if (!word.isEmpty()) {
                stack.add(word);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop());
            if (!stack.isEmpty()){
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    //反转字符串中的单词 III
    //给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
    //
    // 
    //
    //示例 1：
    //
    //输入：s = "Let's take LeetCode contest"
    //输出："s'teL ekat edoCteeL tsetnoc"
    public static String reverseWords4(String s) {

        String[] arr = s.split(" ");
        String[] result = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            String rev = new StringBuffer(arr[i]).reverse().toString();
            result[i] = rev;
        }
        return String.join(" ", result);
    }
    public String reverse1(String s) {
        return  new StringBuffer(s).reverse().toString();
    }
    public String reverse2(String s) {
        String result = "";
        for(int i =s.length()-1; i>=0; i--){
            result = result + s.charAt(i);
        }
        return result;
    }
    public String reverse3(String s) {
        String result = "";
        char[] arr = s.toCharArray();
        for(int i =arr.length-1; i>=0; i--){
            result = result + arr[i];
        }
        return result;
    }

}
