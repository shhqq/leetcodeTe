#
# @lc app=leetcode id=852 lang=python3
#
# [852] Peak Index in a Mountain Array
#

# @lc code=start
class Solution:
    def peakIndexInMountainArray(self, A: List[int]) -> int:
# binary search.
        left = 0
        right = len(A)
        middle = (left + right) // 2
        while left < middle:
            if A[middle - 1] < A[middle] and A[middle] > A[middle + 1]:
                return middle
            elif A[middle - 1] < A[middle]:
                left = middle
                
            else:
                right = middle
                
            middle = (left + right) // 2
        return middle
# @lc code=end

