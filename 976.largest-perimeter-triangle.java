import java.util.Arrays;

/*
 * @lc app=leetcode id=976 lang=java
 *
 * [976] Largest Perimeter Triangle
 */

// @lc code=start
class Solution {
    public int largestPerimeter(int[] A) {
        // The sum of two smaller edges should be greater than the bigger one.
        Arrays.sort(A);
        int len = A.length;
        for (int i = 0; i < len-2; i++){
            if(A[len-1-i] < A[len-2-i] + A[len-3-i]){
                return A[len-1-i] + A[len-2-i] + A[len-3-i];
            }
        }
        return 0;

    }
}
// @lc code=end

