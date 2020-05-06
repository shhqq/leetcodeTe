import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        /*
        // ************* algorithm 1 **************
        // 使用简单的递归
        // 遍历nums作为第一个元素，然后递归获取其余值的排列数；
        // 因为会有重复的数，所以做一个continue判断
        // 每次将nums去掉当前值，然后组合起来。
        if(nums.length == 1){
            return Arrays.asList(Arrays.asList(nums[0]));
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int[] remain = new int[nums.length-1];
            boolean find = false;
            for(int j = 0; j < nums.length; j++){
                if (find){
                    remain[j-1] = nums[j];
                } else {
                    if (nums[j] == nums[i]) {
                        find = true;
                    } else {
                        remain[j] = nums[j];
                    }
                }
            }
            
            for(List<Integer> l : permuteUnique(remain)){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.addAll(l);
                res.add(temp);
            }
        }
        return res;
        // */

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums){
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // 因为会有重复的值，所以这里统计出现的个数
                if(count(temp, nums[i]) < count(nums, nums[i])){
                    temp.add(nums[i]);
                    backtrack(res, temp, nums);
                    int value = temp.remove(temp.size()-1);
                    while(i < nums.length - 1 && nums[i + 1] == value){
                        i++;
                    }
                }
            }
        }
    }

    /**
     * Count occurrence of the number in the list.
     * @param temp  list of integers.
     * @param n     number to count.
     * @return      count of number in the list.
     */
    private int count(List<Integer> temp, int n){
        int ans = 0;
        for (int i = 0; i < temp.size(); i++){
            if(temp.get(i) == n){
                ans++;
            }
        }
        return ans;
    }

    /**
     * Count occurrence of the number in the array.
     * @param temp  Array of integers.
     * @param n     Number to count.
     * @return      Count of number.
     */
    private int count(int[] temp, int n){
        int ans = 0;
        for (int i = 0; i < temp.length; i++){
            if(temp[i] == n){
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

