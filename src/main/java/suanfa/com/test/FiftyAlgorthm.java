package suanfa.com.test;

import java.util.Scanner;

public class FiftyAlgorthm {

    /*【程序1】
    题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
    1.程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21....
    */
    public static final int MONTH = 15;
    public static void main(String[] args) {
        long f1 = 1L, f2 = 1L;
        long f;
        for(int i=3; i<MONTH; i++) {
            f = f2;
            f2 = f1 + f2;
            f1 = f;
            System.out.print("第" + i +"个月的兔子对数: ");
            System.out.println(" " + f2);
        }
    }

    /*【程序2】
    *
    题目：判断101-200之间有多少个素数，并输出所有素数。
    1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，
    则表明此数不是素数，反之是素数。 */
    public static int count = 0;
    public static void main1(String[] args) {
        for(int i=101;i<200;i++){
            boolean b = true;//默认此数就素数
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    b = false; //此数不是素数
                    break;
                }
            }
            if(b){
                count++;
                System.out.print(i+" ");
            }
        }
        System.out.println("/n素数的个数："+count);
    }

    /*【程序3】
    题目：打印出所有的"水仙花数(narcissus number)"，所谓"水仙花数"是指一个三位数，
    其各位数字立方和等于该数本身。例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
    1.程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。 */
    static int b, bb, bbb;
    public static void main2(String[] args) {

        for(int num=101; num<1000; num++) {
            FiftyAlgorthm tnn = new FiftyAlgorthm();
            tnn.f(num);
        }
    }
    public void f(int m) {
        bbb = m / 100;
        bb = (m % 100) / 10;
        b = (m % 100) % 10;
        if((bbb * bbb * bbb + bb * bb * bb + b * b * b) == m) {
            System.out.println(m);
        }
    }

    /*【程序4】
    题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
    程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：
    (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
    (2)如果n>k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数你n,重复执行第一步。
    (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。 */

    static int n, k = 2;
    public static void main3(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        System.out.print(n + "=" );
        FiftyAlgorthm fpf = new FiftyAlgorthm();
        fpf.f3(n);
    }
    public void f3(int n) {
        while (k <= n) {
            if (k == n) {
                System.out.println(n);
                break;
            } else if (n > k && n % k == 0) {
                System.out.print(k + "*");
                n = n / k;
                f3(n);
                break;
            } else if (n > k && n % k != 0) {
                k++;
                f3(n);
                break;
            }
        }
    }

    /*【程序5】
题目：利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
1.程序分析：(a>b)?a:b这是条件运算符的基本例子。 */

    //public static final int S1 = 90;
