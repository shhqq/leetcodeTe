#
# @lc app=leetcode id=171 lang=python3
#
# [171] Excel Sheet Column Number
#

# @lc code=start
class Solution:
    def titleToNumber(self, s: str) -> int:
        l = len(s)
        resu = 0
        for i in range(l):
            resu += (ord(s[i]) - 64) * pow(26, l-i-1)
        return resu
# @lc code=end

