import java.awt.List;
import java.util.Arrays;
import java.util.Set;

/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] res = new int[len];

        int i = 0;
        int j = len - 1;
        int k = j;
        while(i <= j && A[i] <= 0 && A[j] >= 0){
            if(Math.abs(A[i]) > A[j]){
                res[k] = (int)Math.pow(A[i], 2);
                i++;
            }else{
                res[k] = A[j] * A[j];
                j--;
            }
            k--;
        }
        while(i < len && A[i] < 0 ){
            res[k] = A[i] * A[i];
            i++;
            k--;
        }
        while(j >= 0 && A[j] > 0 ){
            res[k] = A[j] * A[j];
            j--;
            k--;
        }
        return res;
    }
}
// @lc code=end

