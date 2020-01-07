#
# @lc app=leetcode id=448 lang=python3
#
# [448] Find All Numbers Disappeared in an Array
#

# @lc code=start
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
# Solution 1: 
# Use hash table to shorten searching time. But this still cost too
# much time and too much extra space.
        '''
        res = {i:1 for i in range(1, 1+len(nums))}
        for i in nums:
            if i in res.keys():
                res.pop(i)
        return res.keys()
        '''
        '''
        # Using list will cause time exceeding while searching item.
        res = []
        for i in range(1, len(nums) + 1):
            if i not in nums:
                res.append(i)
        return res
        '''
# Solution 2:
# Mark the elements as negative whose indices appeared in the 
# list(notice to minus 1). Then the indices of elements which are
# still positive formed the result.
        for i in nums:
            val = abs(i)
            if nums[val - 1] > 0:
                nums[val - 1] *= -1
        res = []
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i + 1)
        return res
# @lc code=end

