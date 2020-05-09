/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        /*
        int[][] ans = new int[n][n];

        int index = 1;
        for (int i = 0; i < (n + 1) / 2; i++){
            for (int j = i; j < n - i - 1; j++){
                ans[i][j] = index++;
            }
            for (int j = i; j < n - i - 1; j++){
                ans[j][n - 1 - i] = index++;
            }
            for (int j = n - 1 - i; j > i; j--){
                ans[n - 1 - i][j] = index++;
            }
            for (int j = n - 1 - i; j > i; j--){
                ans[j][i] = index++;
            }
        }
        if(n % 2 == 1){
            ans[n/2][n/2] = n*n;
        }
        return ans;
        */

        // 可以去沿着螺旋方式遍历矩阵，注意转弯的方式。

        int[][] ans = new int[n][n];
        int i = 0;
        int j = 0;
        int di = 0;
        int dj = 1;
        for (int k = 0; k < n*n; k++){
            ans[i][j] = k + 1;
            try {
                if(ans[i+di][j+dj] != 0){
                    int temp = -di;
                    di = dj;
                    dj = temp;
                }
            } catch (Exception e) {
                int temp = -di;
                di = dj;
                dj = temp;
            }
            i += di;
            j += dj;
        }
        return ans;
    }
}
// @lc code=end

