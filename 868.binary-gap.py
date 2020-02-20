#
# @lc app=leetcode id=868 lang=python3
#
# [868] Binary Gap
#

# @lc code=start
class Solution:
    def binaryGap(self, N: int) -> int:
        s = bin(N)
        if s.count('1') < 2:
            return 0
        
        i = s.index('1')
        ans = 0
        while i < len(s):
            try:
                next_1 = s.index('1', i + 1, len(s))
                ans = max(ans, next_1 - i)
                i = next_1
            except ValueError:
                return ans


# @lc code=end

