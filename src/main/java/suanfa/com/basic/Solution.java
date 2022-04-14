package suanfa.com.basic;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3};   //测试的数组
        int[] Nums = {1,2,3};    //修改后正确的数组
        Solution s = new Solution();
        int k = s.removeDuplicates(nums);       //调用我修改后的数组的长度
        assert k == Nums.length;        //assert 用来判断k是否等于 == 后面的数，返回true或者false。也可以用if代替
        for (int i = 0; i < k; i++) {
            if (nums[i] == Nums[i]){
//                System.out.print("正确"+" ");
                System.out.print(nums[i]+" ");
            }
        }
    }

    public int removeDuplicates(int[] nums) {
        //传进来一个数组，判断数组长度先
        /**思路：
         *      1-用双指针，一个p，用来判断，一个q，用来遍历
         *      2-p和q判断，如果两个数相等，则q往后退一位
         *      3-如果两个数不相等，p+1（p后面的一个位置 被赋予 q现在的位置的数值），之后p和q各往后退一位。如此循环
         */
        int n = nums.length;
        int p=0;  //用于判断,下面的q用来遍历
        for (int q = 0; q < n; q++) {
            if (nums[p] != nums[q]) {
                nums[p+1] = nums[q];
                p++;
            }
        }
        return p+1;  //因为p是是从零开始的，所以实际长度要+1；
    }
}
