#
# @lc app=leetcode id=476 lang=python3
#
# [476] Number Complement
#

# @lc code=start
class Solution:
    def findComplement(self, num: int) -> int:
        if num < 0: 
            return abs(num) - 1
        else:
            b = bin(num)
            length = len(b)
            res = 0
            for i in range(2, length):
                if b[i] == '0':
                    res += pow(2, length - i - 1)
            return res
# @lc code=end

