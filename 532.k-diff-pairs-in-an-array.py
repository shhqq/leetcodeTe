#
# @lc app=leetcode id=532 lang=python3
#
# [532] K-diff Pairs in an Array
#

# @lc code=start
class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
# solution 1:
# use set 
        '''
        if k < 0:
            return 0
        count = 0
        if k == 0:
            for i in set(nums):
                if nums.count(i) > 1:
                    count += 1
            return count
        else:
            for i in set(nums):
                if (i + k) in nums:
                    count += 1
            return count
        '''

# solution 2:
# use collections.Counter to generate a hashmap.
        c = collections.Counter(nums)
        count = 0
        for i in c:
            if k > 0 and (i+k) in c:
                count += 1
            elif k == 0 and c[i] > 1:
                count += 1
        return count
# @lc code=end

