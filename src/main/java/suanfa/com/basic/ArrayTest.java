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

        /*int ren = removeDuplicates(nums);
        System.out.println(ren);
        // 打印所有数组元素
        for (int element: nums) {
            System.out.println(element);
        }*/

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

        /*for (int i = 0; i < s.length(); i++)
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                return i;
        return -1;*/

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

    //字符串转换整数 (atoi)
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

}
