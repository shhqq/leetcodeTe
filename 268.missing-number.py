#
# @lc app=leetcode id=268 lang=python3
#
# [268] Missing Number
#

# @lc code=start
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
# solution 1: 
# Add first element and the last element, then compare the 
# sum.
        '''
        nums.sort()
        for i in range(len(nums) // 2 + 1):
            if nums[i] + nums[len(nums) - 1 - i] > len(nums):
                return nums[i] - 1
            elif nums[i] + nums[len(nums)-i-1] < len(nums):
                return nums[len(nums)-i-1] + 1
        if (len(nums) // 2) not in nums:
            return len(nums) // 2
        '''
# solution 2:
# generate a (n+1)-length list of "1", transfer 1 to 0 at
# position of element. Finally return the position of the 
# remain '1'.
# time complexity and space complexity are o(n).
        '''
        s = ['1' for _ in range(len(nums)+1)]
        for i in nums:
            s[i] = '0'
        return s.index('1')
        '''
# solution 3:
# Use the dichotomy.
        nums.sort()
        left = 0
        right = len(nums)
        middle = (left + right) // 2
        while left < middle:
            if nums[middle] > middle:
                right = middle
            else:
                left = middle
            middle = (left + right) // 2
        # There are two results:
        # nums[left] - 1 == target or nums[left] + 1 = target 
        if nums[left] > left:
            return nums[left] - 1
        elif nums[left] == left:
            return nums[left] + 1
            
# @lc code=end

