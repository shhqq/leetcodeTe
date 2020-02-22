#
# @lc app=leetcode id=905 lang=python3
#
# [905] Sort Array By Parity
#

# @lc code=start
class Solution:
    def sortArrayByParity(self, A: List[int]) -> List[int]:
# Use two pointers to find the first odd element from the left 
# and the first even element from the right. Then swap them.
        i = 0
        j = len(A) - 1
        while i < j:
            if A[i] % 2 == 0:
                i += 1
            if A[j] % 2 == 1:
                j -= 1
            if A[i] % 2 == 1 and A[j] % 2 == 0 and i < j:
                temp = A[j]
                A[j] = A[i]
                A[i] = temp
                i += 1
                j -= 1
        return A

# @lc code=end

