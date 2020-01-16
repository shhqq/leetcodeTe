#
# @lc app=leetcode id=704 lang=python3
#
# [704] Binary Search
#

# @lc code=start
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1
        left = 0
        right = len(nums)
        middle = (left + right) // 2 
        while left < middle:
            if nums[middle] == target:
                return middle
            elif nums[middle] < target:
                left = middle
            else:
                right = middle
            middle = (left + right) // 2
        return middle if nums[middle] == target else -1

# @lc code=end

