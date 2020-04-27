/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        /**
         * 基本思路： 使用移位操作实现乘除
         * 有移位操作就要考虑越界问题。
         * 同样，取绝对值也要考虑越界问题。
         * 
         * 1. dvs可能是0
         * 2. dvd是最小值， dvs是-1，那么要返回最大值。（其实可以合并到第三条）
         * 3. dvd是最小值，dvs不是最小值，那么要把dvd加上一个整数，才能用abs获取其绝对值。
         * 4. dvs是最小值，这时候结果之能是0（dvd不是最小值）或1（dvs也是最小值）
         * 5. 当dvs使用右移操作时，也要格外小心。当dvs大于最大值的一半时，右移将越界。
         */
        if(divisor == 0 ||(dividend == Integer.MIN_VALUE && divisor == -1)){
            return Integer.MAX_VALUE;
        }else if(dividend == Integer.MIN_VALUE && divisor != Integer.MIN_VALUE){
            if(divisor > 0){
                return divide(dividend + divisor, divisor) - 1;
            }else{
                return divide(dividend - divisor, divisor) + 1;
            }
        }else if(divisor == Integer.MIN_VALUE){
            if(dividend == Integer.MIN_VALUE){
                return 1;
            }else{
                return 0;
            }
        }else {
            int ans = 0;
            int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
            int dvd = Math.abs(dividend);
            int dvs = Math.abs(divisor);

            // 这里保证后面temp的初始值小于max_value的一半。
            if(dvs > Integer.MAX_VALUE >> 1){
                if(dvd >= dvs){
                    return sign;
                }else{
                    return 0;
                }
            }
            while(dvs <= dvd){
                int temp = dvs, mul = 1;
                while(dvd >= (temp << 1)){
                    temp <<= 1;
                    mul <<= 1;
                    // 如果temp大于MAX_VALUE一半时，应该提前结束。
                    if(temp > Integer.MAX_VALUE >> 1){
                        break;
                    }
                }
                dvd -= temp;
                ans += mul;

            }
            return sign == 1? ans : -ans;
        }
    }
}
// @lc code=end

