#
# @lc app=leetcode id=219 lang=python3
#
# [219] Contains Duplicate II
#

# @lc code=start
class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
# solution 1:
# Use brute force:
# this will cause time limit exceeded.
        """
        if k>= len(nums):
            return self.duplicate(nums)
        for i in range(len(nums) - k):
            if self.duplicate(nums[i: i+k+1]):
                return True
        return False
    def duplicate(self, nums: list) -> bool:
        return len(nums) != len(set(nums))
        """
# solution 2:
# use set
# Use a slide window to avoid to apply for memory.
        if k>= len(nums):
            return len(nums) != len(set(nums))
        distinct = set(nums[0: k + 1])
        if len(distinct) != k+1:
            return True
        for i in range(len(nums) - k - 1):
            distinct.remove(nums[i])
            if nums[i + k + 1] in distinct:
                return True
            else:
                distinct.add(nums[i + k + 1])
        return False
# @lc code=end

