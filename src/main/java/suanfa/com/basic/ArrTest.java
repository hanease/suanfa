package suanfa.com.basic;

import java.util.*;

public class ArrTest {

    public static void main(String[] args) {
        double[] myList = {1.9, 2.9, 3.4, 3.5};
        int[] input = new int[]{3, 1, 2, 6, -4, 2};
        int[] nums = new int[]{1, 1, 2, 3, 4, 4, 5};
        int[] nums1 = new int[]{1, 1, 1, 3, 3, 4, 5, 5, 6,7};
        String[] aa = new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        String[] bb = {"abcw","baz","foo","bar","xtfn","abcdef"};
        //int ren = maxProduct(bb);
        //System.out.println(ren);
        //double mid = findMedianSortedArrays(nums,nums1);
        //System.out.println(mid);

        String str = "The game received average review scores of 96.92% and 98/100 for the Xbox 360 version";
        String newStr = "";
        for(int i = 0 ; i < str.length() ; ++i){
            if(!Character.isDigit(str.charAt(i)))
                newStr += str.charAt(i);
        }
        System.out.println(newStr);
    }

public static int maxProduct(String[] words) {

/**
 全是小写字母, 可以用一个32为整数表示一个word中出现的字母,
 hash[i]存放第i个单词出现过的字母, a对应32位整数的最后一位,
 b对应整数的倒数第二位, 依次类推. 时间复杂度O(N^2)
 判断两两单词按位与的结果, 如果结果为0且长度积大于最大积则更新
 **/
        int n = words.length;
        int[] hash = new int[n];
        int max = 0;
        for(int i = 0; i < n; ++i) {
            for(char c : words[i].toCharArray())
                hash[i] |= 1 << (c-'a');
        }

        for(int i = 0; i < n-1; ++i) {
            for(int j = i+1; j < n; ++j) {
                if((hash[i] & hash[j]) == 0)
                    max = Math.max(words[i].length() * words[j].length(), max);
            }
        }
        return max;
    }

