package suanfa.com.biancheng;

public class Knapsack {

    //根据收益率，对记录的商品进行从大到小排序
    public static void sort(float [] w, float [] p) {
        int length = w.length;
        //用v[]存商品的收益率
        float [] v = new float[length];
        for (int i=0;i<length;i++) {
            v[i] = p[i]/w[i];
        }
        //根据 v 数组记录的各个商品收益率的大小，同时对 w 和 p 数组进行排序
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (v[i] < v[j]) {
                    float temp = v[i];
                    v[i] = v[j];
                    v[j] = temp;
                    temp = w[i];
                    w[i] = w[j];
                    w[j] = temp;
                    temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }
    }
    /*贪心算法解决部分背包问题
    w：记录各个商品的总重量
    p：记录各个商品的总价值
    result：记录各个商品装入背包的比例
    W：背包的容量
    */
    public static void fractional_knapsack(float []w, float []p, float []result, float W) {
        //根据收益率，重新对商品进行排序
        sort(w, p);
        int i=0;
        //从收益率最高的商品开始装入背包，直至背包装满为止
        while (W > 0) {
            float temp = W > w[i]?w[i]:W;
            result[i] = temp / w[i];
            W -= temp;
            i++;
        }
    }
    public static void main(String[] args) {
        //设定背包的容量
        float W = 50;
        //各个商品的重量
        float [] w = { 10,30,20 };
        //各个商品的价值
        float [] p = { 60,100,120 };
        //统计背包中商品的总收益
        float [] result = {0,0,0};
        //调用解决部分背包问题的函数
        fractional_knapsack(w,p,result,W);
        //统计背包中商品的总收益
        float values = 0;
        //根据 result 数组中记录的数据，决定装入哪些商品
        for (int i = 0; i < w.length; i++) {
            if (result[i] == 1) {
                System.out.println("总重量为"+w[i]+",总价值为"+p[i]+"的商品全部装入");
                values += p[i];
            }
            else if (result[i] == 0)
                System.out.println("总重量为"+w[i]+",总价值为"+p[i]+"的商品不装");
            else {
                System.out.println("总重量为"+w[i]+",总价值为"+p[i]+"的商品装入"+result[i]*100+"%");
                values += p[i] * result[i];
            }
        }
        System.out.print("最终收获的商品价值为"+values);
    }
}
