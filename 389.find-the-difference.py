#
# @lc app=leetcode id=389 lang=python3
#
# [389] Find the Difference
#

# @lc code=start
class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        set_s = set(s)
        set_t = set(t)
        for c in set_t:
            if c not in set_s:
                return c
            elif t.count(c) > s.count(c):
                return c
# @lc code=end

