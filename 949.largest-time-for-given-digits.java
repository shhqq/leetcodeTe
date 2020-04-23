/*
 * @lc app=leetcode id=949 lang=java
 *
 * [949] Largest Time for Given Digits
 */

// @lc code=start
class Solution {
    public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        if(A[0] > 2){
            return "";
        }else if(A[1] > 5){
            return "";
        }
        Integer hour = -1; 
        Integer minute = -1;
        for(int i = 0; i< A.length; i++){
            for(int j = 0; j < A.length; j++){
                if(j == i){continue;}
                for(int k = 0; k < A.length; k++){
                    if(k == j || k == i){continue;}
                    
                    // since i,j,k,m are different from each other, and they are in [1,2,3,4]
                    // so i+j+k+m = 6. Use m = 6-i-j-k directly rather than the for-loop sentence 
                    // to reduce time. 
                    //for(int m = 0; m < A.length; m++){
                        int m = 6-i-j-k;
                        if(m == i|| m == j || m == k){continue;}
                        int hour_temp = A[i] * 10 + A[j];
                        int minute_temp = A[k] * 10 + A[m];
                        if(hour_temp > 23 || minute_temp > 59){
                            continue;
                        }else{
                            if(hour < hour_temp){
                                hour = hour_temp;
                                minute = minute_temp;
                            }else if(hour == hour_temp && minute< minute_temp){
                                minute = minute_temp;
                            }
                        }
                    //}
                }
            }
        }
        if(hour<0 || minute < 0){
            return "";
        }else{
            // String h = hour < 10 ? '0' + hour.toString() : hour.toString();
            // String m = minute < 10 ? '0' + minute.toString() : minute.toString();
            // return h + ":" + m;
            return String.format("%02d:%02d", hour, minute);
        }
    }
}
// @lc code=end

