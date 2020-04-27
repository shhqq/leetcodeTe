import java.util.ArrayList;

import com.sun.javafx.fxml.expression.BinaryExpression;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        /**
         * ************* algorithm 1 ************
         * 使用递归生成，每次判断左括号还是右括号。
         */
        List<String> ans = new ArrayList<>();
        generateParenthesisHelper(ans, "", 0, 0, 0, n);
        return ans;
    }

    public void generateParenthesisHelper(List<String> ans, String str, int currentLength, int left, int right, int n){
        if(currentLength == 2 * n){
            ans.add(str);
        }else{
            if(left > right && left < n){
                generateParenthesisHelper(ans, str + "(", currentLength+1, left+1, right, n);
                generateParenthesisHelper(ans, str+")", currentLength+1, left, right + 1, n);
            }else if(left == right || left < n){
                generateParenthesisHelper(ans, str+"(", currentLength+1, left+1, right, n);
            }else{
                generateParenthesisHelper(ans, str+")", currentLength+1, left, right + 1, n);
            }
        }
    }

    

        /**
         * ******* algorithm 3 ***************
         * 想到用数字的二进制数表示，1代表（，0代表），然后匹配。
         * 实质上与枚举所有可能是一样的。
         */
    /* 
        int left = 0, leftRemain = 0;
        List<String> ans = new ArrayList();
        for(int i = (int)Math.pow(2, 2*n-1); i < Math.pow(2, 2*n); i++){
            String s = binaryRepresenString(i);
            if(countOne(s) == n){
                left = 0;
                boolean err = true;
                for(int j = 0; j < s.length(); j++){
                    if(s.charAt(j) == '1'){
                        left++;
                    }else{
                        if(left < 1){
                            err = false;
                        }else{
                            left--;
                        }
                    }
                }
                if(err){
                    StringBuilder temp = new StringBuilder();
                    for(char c: s.toCharArray()){
                        temp.append(c == '1'? '(': ')');
                    }
                    ans.add(temp.toString());
                }
            }
        }
        return ans;
    }

    public String binaryRepresenString(int n){
        StringBuilder ans = new StringBuilder();
        while(n>0){
            ans.append(n % 2);
            n /= 2;
        }
        return ans.reverse().toString();
    }

    public int countOne(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
    // */
}
// @lc code=end

