package suanfa.com.biancheng;

public class Interpolation_search {

    // 实现插值查找算法，ele 表示要查找的目标元素，[begin,end] 指定查找区域
    public static int interpolation_search(int[] arr, int begin, int end, int ele) {
        // 如果[begin,end] 不存在，返回 -1
        if (begin > end) {
            return -1;
        }
        //如果搜索区域内只有一个元素，判断其是否为目标元素
        if (begin == end) {
            if (ele == arr[begin]) {
                return begin;
            }
            //如果该元素非目标元素，则查找失败
            return -1;
        }
        // 找到中间元素所在的位置
        int mid = begin + ((end - begin) / (arr[end] - arr[begin]) * (ele - arr[begin]));
        // 递归的出口
        if (ele == arr[mid]) {
            return mid;
        }
        // 比较 ele 和 arr[mid] 的值，缩小 ele 可能存在的区域
        if (ele < arr[mid]) {
            // 新的搜索区域为 [begin,mid-1]
            return interpolation_search(arr, begin, mid - 1, ele);
        } else {
            // 新的搜索区域为 [mid+1,end]
            return interpolation_search(arr, mid + 1, end, ele);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // 输出目标元素 2 所在位置的下标
        int add = interpolation_search(arr, 0, 9, 2);
        if(add != -1) {
            System.out.print(add);
        }else {
            System.out.print("查找失败");
        }

    }
}
