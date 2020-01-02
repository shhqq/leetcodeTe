#
# @lc app=leetcode id=349 lang=python3
#
# [349] Intersection of Two Arrays
#

# @lc code=start
class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
# Use set to storage the single number.
        set1 = set(nums1)
        set2 = set(nums2)
        res = []

        if len(set1) <= len(set2):
            for i in set1:
                if i in set2:
                    res.append(i)
        else:
            for i in set2:
                if i in set1:
                    res.append(i)
        return res
# @lc code=end

