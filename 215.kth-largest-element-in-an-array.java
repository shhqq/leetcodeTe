/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return solution2(nums, k);
    }

    /**
     * solution1：
     * 其实是排序的一种变体，虽然快排比较快，但需要全部排好序。这里只需要找到排序后的
     * 第k个，使用选择排序需要k次，那么就需要比较k和log2N谁大。
     * @param nums
     * @param k
     * @return
     */
    private int solution1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums[k-1];
    }

    /**
     * 第二种答案：
     * 推荐的答案是使用快速排序(Quick Select)的一个变形。
     * 随机选择一个元素e，将数组分为小于e和大于e的两部分，如此递归。
     * @param nums
     * @param k
     * @return
     */
    private int solution2(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        // 第k个最大值，相当于升序的第n-k个值。
        int index = nums.length - k;
        while (start < end) {
            int pivot = partition(nums, start, end);

            // 如果排序使用的元素在排序后的序号恰好是k，则直接返回；
            // 否则，递归排序。
            if (pivot < index) {
                start = pivot + 1;
            } else if (pivot > index) {
                end = pivot - 1;
            } else {
                return nums[pivot];
            }
        }
        return nums[start];
    }
    /**
     * 将数组按照某个元素，分为大于和小于两部分，并返回该元素在排序后的序号。
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] nums, int start, int end) {
        // 关键在于基准元素的选择，是随机？还是选固定序号的，比如第一个元素？
        // 这里选择第start个数作为基准
        int pivot = start;
        int temp;
        
        while (start <= end) {
            // 从左侧找，找到第一个大于e的数
            while (start <= end && nums[start] <= nums[pivot]) {
                start++;
            }
            // 从右侧找，找到第一个小于e的数
            while (start <= end && nums[end] > nums[pivot]) {
                end--;
            }
            if (start > end) {
                break;
            }

            // 交换这两个数
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        // 这里注意要交换end和pivot的元素，因为这时nums[end] < nums[pivot] 且
        // nums[end+1] > nums[pivot]的，所以交换这两个，就将数组按照nums[pivot]
        // 分为了两部分。
        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;

        return end;
    }
}
// @lc code=end