//public static final int S2 = 60;
    static int grade;
    public static void main5(String[] args) {
        Scanner str = new Scanner(System.in);
        int s = str.nextInt();
        FiftyAlgorthm fc = new FiftyAlgorthm();
        grade = fc.compare(s);
        if(grade == 1) {
            System.out.print('A');
        } else if(grade == 2) {
            System.out.print('B');
        } else {
            System.out.println('C');
        }
    }
    public int compare(int s) {
        return s > 90 ? 1
                : s > 60 ? 2
                :3;
    }

    /*【程序6】

题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
1.程序分析：利用辗除法。 */
    /*
     * 在循环中，只要除数不等于0，用较大数除以较小的数，将小的一个数作为下一轮循环的大数，取得的余数作为下一轮循环的较小的数，如此循环直到较小的数的值为0，返回
     * 较大的数，此数即为最小公约数，最小公倍数为两数之积除以最小公倍数。
     * */
    public static void main6(String[] args) {
        int a, b;
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        a = s1.nextInt();
        b = s2.nextInt();
        FiftyAlgorthm scd = new FiftyAlgorthm();
        int m = scd.division(a, b);
        int n = a * b / m;
        System.out.println("最大公约数: " + m);
        System.out.println("最小公倍数: " + n);
    }

    public int division(int x, int y) {
        int t;
        if(x < y) {
            t = x;
            x = y;
            y = t;
        }

        while(y != 0) {
            if(x == y) return 1;
            else {
                int k = x % y;
                x = y;
                y = k;
            }
        }
        return x;
    }

    /*【程序7】

题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
1.程序分析：利用while语句,条件为输入的字符不为 '/n '. */

    static int digital = 0;
    static int character = 0;
    static int other = 0;
    static int blank = 0;
    public static void main7(String[] args) {
        char[] ch = null;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ch = s.toCharArray();


        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                digital++;
            } else if ((ch[i] >= 'a' && ch[i] <= 'z') || ch[i] > 'A' && ch[i] <= 'Z') {
                character++;
            } else if (ch[i] == ' ') {
                blank++;
            } else {
                other++;
            }

        }

        System.out.println("数字个数: " + digital);
        System.out.println("英文字母个数: " + character);
        System.out.println("空格个数: " + blank);
        System.out.println("其他字符个数:" + other);
    }

    /*【程序8】

题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
*/
    /*
     * 算法： 定义一个变量b， 赋初值为0；定义一变量sum， 赋初值为0，
     * 进入循环后，将a + b 的值赋给b，将sum + b 的值赋给sum；
     * 同时，将a 增加十倍， ++ i； 继续循环；
     * 循环结束后，输出sum 的值。
     */
    static long a = 2, b8 = 0;
    public static void main8(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i = 0;
        long sum = 0;
        while(i < n) {
            b8 = b8 + a;
            sum = sum + b8;
            a = a * 10;
            ++ i;
        }
        System.out.println("input number: " + n);
        System.out.println(sum);
    }

    /*【程序9】
题目：一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3.编程 找出1000以内的所有完数。
*/
    public static void main9(String[] args) {

        System.out.println("1到1000的完数有： ");
        for(int i=1; i<1000; i++) {
            int t = 0;
            for(int j=1; j<= i/2; j++) {
                if(i % j == 0) {
                    t = t + j;
                }
            }
            if(t == i) {
                System.out.print(i + " ");
            }
        }
    }

    /*【程序10】

题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，
求它在 第10次落地时，共经过多少米？第10次反弹多高？
*/
    static double height = 100;
    static double distance = 100;
    public static void main10(String[] args) {
        for(int i=1; i<10; i++) {
            distance = distance + height;
            height = height / 2;
        }

        System.out.println("路程：" + distance);
        System.out.println("高度：" + height / 2);
    }

    /*【程序11】
*
题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
1.程序分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去 掉不满足条件的排列。
*/
    /*算法：3个for循环加一个if语句；
     *
     */
    public static void main11(String[] args) {
        int count = 0;
        for(int x=1; x<5; x++) {
            for(int y=1; y<5; y++) {
                for(int z=1; z<5; z++) {
                    if(x != y && y != z && x != z) {
                        count ++;
                        System.out.print(x*100 + y*10 + z + "   ");
                        if(count % 4 == 0) {
                            System.out.println();
                        }
                    }
                }
            }
        }
        System.out.println("共有" + count + "个三位数");
    }

    /*【程序15】
*
题目：输入三个整数x,y,z，请把这三个数由小到大输出。
1.程序分析：我们想办法把最小的数放到x上，先将x与y进行比较，如果x> y则将x与y的值进行交换，然后再用x与z进行比较，如果x> z则将x与z的值进行交换，这样能使x最小。
*/

    public static void main15(String[] args) {
        FiftyAlgorthm fnc = new FiftyAlgorthm();
        int a, b, c;

        System.out.println("Input 3 numbers:");
        a = fnc.input();
        b = fnc.input();
        c = fnc.input();
//
//   fnc.compare(a, b);//方法调用不能通过改变形参的值来改变实参的值
//   fnc.compare(b, c);// 这种做法是错的
//   fnc.compare(a, c);
        //System.out.println("result:" + a +" " + b + " " + c);// 没有改变

        if(a > b) {
            int t = a;
            a = b;
            b = t;
        }

        if(a > c) {
            int t = a;
            a = c;
            c = t;
        }

        if(b > c) {
            int t = b;
            b = c;
            c = t;
        }
        System.out.println( a + " " + b + " " + c);
    }
    public int input() {
        int value = 0;
        Scanner s = new Scanner(System.in);
        value = s.nextInt();
        return value;
    }
    public void compare(int x, int y) {//此方法没用
        if(x > y) {
            int t = x;
            x = y;
            y = t;
        }
    }

    /*【程序16】
     *
     *题目：输出9*9口诀。
     *1.程序分析：分行与列考虑，共9行9列，i控制行，j控制列。
     **/

    public static void main16(String[] args) {
        for(int i=1; i<10; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(j + "*" + i + "=" + j*i + " " );
            }
            System.out.println();
        }
    }

    /*【程序21】
*
题目：求1+2!+3!+...+20!的和
1.程序分析：此程序只是把累加变成了累乘。
*/
    static long sum = 0;
    static long fac = 0;
    public static void main21(String[] args) {
        long sum = 0;
        long fac = 1;
        for(int i=1; i<=10; i++) {
            fac = fac * i;
            sum += fac;
        }
        System.out.println(sum);
    }

    /*【程序22】
*
题目：利用递归方法求5!。
1.程序分析：递归公式：fn=fn_1*4!
*/
    public static void main22(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        FiftyAlgorthm tfr = new FiftyAlgorthm();
        System.out.println(tfr.recursion(n));
    }
    public long recursion(int n) {
        long value = 0 ;
        if(n ==1 || n == 0) {
            value = 1;
        } else if(n > 1) {
            value = n * recursion(n-1);
        }
        return value;
    }

    /*【程序27】
*
题目：求100之内的素数
1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，
如果能被整除， 则表明此数不是素数，反之是素数。
**/

    public static void main27(String[] args) {
        boolean b =false;
        int count = 0;
        for(int i=2; i<100; i+=1) {
            for(int j=2; j<=Math.sqrt(i); j++) {
                if(i % j == 0) {
                    b = false;
                    break;
                } else{
                    b = true;
                }
            }

            if(b == true) {
                count ++;
                System.out.print(i + " ");
            }
        }
        System.out.println('\n' + "The number of PrimeNumber is :" + count);
    }


}
