#
# @lc app=leetcode id=766 lang=python3
#
# [766] Toeplitz Matrix
#

# @lc code=start
class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
# The privious c-1 numbers is equals to the last c-1 numbers of the next row.
        r = len(matrix) # number of rows will be in range [1, 20]
        c = len(matrix[0])
        for i in range(r - 1):
            if matrix[i][0: c-1] != matrix[i+1][1: c]:
                return False
        return True
# @lc code=end

