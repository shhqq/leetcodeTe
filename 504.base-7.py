#
# @lc app=leetcode id=504 lang=python3
#
# [504] Base 7
#

# @lc code=start
class Solution:
    def convertToBase7(self, num: int) -> str:
        res = ''
        m = abs(num)
        while m > 0:
            remain = m % 7
            res = str(remain) + res
            m = m // 7
        if num < 0:
            res = '-' + res
        if num == 0:
            return '0'
        return res
# @lc code=end

