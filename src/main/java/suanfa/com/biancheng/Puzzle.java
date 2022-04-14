package suanfa.com.biancheng;

public class Puzzle {
    //如下为解决迷宫问题的 Java 程序：
    static boolean find = false;
    static int ROW = 5;
    static int COL = 5;
    //(row,col) 表示起点，(outrow,outcol)表示终点
    public static void maze_puzzle(char [][] maze, int row, int col, int outrow, int outcol) {
        maze[row][col] = 'Y'; // 将各个走过的区域标记为 Y
        //如果行走至终点，表明有从起点到终点的路线
        if (row == outrow && col == outcol) {
            find = true;
            System.out.println("成功走出迷宫,路线图为：");
            printmaze(maze);
            return ;
        }
        //尝试向上移动
        if (canMove(maze, row - 1, col)) {
            maze_puzzle(maze, row - 1, col, outrow, outcol);
            //如果程序不结束，表明此路不通，恢复该区域的标记
            maze[row - 1][col] = '1';
        }
        //尝试向左移动
        if (canMove(maze, row, col - 1)) {
            maze_puzzle(maze, row, col - 1, outrow, outcol);
            //如果程序不结束，表明此路不通，恢复该区域的标记
            maze[row][col - 1] = '1';
        }
        //尝试向下移动
        if (canMove(maze, row + 1, col)) {
            maze_puzzle(maze, row + 1, col, outrow, outcol);
            //如果程序不结束，表明此路不通，恢复该区域的标记
            maze[row + 1][col] = '1';
        }
        //尝试向右移动
        if (canMove(maze, row, col + 1)) {
            maze_puzzle(maze, row, col + 1, outrow, outcol);
            //如果程序不结束，表明此路不通，恢复该区域的标记
            maze[row][col + 1] = '1';
        }
    }
    //判断(row,col)区域是否可以移动
    public static boolean canMove(char [][] maze, int row, int col) {
        //如果目标区域位于地图内，不是黑色区域，且尚未移动过，返回 true：反之，返回 false
        return row >= 0 && row <= ROW - 1 && col >= 0 && col <= COL - 1 && maze[row][col] != '0' && maze[row][col] != 'Y';
    }
    //输出行走路线
    public static void printmaze(char [][] maze) {
        for(int i=0;i<ROW;i++) {
            for(int j=0;j<COL;j++) {
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char [][]maze = new char[][]{
                {'1','0','1','1','1'},
                {'1','1','1','0','1'},
                {'1','0','0','1','1'},
                {'1','0','0','1','0'},
                {'1','0','0','1','1'} };
        maze_puzzle(maze, 0, 0, ROW - 1, COL - 1);
        if (find == false) {
            System.out.print("未找到可行线路");
        }
    }
}
