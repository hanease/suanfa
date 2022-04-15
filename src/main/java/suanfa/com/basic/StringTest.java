package suanfa.com.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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


    //反转字符串--对称交换即可
    public void reverseString(char[] s) {
        int length = s.length;
        char temp;
        for (int i = 0; i < length/2; i++) {
            temp = s[i];
            s[i] = s[length-1-i];
            s[length-1-i] = temp;
        }
    }

    //整数反转
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }

    //字符串中的第一个唯一字符
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++)
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                return i;
        return -1;

    }
    public int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap();
        char[] chars = s.toCharArray();
        //先统计每个字符的数量
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        //然后在遍历字符串s中的字符，如果出现次数是1就直接返回
        for (int i = 0; i < s.length(); i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;

    }

    //有效的字母异位词
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < s.length(); i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;

    }

    //验证回文串
    public boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            //因为题中说了，只考虑字母和数字，所以不是字母和数字的先过滤掉
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            //然后把两个字符变为小写，在判断是否一样，如果不一样，直接返回false
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }

    //最长回文子串
    //给你一个字符串 s，找到 s 中最长的回文子串。
    public static String longestPalindrome(String s) {
        //边界条件判断
        if (s.length() < 2)
            return s;
        //start表示最长回文串开始的位置，
        //maxLen表示最长回文串的长度
        int start = 0, maxLen = 1;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int right = 1; right < length; right++) {
            for (int left = 0; left < right; left++) {
                //如果两种字符不相同，肯定不能构成回文子串
                if (s.charAt(left) != s.charAt(right))
                    continue;

                //下面是s.charAt(left)和s.charAt(right)两个
                //字符相同情况下的判断
                //如果只有一个字符，肯定是回文子串
                if (right == left) {
                    dp[left][right] = true;
                } else if (right - left <= 2) {
                    //类似于"aa"和"aba"，也是回文子串
                    dp[left][right] = true;
                } else {
                    //类似于"a******a"，要判断他是否是回文子串，只需要
                    //判断"******"是否是回文子串即可
                    dp[left][right] = dp[left + 1][right - 1];
                }
                //如果字符串从left到right是回文子串，只需要保存最长的即可
                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
            }
        }
        //截取最长的回文子串
        return s.substring(start, start + maxLen);
    }

    //字符串转换整数 (atoi)
    //请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
    //
    //函数 myAtoi(string s) 的算法如下：
    // 输入：s = "4193 with words"
    //输出：4193
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int index = 0;
        // 先去除空格
        while (index < length && chars[index] == ' '){
            index++;
        }
        // 极端情况 "  " 和""
        if(index >= length){
            return 0;
        }
        // 再判断符号
        int sign =  1;
        if(chars[index] == '-' || chars[index] == '+'){
            if(chars[index] == '-'){
                sign = -1;
            }
            index++;
        }
        int result = 0;
        int temp = 0;
        while (index < length){
            int num = chars[index] - '0';
            if(num > 9 || num < 0){
                break;
            }
            temp = result;
            result = result * 10 + num;
            // 越界后，数值和期望数值发生变化，取余再除10获取原始值，比对判断
            if(result/10 !=temp){
                if(sign > 0){
                    return Integer.MAX_VALUE;
                }else {
                    return Integer.MIN_VALUE;
                }
            }
            index++;
        }
        return result*sign;
    }

    public int myAtoi1(String str) {
        str = str.trim();//去掉前后的空格
        //如果为空，直接返回0
        if (str.length() == 0)
            return 0;
        int index = 0;//遍历字符串中字符的位置
        int res = 0;//最终结果
        int sign = 1;//符号，1是正数，-1是负数，默认为正数
        int length = str.length();
        //判断符号
        if (str.charAt(index) == '-' || str.charAt(index) == '+')
            sign = str.charAt(index++) == '+' ? 1 : -1;
        for (; index < length; ++index) {
            //取出字符串中字符，然后转化为数字
            int digit = str.charAt(index) - '0';
            //按照题中的要求，读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
            //字符串的其余部分将被忽略。如果读取了非数字，后面的都要忽略
            if (digit < 0 || digit > 9)
                break;
            //越界处理
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else
                res = res * 10 + digit;
        }
        return sign * res;
    }

    //实现 strStr()
    //实现 strStr() 函数。
    //
    //给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
    public int strStr(String haystack, String needle) {
        int length = needle.length();
        int total = haystack.length() - length + 1;
        for (int start = 0; start < total; ++start) {
            if (haystack.substring(start, start + length).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    //外观数列
    public String countAndSay(int n) {
        // 递归出口
        if(n==1){
            return "1";
        }
        // 假设我们获得上一次的结果为 s1 = 112213
        String s1 = countAndSay(n - 1);
        // 定义结果
        StringBuilder result = new StringBuilder();
        // 对s1遍历处理获取值
        char local = s1.charAt(0);
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            // 设定计数器 计算同一个数字出现的次数 count
            if(s1.charAt(i) == local){
                count++;
            }else {
                // 不符合，记录下
                result.append(count);
                result.append(local);
                count = 1;
                local = s1.charAt(i);
            }
        }
        result.append(count);
        result.append(local);
        return result.toString();
    }

    //最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0)
            return "";
        //默认第一个字符串是他们的公共前缀
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            //不断的截取
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
        return pre;
    }

    //有效的括号
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    //
    //有效字符串需满足：
    //
    //左括号必须用相同类型的右括号闭合。
    //左括号必须以正确的顺序闭合。
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        //遍历所有的元素
        for (char c : chars) {
            //如果是左括号，就把他们对应的右括号压栈
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                //否则就只能是右括号。
                //1，如果栈为空，说明括号无法匹配。
                //2，如果栈不为空，栈顶元素就要出栈，和这个右括号比较。
                //如果栈顶元素不等于这个右括号，说明无法匹配，
                //直接返回false。
                return false;
            }
        }
        //最后如果栈为空，说明完全匹配，是有效的括号。
        //否则不完全匹配，就不是有效的括号
        return stack.isEmpty();
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
    public void reverseString1(char[] s) {
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
