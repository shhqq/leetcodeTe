/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        long ans = 0L;
        boolean positive = true;
        boolean start = false;
        for(char c: str.toCharArray()){
            if(c == ' ' && !start){
                continue;
            }
            int n = (int)c;
            if(n >= 48 && n <= 57){
                start = true;
                if(positive){
                    if(ans * 10 + n - 48 < Math.pow(2, 31)){
                        ans = ans * 10 + n - 48;
                    }else{
                        return (int)(Math.pow(2, 31));
                    }
                }else{
                    if(ans*10 + 48 - n >= -Math.pow(2, 31)){
                        ans = ans * 10 + 48 - n;
                    }else{
                        return -(int)Math.pow(2, 31) - 1;
                    }
                }
            }
            else if(c == '-' && !start){
                positive = false;
                start = true;
            }
            else if(c == '+' && !start){
                start = true;
            }
            else{
                return (int)ans;
            }
        }
        return (int)ans;
    }
}
// @lc code=end

