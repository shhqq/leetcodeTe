#
# @lc app=leetcode id=747 lang=python3
#
# [747] Largest Number At Least Twice of Others
#

# @lc code=start
class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        max_index = nums.index(max(nums))
        nums.sort()
        return max_index if nums[-1] >= 2*nums[-2] else -1
# @lc code=end

