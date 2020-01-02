#
# @lc app=leetcode id=350 lang=python3
#
# [350] Intersection of Two Arrays II
#

# @lc code=start
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
# solution 1:
# Use set to storage the single numbers
        '''
        set1 = set(nums1)
        set2 = set(nums2)
        res = []

        if len(set1) <= len(set2):
            for i in set1:
                if i in set2:
                    res += [i for _ in range(min(nums1.count(i), nums2.count(i)))]
        else:
            for i in set2:
                if i in set1:
                    res += [i for _ in range(min(nums1.count(i), nums2.count(i)))]
        return res
        '''
# solution 2:
# Sort the two lists and then compare.
# Use two pointer to track the two lists.
        nums1.sort()
        nums2.sort()
        if len(nums1) == 0 or len(nums2) == 0:
            return None
        i = 0
        j = 0
        res = []
        while i < len(nums1) and j < len(nums2):
            if nums1[i] < nums2[j]:
                i += 1
            elif nums1[i] == nums2[j]:
                res.append(nums1[i])
                i += 1
                j += 1
            else:
                j += 1
        return res
# @lc code=end

