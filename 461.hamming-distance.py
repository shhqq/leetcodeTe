#
# @lc app=leetcode id=461 lang=python3
#
# [461] Hamming Distance
#

# @lc code=start
class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
# Use the bit operation.
# '^' returns '1' if the corresponding bit is different.
# Else, it returns '0'.
        h = x ^ y
        return bin(h).count('1')
# @lc code=end

