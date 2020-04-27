import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        /**
         * Firstly, calculate the number of result. The number is the product of the 
         * possibility of every digit.
         * Secondly, structure the string.
         */
        if(digits.length() == 0){
            return new ArrayList<String>();
        }
        List<String> ans = new ArrayList<>();
        String[] num2letter = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        int num = 1;
        for(int i = 0; i < digits.length(); i++){
            num *= num2letter[(int)digits.charAt(i) - 50].length();
        }

        for(int i = 0; i < num; i++){
            int temp2 = num;
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < digits.length(); j++){
                // 1. 当前数字代表字母的可能种类
                int numOfPossibleChar = num2letter[(int)digits.charAt(j) - 50].length();
                
                // 2. 后续的循环数，设为n，也就是当前字母重复的次数
                temp2 = temp2 / numOfPossibleChar;

                // 3. 
                // 当前的具体字母应该是i除以后续数字的循环数n，然后对当前可能的字母数量取余。
                // 因为当前字母是n个后会换下一个，而又有q前面的字母造成循环，所以要取余。
                int currentIndex = i / (temp2) % numOfPossibleChar;
                str.append(num2letter[(int)digits.charAt(j) - 50].charAt(currentIndex));
                
            }
            ans.add(str.toString());
        }
        return ans;
    }
}
// @lc code=end

