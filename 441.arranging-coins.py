#
# @lc app=leetcode id=441 lang=python3
#
# [441] Arranging Coins
#

# @lc code=start
class Solution:
    def arrangeCoins(self, n: int) -> int:
# The sum of first n terms of an arithmetic sequence.
        t = (pow(1+8*n, 1/2) - 1) // 2
        return int(t)
# @lc code=end

