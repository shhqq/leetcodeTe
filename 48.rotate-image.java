/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length < 2){
            return;
        } else {
            int row = 0;
            int col = 0;
            int n = matrix.length;
            int remainN = n;
            while (remainN > 1){
                int i = row;
                int j = col;
                for (;i < n-1-row; i++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n-1-j][i];
                    matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                    matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                    matrix[j][n-1-i] = temp;
                }
                row++;
                col++;
                remainN -= 2;
            }
        }
    }
}
// @lc code=end

