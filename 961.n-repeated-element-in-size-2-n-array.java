import java.util.Dictionary;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

/*
 * @lc app=leetcode id=961 lang=java
 *
 * [961] N-Repeated Element in Size 2N Array
 */

// @lc code=start
class Solution {
    public int repeatedNTimes(int[] A) {
        /*
        for(int i = 1; i < 4; i++){
            for (int j = 0; j < A.length - 1; j++){
                if(A[j] == A[j+i]){
                    return A[j];
                }
            }
        }
        throw null;
        // */
        
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int x: A){
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        for (int k: count.keySet()){
            if (count.get(k) > 1){
                return k;
            }
        }
        throw null;
        // */
    }
}
// @lc code=end

