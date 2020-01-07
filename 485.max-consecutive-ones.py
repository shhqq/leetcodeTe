#
# @lc app=leetcode id=485 lang=python3
#
# [485] Max Consecutive Ones
#

# @lc code=start
class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
# Solution 1:
# Transform nums to a string, then split the string by '0'.
# Return the maximum length of the list of string.
        '''
        s = ''
        for i in nums:
            s += str(i)
        sub = s.split('0')
        max_consecutive_ones = 0
        for i in sub:
            max_consecutive_ones = max(max_consecutive_ones, len(i))
        return max_consecutive_ones
        '''

# solution 2:
# count 1 directly.
        max_consecutive_ones = 0
        count = 0
        for i in nums:
            if i == 0:
                max_consecutive_ones = max(max_consecutive_ones, count)
                count = 0
            else:
                count += 1
        
        return max(max_consecutive_ones, count)

# @lc code=end

