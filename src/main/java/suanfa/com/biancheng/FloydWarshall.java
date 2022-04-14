package suanfa.com.biancheng;

public class FloydWarshall {

    static int V = 4; // 顶点的个数
    static int[][] P = new int[V][V]; // 记录各个顶点之间的最短路径
    static int INF = 65535; // 设置一个最大值
    // 中序递归输出各个顶点之间最短路径的具体线路
    public static void printPath(int i, int j) {
        int k = P[i][j];
        if (k == 0)
            return;
        printPath(i, k);
        System.out.print((k + 1) + "-");
        printPath(k, j);
    }
    // 输出各个顶点之间的最短路径
    public static void printMatrix(int[][] graph) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (j == i) {
                    continue;
                }
                System.out.print((i + 1) + " - " + (j + 1) + "：最短路径为:");
                if (graph[i][j] == INF)
                    System.out.println("INF");
                else {
                    System.out.print(graph[i][j]);
                    System.out.print("，依次经过：" + (i + 1) + "-");
                    // 调用递归函数
                    printPath(i, j);
                    System.out.println((j + 1));
                }
            }
        }
    }
    // 实现弗洛伊德算法,graph[][V] 为有向加权图
    public static void floydWarshall(int[][] graph) {
        int i, j, k;
        // 遍历每个顶点，将其作为其它顶点之间的中间顶点，更新 graph 数组
        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    // 如果新的路径比之前记录的更短，则更新 graph 数组
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        // 记录此路径
                        P[i][j] = k;
                    }
                }
            }
        }
        // 输出各个顶点之间的最短路径
        printMatrix(graph);
    }
    public static void main(String[] args) {
        // 有向加权图中各个顶点之间的路径信息
        int[][] graph = new int[][] { { 0, 3, INF, 5 }, { 2, 0, INF, 4 }, { INF, 1, 0, INF }, { INF, INF, 2, 0 } };
        floydWarshall(graph);
    }
}
