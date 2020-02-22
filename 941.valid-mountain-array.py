#
# @lc app=leetcode id=941 lang=python3
#
# [941] Valid Mountain Array
#

# @lc code=start
class Solution:
    def validMountainArray(self, A: List[int]) -> bool:
        if len(A) < 3:
            return False
        peak = max(A)
        peak_index = A.index(peak)
        if peak_index == 0 or peak_index == len(A) - 1:
            return False
        for i in range(peak_index):
            if A[i] >= A[i + 1]:
                return False
        for i in range(peak_index, len(A) - 1):
            if A[i] <= A[i + 1]:
                return False
        return True

# @lc code=end

