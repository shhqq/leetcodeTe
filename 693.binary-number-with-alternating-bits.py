#
# @lc app=leetcode id=693 lang=python3
#
# [693] Binary Number with Alternating Bits
#

# @lc code=start
class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
# Solution 1:
# Use bit manipulation.
# It's fast but n * 2 may exceed the limit of int.
        '''
        if n <= 0:
            return False
        if n % 2 == 1:
            return bin(n ^ (n*2)).count('0') == 1
        else:
            return bin(n ^ (n*2+1)).count('0') == 1
        '''

# Solution 2:
# Get binary representation of n.
# This may be a little slower.
        if n <= 0:
            return False
        a = 0 if n % 2 == 1 else 1
        while n > 0:
            if a == n % 2:
                return False
            a = n % 2
            n = n // 2
        return True
# @lc code=end

