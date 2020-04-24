/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        /**
         * 以任意一个字符为中心，向两侧扩展。
         * 可能中间两个是相同的，例如“abba“，
         * 也可能两侧是相同的，例如“abcba”，
         * 两种都满足的，例如“aaaaa”。
         * 遍历所有的情况。
         */
        if(s.length() == 0){
            return "";
        }
        int startAns = 0;
        int endAns = 0;
        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++){
            // 可能是此字符两侧相同
            if(i-1 >= 0 && i + 1 < s.length() && s.charAt(i-1) == s.charAt(i+1)){
                start = i - 1;
                end = i + 1;
                while(true){
                    if(start >= 0 && end < s.length()){
                        if(s.charAt(start) == s.charAt(end)){
                            start--;
                            end++;
                        }else{
                            if(end - start > endAns - startAns){
                                startAns = start;
                                endAns = end;
                            }
                            break;
                        }
                    } else {
                        if(end - start > endAns - startAns){
                            startAns = start;
                            endAns = end;
                        }
                        break;
                    }
                }
            }
            // 可能是此字符与下一个字符相同
            if(i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)){
                start = i;
                end = i + 1;
                while(true){
                    if(start >= 0 && end < s.length()){
                        if(s.charAt(start) == s.charAt(end)){
                            start--;
                            end++;
                        }else{
                            if(end - start > endAns - startAns){
                                startAns = start;
                                endAns = end;
                            }
                            break;
                        }
                    } else {
                        if(end - start > endAns - startAns){
                            startAns = start;
                            endAns = end;
                        }
                        break;
                    }
                }
            } 
        }
        String ans = "";
        if (endAns - startAns > 1){
            ans = s.substring(startAns+1, endAns);
        }else{
            ans = s.substring(startAns, endAns+1);
        }
        return ans;
    }
}
// @lc code=end

