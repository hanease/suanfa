package suanfa.com.biancheng;

public class Selection_sort {

    // list[N] 为存储待排序序列的数组
    public static void selection_sort(int[] list) {
        int length = list.length;
        int i, j;
        // 从第 1 个元素开始遍历，直至倒数第 2 个元素
        for (i = 0; i < length - 1; i++) {
            int min = i; // 事先假设最小值为第 i 个元素
            // 从第 i+1 个元素开始遍历，查找真正的最小值
            for (j = i + 1; j < length; j++) {
                if (list[j] < list[min]) {
                    min = j;
                }
            }
            // 如果最小值所在位置不为 i，交换最小值和第 i 个元素的位置
            if (min != j) {
                int temp = list[min];
                list[min] = list[i];
                list[i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] list = { 14, 33, 27, 10, 35, 19, 42, 44 };
        selection_sort(list);
        // 输出已排好序的序列
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
