/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        /**
         *  ******************* algorithm 1 ************
         * 定义一个整数数组，记录结果的每一位的值，由高到低，即个位在数组最后一个。
         * 结果最长为len1 + len2
         */
        int len1 = num1.length(), len2 = num2.length();
        int[] mul = new int[len1 + len2];
        for(int i = len1 - 1; i >= 0; i--){
            for (int j = len2 - 1; j >= 0; j--){
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                mul[i + j + 1] += n1 * n2;
            }
        }

        // 计算每一位的值，当前值加进位，再对10取模
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = mul.length - 1; i >= 0; i--){
            int sum = mul[i] + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }

        while (sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }


        /**
         * ********************  algorithm 2 *************************
         * 用num2的每一位乘以num1，得到一个字符串，然后将所有的字符串加起来，注意要补0。
         */
        /*
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        } else {
            String ans = "";
            String zeros = "";
            for (int i = num2.length() - 1; i >= 0; i--){
                if(i < num2.length() - 1) {
                    zeros += "0";
                }
                if(num2.charAt(i) == '0'){
                    continue;
                }
                String mul = multiplyHelper(num1, num2.charAt(i)) + zeros;
                ans = addTwoString(ans, mul);
            }
            return ans;
        }
    }

    public String multiplyHelper(String num1, char c){
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int n = c - '0';
        for (int i = num1.length() - 1; i >= 0; i--) {
            int mul = (num1.charAt(i) - '0') * n + carry;
            ans.insert(0, mul % 10);
            carry = mul / 10; 
        }
        if(carry > 0){
            ans.insert(0, carry);
        }
        
        return ans.toString();
    }

    private String addTwoString(String s1, String s2){
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int i = 0;
        int len1 = s1.length(), len2 = s2.length();
        for (; i < Math.min(len1, len2); i++){
            int sum = s1.charAt(len1 - 1 - i) - '0' + s2.charAt(len2 - 1 - i) - '0' + carry;
            ans.insert(0, sum % 10);
            carry = sum / 10;
        }

        String remain = len1 > len2 ? s1.substring(0, len1 - i): s2.substring(0, len2 - i);
        i = remain.length() - 1;
        while (i >= 0) {
            int sum = remain.charAt(i) - '0' + carry;
            ans.insert(0, sum % 10);
            carry = sum / 10;
            i--;
        }

        if(carry > 0){
            ans.insert(0, carry);
        }

        return ans.toString();
    }
    */
}
// @lc code=end

