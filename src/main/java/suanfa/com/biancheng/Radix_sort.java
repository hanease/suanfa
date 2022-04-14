package suanfa.com.biancheng;

import java.util.Arrays;

public class Radix_sort {

    // 计数排序算法，place 表示以指定数位为准，对序列中的元素进行排序
    public static void countingSort(int array[], int place) {
        int size = array.length;
        int[] output = new int[size];
        // 假设第一个元素指定数位上的值最大
        int max = (array[0] / place) % 10;
        // 找到真正数位上值最大的元素
        for (int i = 1; i < size; i++) {
            if (((array[i] / place) % 10) > max)
                max = array[i];
        }
        // 创建并初始化 count 数组
        int[] count = new int[max + 1];
        for (int i = 0; i < max; ++i)
            count[i] = 0;
        // 统计各个元素出现的次数
        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++;
        // 累加 count 数组中的出现次数
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
        // 根据 count 数组中的信息，找到各个元素排序后所在位置，存储在 output 数组中
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }
        // 将 output 数组中的数据原封不动地拷贝到 array 数组中
        for (int i = 0; i < size; i++)
            array[i] = output[i];
    }
    // 找到整个序列中的最大值
    public static int getMax(int array[]) {
        int size = array.length;
        int max = array[0];
        for (int i = 1; i < size; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }
    // 基数排序算法
    public static void radixSort(int array[]) {
        // 找到序列中的最大值
        int max = getMax(array);
        // 根据最大值具有的位数，从低位依次调用计数排序算法
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(array, place);
    }
    public static void main(String args[]) {
        int[] data = { 121, 432, 564, 23, 1, 45, 788 };
        radixSort(data);
        System.out.println(Arrays.toString(data));
    }
}
