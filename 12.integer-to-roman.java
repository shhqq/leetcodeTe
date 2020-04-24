/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        String[] ch = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] ns = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i< 13; i++){
            int repeat = num / ns[i];
            for(int j = 0; j< repeat; j++){
                ans.append(ch[i]);
            }
            num %= ns[i];
        }
        return ans.toString();

        /*
        StringBuilder ans = new StringBuilder();
        int thousand = num / 1000;
        for(int i = 0; i< thousand; i++){
            ans.append('M');
        }

        num = num % 1000;
        int hundred = num / 100;
        if(hundred < 4){
            for(int i = 0; i < hundred; i++){
                ans.append('C');
            }
        }else if( hundred == 4){
            ans.append("CD");
        }else if(hundred < 9){
            ans.append('D');
            for(int i = 0; i < hundred - 5; i++){
                ans.append('C');
            }
        }else{
            ans.append("CM");
        }

        num = num % 100;
        int ten = num / 10;
        if(ten < 4){
            for(int i = 0; i < ten; i++){
                ans.append('X');
            }
        }else if(ten == 4){
            ans.append("XL");
        }else if(ten < 9){
            ans.append('L');
            for(int i = 0; i < ten - 5; i++){
                ans.append('X');
            }
        }else{
            ans.append("XC");
        }

        int unit = num % 10;
        if(unit < 4){
            for(int i = 0; i < unit; i++){
                ans.append('I');
            }
        }else if(unit == 4){
            ans.append("IV");
        }else if(unit < 9){
            ans.append('V');
            for(int i = 0; i < unit - 5; i++){
                ans.append('I');
            }
        }else{
            ans.append("IX");
        }
        return ans.toString();
        // */
    }
}
// @lc code=end

