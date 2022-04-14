package suanfa.com.biancheng;

public class Getmax {
    public static int get_max(int [] arr,int left,int right) {
        //如果数组不存在或者数组内没有元素
        if (arr == null || arr.length == 0) {
            return -1;
        }
        //如果查找范围中仅有 2 个数字，则直接比较即可
        if(right - left <=1) {
            if(arr[left] >= arr[right]) {
                return arr[left];
            }
            return arr[right];
        }
        //等量划分成 2 个区域
        int middle = (right-left)/2 + left;
        int max_left = get_max(arr,left,middle);
        int max_right = get_max(arr,middle+1,right);
        if(max_left >= max_right) {
            return max_left;
        }else {
            return max_right;
        }
    }
    public static void main(String[] args) {
        int [] arr = new int[] { 3,7,2,1 };
        int max = get_max(arr,0,3);
        System.out.println("最大值："+max);
    }
}
