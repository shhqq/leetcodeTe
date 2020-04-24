import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        HashMap<Integer, List<Integer>> pairs= new HashMap<>();
        for(int i = 0; i < len; i++){
            for(int j = i+1; j< len; j++){
                for(int k = 0; k< len; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        int[] temp = {nums[i], nums[j], nums[k]};
                        Arrays.sort(temp);
                        if(pairs.keySet().contains(temp[0])){
                            if(pairs.get(temp[0]).contains(temp[1])) {
                                continue;
                            } else {
                                pairs.get(temp[0]).add(temp[1]);
                                ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            }
                        } else {
                            pairs.put(temp[0], Arrays.asList(temp[1]));
                            ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        }
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

