import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    /**
     * 使用backTracking
     * @param ans
     * @param comb
     * @param k
     * @param start
     * @param n
     */
    private void backTracking(List<List<Integer>> ans, List<Integer> comb, int k, int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> temp = new ArrayList<>(comb);
            ans.add(temp);
            return;
        }

        for (int i = start; i <= 9; i++) {
            comb.add(i);
            backTracking(ans, comb, k, i + 1, n - i);
            comb.remove(comb.size() - 1);
        }
    }
}
// @lc code=end

