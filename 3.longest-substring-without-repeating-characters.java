import java.util.HashMap;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestSubNum = 0;
        int startSubIndex = 0;
        for(int i = 0; i < s.length(); i++){
            int nextIndex = s.indexOf(s.charAt(i), startSubIndex);
            if(nextIndex != i){
                longestSubNum = Math.max(longestSubNum, i - startSubIndex);
                startSubIndex = nextIndex + 1;
            }
        }
        // 注意处理最后的情况
        longestSubNum = Math.max(longestSubNum, s.length() - startSubIndex);
        return longestSubNum;
    }
}
// @lc code=end

