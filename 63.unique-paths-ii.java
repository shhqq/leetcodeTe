/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 同样，这里可以使用二维数组，也可以使用一维数组。
        int[] ans = new int[n];
        ans[0] = 1;

        for(int j = 1; j < n; j++){
            ans[j] = obstacleGrid[0][j] == 1 ? 0 : ans[j-1];
        }

        for(int i = 1; i < m; i++){
            for (int j = 0; j < n; j++){
                if(j == 0){
                    ans[j] = obstacleGrid[i][j] == 1 ? 0 : ans[j];
                }else {
                    ans[j] = obstacleGrid[i][j] == 1 ? 0 : ans[j] + ans[j-1];
                }
            }
        }
        return ans[n-1];
    }
}
// @lc code=end

