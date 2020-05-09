import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder ans = new StringBuilder();
        List<Integer> nums = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < n; i++){
            nums.add(i + 1);
            count *= (i + 1);
        }

        k = k - 1;      // 注意这里k要-1

        // 从左到右，例如，n=4时，第一个数固定为1，那么2，3，4共有3!= 6 种，对6取除数就得到
        // 第一个数是几，然后在对6取模，计算后续顺序。
        while (k > 0){
            count /= nums.size();
            int index = k / count;
            ans.append(nums.get(index));
            nums.remove(index);

            k = k % count;
        }
        
        // 对剩余的数，肯定是从小到大排列，依次加到末尾即可。
        for (Integer i: nums){
            ans.append(i);
        }
        return ans.toString();
    }
}
// @lc code=end

