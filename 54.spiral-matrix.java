import java.util.ArrayList;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new ArrayList<Integer>();
        }
        List<Integer> ans = new ArrayList();
        int circle = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int circleMax = Math.min((m + 1) / 2, (n + 1) / 2);
        for (int i = 0; i < circleMax; i++){
            int j = i;
            while(j < n - i){
                ans.add(matrix[i][j]);
                j++;
            }
            j = i + 1;
            while(j < m - i){
                ans.add(matrix[j][n - 1 - i]);
                j++;
            }
            j = n-2-i;
            while(j >= i && m - 1 - i > i){
                ans.add(matrix[m - 1 - i][j]);
                j--;
            }
            j = m-2-i;
            while(j > i && i != n - 1 - i){
                ans.add(matrix[j][i]);
                j--;
            }
        }
        return ans;
    }
}
// @lc code=end

