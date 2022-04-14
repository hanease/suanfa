package suanfa.com.biancheng;

public class Merge_sort {

    //实现归并排序算法的分割操作
    public static void merge_sort(int[] arr, int p, int q) {
        // 如果数组不存在或者 [p.q] 区域不合理
        if (arr == null || p >= q) {
            return;
        }
        //对[p,q]区域进行分割
        int mid = (p + q) / 2;
        merge_sort(arr, p, mid);
        merge_sort(arr, mid + 1, q);
        //对分割的 [p,mid] 和 [mid+1,q] 区域进行归并
        merge(arr, p, mid, q);
    }
    //实现归并排序算法的归并操作
    public static void merge(int[] arr, int p, int mid, int q) {
        int numL = mid - p + 1;
        int numR = q - mid;
        //创建 2 个数组，分别存储 [p,mid] 和 [mid+1,q]区域内的元素
        int[] leftarr = new int[numL + 1];
        int[] rightarr = new int[numR + 1];
        int i;
        for (i = 0; i < numL; i++) {
            leftarr[i] = arr[p - 1 + i];
        }
        //将 leftarr 数组中最后一个元素设置为足够大的数。
        leftarr[i] = 2147483647;
        for (i = 0; i < numR; i++) {
            rightarr[i] = arr[mid + i];
        }
        //将 rightarr 数组中最后一个元素设置为足够大的数。
        rightarr[i] = 2147483647;
        int j = 0;
        i = 0;
        //对 leftarr 和 rightarr 数组中存储的 2 个区域的元素做归并操作
        for (int k = p; k <= q; k++) {
            if (leftarr[i] <= rightarr[j]) {
                arr[k - 1] = leftarr[i];
                i++;
            } else {
                arr[k - 1] = rightarr[j];
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 7, 5, 2, 4, 1, 6, 3, 0 };
        //对 arr 数组中第 1 至 8 个元素进行归并排序
        merge_sort(arr, 1, 8);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
