package suanfa.com.test;

import java.util.Arrays;

public class Chazhao {

    //一、顺序表查找
    public static int sequentialSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key)
                return i;
        }
        return -1;
    }
    /**
     * 有哨兵顺序查找
     */
    public static int sequentialSearch2(int[] a, int key) {
        int index = a.length - 1;
        a[0] = key;// 将下标为0的数组元素设置为哨兵
        while (a[index] != key) {
            index--;
        }
        return index;
    }
    //-----------------------------------------------------------------
    //二、折半查找
    public static int binarySearch(int[] a, int key) {
        int low, mid, high;
        low = 0;// 最小下标
        high = a.length - 1;// 最大小标
        while (low <= high) {
            mid = (high + low) / 2;// 折半下标
            if (key > a[mid]) {
                low = mid + 1; // 关键字比 折半值 大，则最小下标 调成 折半下标的下一位
            } else if (key < a[mid]) {
                high = mid - 1;// 关键字比 折半值 小，则最大下标 调成 折半下标的前一位
            } else {
                return mid; // 当 key == a[mid] 返回 折半下标
            }
        }
        return -1;
    }
    //-----------------------------------------------------------------
    //三、插值查找
    public static int interpolationSearch(int[] a, int key) {
        int low, mid, high;
        low = 0;// 最小下标
        high = a.length - 1;// 最大小标
        while (low < high) {
            mid = low + (high - low) * (key - a[low]) / (a[high] - a[low]);
            // mid = (high + low) / 2;// 折半下标
            if (key > a[mid]) {
                low = mid + 1; // 关键字比 折半值 大，则最小下标 调成 折半下标的下一位
            } else if (key < a[mid]) {
                high = mid - 1;// 关键字比 折半值 小，则最大下标 调成 折半下标的前一位
            } else {
                return mid; // 当 key == a[mid] 返回 折半下标
            }
        }
        return -1;
    }
    //-----------------------------------------------------------------
    //四、斐波那契查找
    /** 斐波那契数列 */
    static int[] f = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 };
    public static int fibonaciSearch(int[] a, int key) {
        int low, mid, high, k;
        low = 0;
        high = a.length - 1;
// 斐波那契数列下标
        k = 0;
// 获取斐波那契分割值下标
        while (high > f[k] - 1)
            k++;
// 利用Java工具类Arrays构造长度为f[k]的新数组并指向引用a
        a = Arrays.copyOf(a, f[k]);
// 对新数组后面多余的元素赋值最大的元素
        for (int i = high + 1; i < f[k]; i++) {
            a[i] = a[high];//当key是是最大值时候，防止角标越界异常
        }
        while (low <= high) {
// 前半部分有f[k-1]个元素，由于下标从0开始
// 减去 1 获取 分割位置元素的下标
            mid = low + f[k - 1] - 1;

            if (key < a[mid]) {// 关键字小于分割位置元素，则继续查找前半部分，高位指针移动
                high = mid - 1;
// (全部元素) = (前半部分)+(后半部分)
// f[k] = f[k-1] + f[k-2]
// 因为前半部分有f[k-1]个元素， 则继续拆分f[k-1] = f[k-2] + f[k-3]成立
// 即在f[k-1]个元素的前半部分f[k-2]中继续查找，所以k = k - 1,
// 则下次循环mid = low + f[k - 1 - 1] - 1;
                k = k - 1;
            } else if (key > a[mid]) {// 关键字大于分割位置元素，则查找后半部分，低位指针移动
                low = mid + 1;
// (全部元素) = (前半部分)+(后半部分)
// f[k] = f[k-1] + f[k-2]
// 因为后半部分有f[k-2]个元素， 则继续拆分f[k-2] = f[k-3] + f[k-4]成立
// 即在f[k-2]个元素的前半部分f[k-3]继续查找，所以k = k - 2,
// 则下次循环mid = low + f[k - 2 - 1] - 1;
                k = k - 2;
            } else {
// 当条件成立的时候，则找到元素
                if (mid <= high)
                    return mid;
                else
// 出现这种情况是查找到补充的元素
// 而补充的元素与high位置的元素一样
                    return high;
            }
        }
        return -1;
    }

    //-----------------------------------------------------------------
    //二叉排序树查找操作
    public static void main(String[] args) {
// TODO Auto-generated method stub
// 主要是表达查询，所以手动构造一棵二叉排序树
        BinTree bt1 = new BinTree();
        bt1.data = 62;
        BinTree bt2 = new BinTree();
        bt1.lchild = bt2;
        bt2.data = 58;
        BinTree bt3 = new BinTree();
        bt2.lchild = bt3;
        bt3.data = 47;
        BinTree bt4 = new BinTree();
        bt3.lchild = bt4;
        bt4.data = 35;
        BinTree bt5 = new BinTree();
        bt4.rchild = bt5;
        bt5.data = 37;
        BinTree bt6 = new BinTree();
        bt3.rchild = bt6;
        bt6.data = 51;
        BinTree bt7 = new BinTree();
        bt1.rchild = bt7;
        bt7.data = 88;
        BinTree bt8 = new BinTree();
        bt7.lchild = bt8;
        bt8.data = 73;
        BinTree bt9 = new BinTree();
        bt7.rchild = bt9;
        bt9.data = 99;
        BinTree bt10 = new BinTree();
        bt9.lchild = bt10;
        bt10.data = 93;

        boolean search = searchBST(bt1, 93, null);
        System.out.println(search == true ? "查找成功：" + parentNode.data : "查找失败!");
    }

    static BinTree parentNode = new BinTree();

    public static boolean searchBST(BinTree bt, int key, BinTree parent) {
        if (null == bt || 0 == bt.data) {// 树节点不存在，返回
            parentNode = parent;
            return false;
        } else if (key == bt.data) {// 查找成功
            parentNode = bt;
            return true;
        } else if (key < bt.data) {// 关键字小于根节点则查找左子树
            return searchBST(bt.lchild, key, bt);
        } else// 关键字大于根节点则查找右子树
            return searchBST(bt.rchild, key, bt);
    }

}
