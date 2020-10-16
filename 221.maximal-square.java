/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        return solution2(matrix);
    }

    /**
     * 方法2：
     * 使用dp，需要想到一层关系。
     * 首先创建一个等大的数组dp，dp[i][j]表示以[i,j]处的1为右下角的最大矩形边长。
     * 那么有这样的递推公式dp(i,j) = min(dp(i-1,j), dp(i-1,j-1), dp(i,j-1)) + 1
     * 还有方法3：因为只用到了当前行和上一行，因此不需要用m*n的dp矩阵，使用2行（或者再简化使用1行加一个额外的变量）就可以。
     * 
     * @param matrix
     * @return
     */
    private int solution2(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int ans = 0;
        int row = matrix.length, column = matrix[0].length;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // 第一行和第一列与matrix相同
                if ((i == 0 || j == 0) && matrix[i][j] == '1') {
                    dp[i][j] = 1;
                } else if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]) + 1;
                }
                // System.out.println("i,j: " + dp[i][j]);
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans * ans;
    }

    /**
     * 方法1：
     * 首先想到的就是遍历，从每个1开始向下向右增长。记录正方形边长最大值k。
     * 对于剩余行数或列数<=k的就没必要判断了。
     * @param matrix
     * @return
     */
    private int solution1(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int ans = 0;
        int row = matrix.length, column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (i > row - ans) break;
            for (int j = 0; j < column; j++) {
                if (j > column - ans) break;

                if (matrix[i][j] == '1') {
                    ans = Math.max(ans, calSquare(matrix, i, j));
                    //System.out.println(String.format("%d, i=%d, j =%d", ans, i, j));
                }
            }
        }
        return ans * ans;
    }

    /**
     * [m,n]处为1.
     * 返回矩阵从[m,n]处为左上角的均为1的最大方形的边长。
     */
    private int calSquare(char[][] matrix, int m, int n) {
        int ans = 1;
        int row = matrix.length, col = matrix[0].length;
        while (true) {
            if (m+ans >= row || n+ans >= col) return ans;
            // 检查多出来的一行
            for (int j = n; j <= n + ans; j++) {
                if (matrix[m+ans][j] == '0') return ans;
            }
            // 检查多出来的一列
            for (int i = m; i <= m+ans; i++) {
                if (matrix[i][n+ans] == '0') return ans;
            }
            
            ans++;
        }
    }
}
// @lc code=end

