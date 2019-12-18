#
# @lc app=leetcode id=7 lang=python3
#
# [7] Reverse Integer
#

# @lc code=start
class Solution:
    def reverse(self, x: int) -> int:
        # Solution 1: Use string to reverse the integer.
        x_str = str(x)
        length = len(x_str)
        result = ""
        for i in range(length):
            result += x_str[length - 1 - i]
        if x < 0:
            result = "-" + result[0:length-1]
        result = int(result)
        if result < -pow(2, 31) or result > pow(2, 31) - 1:
            return 0
        else:
            return result
        
        # Solution 2: Divide the integer to every single numbers.

        # result = 0
        # temp = abs(x)
        # while True:
        #     result = result * 10 + temp % 10
        #     if temp < 10:
        #         break
        #     else:
        #         temp = temp // 10
        # if x < 0:
        #     result = -result
        # if result < -pow(2, 31) or result > pow(2, 31) - 1:
        #     return 0
        # else:
        #     return result

# @lc code=end

