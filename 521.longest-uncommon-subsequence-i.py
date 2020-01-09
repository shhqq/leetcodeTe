#
# @lc app=leetcode id=521 lang=python3
#
# [521] Longest Uncommon Subsequence I 
#

# @lc code=start
class Solution:
    def findLUSlength(self, a: str, b: str) -> int:
# if a is the same as b: return -1.
# if a is different from b, then the longer length is the result.
        if a == b:
            return -1
        else:
            return max(len(a), len(b))
# @lc code=end