    //两数之和
    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    //
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.get(target - nums[i]) != null) {
                return new int[]{m.get(target - nums[i]), i};
            }
            m.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    //寻找两个正序数组的中位数
    //给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
    //
    //算法的时间复杂度应该为 O(log (m+n)) 。

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        /*
         * 两个数组有序，所以逐个将较小的数据取出来存入sortedList，不需要取出全部，只要取到中位数的位置
         * 就行。listSize代表总共需要取出的数量，最终sortedList末尾的数就是中位数（要区分奇数偶数）
         */
        int totalLenth = nums1.length + nums2.length;
        List<Integer> sortedList = new ArrayList<>();
        int listSize;
        if(totalLenth % 2 == 0){
            listSize = totalLenth/2 + 1;
        }else{
            listSize = (int) (totalLenth/2f + 0.5f);
        }

        // p1和p2代表两个数组遍历时的指针
        int p1 = 0;
        int p2 = 0;
        while(sortedList.size() < listSize){
            if(p1 == nums1.length){
                sortedList.add(nums2[p2]);
                p2++;
            }else if (p2 == nums2.length){
                sortedList.add(nums1[p1]);
                p1++;
            }else{
                if(nums1[p1] < nums2[p2]){
                    //拿出较小的数，然后指针往后移动
                    sortedList.add(nums1[p1]);
                    p1++;
                }else{
                    sortedList.add(nums2[p2]);
                    p2++;
                }
            }
        }

        // 输出结果
        if(totalLenth % 2 == 0){
            int v1 = sortedList.get(listSize -1);
            int v2 = sortedList.get(listSize -2);
            return (v1 + v2)/2f;
        }else{
            return sortedList.get(listSize -1);
        }

    }

    //最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length()<m){
                res = strs[i];
                m=strs[i].length();
            }
        }

        for (int i = 0; i < strs.length; i++) {
            while (true){
                if (strs[i].startsWith(res)){
                    break;
                }else{
                    res = res.substring(0,res.length()-1);
                }
            }
        }

        return res;
    }

    //最接近的三数之和
    //给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
    //
    //返回这三个数的和。
    //示例 1：
    //
    //输入：nums = [-1,2,1,-4], target = 1
    //输出：2
    //解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int num1 = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            int newTarget = target - num1;
            while(left < right){
                int val = nums[left] + nums[right];
                if(val == newTarget){
                    return target;
                }else if(val > newTarget){
                    right--;
                }else{
                    left++;
                }

                if(Math.abs(newTarget - val) < Math.abs(min)){
                    min = newTarget - val;

                }
            }
        }

        return target - min;
    }

    //删除排序数组中的重复项
    public int removeDuplicates(int[] A) {
        int count = 0;//重复的数字个数
        for (int right = 1; right < A.length; right++) {
            if (A[right] == A[right - 1]) {
                //如果与重复的，count要加1
                count++;
            } else {
                //如果没有重复，后面的就往前挪
                A[right - count] = A[right];
            }
        }
        //数组的长度减去重复的个数
        return A.length - count;
    }


    //除自身以外数组的乘积
    //输入: nums = [1,2,3,4]
    //输出: [24,12,8,6]
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int len = nums.length;
        int[] output = new int[len];
        for(int i=0;i<len;i++){
            output[i] = left;
            left *= nums[i];
        }
        for(int j=len-1;j>=0;j--){
            output[j] *= right;
            right *= nums[j];
        }
        return output;
    }

    //存在重复元素
    //给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
    //输入：nums = [1,2,3,1]
    //输出：true
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!temp.add(nums[i])) {
                return true;
            }
        }
        return false;
    }


    //螺旋矩阵
    //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
    //输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
    //输出：[1,2,3,6,9,8,7,4,5]
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> res = new ArrayList<Integer>();
        int l = 0;      int r = n - 1;
        int upper = 0;  int lower = m - 1;
        int i;
        while(res.size() < m * n){
            i = upper;
            System.out.println(upper + " " + lower + " " + l + " " + r);
            // 向右
            for(int j = l; j <= r; j++){
                res.add(matrix[i][j]);
            }

            // 向下
            for(i = upper + 1; i <= lower; i++){
                res.add(matrix[i][r]);
            }

            // 向左， 需要判断 lower > upper 避免重复遍历
            for(int j = r - 1; j >= l && lower > upper; j--){
                res.add(matrix[lower][j]);
            }

            // 向上， 需要判断 right > left 避免重复遍历
            for(i = lower - 1; i > upper && r > l; i--){
                res.add(matrix[i][l]);
            }

            upper += 1;
            lower -= 1;
            l += 1;
            r -= 1;
        }

        return res;
    }

    //合并两个有序数组
    //示例 1：
    /*输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    输出：[1,2,2,3,5,6]
    解释：需要合并 [1,2,3] 和 [2,5,6] 。
    合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。*/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = 0, ptr2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (ptr1 < m || ptr2 < n) {
            if (ptr1 == m) {
                cur = nums2[ptr2++];
            }else if (ptr2 == n){
                cur = nums1[ptr1++];
            }else if (nums1[ptr1] <= nums2[ptr2]){
                cur = nums1[ptr1++];
            }else {
                cur = nums2[ptr2++];
            }
            sorted[ptr1 + ptr2 - 1] = cur;
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = sorted[i];
        }
    }

    //2、给定一个数组 arr，请对数组进行求和，但是数组中可能会有重复的元素，在进行数组求和时，对于重复的数据只用计算一次即可。
    public static int getSum(int[] arr) {
        int i;
        int sum = 0;
        Set set = new HashSet();

        for (i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            sum += it.next();
        }

        return sum;
    }

    // 3、请通过 Solution 类的 getList 方法返回一个 List 的实现类，要求是线程安全的，你可以自己设计一个同步的 List 实现类进行返回。

    public static List<Integer> getList() {
        // 三种线程安全的容器
        // 使用Vector
        // Vector<Integer> vector = new Vector<>();
        // 使用Collections的静态方法synchronizedList(List< T> list)
        List<Integer> list = new ArrayList<>();
        List<Integer> syncList = Collections.synchronizedList(list);
        // 使用CopyOnWriteArrayList容器
        // CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        // return vector;
        return syncList; // 写入性能最好
        // return copyOnWriteArrayList; // 写入性能最差，读取性能最好
    }

    // 4、我们会调用您写的 copy 方法，并传递两个参数，第一个参数是原数组（有值），第二个是目标数组（无值），您需要将第一个数组中的值复制到第二数组中。
    // write your code here
    public static void copy(String[] a, String[] b){
        for (int i=0;i<a.length;i++) {
            b[i]=a[i];
            System.out.println(b[i]);
        }

    }


}
