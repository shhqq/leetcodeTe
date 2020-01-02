#
# @lc app=leetcode id=283 lang=python3
#
# [283] Move Zeroes
#

# @lc code=start
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
# solution 1:
# remove all 0s, and then append to the end.
        '''
        length_previous = len(nums)
        while True:
            try:
                nums.remove(0)
            except ValueError:
                break
        length_next = len(nums)
        nums = nums + [0 for _ in range(length_previous - length_next)]
        '''
# solution 2:
# swap the first zero and the first non-zero.
        count_zero = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                count_zero += 1
            else:
                temp = nums[i]
                nums[i] = 0
                nums[i - count_zero] = temp
# @lc code=end

