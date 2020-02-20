#
# @lc app=leetcode id=830 lang=python3
#
# [830] Positions of Large Groups
#

# @lc code=start
class Solution:
    def largeGroupPositions(self, S: str) -> List[List[int]]:
        if len(S) == 0:
            return []
        ans = []
        left = 0
        right = -1
        c = S[0]
        for i in S:
            if i == c:
                right += 1
            else:
                if right - left > 1:
                    ans.append([left, right])
                right += 1
                left = right
                c = i
        if right - left > 1:
            ans.append([left, right])
        return ans
# @lc code=end

