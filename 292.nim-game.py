#
# @lc app=leetcode id=292 lang=python3
#
# [292] Nim Game
#

# @lc code=start
class Solution:
    def canWinNim(self, n: int) -> bool:
# if n is divisible by 4, then you can't win.
        # if n % 4 == 0:
        #     return False
        # else:
        #     return True
        return False if n % 4 == 0 else True
# @lc code=end

