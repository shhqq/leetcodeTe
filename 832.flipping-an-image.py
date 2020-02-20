#
# @lc app=leetcode id=832 lang=python3
#
# [832] Flipping an Image
#

# @lc code=start
class Solution:
    def flipAndInvertImage(self, A: List[List[int]]) -> List[List[int]]:
        ans = []
        for i in A:
            i.reverse()
            for j in range(len(i)):
                i[j] = i[j] ^ 1
            ans.append(i)
        return ans

# @lc code=end

