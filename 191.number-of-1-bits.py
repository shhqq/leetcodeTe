#
# @lc app=leetcode id=191 lang=python3
#
# [191] Number of 1 Bits
#

# @lc code=start
class Solution:
    def hammingWeight(self, n: int) -> int:
# Solution 1: Use the format function.
        # binary_str = '{0: 032b}'.format(n)
        # return binary_str.count('1')
# Solution 2: Use the bit manipulation.
        count = 0
        for _ in range(32):
            if (n & 1) == 1:
                count += 1
            # the if clause can be replaced by the sequence as follow:
            # count += (n & 1)
            n >>= 1
        return count
# @lc code=end

