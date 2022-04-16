package suanfa.com.basic;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayMidTest {

    public static void main(String[] args) {
        double[] myList = {1.9, 2.9, 3.4, 3.5};
        int[] input = new int[]{3, 1, 2, 6, -4, 2};
        int[] nums = new int[]{1, 1, 2, 3, 4, 4, 5};
        int[] nums1 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        List<List<Integer>> ren = threeSum(input);
        System.out.println(ren.toArray());
    }

    //三数之和
    public static List<List<Integer>> threeSum(int[] nums) {
        //先对数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            //过滤掉重复的
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            //因为是排序的，如果第一个数字大于0，那么后面的也都
            //大于0，他们三个数字的和不可能等于0
            if (nums[i] > 0)
                break;
            int left = i + 1;//左指针
            int right = nums.length - 1;//右指针
            int target = -nums[i];
            while (left < right) {
                //左右指针的和
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    //找到了一组，把他们加入到集合list中
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //过滤掉重复的
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;

    }

   //矩阵置零
   //给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
   public void setZeroes(int[][] matrix) {
       int m = matrix.length;//行
       int n = matrix[0].length;//列
       //row[i]表示第i行是否有0
       boolean[] row = new boolean[m];
       boolean[] col = new boolean[n];

       //第一次遍历，确定哪些行哪些列应该为0
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               //如果当前位置是0，那么当前的行
               //和当前的列都应该标注为0
               if (matrix[i][j] == 0) {
                   row[i] = true;
                   col[j] = true;
               }
           }
       }
       //把那些应该为0的行和列全部置为0
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               if (row[i] || col[j]) {
                   matrix[i][j] = 0;
               }
           }
       }
   }

    //在二维转置矩阵中的应用
    public int[][] transpose(int[][] A) {
        int x=A.length;
        int y=A[0].length;
        int[][] B=new int[y][x];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                B[j][i]=A[i][j];
            }
        }
        return B;
    }

    //字母异位词分组
    //字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
    //输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    //输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length;
        if(n == 0) return ans;
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if(map.containsKey(s)){
                map.get(s).add(str);
            }else{
                map.put(s,new ArrayList<>(Arrays.asList(str)));
            }
        }
        for(String key : map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if(strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            // 将字符串转化为字符数组后排序
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            // 将排序后的字符串作为key
            String strKey = String.valueOf(ch);
            // 如果map中不存在排序后的字符串的key，创建一个list
            if(!map.containsKey(strKey))
                map.put(strKey, new ArrayList<>());
            // 将原字符串添加到key对应的列表中
            map.get(strKey).add(s);
        }
        return new ArrayList<>(map.values());
    }

    //无重复字符的最长子串
    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    public int lengthOfLongestSubstring1(String s) {
        //创建队列
        Queue<Character> queue = new LinkedList<>();
        int max = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                //如果有重复的，队头出队，直到没有重复的为止
                queue.poll();
            }
            //添加到队尾
            queue.add(c);
            //更新max
            max = Math.max(max, queue.size());
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] dict = new int[128];
        Arrays.fill(dict, -1);
        int max = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            //left记录的是没有重复字符串的最左边的那个字符的位置
            left = Math.max(dict[s.charAt(i)] + 1, left);
            //记录当前字符的位置
            dict[s.charAt(i)] = i;
            //更新max
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring3(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            //移除重复的
            while (set.contains(s.charAt(right)))
                set.remove(s.charAt(left++));
            set.add(s.charAt(right++));
            //更新max
            max = Math.max(max, set.size());
        }
        return max;
    }

    //递增的三元子序列
    //给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
    //
    //如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
    //
    //输入：nums = [1,2,3,4,5]
    //输出：true
    //解释：任何 i < j < k 的三元组都满足题意
    public boolean increasingTriplet(int[] nums) {
        //3个数字，small记录最小的数字
        int small = Integer.MAX_VALUE;
        //mid记录中间的数字
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                //记录遍历过的最小值
                small = num;
            } else if (num <= mid) {
                //记录比small大的最小值，也就是mid的值
                mid = num;
            } else {
                //mid如果赋值了，那么之前肯定有个比
                //mid小的值，这里又有个比mid大的值，
                //所以他们三个可以构成递增的三元子序列
                return true;
            }
        }
        return false;
    }

    //有效的数独
    public boolean isValidSudoku(char[][] board) {
        int[] line = new int[9];
        int[] column = new int[9];
        int[] cell = new int[9];
        int shift = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //如果还没有填数字，直接跳过
                if (board[i][j] == '.')
                    continue;
                shift = 1 << (board[i][j] - '0');
                int k = (i / 3) * 3 + j / 3;
                //如果对应的位置只要有一个大于0，说明有冲突，直接返回false
                if ((column[i] & shift) > 0 || (line[j] & shift) > 0 || (cell[k] & shift) > 0)
                    return false;
                column[i] |= shift;
                line[j] |= shift;
                cell[k] |= shift;
            }
        }
        return true;
    }

    //57. 插入区间
    //给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
    //
    //在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
    //输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
    //输出：[[1,5],[6,9]]
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean visited=false;
        List<int[]>list=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int[]v=intervals[i];
            if(!visited){
                //如果要插入的区间在左边
                if(newInterval[1]<v[0]){
                    list.add(newInterval);
                    list.add(v);
                    visited=true;
                }else if(newInterval[0]>v[1]){
                    list.add(v);
                }else{
                    list.add(merge(v,newInterval));
                    visited=true;
                }
            }else{
                //visited=true
                int[] last=list.get(list.size()-1);
                if(v[0]<=last[1]){
                    //涉及
                    list.add(merge(v,list.remove(list.size()-1)));
                }else list.add(v);
            }
        }
        if(!visited) list.add(newInterval);
        int[][]res=new int[list.size()][2];
        IntStream.range(0,list.size()).forEach(i->res[i]=list.get(i));
        return res;
    }
    public int[] merge(int[]a,int[]b){
        return new int[]{Math.min(a[0],b[0]),Math.max(a[1],b[1])};
    }

    //442. 数组中重复的数据
    //给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
    //
    //你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
    //输入：nums = [4,3,2,7,8,2,3,1]
    //输出：[2,3]
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> rs = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(nums[Math.abs(nums[i])-1]<0) {
                rs.add(Math.abs(nums[i]));
            }else {
                nums[Math.abs(nums[i])-1]*=-1;
            }
        }

        return rs;
    }

    //1817. 查找用户活跃分钟数
    //给你用户在 LeetCode 的操作日志，和一个整数 k 。日志用一个二维整数数组 logs 表示，其中每个 logs[i] = [IDi, timei] 表示 ID 为 IDi 的用户在 timei 分钟时执行了某个操作。
    //多个用户 可以同时执行操作，单个用户可以在同一分钟内执行 多个操作 。
    //指定用户的 用户活跃分钟数（user active minutes，UAM） 定义为用户对 LeetCode 执行操作的 唯一分钟数 。 即使一分钟内执行多个操作，也只能按一分钟计数。
    //请你统计用户活跃分钟数的分布情况，统计结果是一个长度为 k 且 下标从 1 开始计数 的数组 answer ，对于每个 j（1 <= j <= k），answer[j] 表示 用户活跃分钟数 等于 j 的用户数
    //返回上面描述的答案数组 answer 。
    //输入：logs = [[0,5],[1,2],[0,2],[0,5],[1,3]], k = 5
    //输出：[0,2,0,0,0]
    //解释：
    //ID=0 的用户执行操作的分钟分别是：5 、2 和 5 。因此，该用户的用户活跃分钟数为 2（分钟 5 只计数一次）
    //ID=1 的用户执行操作的分钟分别是：2 和 3 。因此，该用户的用户活跃分钟数为 2
    //2 个用户的用户活跃分钟数都是 2 ，answer[2] 为 2 ，其余 answer[j] 的值都是 0
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] array = new int[k];
        Arrays.sort(logs, (o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);
        map.put(logs[0][0],1);
        for (int i = 1; i < logs.length; i++) {
            if (logs[i-1][0]==logs[i][0]&&logs[i-1][1]==logs[i][1]){
                continue;
            }
            map.put(logs[i][0],map.getOrDefault(logs[i][0],0)+1);
        }
        for (Integer integer : map.keySet()) {
            array[map.get(integer)-1]+=1;
        }
        return array;
    }

    //1333. 餐厅过滤器
    //给你一个餐馆信息数组 restaurants，其中  restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]。你必须使用以下三个过滤器来过滤这些餐馆信息。
    //
    //其中素食者友好过滤器 veganFriendly 的值可以为 true 或者 false，如果为 true 就意味着你应该只包括 veganFriendlyi 为 true 的餐馆，为 false 则意味着可以包括任何餐馆。此外，我们还有最大价格 maxPrice 和最大距离 maxDistance 两个过滤器，它们分别考虑餐厅的价格因素和距离因素的最大值。
    //
    //过滤后返回餐馆的 id，按照 rating 从高到低排序。如果 rating 相同，那么按 id 从高到低排序。简单起见， veganFriendlyi 和 veganFriendly 为 true 时取值为 1，为 false 时，取值为 0 。
    //输入：restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly = 1, maxPrice = 50, maxDistance = 10
    //输出：[3,1,5]
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        // 过滤收集
        List<int[]> collector = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if (veganFriendly == 1 && restaurant[2] == 0 || restaurant[3] > maxPrice || restaurant[4] > maxDistance) {
                continue;
            }
            collector.add(restaurant);
        }
        // 排序
        collector.sort((o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);
        List<Integer> res = new ArrayList<>();
        for (int[] rest : collector) {
            res.add(rest[0]);
        }
        return res;
    }





}
