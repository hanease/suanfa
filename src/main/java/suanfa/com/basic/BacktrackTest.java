package suanfa.com.basic;

import java.util.*;

public class BacktrackTest {

    public static void main(String[] args) {
        double[] myList = {1.9, 2.9, 3.4, 3.5};
        int[] input = new int[]{3, 1, 82, 82, -4, 2,19,3,-1};
        int[] nums = new int[]{1, 1, 2, 3, 4, 4, 5};
        int[] nums1 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        int ren = findKthLargest(input,4);
        int[] m = searchRange(nums,4);
        System.out.println(ren);
    }



    //电话号码的字母组合
    //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
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

    //全排列
    //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        //终止条件，如果数字都被使用完了，说明找到了一个排列，（可以把它看做是n叉树到
        //叶子节点了，不能往下走了，所以要返回）
        if (tempList.size() == nums.length) {
            //因为list是引用传递，这里必须要重新new一个
            list.add(new ArrayList<>(tempList));
            return;
        }
        //（可以把它看做是遍历n叉树每个节点的子节点）
        for (int i = 0; i < nums.length; i++) {
            //因为不能有重复的，所以有重复的就跳过
            if (tempList.contains(nums[i]))
                continue;
            //选择当前值
            tempList.add(nums[i]);
            //递归（可以把它看做遍历子节点的子节点）
            backtrack(list, tempList, nums);
        }
    }



    //子集
    //给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
    //解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
    //输入：nums = [1,2,3]
    //输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        //走过的所有路径都是子集的一部分，所以都要加入到集合中
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            //做出选择
            tempList.add(nums[i]);
            //递归
            backtrack(list, tempList, nums, i + 1);
            //撤销选择
            tempList.remove(tempList.size() - 1);
        }
    }

    //单词搜索
    //给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
    //单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //从[i,j]这个坐标开始查找
                if (dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
        //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index])
            return false;
        //如果word的每个字符都查找完了，直接返回true
        if (index == word.length - 1)
            return true;
        //把当前坐标的值保存下来，为了在最后复原
        char tmp = board[i][j];
        //然后修改当前坐标的值
        board[i][j] = '.';
        //走递归，沿着当前坐标的上下左右4个方向查找
        boolean res = dfs(board, word, i + 1, j, index + 1)
                || dfs(board, word, i - 1, j, index + 1)
                || dfs(board, word, i, j + 1, index + 1)
                || dfs(board, word, i, j - 1, index + 1);
        //递归之后再把当前的坐标复原
        board[i][j] = tmp;
        return res;
    }

    //多数元素
    //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    //
    //你可以假设数组是非空的，并且给定的数组总是存在多数元素。

    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //遇到友军阵容增加
            if (res == nums[i])
                count++;
            else {
                //遭遇敌军，对拼消耗
                count--;
                //该批友军阵亡，换下一批作为友军记录
                if (count == 0) {
                    res = nums[i + 1];
                }
            }
        }
        return res;
    }

    //颜色分类
    //给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    //我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
    //必须在不使用库的sort函数的情况下解决这个问题。
    // 
    //示例 1：
    //输入：nums = [2,0,2,1,1,0]
    //输出：[0,0,1,1,2,2]
    public void sortColors(int[] nums) {
        int left=0, right=nums.length-1;   //left代表红色，right代表蓝色
        for(int i=0; i<=right; i++){
            if(nums[i] == 0){
                swap(nums, left, i);
                left++;
            }
            if(nums[i] == 2){
                swap(nums, i, right);
                right--;
                i--;                     //防止漏算
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //前 K 个高频元素
    //给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
    //示例 1:
    //
    //输入: nums = [1,1,1,2,2,3], k = 2
    //输出: [1,2]

    public int[] topKFrequent(int[] nums, int k) {
        //先统计每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        //最大堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int key : map.keySet())
            priorityQueue.add(new int[]{key, map.get(key)});

        //取堆中最大的k个元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = priorityQueue.poll()[0];
        return res;
    }


    //数组中的第K个最大元素
    //给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    //
    //请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

    public static int findKthLargest(int[] nums, int k) {
        boolean flag = false;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int num : nums) {
            heap.offer(num);
            if (flag || heap.size() > k) {
                heap.poll();
                flag = true;
            }
        }
        return heap.peek();
    }

    //寻找峰值
    //峰值元素是指其值严格大于左右相邻值的元素。
    //
    //给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
    //
    //你可以假设 nums[-1] = nums[n] = -∞ 。

    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(i - 1 >=0 && nums[i - 1] > nums[i])
                continue;
            if(i + 1 < nums.length && nums[i + 1] > nums[i])
                continue;
            return i;
        }
        return -1;
    }


    //在排序数组中查找元素的第一个和最后一个位置
    //给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    //
    //如果数组中不存在目标值 target，返回 [-1, -1]。
    //
    //进阶：
    //
    //你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
    // 
    //
    //示例 1：
    //
    //输入：nums = [5,7,7,8,8,10], target = 8
    //输出：[3,4]
    public static int[] searchRange(int[] nums, int target) {
        int count1 = 0;
        int count2 = 0;
        boolean b = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count1 = i;
                b = false;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                count2 = i;
                b = false;
                break;
            }
        }
        if (b == false) {
            return new int[]{count1, count2};
        }
        return new int[]{-1, -1};
    }


}
