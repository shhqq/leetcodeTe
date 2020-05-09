/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[] ans = new int[col];

        ans[0] = grid[0][0];
        for (int j = 1; j< col; j++){
            ans[j] = ans[j-1] + grid[0][j];
        }
        for (int i = 1; i < row; i++){
            for (int j = 0; j < col; j++){
                if(j == 0){
                    ans[j] += grid[i][j];
                } else {        // 左边和前值的较小值加上grid的值
                    ans[j] = Math.min(ans[j], ans[j - 1]) + grid[i][j];
                }
            }
        }
        return ans[col - 1];
    }
}
// @lc code=end

