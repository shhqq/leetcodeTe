#
# @lc app=leetcode id=414 lang=python3
#
# [414] Third Maximum Number
#

# @lc code=start
class Solution:
    def thirdMax(self, nums: List[int]) -> int:
# solution 1:
# Use built-in method set() and list.sort().
        '''
        sorted_set = list(set(nums))
        sorted_set.sort()
        return sorted_set[-3] if len(sorted_set) > 2 else sorted_set[-1]
        '''
# solution 2:
# Use three variables to restore the first three maximum value.
        max1 = None
        max2 = None
        max3 = None
        for n in nums:
            if max1 == None or n > max1:
                max3 = max2
                max2 = max1
                max1 = n
            elif n < max1 and ( max2 is None or n > max2):
                max3 = max2
                max2 = n
            elif max2 is not None and n < max2 and (max3 is None or n > max3):
                max3 = n
        return max3 if max3 is not None else max1
# @lc code=end

