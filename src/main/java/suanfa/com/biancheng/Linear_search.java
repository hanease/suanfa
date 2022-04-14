package suanfa.com.biancheng;

public class Linear_search {

    // 实现顺序查找，arr[N] 为待查找序列，value 为要查找的目标元素
    public static int linear_search(int[] arr, int value) {
        // 从第 1 个元素开始遍历
        for (int i = 0; i < arr.length; i++) {
            // 匹配成功，返回元素所处的位置下标
            if (arr[i] == value) {
                return i;
            }
        }
        // 匹配失败，返回 -1
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 10, 14, 19, 26, 27, 31, 33, 35, 42, 44 };
        int add = linear_search(arr, 33);
        if (add != -1) {
            System.out.println("查找成功，为序列中第 " + (add + 1) + " 个元素");
        } else {
            System.out.println("查找失败");
        }
    }
}
