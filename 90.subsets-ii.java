import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(ans, new ArrayList<>(), nums, -1);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, ArrayList<Integer> temp, int[] nums, int index){
        ans.add(new ArrayList<>(temp));
        for (int i = index + 1; i < nums.length; i++){
            temp.add(nums[i]);
            backTrack(ans, temp, nums, i);
            int lastValue = temp.remove(temp.size() - 1);
            while (i < nums.length - 1 && nums[i + 1] == lastValue){
                i++;
            }
        }
    }
}
// @lc code=end

