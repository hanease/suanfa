package suanfa.com.biancheng;

public class Bubble_sort {

    public static void Bubble_sort(int[] list) {
        int length = list.length;
        // length 个元素，遍历 length-1 次
        for (int i = 0; i < length-1; i++) {
            // 从第 1 个元素开始遍历，遍历至 length-1-i
            for (int j = 0; j < length - 1 - i; j++) {
                // 比较 list[j] 和 list[j++] 的大小
                if (list[j] > list[j + 1]) {
                    // 交换 2 个元素的位置
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] list = { 14, 33, 27, 35, 10 };
        Bubble_sort(list);
        // 输出已排好序的序列
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
