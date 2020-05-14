/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        // algorithm 1，使用变量存储
        // 没必要使用数组保存中间结果，因为只用到两个值，直接使用两个值加一个temp保存就可以
        int n = s.length();
        int temp1 = 1;
        int temp2 = 1;
        for (int i = n-1; i >= 0; i--){
            if(s.charAt(i) == '0'){
                // temp1, temp2 分别更新为0， temp1
                temp2 = temp1;      // 注意先要把temp2更新为temp1
                temp1 = 0;
            } else if(s.charAt(i) == '1' && i < n-1){
                // temp1, temp2 分别更新为temp1+temp2, temp1
                int temp = temp2;
                temp2 = temp1;
                temp1 += temp;
            } else if(s.charAt(i) == '2' && i < n-1 && s.charAt(i+1) < '7'){
                // temp1, temp2 分别更新为temp1+temp2, temp1
                int temp = temp2;
                temp2 = temp1;
                temp1 += temp;
            } else {
                // temp1, temp2 分别更新为temp1， temp1
                temp2 = temp1;
            }
        }
        return temp1;



        // int n = s.length();
        // int[] counts = new int[n + 1];

        // counts[n] = 1;
        // counts[n - 1] = 1;
        
        // for (int i = n - 1; i >= 0; i--){
        //     // 如果是0，如果是以0开头，那么直接返回0；否则
        //     if(s.charAt(i) == '0'){
        //         // 不用分情况，直接等于0即可
        //         counts[i] = 0;

        //         /*
        //         // 如果以0开头或0前面不是1，也不是2
        //         if (i == 0 || (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2')){
        //             return 0;
        //         } else {                // 该值置为0
        //             counts[i] = 0;
        //         }
        //         */
        //     } else if (s.charAt(i) == '1'){
        //         if (i == n - 1){
        //             counts[i] = counts[i + 1];
        //         }else {
        //             counts[i] = counts[i + 1] + counts[i + 2];
        //         }
        //     } else if(s.charAt(i) == '2'){
        //         if (i < n - 1 && s.charAt(i + 1) < '7'){
        //             counts[i] = counts[i + 1] + counts[i + 2];
        //         }
        //         else {
        //             counts[i] = counts[i + 1];
        //         }
        //     } else {
        //         counts[i] = counts[i + 1];
        //     }
        // }
        // return counts[0];

        /*
        // algorithm 2 ,使用递归
        // 使用递归将会超时
        if (s.length() == 0){
            return 1;
        } else {
            if(s.charAt(0) == '0'){
                return 0;
            } else if (s.charAt(0) == '1' && s.length() > 1){
                return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
            } else if (s.charAt(0) == '2' && (s.length() > 1 && s.charAt(1) < '7')){
                return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
            }else {
                return numDecodings(s.substring(1));
            }
        }
        // */
    }
}
// @lc code=end

