import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;

/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        return solution2(grid);
    }
    
    /**
     * 使用递归，形式更简单
     * @param grid
     * @return
     */
    private int solution2(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int count = 0;
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfsMarking(grid, i, j);
                }
            }
        }
        return count;
    }

    /**
     * 深度优先进行标记，也就是递归
     * @param grid
     * @param i
     * @param j
     */
    private void dfsMarking(char[][] grid, int i, int j){
        if (i <0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '2';
        dfsMarking(grid, i-1, j);
        dfsMarking(grid, i+1, j);
        dfsMarking(grid, i, j-1);
        dfsMarking(grid, i, j+1);
    }
    /**
     * 使用一个栈保存周边的坐标
     * @param grid
     * @return
     */
    private int solution1(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int count = 0;
        int row = grid.length, col = grid[0].length;
        List<point> land = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    land.add(new point(i, j));
                    while (land.size() > 0) {
                        List<point> temp = new ArrayList<>();

                        for(point k : land) {
                            int m = k.row, n = k.col;
                            grid[m][n] = '2';
                            if (m > 0 && grid[m-1][n] == '1') {
                                temp.add(new point(m-1, n));
                                grid[m-1][n] = '2';
                            }
                            if (m < row - 1 && grid[m+1][n] == '1') {
                                temp.add(new point(m+1, n));
                                grid[m+1][n] = '2';
                            }
                            if (n > 0 && grid[m][n-1] == '1') {
                                temp.add(new point(m, n-1));
                                grid[m][n-1] = '2';
                            }
                            if (n < col - 1 && grid[m][n+1] == '1') {
                                temp.add(new point(m, n+1));
                                grid[m][n+1] = '2';
                            }
                        }
                        land = temp;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 用来保存坐标
     */
    class point {
        int row;
        int col;
        public point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
// @lc code=end

/**
 * 可以用栈，保存上下左右的坐标，也可以用递归。
 */