import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        generate(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private void generate(List<List<Integer>> ans, List<Integer> temp, int[] candidates, int target, int index){
        if(target < 0){
            return;
        } else if (target == 0){
            ans.add(new ArrayList<Integer>(temp));
        } else {
            for (int i = index; i < candidates.length; i++){
                temp.add(candidates[i]);
                generate(ans, temp, candidates, target - candidates[i], i + 1);     // 因为不可重复，这里是i+1
                int lastValue = temp.remove(temp.size() - 1);
                while (i < candidates.length - 1 && candidates[i + 1] == lastValue){
                    i++;        // 如果下一个和删除的值相同，那么就跳过
                }
            }
        }
    }
}
// @lc code=end

