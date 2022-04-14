package suanfa.com.biancheng;

public class Counting_sort {

    //找到数组中的最大值
    public static int getMax(int[] list) {
        int max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        return max;
    }
    public static void countingSort(int[] list) {
        int length = list.length;
        //第 1 步，找到序列中的最大值
        int max = getMax(list);
        //第 2 步，初始化一个 array[max+1]
        int[] array = new int[max + 1];
        int[] output = new int[length];
        //第 3 步，统计各个元素的出现次数，并存储在相应的位置上
        for (int i = 0; i < length; i++) {
            array[list[i]]++;
        }
        // 第 4 步，累加 array 数组中的出现次数
        for (int i = 1; i <= max; i++) {
            array[i] += array[i - 1];
        }
        // 第 5 步，根据 array 数组中的信息，找到各个元素排序后所在位置，存储在 output 数组中
        for (int i = length - 1; i >= 0; i--) {
            output[array[list[i]] - 1] = list[i];
            array[list[i]]--;
        }
        // 将 output 数组中的数据原封不动地拷贝到 list 数组中
        for (int i = 0; i < length; i++) {
            list[i] = output[i];
        }
    }
    public static void printList(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
    public static void main(String[] args) {
        // 待排序序列
        int[] list = new int[] { 4, 2, 2, 8, 3, 3, 1 };
        //进行计数排序
        countingSort(list);
        printList(list);
    }
}
