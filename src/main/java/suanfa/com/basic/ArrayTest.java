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

}
