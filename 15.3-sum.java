import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javafx.scene.shape.Ellipse;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int low = i+1, high = nums.length - 1, sum = 0 - nums[i];
                while (low < high){
                    if(nums[low] + nums[high] == sum){
                        ans.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        // 如果数字与之前的重复，要前进一位
                        while(low < high && nums[low] == nums[low+1]){
                            low++;
                        }
                        while(low < high && nums[high] == nums[high-1]){
                            high--;
                        }

                        low++;
                        high--;
                    } else if(nums[low] + nums[high] < sum){
                        low++;
                    }else {
                        high--;
                    }
                    
                }
            }
        }

        return ans;
        /*
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        HashMap<Integer, List<Integer>> pairs= new HashMap<>();
        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                for(int k = j+1; k < len; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        int[] temp = {nums[i], nums[j], nums[k]};
                        Arrays.sort(temp);
                        if(pairs.keySet().contains(temp[0])){
                            if(pairs.get(temp[0]).contains(temp[1])) {
                                continue;
                            } else {
                                pairs.get(temp[0]).add(temp[1]);
                                ans.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                            }
                        } else {
                            pairs.put(temp[0], new ArrayList<Integer>(Arrays.asList(temp[1])));
                            ans.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                        }
                    }
                }
            }
        }
        return ans;
        // */ 
    }
}
// @lc code=end

