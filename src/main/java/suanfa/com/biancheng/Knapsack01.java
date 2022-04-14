package suanfa.com.biancheng;

public class Knapsack01 {

    static int N = 5;//商品的种类
    static int W = 11;//背包的承重
    //动态规划算法解决01背包问题
    public static void knapsack01(int [][] result , int [] w,int []v) {
        //逐个遍历每个商品
        for(int i=1;i<=N;i++) {
            //求出从 1 到 W 各个承重对应的最大收益
            for ( int j=1;j<=W;j++) {
                //如果背包承重小于商品总重量，则该商品无法放入背包，收益不变
                if(j<w[i]) {
                    result[i][j] = result[i-1][j];
                }else {
                    //比较装入该商品和不装该商品，哪种情况获得的收益更大，记录最大收益值
                    result[i][j] = result[i - 1][j] > (v[i] + result[i - 1][j - w[i]]) ? result[i - 1][j] : (v[i] + result[i - 1][j - w[i]]);
                }
            }
        }
    }
    //追溯选中的商品
    public static void select(int [][] result , int [] w,int []v) {
        int n = N;
        int bagw = W;
        //逐个商品进行判断
        while(n>0) {
            //如果在指定承重下，该商品对应的收益和上一个商品对应的收益相同，则表明未选中
            if (result[n][bagw] == result[n - 1][bagw]) {
                n--;
            }
            else {
                //输出被选用商品的重量和价值
                System.out.print("("+w[n]+","+v[n]+") ");
                //删除被选用商品的承重，以便继续遍历
                bagw = bagw - w[n];
                n--;
            }
        }
    }
    public static void main(String[] args) {
        int [] w= {0,1 , 2 , 5 , 6 , 7}; //商品的重量
        int [] v ={0,1 , 6 , 18 , 22 , 28};  //商品的价值
        int [][] result = new int[N+1][W+1];
        knapsack01(result, w, v);;
        System.out.println("背包可容纳重量为 "+W+"，最大收益为 "+result[N][W]);
        System.out.print("选择了");
        select(result, w,v);
    }
}
