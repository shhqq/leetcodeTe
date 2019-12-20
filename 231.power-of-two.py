#
# @lc app=leetcode id=231 lang=python3
#
# [231] Power of Two
#

# @lc code=start
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        s = '{0: 032b}'.format(n)
        return s.count('1') == 1 and n > 0
# @lc code=end

