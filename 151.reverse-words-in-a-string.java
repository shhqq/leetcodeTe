import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        List<String> strs = new ArrayList<>();
        int len = s.length();
        int left = 0;
        for (; left < len; left++) {
            if (s.charAt(left) != ' ') {
                break;
            }
        }
        int right;
        while (true) {
            right = s.indexOf(" ", left);
            if (right == -1) {
                strs.add(0, s.substring(left));
                break;
            } else {
                strs.add(0, s.substring(left, right));
                left = right;
                while (left < len) {
                    if (s.charAt(left) == ' ') left++;
                    else break;
                }
                if (left == len) {
                    break;
                }
            }
        }

        return String.join(" ", strs);
    }
}
// @lc code=end

