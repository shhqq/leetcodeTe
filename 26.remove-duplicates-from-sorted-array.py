#
# @lc app=leetcode id=26 lang=python3
#
# [26] Remove Duplicates from Sorted Array
#

# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        else:
            count = 1
            temp = nums[0]
            for i in range(1, len(nums)):
                if nums[i] != temp:
                    count += 1
                    temp = nums[i]
                    nums[count - 1] = nums[i]
            return count

# @lc code=end

