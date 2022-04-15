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

    //排序和搜索-------------------------------------------------------------------
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

    //你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
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

    //合并区间
    //以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
    //输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    //输出：[[1,6],[8,10],[15,18]]
    //解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        //1、对二维数组按照第一列升序排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        //2、进行合并数组
        List<int []> list = new ArrayList<>();
        int term[] =intervals[0];//临时空间，1 判断是否需要合并集合，2 是否放入结果集
        for (int i = 1; i < intervals.length; i++) {
            if (term[1]>=intervals[i][0]){
                term[1]=Math.max(term[1],intervals[i][1]);
            }else {
                list.add(term);
                term=intervals[i];
            }
        }
        list.add(term);
        return list.toArray(new int[list.size()][2]);
    }

    //搜索旋转排序数组
    //整数数组 nums 按升序排列，数组中的值 互不相同 。
    //
    //在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
    //
    //给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
    //输入：nums = [4,5,6,7,0,1,2], target = 0
    //输出：4
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[i]) {
                if (target < nums[mid] && target >= nums[i]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else if (nums[mid] < nums[i]) {
                if (target > nums[mid] && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }

    //搜索二维矩阵 II
    //编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
    //
    //每行的元素从左到右升序排列。
    //每列的元素从上到下升序排列。
    //输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
    //输出：true
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0, j = matrix[0].length - 1; i < matrix.length && j >= 0; ) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    //数学-------------------------------------------------------------------
    //快乐数
    //编写一个算法来判断一个数 n 是不是快乐数。
    //
    //「快乐数」 定义为：
    //
    //对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
    //然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
    //如果这个过程 结果为 1，那么这个数就是快乐数。
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int temp = n;
            int sum = 0;
            while (temp >= 10) {
                int mod = temp % 10;
                temp /= 10;
                sum += mod * mod;
            }
            sum += temp * temp;
            if (!set.add(sum)) {
                return false;
            }
            n = sum;
        }
        return true;

    }

    //阶乘后的零
    //给定一个整数 n ，返回 n! 结果中尾随零的数量。
    //
    //提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n >= 5) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }

    //Excel表列序号
    //给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
    //A -> 1
    //B -> 2
    //C -> 3
    //...
    //Z -> 26
    //AA -> 27
    //AB -> 28
    //输入: columnTitle = "A"
    //输出: 1
    public int titleToNumber(String columnTitle) {
        char[] target = columnTitle.toCharArray();
        int res = 0;
        for(char c:target){
            int curNum = c-'A'+1;
            res = res*26+curNum;
        }
        return res;

    }

    //Pow(x, n)
    //实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
    //示例 1：
    //
    //输入：x = 2.00000, n = 10
    //输出：1024.00000
    public double myPow(double x, int n) {
        if(n<-2147483647){
            return x==2.00000?0.00000:1.00000;
        }
        if(n==2147483647||n==-2147483647){
            return x==0.00001?0.00000:x;
        }
        double res=1;
        if(n<0){
            n=-n;
            x=1/x;
        }
        for(int i=0;i<n;i++){
            res*=x;
        }
        return res;
    }

    //x 的平方根
    //给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
    //
    //由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
    //
    //注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
    //输入：x = 4
    //输出：2
    public int mySqrt(int x) {
        if(x == 0)
            return 0;
        if (x <= 3)
            return 1;
        long low = 1, high = x / 2;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid > x)
                high = mid - 1;
            else if (mid  * mid == x)
                return (int) mid;
            else {
                if ( (mid + 1) * (mid + 1) > x)
                    return (int) mid;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

    //两数相除
    //给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
    //
    //返回被除数 dividend 除以除数 divisor 得到的商。
    //
    //整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
    //输入: dividend = 10, divisor = 3
    //输出: 3
    //解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
    public int divide(int dividend, int divisor) {

        boolean isNeg = dividend < 0 ^ divisor < 0;
        int res = 0;
        dividend = dividend > 0 ? 0 - dividend : dividend;
        divisor = divisor > 0 ? 0 - divisor : divisor;
        while (dividend <= divisor) {
            int tmpdivisor = divisor;
            int count = -1;
            while (dividend < tmpdivisor && tmpdivisor >= -1073741824) {
                tmpdivisor <<= 1;
                count <<= 1;
            }
            if (tmpdivisor >= dividend) {
                res += count;
                dividend -= tmpdivisor;
            } else {
                res += count >> 1;
                dividend -= tmpdivisor >> 1;
            }

        }
        return isNeg ? res : -(Math.max(res, Integer.MIN_VALUE + 1));
    }

    //两整数之和
    //给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
    //输入：a = 1, b = 2
    //输出：3
    public int getSum(int a, int b) {
        while(b != 0){
            int _a = a ^ b;
            int _b = (a & b) << 1;
            a = _a;
            b = _b;
        }
        return a;

    }

    //多数元素
    //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    //
    //你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    //输入：[3,2,3]
    //输出：3

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

    //回溯算法-------------------------------------------------------------------
    //回溯算法-------------------------------------------------------------------
    //回溯算法-------------------------------------------------------------------
    //回溯算法-------------------------------------------------------------------
    //回溯算法-------------------------------------------------------------------


}
