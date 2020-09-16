import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        /**
         * 使用一个栈保存数字，如果是运算符，则取出两个数字，运算后再入栈
         */
        List<Integer> nums = new ArrayList<>();
        int ans = 0;

        for(int i = 0; i < tokens.length; i++) {
            try {
                int n = Integer.parseInt(tokens[i]);
                nums.add(n);
            } catch (NumberFormatException e) {
                int n1 = nums.remove(nums.size()-1);
                int n2 = nums.remove(nums.size()-1);
                
                switch (tokens[i]) {
                    case "+":
                        ans = n1 + n2;
                        break;
                    case "-":
                        ans = n2 - n1;
                        break;
                    case "*":
                        ans = n1 * n2;
                        break;
                    case "/":
                        ans = n2 / n1;
                        break;
                    default:
                        break;
                }
                nums.add(ans);
            }
        }
        return nums.size() == 0 ? 0 : nums.remove(nums.size()-1);
    }
}
// @lc code=end

