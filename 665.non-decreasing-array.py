#
# @lc app=leetcode id=665 lang=python3
#
# [665] Non-decreasing Array
#

# @lc code=start
class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
# There are two method to handle the situation:
# array[i] > array[i+1]
# decrease the array[i] or increase the array[i+1].
# There are two situations that can not be modified:
# example1: (nums[i] <= nums[i-1] and nums[i+1] >= nums[i+2]) like [4, 4, 3, 3]
# example2: (nums[i] > nums[i+2] and nums[i-1] > nums[i+1]) like [3, 4, 2, 3]. 

# Or there are two situations that can be modified: this is easier,
# nums[i-1] <= nums[i+1] or nums[i] <= nums[i+2].
# both the examples above don't meet the condition, so both are false.

        # modified = False
        # for i in range(len(nums) - 1):
        #     if nums[i] > nums[i + 1]:
        #         if not modified:
        #             if 0 < i < len(nums) - 2:
        #                 if (nums[i] <= nums[i-1] and nums[i+1] >= nums[i+2]) or (nums[i]>nums[i+2] and nums[i-1]>nums[i+1]):
        #                     return False
        #                 else:
        #                     modified = True
        #             else: # i == 0 or i = len(nums) - 2:
        #                 modified = True
        #         else:
        #             return False
        # return True

        modified = False
        for i in range(len(nums) - 1):
            if nums[i] > nums[i + 1]:
                if not modified:
                    if 0 < i < len(nums) - 2:
                        if nums[i-1] <= nums[i+1] or nums[i] <= nums[i+2]:
                            modified = True
                        else:
                            return False
                    else: # i == 0 or i = len(nums) - 2:
                        modified = True
                else:
                    return False
        return True
# @lc code=end

