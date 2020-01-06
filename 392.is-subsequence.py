#
# @lc app=leetcode id=392 lang=python3
#
# [392] Is Subsequence
#

# @lc code=start
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
# Use str.find(sub: text, start: optional[int], end: optional[int])
        p = -1
        for c in s:
            p = t.find(c, p + 1)
            if p == -1:
                return False
        return True
# @lc code=end

