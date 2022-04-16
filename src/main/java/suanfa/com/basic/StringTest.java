package suanfa.com.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StringTest {
    public static void main(String args[]) throws IOException {
        String str = new String("Welcome-to-Runoob");
        String s1111 = "Let's take LeetCode contest";
        //String abssss = reverseWords4(s1111);
        String abssss11 = deleteText(s1111,8);

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

    //反转字符串
    //示例 1：
    //
    //输入：s = ["h","e","l","l","o"]
    //输出：["o","l","l","e","h"]
    public void reverseString1(char[] nums) {
        if (nums.length <= 1)
            return;

        int herd = 0;
        int tail = nums.length - 1;
        while (herd < tail) {
            //获取尾部下标数据
            char str = nums[tail];
            //尾部数据 = 头步数据
            nums[tail] = nums[herd];
            //头部数据 = 尾部数据
            nums[herd] = str;
            herd ++;
            tail --;
        }
    }

    // 翻转字符串里的单词
    // 方法一;思路：数组的翻转
    //输入：s = "the sky is blue"
    //输出："blue is sky the"
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
                return word + " " + reverseWords_4(s.substring(0, len));
            }
        }
        return s;
    }

    //反转字符串中的单词 III
    //给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
    //示例 1：
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

    //计数质数
    //给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
    //输入：n = 10
    //输出：4
    //解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
    public int countPrimes(int n) {
        boolean[] arr = new boolean[n];
        int cnt = 0;
        for(int i = 2; i < n; i++) {
            if(arr[i]) continue;
            cnt++;
            for(int j = i; j < n; j+=i) {
                arr[j] = true;
            }
        }
        return cnt;
    }

    //3的幂
    //给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
    //
    //整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
    public boolean isPowerOfThree(int n) {
        if (n > 1)
            while (n % 3 == 0)
                n /= 3;
        return n == 1;
    }

    //Fizz Buzz
    //给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
    //
    //answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
    //answer[i] == "Fizz" 如果 i 是 3 的倍数。
    //answer[i] == "Buzz" 如果 i 是 5 的倍数。
    //answer[i] == i （以字符串形式）如果上述条件全不满足。
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0)
                res.add("Fizz");
            else if (i % 5 == 0)
                res.add("Buzz");
            else
                res.add(Integer.toString(i));
        }
        return res;
    }

    //罗马数字转整数
    //罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
    //
    //字符          数值
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        //所有可能的都列出来
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int res = 0;
        for (int i = 0; i < s.length(); ) {
            //先截取两个字符，如果这两个字符存在于map中，就表示他们是一个整体。否则就截取一个
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                res += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                res += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return res;
    }

    //位1的个数
    //编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >>> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    //颠倒二进制位
    //颠倒给定的 32 位无符号整数的二进制位。
    //请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
    //在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
    //输入：n = 00000010100101000001111010011100
    //输出：964176192 (00111001011110000010100101000000)
    //解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
    //     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //res先往左移一位，把最后一个位置空出来，
            //用来存放n的最后一位数字
            res <<= 1;
            //res加上n的最后一位数字
            res |= n & 1;
            //n往右移一位，把最后一位数字去掉
            n >>= 1;
        }
        return res;
    }

    //杨辉三角
    //给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
    //
    //在「杨辉三角」中，每个数是它左上方和右上方的数的和。

    public static List<List<Integer>> generate(int numRows) {
        //结果值
        List<List<Integer>> res = new ArrayList<>();
        //每一行的元素
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            //下面一行都会比上面一行多一个元素，我们在第一个位置给他加个1
            row.add(0, 1);
            //遍历每一行的结果，遍历的时候跳过第一个和最后一个，
            //每个格子的值都是他正上面和左上角元素的和
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            //把结果存放到res中
            res.add(new ArrayList<>(row));
        }
        return res;
    }


    //招商银行-01. 文本编辑程序设计
    //通过的用户数712
    //尝试过的用户数736
    //用户总通过次数722
    //用户总提交次数1753
    //题目难度Easy
    //请你设计一个文本编辑程序，需要编辑的稿件 article 为仅由大写字母、小写字母与空格组成的字符串（下标从 0 开始），光标所在字符串下标位置记作 index，程序运行后，若光标停留位置为空格，不作操作，返回原文本；否则光标所在位置对应的整个单词将被删除，并返回编辑后经过整理空格的文本。
    //
    //注意：
    //
    //输入保证字符串不以空格开头和结尾且不包含连续的空格。
    //返回的字符串不以空格开头和结尾且不包含连续的空格。若删除单词后有多余的空格，需要删除。
    //示例 1：
    //
    //输入：article = "Singing dancing in the rain", index = 10
    //
    //输出："Singing in the rain"
    //
    //解释：
    //"Singing dancing in the rain" 光标位于 "dancing" 单词的字符 'n'
    //删除光标所在的单词 "dancing" 及其前或后的一个空格。
    //
    //示例 2：
    //
    //输入：article = "Hello World", index = 2
    //
    //输出："World"
    public static  String deleteText(String article, int index) {
        char se = article.charAt(index);
        if(" ".equals(String.valueOf(se))){
            return article;
        }
        String[] words = article.split(" ");
        List<String> aa = new ArrayList<>();
        for(String word1:words){
            aa.add(word1);
        }
        int selec = 0;
        int size = 0;
        for(String word:words){
            size = size+word.length() + 1;
            if(index<size){
                break;
            }
            selec++;
        }
        aa.remove(selec);
        return String.join(" ", aa);

    }

    //串联所有单词的子串
    //给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
    //
    //注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
    //输入：s = "barfoothefoobarman", words = ["foo","bar"]
    //输出：[0,9]
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();

        int len = s.length() - wordLen * words.length;
        List<String> baseList = Arrays.asList(words);
        List<String> wordList;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= len; i++) {
            wordList = new ArrayList<>(baseList);

            boolean flag = true;
            for (int j = 0; j < words.length; j++) {

                if (!flag) {
                    continue;
                }

                flag = wordList.remove(s.substring(i + (j * wordLen), i + ((j + 1) * wordLen)));
            }

            if (flag) {
                result.add(i);
            }

        }
        return result;
    }

    //32. 最长有效括号
    //给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
    //输入：s = "(()"
    //输出：2
    //解释：最长有效括号子串是 "()"
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);

        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxLen = Math.max(maxLen, i- stack.peek());
                }
            }
        }

        return maxLen;
    }

    //3. 无重复字符的最长子串
    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
    //示例 1:
    //
    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    //93. 复原 IP 地址
    //有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
    //
    //例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
    //给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
    //输入：s = "25525511135"
    //输出：["255.255.11.135","255.255.111.35"]
    List<String> ret = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        LinkedList<String> path = new LinkedList<>();
        backTrace(0,s,path);
        return ret;
    }

    public void backTrace(int startIndex, String s, LinkedList<String> path){
        if(path.size() > 4) return; // 长度>4剪枝
        if(startIndex == s.length() && path.size() == 4){
            ret.add(toResult(path));
            return;
        }
        for(int i = startIndex;i<s.length();i++){
            String str = s.substring(startIndex,i+1);
            if(!isValid1(str)) continue;
            path.offerLast(str);
            backTrace(i+1,s,path);
            path.removeLast();
        }
    }

    public String toResult(LinkedList<String> path){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < path.size(); i++){
            sb.append(path.get(i));
            if(i != path.size() - 1)
                sb.append(".");
        }
        return sb.toString();
    }

    public boolean isValid1(String s){
        if(s.length()==1) return true;
        if(s.length()>3) return false;
        if(s.charAt(0) == '0') return false;
        if(Integer.valueOf(s) > 255) return false;
        return true;
    }


    //187. 重复的DNA序列
    //DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
    //
    //例如，"ACGAATTCCG" 是一个 DNA序列 。
    //在研究 DNA 时，识别 DNA 中的重复序列非常有用。
    //
    //给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
    //输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    //输出：["AAAAACCCCC","CCCCCAAAAA"]
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if (len < 10) return new ArrayList<>();
        Set<String> res = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 10; i <= len; i++) {
            String sub = s.substring(i - 10, i);
            if (map.containsKey(sub)) {
                res.add(sub);
            } else {
                map.put(sub, 1);
            }
        }
        return new ArrayList<>(res);
    }


}
