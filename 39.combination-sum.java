import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        generate(ans, new ArrayList<Integer>(), candidates, 0, target);
        return ans;
    }

    public void generate(List<List<Integer>> ans, List<Integer> temp, int[] candidates, int index, int target){
        if (target < 0){
            return;
        } else if (target == 0){
            ans.add(new ArrayList<>(temp));         // 1. 这里需要new ArrayList<>()
        } else {
            for (int i = index; i < candidates.length; i++){
                temp.add(candidates[i]);
                generate(ans, temp, candidates, i, target - candidates[i]); // 2. 因为可以重复，这里是i，不是i+1
                temp.remove(temp.size() - 1);   // 3. 去掉最后一个，准备试添加新的
            }
        }
    }
}
// @lc code=end

