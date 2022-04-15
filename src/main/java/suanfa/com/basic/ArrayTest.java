package suanfa.com.basic;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class ArrayTest {


    public static void main(String[] args) {
        double[] myList = {1.9, 2.9, 3.4, 3.5};
        int[] input = new int[]{3, 1, 2, 6, 4, 2};
        int[] nums = new int[]{1, 1, 2, 3, 4, 4, 5};
        int[] nums1 = new int[]{1,1,1,3,3,4,3,2,4,2};
        int[] input2 = new int[]{3, 1, 9, 6, 4, 2};
        int[] ren = plusOne1(input2);
        // 打印所有数组元素
        for (int element: ren) {
            System.out.println(element);
        }

        rotate(input, 4);
        // 打印所有数组元素
        for (int element: input) {
            System.out.println(element);
        }
        int[] outnput =plusOne(input);
        for (int element: outnput) {
            System.out.println(element);
        }
        System.out.println(containsDuplicate(nums1));
    }

    //删除排序数组中的重复项
    public static int removeDuplicates(int[] nums) {

        int n = nums.length;
        int p=0;  //用于判断,下面的q用来遍历
        for (int q = 0; q < n; q++) {
            if (nums[p] != nums[q]) {
                nums[p+1] = nums[q];
                p++;
            }
        }
        return p+1;
    }

    //旋转数组
    public static void rotate(int[] nums, int k) {
        // k可能大于数组长度，取余
        k = k%nums.length;
        for (int j = 0; j < k; j++) {
            int temp = nums[nums.length-1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
        }

        int length = nums.length;
        int temp[] = new int[length];
        //把原数组值放到一个临时数组中，
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        //然后在把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }


    //存在重复元素
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            //因为集合set中不能有重复的元素，如果有重复的
            //元素添加，就会添加失败
            if (!set.add(num))
                return true;
        }
        return false;

    }

    //只出现一次的数字
    public int singleNumber(int[] nums) {

        int result = 0;
        for (int i = 0; i < nums.length; i++)
            result ^= nums[i];
        return result;

    }

    //两个数组的交集 II
    //给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
    //输入：nums1 = [1,2,2,1], nums2 = [2,2]
    //输出：[2,2]
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        //先把数组nums1的所有元素都存放到map中，其中key是数组中
        //的元素，value是这个元素出现在数组中的次数
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        //然后再遍历nums2数组，查看map中是否包含nums2的元素，如果包含，
        //就把当前值加入到集合list中，然后再把对应的value值减1。
        for (int i = 0; i < nums2.length; i++) {
            if (map.getOrDefault(nums2[i], 0) > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        //把集合list转化为数组
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }

    //加一
    public static int[] plusOne(int[] digits) {
        String sum = "";
        for(int i : digits){
            sum = sum+i;
        }
        Long ren = Long.valueOf(sum) + 1;
        String sum1 = ren.toString();
        char[] asss = sum1.toCharArray();
        int[] renarr = new int[asss.length];
        for (int i = 0; i < asss.length; i++){
            renarr[i] = Integer.valueOf(asss[i]+"");
        }
        return renarr;
    }


    //加一 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
    public static int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }

    //移动零
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int index = 0;
        //一次遍历，把非零的都往前挪
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[index++] = nums[i];
        }
        //后面的都是0,
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    //两数之和
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++)
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
        }
        return new int[]{-1, -1};
    }

    //有效的数独
    //请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
    //
    //数字 1-9 在每一行只能出现一次。
    //数字 1-9 在每一列只能出现一次。
    //数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
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

    //旋转图像
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        //先上下交换
        for (int i = 0; i < length / 2; i++) {
            int temp[] = matrix[i];
            matrix[i] = matrix[length - i - 1];
            matrix[length - i - 1] = temp;
        }
        //在按照对角线交换
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    //合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = new int[m + n];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j])
                temp[index++] = nums1[i++];
            else
                temp[index++] = nums2[j++];
        }
        for (; i < m; ) {
            temp[index++] = nums1[i++];
        }
        for (; j < n; ) {
            temp[index++] = nums2[j++];
        }
        //再把数组temp中的值赋给nums1
        for (int k = 0; k < m + n; k++) {
            nums1[k] = temp[k];
        }
    }

    public int firstBadVersion(int n) {
        /*int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid))
                start = mid + 1;
            else
                end = mid;
        }
        return start;*/
        return 0;
    }

    //寻找数组的中心索引
    //给你一个整数数组 nums ，请计算数组的 中心下标 。
    //
    //数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
    //如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
    //如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
    //输入：nums = [1, 7, 3, 6, 5, 6]
    //输出：3
    //解释：
    //中心下标是 3 。
    //左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
    //右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
    public int pivotIndex(int[] nums) {
        int sum=0,flag=0,end=0;
        for(int i=0;i<nums.length;i++){//sum为数组中所有元素的总和
            sum+=nums[i];
        }
        if(sum-nums[0]==0){//如果除了nums[0]以外的和为0，即0为数组的中心索引
            return 0;
        }
        for(int j=0;j<nums.length;j++){//flag为数组中从索引为0的位置到索引为j的位置的所有元素的和
            flag+=nums[j];
            if(j!=0){
                end=flag-nums[j];//end为数组中从索引为0的位置到索引为j-1的位置的所有元素的和
            }
            while(end==sum-flag){//数组中索引为j的位置前的所有元素总和
                //与数组中索引位置为j的位置后的所有元素总和相等
                return j;
            }
        }
        return -1;
    }

    //搜索插入位置
    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    //请必须使用时间复杂度为 O(log n) 的算法。
    //输入: nums = [1,3,5,6], target = 5
    //输出: 2
    public int searchInsert(int[] nums, int target) {
        int a=nums.length;
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                a=i;
                return a;
            }else if(target<nums[i]){
                a=i;
                return a;

            }

        }
        return a;

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

    //移除元素
    //给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
    //
    //不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
    //
    //元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == val){
                continue;
            }
            nums[left++] = nums[i];
        }
        return left;
    }
    public static int removeElement2(int[] nums, int val) {
        int slow = -1;
        int fast = 0;
        while(fast<nums.length){
            if(nums[fast]!=val){
                nums[++slow]=nums[fast];
            }
            fast++;
        }
        int[] result = new int[slow + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[i];
        }
        nums = result;
        return slow+1;
    }

    //最大连续1的个数
    //给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
    //示例 1：
    //
    //输入：nums = [1,1,0,1,1,1]
    //输出：3
    //解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
    public int findMaxConsecutiveOnes(int[] nums) {

        int max=0,temp=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                temp++;
            }else{
                temp=0;
            }
            max = Math.max(max,temp);
        }
        return  max;
    }

    //长度最小的子数组
    //给定一个含有 n 个正整数的数组和一个正整数 target 。
    //找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
    //输入：target = 7, nums = [2,3,1,2,4,3]
    //输出：2
    //解释：子数组 [4,3] 是该条件下的长度最小的子数组。
    public int minSubArrayLen(int target, int[] nums) {
        // 遍历
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < length; i++){
            int sum = 0;
            for(int j = i; j < length; j++){
                sum += nums[j];
                if(sum >= target){
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    //寻找旋转排序数组中的最小值
    //已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
    //若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
    //若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
    //注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
    //
    //给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
    //
    //你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
    //输入：nums = [3,4,5,1,2]
    //输出：1
    //解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return nums[left];
    }

}
