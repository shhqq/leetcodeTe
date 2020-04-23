/*
 * @lc app=leetcode id=944 lang=java
 *
 * [944] Delete Columns to Make Sorted
 */

// @lc code=start
class Solution {
    public int minDeletionSize(String[] A) {

        int ans = 0;
        int numOfStrings = A.length;
        if(numOfStrings == 0){
            return 0;
        }
        int lengthOfString = A[0].length();
        for(int i = 0; i < lengthOfString; i++){
            for(int j = 0; j < numOfStrings - 1; j++){
                if(A[j].charAt(i) > A[j+1].charAt(i)){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

