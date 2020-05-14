import java.util.ArrayList;

/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        // 每个部分都在0到255之间，可以使用遍历。
        List<String> ans = new ArrayList<>();
        int n = s.length();
        for(int a = 1; a <= 3 && a <= n; a++){
            for(int b = a + 1; b <= a + 3 && b <= n; b++){
                for (int c = b+1; c <= b + 3 && b <= n; c++){
                    if(n - c > 0 && n - c < 4){
                        String part1 = s.substring(0, a);
                        String part2 = s.substring(a, b);
                        String part3 = s.substring(b, c);
                        String part4 = s.substring(c);
                        if(isValid(part1) && isValid(part2) && isValid(part3) && isValid(part4)){
                            ans.add(part1 + '.' +part2 + '.' + part3 + '.' + part4);
                        }
                    }
                }
            }
        }
        return ans;
    }

    private boolean isValid(String s){
        if (s.length() > 1 && s.charAt(0) == '0'){
            return false;
        } else if(Integer.valueOf(s) > 255){
            return false;
        }else {
            return true;
        }
    }
}
// @lc code=end

