import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        // ************* algorithm 1 **************
        // 使用简单的递归
        // 遍历nums作为第一个元素，然后递归获取其余值的排列数；
        // 每次将nums去掉当前值，然后组合起来。
        if(nums.length == 1){
            return Arrays.asList(Arrays.asList(nums[0]));
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
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
            
            for(List<Integer> l : permute(remain)){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.addAll(l);
                res.add(temp);
            }
        }
        return res;
    }

    /*
    // ************* algorithm 2 ***************
    // 使用backtrack，
    // backtrack 有两个注意的地方：
    // 一是满足条件加到res时，要新建对象；
    // 二是要移除本次添加的值
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums){
        if (temp.size() == nums.length){
            res.add(new ArrayList<Integer>(temp));      // 1. 要新建对象
        } else {
            for (int i = 0; i < nums.length; i++){
                if (!temp.contains(nums[i])){
                    temp.add(nums[i]);
                    backtrack(res, temp, nums);
                    temp.remove(temp.size() - 1);       // 2. 移除本次添加的对象
                }
            }
        }
    }
    */
}
// @lc code=end

