import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++){
            backTrack(ans, new ArrayList<>(), 0, nums, i);
        }
        return ans;
    }
    private void backTrack(List<List<Integer>> ans, List<Integer>temp, int start, int[] nums, int k){
        if (temp.size() == k){
            ans.add(new ArrayList<>(temp));
        } else {
            for(int i = start; i < nums.length; i++){
                temp.add(nums[i]);
                backTrack(ans, temp, i + 1, nums, k);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
// @lc code=end

