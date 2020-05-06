/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if(x == 0 && n < 0){
            return 0;
        }
        if (n == 0){
            return 1;
        } else {
            if (n < 0){
                if(n == Integer.MIN_VALUE){
                    return myPow(x, n + 1) / x;
                }
                n = -n;
                x = 1 / x;
            }
            if(n % 2 == 1){
                return x * myPow(x*x, (n-1) / 2);
            }else{
                return myPow(x*x, n / 2);
            }
        }
    }
}
// @lc code=end

