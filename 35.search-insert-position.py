#
# @lc app=leetcode id=35 lang=python3
#
# [35] Search Insert Position
#

# @lc code=start
class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
# solution 1
        #if len(nums) == 0:
         #   return 0
        # left = 0
        # right = len(nums) - 1
        # middle = (left + right) // 2
        # while left < middle:
        #     if nums[middle] < target:
        #         left = middle
        #         middle = (left + right) // 2
        #         continue
        #     elif nums[middle] > target:
        #         right = middle
        #         middle = (left + right) // 2
        #         continue
        #     else:
        #         return middle
        # if nums[left] >= target:
        #     # this situation, left must equals 0;
        #     return 0
        # elif nums[right] < target:
        #     # this situation, right must equals len(nums) -1;
        #     return len(nums)
        # else:
        #     return left + 1

# solution 2
        # if target in nums:
        #     return nums.index(target)
        # i = 0
        # while i < len(nums) and nums[i] < target:
        #     i += 1
        # return i

# solution 3
        if target in nums:
            return nums.index(target)
        for num, i in enumerate(nums):
            if i >target:
                return num
        return len(nums)
        
# @lc code=end

