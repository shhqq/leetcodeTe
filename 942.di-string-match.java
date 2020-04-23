/*
 * @lc app=leetcode id=942 lang=java
 *
 * [942] DI String Match
 */

// @lc code=start
class Solution {
    public int[] diStringMatch(String S) {
        int lenOfS = S.length();
        int minN = 0;
        int maxN = lenOfS;
        int[] res = new int[lenOfS + 1];
        for(int i = 0; i < lenOfS; i++){
            if(S.charAt(i) == 'I'){
                res[i] = minN;
                minN++;
            }else{
                res[i] = maxN;
                maxN--;
            }
        }
        res[lenOfS] = minN;
        return res;
    }
}
/**
 * 如果下一个时“I”，就加入剩余的最小值；
 * 如果下一个是“D”，那么就加入剩余的最大值。
 */
// @lc code=end

