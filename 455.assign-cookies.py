#
# @lc app=leetcode id=455 lang=python3
#
# [455] Assign Cookies
#

# @lc code=start
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
# Use two pointers to track g and s respectively.
        g.sort()
        s.sort()
        p = q = 0
        count = 0
        for q in range(len(s)):
            if p == len(g):
                break
            if s[q] >= g[p]:
                count += 1
                p += 1
        return count
# @lc code=end

