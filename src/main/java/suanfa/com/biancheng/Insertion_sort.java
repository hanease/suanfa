package suanfa.com.biancheng;

public class Insertion_sort {

    public static void insertion_sort(int[] list) {
        int length = list.length;
        // 从第 2 个元素（下标为 1）开始遍历
        for (int i = 1; i < length; i++) {
            // 记录要插入的目标元素
            int insert_elem = list[i];
            // 记录目标元素所在的位置，从此位置向前开始遍历
            int position = i;
            // 从 position 向前遍历，找到目标元素的插入位置
            while (position > 0 && list[position - 1] > insert_elem) {
                // position 处的元素向后移动一个位置
                list[position] = list[position - 1];
                position--;
            }
            // 将目标元素插入到指定的位置
            if (position != i) {
                list[position] = insert_elem;
            }
        }
    }
    public static void main(String[] args) {
        int[] list = { 10, 14, 19, 27, 33, 35, 42, 44 };
        insertion_sort(list);
        // 输出已排好序的序列
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
