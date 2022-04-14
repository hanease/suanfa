package suanfa.com.biancheng;

import java.util.ArrayList;
import java.util.Collections;

public class Bucket_Sort {
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0)
            return;
        @SuppressWarnings("unchecked")
        ArrayList<Float>[] bucket = new ArrayList[n];
        // 创建空桶
        for (int i = 0; i < n; i++)
            bucket[i] = new ArrayList<Float>();
        // 根据规则将序列中元素分散到桶中
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) arr[i] * n;
            bucket[bucketIndex].add(arr[i]);
        }
        // 对各个桶内的元素进行排序
        for (int i = 0; i < n; i++) {
            Collections.sort((bucket[i]));
        }
        // 合并所有桶内的元素
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0, size = bucket[i].size(); j < size; j++) {
                arr[index++] = bucket[i].get(j);
            }
        }
    }
    public static void main(String[] args) {
        float[] arr = { (float) 0.42, (float) 0.32, (float) 0.23, (float) 0.52, (float) 0.25, (float) 0.47,
                (float) 0.51 };
        bucketSort(arr);
        for (float i : arr)
            System.out.print(i + " ");
    }
}
