#
# @lc app=leetcode id=507 lang=python3
#
# [507] Perfect Number
#

# @lc code=start
class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        if num <= 1:
            return False
        sum_divisor = 0
        for i in range(2, int(pow(num, 1/2)) + 1):
            if num % i == 0:
                sum_divisor = sum_divisor + i + num // i
        if pow(num, 1/2) % 1 == 0:
            sum_divisor -= pow(num, 1/2)
        sum_divisor += 1
        
        return True if num == sum_divisor else False

# @lc code=end

