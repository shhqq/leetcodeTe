import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        /**
         * 最终结果是每行字符串拼接的，所有可以分成numRows个子字符串
         * 使用可变字符串StringBuilder存储每行字符串，方便添加。
         * knowledge:
         * StringBuilder
         */
        if(numRows == 1){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i< Math.min(numRows, s.length()); i++){
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;

        for(char c: s.toCharArray()){
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows - 1){
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for(StringBuilder row : rows){
            ret.append(row);
        }
        return ret.toString();
        /*
        if(s.length() == 0 || numRows == 1){
            return s;
        }
        List chars = new ArrayList();

        int num = 2 * numRows - 2;          // 循环数
        for(int j = 0; j <= num/2; j++){
            for(int i = 0; i <= s.length() / num; i++){
                if(i*num+j<s.length())
                {
                    chars.add(s.charAt(i * num + j));
                }
                if(j != 0 && j != num / 2){
                    if(i*num+num-j < s.length())
                        chars.add(s.charAt(i * num + num - j));
                }
                
            }
        }
        String ans = "";
        for(int i = 0; i < chars.size(); i++){
            ans += chars.get(i);
        }
        return ans;
        // */
    }
}
// @lc code=end

