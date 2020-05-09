/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        /**
         * +++++++++++++++++  algorithm 1 ++++++++++++++++++++
         * 可以硬算
         */
        // double ans = 1;
        // for(int i = 1; i < m; i++){
        //     ans = ans * (n - 1 + i) / i;
        // }
        // return (int)ans;


        
        /**
         * +++++++++++++++++  algorithm 2 ++++++++++++++++++++
         * 存储中间值，避免使用递归。
         * 即(m, n) = (m-1, n) + (m, n-1);
         * 可以使用二维数组，也可以使用一维数组。
         * 将(m-1, n)当做前值，(m, n-1)当做前一个值
         * 
         */

        int[] ans = new int[n];
        for(int i = 0; i< n; i++){
            ans[i] = 1;
        }
        for(int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                ans[j] += ans[j-1];
            }
        }
        return ans[n-1];
    }
}
// @lc code=end

