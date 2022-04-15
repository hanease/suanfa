package suanfa.com.basic;

import java.util.*;

public class MidAllTest {

    public static void main(String[] args) {
        double[] myList = {1.9, 2.9, 3.4, 3.5};
        int[] input = new int[]{3, 1, 2, 6, -4, 2};
        int[] nums = new int[]{1, 1, 2, 3, 4, 4, 5};
        int[] nums1 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(nums1);
    }

    //回溯算法-------------------------------------------------------------------
    //电话号码的字母组合
    //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    //给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    //输入：digits = "23"
    //输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        Deque<Character> path = new ArrayDeque<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(digits, 0, ans, path, map);
        return ans;
    }

    private static void backtrack(String digits, int begin, List<String> ans, Deque<Character> path, Map<Character, String> map) {
        if (path.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character character : path) {
                sb.append(character);
            }
            ans.add(sb.toString());
            return;
        }
        for (int i = begin; i < digits.length(); i++) {
            String s = map.get(digits.charAt(i));
            for (int j = 0; j < s.length(); j++) {
                path.addLast(s.charAt(j));
                backtrack(digits, i + 1, ans, path, map);
                path.removeLast();
            }
        }

    }

    //括号生成
    //数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    //输入：n = 3
    //输出：["((()))","(()())","(())()","()(())","()()()"]
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, n, n, "");
        return res;
    }

    private void dfs(List<String> res, int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，说明找到了有效的括号
            res.add(curStr);
            return;
        }
        //左括号只有剩余的时候才可以选，如果左括号的数量已经选完了，是不能再选左括号了。
        //如果选完了左括号我们是还可以选择右括号的。
        if (left < 0)
            return;
        // 如果右括号剩余数量小于左括号剩余的数量，说明之前选择的无效
        if (right < left)
            return;
        //选择左括号
        dfs(res, left - 1, right, curStr + "(");
        //选择右括号
        dfs(res, left, right - 1, curStr + ")");
    }

    //全排列
    //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    //输入：nums = [1,2,3]
    //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]







    //回溯算法-------------------------------------------------------------------

    //回溯算法-------------------------------------------------------------------
    //回溯算法-------------------------------------------------------------------
    //回溯算法-------------------------------------------------------------------
    //回溯算法-------------------------------------------------------------------
    //回溯算法-------------------------------------------------------------------
    //回溯算法-------------------------------------------------------------------


}
