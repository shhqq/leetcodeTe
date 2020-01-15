#
# @lc app=leetcode id=643 lang=python3
#
# [643] Maximum Average Subarray I
#

# @lc code=start
class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
# Use a slide window to calculate the sum of the subarray.
# Because the k is constant, so the maximum average value means 
# the maximum sum of the k-length subarray.
        sum_sub = sum(nums[0:k])
        sum_temp = sum_sub
        for i in range(k, len(nums)):
            sum_temp = sum_temp + nums[i] - nums[i - k]
            sum_sub = max(sum_sub, sum_temp)
        return sum_sub / k
# @lc code=end

