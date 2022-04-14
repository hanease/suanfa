package suanfa.com.biancheng;

public class Shell_sort {
    // list[N] 为存储待排序序列的数组
    public static void shell_sort(int[] list) {
        int length = list.length;
        // 初始化间隔数为 1
        int interval = 1;
        // 计算最大间隔
        while (interval < length / 3) {
            interval = interval * 3 + 1;
        }
        // 根据间隔数，不断划分序列，并对各子序列排序
        while (interval > 0) {
            // 对各个子序列做直接插入排序
            for (int i = interval; i < length; i++) {
                int temp = list[i];
                int j = i;
                while (j > interval - 1 && list[j - interval] >= temp) {
                    list[j] = list[j - interval];
                    j -= interval;
                }
                if (j != i) {
                    list[j] = temp;
                }
            }
            // 计算新的间隔数，继续划分序列
            interval = (interval - 1) / 3;
        }
    }
    public static void main(String[] args) {
        int[] list = { 35, 33, 42, 10, 14, 19, 27, 44 };
        shell_sort(list);
        // 输出已排好序的序列
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
