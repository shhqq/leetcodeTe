/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        /**
         * 使用两个指针，一个指向开头，一个指向结尾。
         * 向中间靠拢，每次移动值较小的指针，因为距离缩短了，较大的值不动才可能更大。
         * Use two pointers which point the start and end respectively.
         * Every step, move the pointer pointing the minimum value.
         * Because the distance is getting shorter, the bigger value should be 
         * retained.
         */
        int maxAr = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            maxAr = Math.max(maxAr, (right-left) * Math.min(height[left], height[right]));
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxAr;
        /*
        int ans = 0;
        int distance = 0;
        int minNum = 0;
        for(int i = 0; i < height.length; i++){
            if(height[i] == 0){
                continue;
            }
            int j = i;
            if(height[i] <= minNum){    //如果下一个比前面的小，那必然在距离至少要增加minNum/height[i]倍。
                j += distance * minNum / height[i];
            }
            for(; j< height.length; j++){
                if((j-i) * Math.min(height[i], height[j]) > ans){
                    distance = j-i;
                    minNum = Math.min(height[i], height[j]);
                    ans = (j-i) * Math.min(height[i], height[j]);
                }
            }
        }
        return ans;
        // */
    }
}
// @lc code=end

