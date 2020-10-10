/*
 * @lc app=leetcode id=201 lang=java
 *
 * [201] Bitwise AND of Numbers Range
 */

// @lc code=start
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m){
            n = n & n-1;
        }
        return n & m;
    }
}
// @lc code=end

