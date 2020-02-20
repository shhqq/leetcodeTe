#
# @lc app=leetcode id=867 lang=python3
#
# [867] Transpose Matrix
#

# @lc code=start
class Solution:
    def transpose(self, A: List[List[int]]) -> List[List[int]]:
        ans = []
        for i in range(len(A[0])):
            temp = [0] * len(A)
            for j in range(len(temp)):
                temp[j] = A[j][i]
            ans.append(temp)
        return ans
# @lc code=end

