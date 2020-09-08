import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    /**
     * 每次让第一个子串长度加一，然后剩下的部分进行递归，即可。
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        if (s.length() == 1) {
            List<String> temp = new ArrayList<>();
            temp.add(s);
            res.add(temp);
            return res;
        }
        // 拆分时，第一个子串长度依次增加
        for (int i = 1; i < s.length(); i++) {
            // 首先要判断第一个子串是否是回文
            String first = s.substring(0, i);
            if(isPalindrome(first)) {
                List<List<String>> right = partition(s.substring(i));
                if (right.size() > 0) {
                    for(int j = 0; j < right.size(); j++) {
                        List<String> temp = new ArrayList<>();
                        temp.add(first);
                        temp.addAll(right.get(j));
                        res.add(temp);
                    }
                }
            }
        }
        // 判断s本身是否为回文
        if(isPalindrome(s)) {
            List<String> temp = new ArrayList<>();
            temp.add(s);
            res.add(temp);
        }
        return res;
    }

    /**
     * 判断字符串是否为回文
     * @param s a string
     * @return whether the string is palindrome
     */
    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;    
    }
}

// @lc code=end

