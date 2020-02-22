#
# @lc app=leetcode id=922 lang=python3
#
# [922] Sort Array By Parity II
#

# @lc code=start
class Solution:
    def sortArrayByParityII(self, A: List[int]) -> List[int]:
        
        # Use two pointers to track the odd indices and even indices 
        # respectively.
        
        i = 0
        j = len(A) - 1
        while i < len(A) and j > 0:
            if A[i] % 2 == 0:
                i += 2
            if A[j] % 2 == 1:
                j -= 2
            if i < len(A) and j > 0 and A[i] % 2 != 0 and A[j] % 2 != 1:
                temp = A[j]
                A[j] = A[i]
                A[i] = temp
                i += 2
                j -= 2
        return A
# @lc code=end

