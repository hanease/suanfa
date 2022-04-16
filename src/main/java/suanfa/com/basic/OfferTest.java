package suanfa.com.basic;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OfferTest {

    public static void main(String[] args) {
        double[] myList = {1.9, 2.9, 3.4, 3.5};
        int[] input = new int[]{3, 1, 2, 6, 4, 2};
        int[] nums = new int[]{1, 1, 2, 3, 4, 4, 5};
        int[] nums1 = new int[]{1,1,1,3,3,4,3,2,4,2};
        int[] input2 = new int[]{3, 1, 9, 6, 4, 2};
        // 打印所有数组元素
        for (int element: nums1) {
            System.out.println(element);
        }

        // 打印所有数组元素
        for (int element: input) {
            System.out.println(element);
        }
    }

    //剑指 Offer 05. 替换空格
    //请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    //输入：s = "We are happy."
    //输出："We%20are%20happy."
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        //char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            }else{
                sb.append(s.charAt(i) );
            }
        }
        return sb.toString();

    }

    //剑指 Offer 40. 最小的 k 个数
    //输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
    //输入：arr = [3,2,1], k = 2
    //输出：[1,2] 或者 [2,1]
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==0)
            return null;
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Comparator.comparing(Integer -> Integer));
        for(int i:arr) {
            pq.add(i);
        }
        int []min=new int[k];
        for(int i=0;i<k;i++){
            min[i]=pq.poll();
        }
        return min;
    }

    //剑指 Offer 04. 二维数组中的查找
    //在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    //现有矩阵 matrix 如下：
    //
    //[
    //  [1,   4,  7, 11, 15],
    //  [2,   5,  8, 12, 19],
    //  [3,   6,  9, 16, 22],
    //  [10, 13, 14, 17, 24],
    //  [18, 21, 23, 26, 30]
    //]
    public boolean searchMatrix(int[][] matrix, int target) {
        //直接遍历整个二维数组
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int j = matrix[0].length - 1, i = 0;//n*m
            while(j >= 0 && i < matrix.length)
            {
                if(matrix[i][j] > target) j--;
                else if(matrix[i][j] < target) i++;
                else return true;
            }
            return false;
   }




}
