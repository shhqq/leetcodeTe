#
# @lc app=leetcode id=168 lang=python3
#
# [168] Excel Sheet Column Title
#

# @lc code=start
class Solution:
    def convertToTitle(self, n: int) -> str:
# This is not a difficult problem, but it is easy to make a mistake.
        columnTitle = ''
        while n > 26:
            temp = n % 26
            if temp == 0:
                columnTitle = 'Z' + columnTitle
                n -= 26
            else:
                columnTitle = chr(temp + 64) + columnTitle
            n = n // 26
        columnTitle = chr(n + 64) + columnTitle
        return columnTitle
# @lc code=end

