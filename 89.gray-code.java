import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        // 格雷码的生成，将n-1的序列镜像一份，然后前半段前面加0，后半段前面加1
        List<Integer> ans = new ArrayList<>();
        if(n == 0){
            ans.add(0);
            return ans;
        } else if (n == 1){
            ans.add(0);
            ans.add(1);
            return ans;
        } else {
            ans = grayCode(n - 1);
            int count = ans.size();
            for (int i = count - 1; i >= 0; i--){
                ans.add(ans.get(i) + (int)Math.pow(2, n - 1));
            }
            return ans;
        }
    }
}
// @lc code=end

