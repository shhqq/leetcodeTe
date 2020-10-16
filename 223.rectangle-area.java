/*
 * @lc app=leetcode id=223 lang=java
 *
 * [223] Rectangle Area
 */

// @lc code=start
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int s1 = (C - A) * (D - B);
        int s2 = (G - E) * (H - F);

        int left = Math.max(A, E), right = Math.max(Math.min(C, G), left);
        int bottom = Math.max(B, F), top = Math.max(Math.min(D, H), bottom);

        return s1 + s2 - (right - left) * (top - bottom);
    }
}
// @lc code=end

