/*
 * @lc app=leetcode id=985 lang=java
 *
 * [985] Sum of Even Numbers After Queries
 */

// @lc code=start
class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        /*
        int[] ans = new int[queries.length];
        A[queries[0][1]] = A[queries[0][1]] + queries[0][0];
        ans[0] = 0;
        for(int j = 0; j < A.length; j++){
            ans[0] += A[j] % 2 == 0 ? A[j] : 0;
        }
        for(int i = 1; i < queries.length; i++){
            ans[i] = ans[i - 1];
            if(queries[i][0] % 2 == 0 && A[queries[i][1]] % 2 == 0){
                ans[i] += queries[i][0];
            } else if(queries[i][0] % 2 != 0 && A[queries[i][1]] % 2 == 0){
                ans[i] -= A[queries[i][1]];
            } else if(queries[i][0] % 2 != 0 && A[queries[i][1]] % 2 != 0){
                ans[i] += A[queries[i][1]] + queries[i][0];
            }
            A[queries[i][1]] = A[queries[i][1]] + queries[i][0];
        }
        return ans;
        // */
        int[] ans = new int[queries.length];
        int s = 0;
        for(int x: A){
            s += x % 2 == 0 ? x : 0;
        }
        for(int i = 0; i < queries.length; i++){
            if(A[queries[i][1]] % 2 == 0)
                s -= A[queries[i][1]];
            A[queries[i][1]] += queries[i][0];
            if(A[queries[i][1]] % 2 == 0)
                s += A[queries[i][1]];
            ans[i] = s;
        }
        return ans;
    }
}
// @lc code=end

