import java.util.List;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        // solution 1 使用DP
        boolean[] bs = new boolean[s.length() + 1];
        bs[0] = true;
        // 这种是从前往后，但是感觉从后往前是不是更好一点
        // for (int i = 0; i <= s.length(); i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (bs[j] && wordDict.contains(s.substring(j, i))) {
        //             bs[i] = true;
        //             break;
        //         }
        //     }
        // }
        // return bs[s.length()];
        
        // 这种是从后往前
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= i; j++) {
                if (bs[i-j] && wordDict.contains(s.substring(i-j, i))) {
                    bs[i] = true;
                    break;
                }
            }
        }
        return bs[s.length()];

        // 使用递归，耗时太长了
        /*
        if (s.length() == 0 || wordDict.contains(s)) {
            return true;
        }
        for (int i = 1; i < s.length(); i++) {
            if(wordDict.contains(s.substring(0, i))) {
                if (wordBreak(s.substring(i), wordDict)) {
                    return true;
                }
            }
        }
        return false;
        */
    }
}
// @lc code=end

