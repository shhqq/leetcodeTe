
import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k > n || k == 0){
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<Integer>(), 1, n, k);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> temp, int start, int n, int k){
        if(temp.size() == k){
            ans.add(new ArrayList<Integer>(temp));
        } else {
            for (int i = start; i <= n; i++){
                temp.add(i);
                backtrack(ans, temp, i + 1, n, k);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
// @lc code=end

