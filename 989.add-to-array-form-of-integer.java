import java.util.ArrayList;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

/*
 * @lc app=leetcode id=989 lang=java
 *
 * [989] Add to Array-Form of Integer
 */

// @lc code=start
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        Integer k = K;
        int len = Math.max(A.length, k.toString().length());
        List<Integer> ans = new ArrayList<>();
        int s = 0; 
        int extra = 0;
        int j = A.length - 1;
        for(int i = len - 1; i >= 0; i--){
            s = K % 10;
            K = K / 10;
            if(j >= 0){
                s += extra + A[j];
            } else {
                s += extra;        
            }
            extra = s / 10;
            s = s % 10;
            j--;
            ans.add(s);
        }
        if(extra > 0){
            ans.add(extra);
        }

        Collections.reverse(ans);
        return ans;
    }
}
// @lc code=end

