import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            List<List<Integer>> temp = threeSum(nums, target-nums[i], i);
            for(int j = 0; j < temp.size(); j++){
                List<Integer> l = new ArrayList<>();
                l.add(nums[i]);
                l.addAll(temp.get(j));
                ans.add(l);
            }
        }
        return ans;
    }

    /**
     * 
     * @param nums
     * @param target
     * @param currentIndex
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums, int target, int currentIndex){
        if(currentIndex > nums.length - 4){
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = currentIndex + 1; i < nums.length - 2; i++){
            if(i > currentIndex + 1 && nums[i] == nums[i-1]){
                continue;
            }
            int low = i+1, high = nums.length - 1, tar = target - nums[i];
            while (low < high){
                if(nums[low] + nums[high] == tar){
                    ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                    while (nums[low] == nums[low-1] && low < high){
                        low++;
                    }
                    while(nums[high] == nums[high+1] && low < high){
                        high--;
                    }
                }else if(nums[low] + nums[high] < tar){
                    low++;
                    while (nums[low] == nums[low-1] && low < high){
                        low++;
                    }
                }else if(nums[low] + nums[high] > tar){
                    high--;
                    while(nums[high] == nums[high+1] && low < high){
                        high--;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

