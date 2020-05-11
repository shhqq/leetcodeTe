/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // 其实就是将0放前面，2放后面。
        // 用两个指针，记录连续0的位置和从后往前连续2的位置，
        // 
        if(nums.length == 0){
            return;
        }
        int low = 0;
        int high = nums.length - 1;
        for(int i = 0; i <= high; i++){ // 处理完的2不需要管，因此i<=high;
            if (nums[i] == 0){
                nums[i] = nums[low];
                nums[low] = 0;
                low++;
            } else if (nums[i] == 2){
                nums[i] = nums[high];
                nums[high] = 2;
                high--;
                i--;
            }
        }
        /**
         * 用三个指针，前两个在前向后，第三个在后向前。
         * 当p1指向0时，如果p2 == p1，那么都加1，如果p2 > p1， p1加1
         * 当p1指向1时，让p2去找后面的第一个0，然后交换两者的值，然后p1加1。
         * 当p1指向2时，让p3往前找第一个不是2的值，然后交换，此时p1不动，因为有可能是1。
         * 这种实际上是2次遍历，因为p2往前找0的过程中会重复遍历。
         */
        /*
        if (nums.length == 0){
            return;
        } else {
            int p1 = 0;
            int p2 = 0;
            int p3 = nums.length - 1;
            while(p1 < p3){
                if (nums[p1] == 0){
                    if(p1 == p2){
                        p2++;
                    }
                    p1++;
                } else if (nums[p1] == 1){
                    while (p2 <= p3){
                        if (nums[p2] == 0){
                            nums[p1] = 0;
                            nums[p2] = 1;
                            break;
                        }else{
                            p2++;
                        }
                    }
                    p1++;
                } else if (nums[p1] == 2){
                    while (p1 < p3){
                        if (nums[p3] != 2){
                            nums[p1] = nums[p3];
                            nums[p3] = 2;
                            break;
                        }
                        p3--;
                    }
                }
            }
        }
        */
    }
}
// @lc code=end

