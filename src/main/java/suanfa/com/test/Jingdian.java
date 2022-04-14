package suanfa.com.test;
import java.io.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class Jingdian {
    //（1）河内塔问题
    /*public static void main(String args[]) throws IOException {

        int n;

        BufferedReader buf;

        buf = new BufferedReader(new InputStreamReader(System. in ));

        System.out.print("请输入盘数：");

        n = Integer.parseInt(buf.readLine());

        Jingdian hanoi = new Jingdian();

        hanoi.move(n, 'A', 'B', 'C');

    }

    public void move(int n, char a, char b, char c) {

        if (n == 1) System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);

        else {

            move(n - 1, a, c, b);

            System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);

            move(n - 1, b, a, c);

        }

    }*/

    //（2）费式数列
    /*public static void main(String[] args) {

        int[] fib = new int[20];

        fib[0] = 0;

        fib[1] = 1;

        for (int i = 2; i < fib.length; i++) fib[i] = fib[i - 1] + fib[i - 2];

        for (int i = 0; i < fib.length; i++) System.out.print(fib[i] + " ");

        System.out.println();

    }*/

    //（3）巴斯卡（Pascal）三角形
    /*public class Pascal extends JFrame {

    public Pascal() {

        setBackground(Color.white);

        setTitle("巴斯卡三角形");

        setSize(520, 350);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(700, 700);

        setVisible(true);

    }

    private long combi(int n, int r) {

        int i;

        long p = 1;

        for (i = 1; i <= r; i++) p = p * (n - i + 1) / i;

        return p;

    }

    public void paint(Graphics g) {

        g.setColor(Color.white);

        g.clearRect(0, 0, getSize().width, getSize().height);

        g.setColor(Color.red);

        final int N = 12;

        int n, r, t;

        for (n = 0; n <= N; n++) {

            for (r = 0; r <= n; r++) g.drawString(" " + combi(n, r), (N - n) * 20 + r * 40, n * 20 + 50);

        }

    }

    public static void main(String args[]) {

        Pascal frm = new Pascal();

    }
    }*/
    //（4）蒙地卡罗法求 PI
    /*public static void main(String[] args) {

        final int N = 50000;

        int sum = 0;

        for (int i = 1; i < N; i++) {

            double x = Math.random();

            double y = Math.random();

            if ((x * x + y * y) < 1) sum++;

        }

        System.out.println("PI = " + (double) 4 * sum / N);

    }*/

    //（5）最大公因数、最小公倍数
    /*public static int gcdOf(int m, int n) {

        int r;

        while (n != 0) {

            r = m % n;

            m = n;

            n = r;

        }

        return m;

    }

    public static int lcmOf(int m, int n) {

        return m * n / gcdOf(m, n);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader ln = new BufferedReader(new InputStreamReader(System. in ));

        System.out.print("请输入第一个数：");

        int x = Integer.parseInt(ln.readLine());

        System.out.print("请输入第二个数：");

        int y = Integer.parseInt(ln.readLine());

        System.out.println("GCD of (" + x + "," + y + ")=" + Jingdian.gcdOf(x, y));

        System.out.println("LCM of (" + x + "," + y + ")=" + Jingdian.lcmOf(x, y));

    }*/

    //（6）阿姆斯壮数
   /* public static void main(String[] args) {

        System.out.println("寻找Armstrong数：");

        for (int i = 100; i <= 999; i++) {

            int a = i / 100;

            int b = (i % 100) / 10;

            int c = i % 10;

            if (a * a * a + b * b * b + c * c * c == i) System.out.print(i + " ");

        }

        System.out.println();

    }*/

    //（7）最大访客数
    /*public static int maxGuest(int[] x, int[] y, int time) {

        int num = 0;

        for (int i = 0; i < x.length; i++) {

            if (time > x[i]) num++;

            if (time > y[i]) num--;

        }

        return num;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System. in ));

        System.out.println("输入来访时间与离开时间(0~24)：");

        System.out.println("范例：10 15");

        System.out.println("输入-1结束");

        java.util.ArrayList list = new ArrayList();

        while (true) {

            System.out.print(">>");

            String input = buf.readLine();

            if (input.equals("-1")) break;

            list.add(input);

        }

        int[] x = new int[list.size()];

        int[] y = new int[list.size()];

        for (int i = 0; i < x.length; i++) {

            String input = (String) list.get(i);

            String[] strs = input.split(" ");

            x[i] = Integer.parseInt(strs[0]);

            y[i] = Integer.parseInt(strs[1]);

        }

        Arrays.sort(x);

        Arrays.sort(y);

        for (int time = 0; time < 25; time++) {

            System.out.println(time + " 时的最大访客数：" + Jingdian.maxGuest(x, y, time));

        }

    }*/

    //（8）洗扑克牌（乱数排列）
    /*public static void main(String args[]) {
        final int N = 52;
        int[] poker = new int[N + 1];
// 初始化阵列
        for (int i = 1; i <= N; i++) poker[i] = i;
// 洗牌
        for (int i = 1; i <= N; i++) {
            int j = (int)(Math.random() * N);
            if (j == 0) j = 1;
            int tmp = poker[i];
            poker[i] = poker[j];
            poker[j] = tmp;

        }
        for (int i = 1; i <= N; i++) {
        // 判断花色
            switch ((poker[i] - 1) / 13) {
                case 0:
                    System.out.print("桃");
                    break;
                case 1:
                    System.out.print("心");
                    break;
                case 2:
                    System.out.print("砖");
                    break;
                case 3:
                    System.out.print("梅");
                    break;
            }
        // 扑克牌数字
            int remain = poker[i] % 13;
            switch (remain) {
                case 0:
                    System.out.print("K ");
                    break;
                case 12:
                    System.out.print("Q ");
                    break;
                case 11:
                    System.out.print("J ");
                    break;
                default:
                    System.out.print(remain + " ");
                    break;
            }
            if (i % 13 == 0) System.out.println("");
        }

    }*/
    //（9）约瑟夫问题（Josephus Problem）
    /*public static int[] arrayOfJosephus(int number, int per) {

        int[] man = new int[number];

        for (int count = 1, i = 0, pos = -1; count <= number; count++) {

            do {

                pos = (pos + 1) % number; // 环状处理

                if (man[pos] == 0) i++;

                if (i == per) { // 报数为3了

                    i = 0;

                    break;

                }

            } while (true);

            man[pos] = count;

        }

        return man;

    }

    public static void main(String[] args) {

        int[] man = Jingdian.arrayOfJosephus(41, 3);

        int alive = 3;

        System.out.println("约琴夫排列：");

        for (int i = 0; i < 41; i++) System.out.print(man[i] + " ");

        System.out.println("\nL表示3个存活的人要放的位置：");

        for (int i = 0; i < 41; i++) {

            if (man[i] > (41 - alive)) System.out.print("L");

            else System.out.print("D");

            if ((i + 1) % 5 == 0) System.out.print(" ");

        }

        System.out.println();

    }*/

    //（10）排列组合
    /*public static void perm(int[] num, int i) {

        if (i < num.length - 1) {

            for (int j = i; j <= num.length - 1; j++) {

                int tmp = num[j];

// 旋转该区段最右边数字至最左边

                for (int k = j; k > i; k--) num[k] = num[k - 1];

                num[i] = tmp;

                perm(num, i + 1);

// 还原

                for (int k = i; k < j; k++) num[k] = num[k + 1];

                num[j] = tmp;

            }

        } else {

// 显示此次排列

            for (int j = 1; j <= num.length - 1; j++) System.out.print(num[j] + " ");

            System.out.println();

        }

    }

    public static void main(String[] args) {

        int[] num = new int[4 + 1];

        for (int i = 1; i <= num.length - 1; i++) num[i] = i;

        perm(num, 1);

    }*/

    //（11）得分排行
   /* public static void main(String[] args)

            throws NumberFormatException, IOException {

        final int MAX = 100;

        final int MIN = 0;

        int[] score = new int[MAX + 1];

        int[] juni = new int[MAX + 2];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System. in ));

        int count = 0;

        do {

            System.out.print("输入分数，-1结束：");

            score[count++] = Integer.parseInt(reader.readLine());

        } while ((score[count - 1] != -1));

        count--;

        for (int i = 0; i < count; i++) juni[score[i]]++;

        juni[MAX + 1] = 1;

        for (int i = MAX; i >= MIN; i--) juni[i] = juni[i] + juni[i + 1];

        System.out.println("得分\t排行");

        for (int i = 0; i < count; i++) {

            System.out.println(score[i] + "\t" + juni[score[i] + 1]);

        }

    }*/

    //（12）选择、插入、气泡排序
    /*public static void selectionSort(int[] number) {

        for (int i = 0; i < number.length - 1; i++) {

            int m = i;

            for (int j = i + 1; j < number.length; j++)

                if (number[j] < number[m]) m = j;
                if (i != m) swap(number, i, m);

        }

    }

    public static void injectionSort(int[] number) {

        for (int j = 1; j < number.length; j++) {

            int tmp = number[j];

            int i = j - 1;

            while (tmp < number[i]) {

                number[i + 1] = number[i];

                i--;

                if (i == -1) break;

            }

            number[i + 1] = tmp;

        }

    }

    public static void bubbleSort(int[] number) {

        boolean flag = true;

        for (int i = 0; i < number.length - 1 && flag; i++) {

            flag = false;

            for (int j = 0; j < number.length - i - 1; j++) {

                if (number[j + 1] < number[j]) {

                    swap(number, j + 1, j);

                    flag = true;

                }

            }

        }

    }

    private static void swap(int[] number, int i, int j) {

        int t;

        t = number[i];

        number[i] = number[j];

        number[j] = t;

    }

    public static void main(String[] args) {

//测试：

        int[] a = {

                10, 9, 1, 100, 20, 200, 39, 45, 23, 18, 2, 2, 15

        };

//测试选择排序：

        System.out.println("选择排序前：");

        for (int x: a) System.out.print(x + " ");

        System.out.println();

        int[] b = new int[a.length];

        b = a;

        selectionSort(b);

        System.out.println("选择排序后：");

        for (int x: b) System.out.print(x + " ");

        System.out.println();

//测试插入排序：

        System.out.println("插入排序前：");

        for (int x: a) System.out.print(x + " ");

        System.out.println();

        int[] c = new int[a.length];

        c = a;

        injectionSort(c);

        System.out.println("插入排序后：");

        for (int x: c) System.out.print(x + " ");

        System.out.println();

//测试气泡排序：

        System.out.println("气泡排序前：");

        for (int x: a) System.out.print(x + " ");

        System.out.println();

        int[] d = new int[a.length];

        d = a;

        bubbleSort(d);

        System.out.println("气泡排序后：");

        for (int x: d) System.out.print(x + " ");

    }*/

    //（13）快速排序（一）
    /*public static void sort(int[] number) {

        sort(number, 0, number.length - 1);

    }

    private static void sort(int[] number, int left, int right) {

        if (left < right) {

            int s = number[left];

            int i = left;

            int j = right + 1;

            while (true) {

// 向右找

                while (i + 1 < number.length && number[++i] < s);

// 向左找

                while (j - 1 > -1 && number[--j] > s);

                if (i >= j) break;

                swap(number, i, j);

            }

            number[left] = number[j];

            number[j] = s;

            sort(number, left, j - 1);

// 对左边进行递回

            sort(number, j + 1, right);

// 对右边进行递回

        }

    }

    private static void swap(int[] number, int i, int j) {

        int t;

        t = number[i];

        number[i] = number[j];

        number[j] = t;

    }*/

    //（14）快速排序（二）
    /*public static void sort(int[] number) {

        sort(number, 0, number.length - 1);

    }

    private static void sort(int[] number, int left, int right) {

        if (left < right) {

            int s = number[(left + right) / 2];

            int i = left - 1;

            int j = right + 1;

            while (true) {

// 向右找

                while (number[++i] < s);

// 向左找

                while (number[--j] > s);

                if (i >= j) break;

                swap(number, i, j);

            }

            sort(number, left, i - 1);

// 对左边进行递回

            sort(number, j + 1, right);

// 对右边进行递回

        }

    }

    private static void swap(int[] number, int i, int j) {

        int t;

        t = number[i];

        number[i] = number[j];

        number[j] = t;

    }*/
    //（15）快速排序（三）
    /*public static void sort(int[] number) {

        sort(number, 0, number.length - 1);

    }

    private static void sort(int[] number, int left, int right) {

        if (left < right) {

            int q = partition(number, left, right);

            sort(number, left, q - 1);

            sort(number, q + 1, right);

        }

    }

    private static int partition(int number[], int left, int right) {

        int s = number[right];

        int i = left - 1;

        for (int j = left; j < right; j++) {

            if (number[j] <= s) {

                i++;

                swap(number, i, j);

            }

        }

        swap(number, i + 1, right);

        return i + 1;

    }

    private static void swap(int[] number, int i, int j) {

        int t;

        t = number[i];

        number[i] = number[j];

        number[j] = t;

    }*/

    //（16）合并排序
    /*public static int[] sort(int[] number1, int[] number2) {

        int[] number3 = new int[number1.length + number2.length];

        int i = 0, j = 0, k = 0;

        while (i < number1.length && j < number2.length) {

            if (number1[i] <= number2[j]) number3[k++] = number1[i++];

            else number3[k++] = number2[j++];

        }

        while (i < number1.length) number3[k++] = number1[i++];

        while (j < number2.length) number3[k++] = number2[j++];

        return number3;

    }*/

    //（17）基数排序
    /*public static void sort(int[] number, int d) {

        int k = 0;

        int n = 1;

        int[][] temp = new int[number.length][number.length];

        int[] order = new int[number.length];

        while (n <= d) {

            for (int i = 0; i < number.length; i++) {

                int lsd = ((number[i] / n) % 10);

                temp[lsd][order[lsd]] = number[i];

                order[lsd]++;

            }

            for (int i = 0; i < number.length; i++) {

                if (order[i] != 0)

                    for (int j = 0; j < order[i]; j++) {

                        number[k] = temp[i][j];

                        k++;

                    }

                order[i] = 0;

            }

            n *= 10;

            k = 0;

        }

    }

    public static void main(String[] args) {

        int[] data = {

                73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100

        };

        Jingdian.sort(data, 100);

        for (int i = 0; i < data.length; i++) {

            System.out.print(data[i] + " ");

        }

    }*/
    //（18）循序查找法（使用卫兵）
    /*public static int search(int[] number, int des) {

        int[] tmp = new int[number.length + 1];

        for (int i = 1; i < tmp.length; i++) {

            tmp[i] = number[i - 1];

        }

        tmp[0] = des;

        int k = tmp[0];

        int i = number.length;

        while (tmp[i] != k) i--;

        return i - 1;

    }

    public static void main(String[] args) {

        int[] number = {

                1, 4, 2, 6, 7, 3, 9, 8

        };

        QuickSort.sort(number);

        int find = Jingdian.search(number, 3);

        if (find != 0) System.out.println("找到数值于索引" + find);

        else System.out.println("找不到数值");

    }*/

    //（19）二分查找法
    /*public static int search(int[] number, int des) {

        int low = 0;

        int upper = number.length - 1;

        while (low <= upper) {

            int mid = (low + upper) / 2;

            if (number[mid] < des) low = mid + 1;

            else if (number[mid] > des) upper = mid - 1;

            else return mid;

        }

        return -1;

    }

    public static void main(String[] args) {

        int[] number = {

                1, 4, 2, 6, 7, 3, 9, 8

        };

        QuickSort.sort(number);

        int find = Jingdian.search(number, 3);

        if (find != -1) System.out.println("找到数值于索引" + find);

        else System.out.println("找不到数值");

    }*/
    //（20）插补查找法
    /*public static int search(int[] number, int des) {

        int low = 0;

        int upper = number.length - 1;

        while (low <= upper) {

            int mid = (upper - low) * (des - number[low]) / (number[upper] - number[low]) + low;

            if (mid < low || mid > upper) return -1;

            if (des < number[mid]) upper = mid - 1;

            else if (des > number[mid]) low = mid + 1;

            else return mid;

        }

        return -1;

    }

    public static void main(String[] args) {

        int[] number = {

                1, 4, 2, 6, 7, 3, 9, 8

        };

        QuickSort.sort(number);

        int find = Jingdian.search(number, 3);

        if (find != -1) System.out.println("找到数值于索引" + find);

        else System.out.println("找不到数值");

    }*/

    //（21）费式查找法
    /*public static int search(int[] number, int des) {

        int[] fib = createFibonacci(number.length);

        int x = findX(fib, number.length + 1, des);

        int m = number.length - fib[x];

        x--;

        int i = x;

        if (number[i] < des) i += m;

        while (fib[x] > 0) {

            if (number[i] < des) i += fib[--x];

            else if (number[i] > des) i -= fib[--x];

            else return i;

        }

        return -1;

    }

    private static int[] createFibonacci(int max) {

        int[] fib = new int[max];

        for (int i = 0; i < fib.length; i++) {

            fib[i] = Integer.MIN_VALUE;

        }

        fib[0] = 0;

        fib[1] = 1;

        for (int i = 2; i < max; i++) fib[i] = fib[i - 1] + fib[i - 2];

        return fib;

    }

    private static int findX(int[] fib, int n, int des) {

        int i = 0;

        while (fib[i] <= n) i++;

        i--;

        return i;

    }

    public static void main(String[] args) {

        int[] number = {

                1, 4, 2, 6, 7, 3, 9, 8

        };

        QuickSort.sort(number);

        int find = Jingdian.search(number, 3);

        if (find != -1) System.out.println("找到数值于索引" + find);

        else System.out.println("找不到数值");

    }*/

    //（22）稀疏矩阵
    /*public static int[][] restore(int[][] sparse) {

        int row = sparse[0][0];

        int column = sparse[0][1];

        int[][] array = new int[row][column];

        int k = 1;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < column; j++) {

                if (k <= sparse[0][2] && i == sparse[k][0] && j == sparse[k][1]) {

                    array[i][j] = sparse[k][2];

                    k++;

                } else array[i][j] = 0;

            }

        }

        return array;

    }

    public static void main(String[] args) {

        int[][] sparse = {

                {

                        5, 6, 4

                }, {

                1, 1, 3

        }, {

                2, 3, 6

        }, {

                3, 2, 9

        }, {

                4, 4, 12

        }

        };

        int[][] array = Jingdian.restore(sparse);

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {

                System.out.print(array[i][j] + " ");

            }

            System.out.println();

        }

    }*/
    //（23）多维矩阵转一维矩阵
    /*public static int[] toOneDimByRow(int[][] array) {

        int[] arr = new int[array.length * array[0].length];

        for (int row = 0; row < array.length; row++) {

            for (int column = 0; column < array[0].length; column++) {

                int i = column + row * array[0].length;

                arr[i] = array[row][column];

            }

        }

        return arr;

    }

    public static int[] toOneDimByColumn(int[][] array) {

        int[] arr = new int[array.length * array[0].length];

        for (int row = 0; row < array.length; row++) {

            for (int column = 0; column < array[0].length; column++) {

                int i = i = row + column * array.length;

                arr[i] = array[row][column];

            }

        }

        return arr;

    }*/

    //（25）奇数魔方阵
    /*public static int[][] magicOdd(int n) {

        int[][] square = new int[n + 1][n + 1];

        int i = 0;

        int j = (n + 1) / 2;

        for (int key = 1; key <= n * n; key++) {

            if ((key % n) == 1) i++;

            else {

                i--;

                j++;

            }

            if (i == 0) i = n;

            if (j > n) j = 1;

            square[i][j] = key;

        }

        int[][] matrix = new int[n][n];

        for (int k = 0; k < matrix.length; k++) {

            for (int l = 0; l < matrix[0].length; l++) {

                matrix[k][l] = square[k + 1][l + 1];

            }

        }

        return matrix;

    }

    public static void main(String[] args) {

        int[][] magic = Jingdian.magicOdd(5);

        for (int k = 0; k < magic.length; k++) {

            for (int l = 0; l < magic[0].length; l++) {

                System.out.print(magic[k][l] + " ");

            }

            System.out.println();

        }

    }*/

    //（26）4N魔方阵
    /*public static int[][] magicFourN(int n) {

        int[][] square = new int[n + 1][n + 1];

        for (int j = 1; j <= n; j++) {

            for (int i = 1; i <= n; i++) {

                if (j % 4 == i % 4 || (j % 4 + i % 4) == 1) square[i][j] = (n + 1 - i) * n - j + 1;

                else square[i][j] = (i - 1) * n + j;

            }

        }

        int[][] matrix = new int[n][n];

        for (int k = 0; k < matrix.length; k++) {

            for (int l = 0; l < matrix[0].length; l++) {

                matrix[k][l] = square[k + 1][l + 1];

            }

        }

        return matrix;

    }

    public static void main(String[] args) {

        int[][] magic = Jingdian.magicFourN(8);

        for (int k = 0; k < magic.length; k++) {

            for (int l = 0; l < magic[0].length; l++) {

                System.out.print(magic[k][l] + " ");

            }

            System.out.println();

        }

    }*/

    //（27）2(2n+1)魔方阵
    public static int[][] magic22mp1(int n) {

        int[][] square = new int[n][n];

        magic_o(square, n / 2);

        exchange(square, n);

        return square;

    }

    private static void magic_o(int[][] square, int n) {

        int row = 0;

        int column = n / 2;

        for (int count = 1; count <= n * n; count++) {

            square[row][column] = count;

// 填A

            square[row + n][column + n] = count + n * n;

// 填B

            square[row][column + n] = count + 2 * n * n;

// 填C

            square[row + n][column] = count + 3 * n * n;

// 填D

            if (count % n == 0) row++;

            else {

                row = (row == 0) ? n - 1 : row - 1;

                column = (column == n - 1) ? 0 : column + 1;

            }

        }

    }

    private static void exchange(int[][] x, int n) {

        int i, j;

        int m = n / 4;

        int m1 = m - 1;

        for (i = 0; i < n / 2; i++) {

            if (i != m) {

                for (j = 0; j < m; j++)

// 处理规则 1

                    swap(x, i, j, n / 2 + i, j);

                for (j = 0; j < m1; j++)

// 处理规则 2

                    swap(x, i, n - 1 - j, n / 2 + i, n - 1 - j);

            } else {

// 处理规则 3

                for (j = 1; j <= m; j++) swap(x, m, j, n / 2 + m, j);

                for (j = 0; j < m1; j++) swap(x, m, n - 1 - j, n / 2 + m, n - 1 - j);

            }

        }

    }

    private static void swap(int[][] number, int i, int j, int k, int l) {

        int t;

        t = number[i][j];

        number[i][j] = number[k][l];

        number[k][l] = t;

    }

    public static void main(String[] args) {

        int[][] magic = Jingdian.magic22mp1(6);

        for (int k = 0; k < magic.length; k++) {

            for (int l = 0; l < magic[0].length; l++) {

                System.out.print(magic[k][l] + " ");

            }

            System.out.println();

        }

    }


}
