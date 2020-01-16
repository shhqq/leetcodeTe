#
# @lc app=leetcode id=661 lang=python3
#
# [661] Image Smoother
#

# @lc code=start
class Solution:
    def imageSmoother(self, M: List[List[int]]) -> List[List[int]]:
# Add a judgment to check if M[i][j] is out of the M.
        if len(M) == 0:
            return []
        res = [[0] * len(M[0]) for _ in range(len(M))]
        for i in range(len(M)):
            for j in range(len(M[0])):
                count = 0
                temp = 0
                for r in range(i-1, i+2, 1):
                    for c in range(j-1, j+2, 1):
                        if r >= 0 and r < len(M) and c >= 0 and c < len(M[0]):
                            count += 1
                            temp += M[r][c]  
                res[i][j] = temp // count
        return res
# @lc code=end

