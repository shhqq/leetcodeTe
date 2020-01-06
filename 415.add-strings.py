#
# @lc app=leetcode id=415 lang=python3
#
# [415] Add Strings
#

# @lc code=start
class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
# Use built-in method ord(char).
        # switch num1 and num2 to ensure num1 is not shorter than num2.
        if len(num1) < len(num2):
            temp = num1
            num1 = num2
            num2 = temp
        max_length = len(num1)
        res = ['' for _ in range(max_length)]

        carry_over = 0
        for i in range(max_length):
            if i >= len(num2):
                res[i] = str((carry_over + ord(num1[-1-i]) - 48) % 10)
                carry_over = (carry_over + ord(num1[-1-i]) - 48) // 10
            else:
                res[i] = str((carry_over + ord(num1[-1-i]) + ord(num2[-1-i]) - 96) % 10)
                carry_over = (carry_over + ord(num1[-1-i]) + ord(num2[-1-i]) - 96) // 10
        if carry_over > 0:
            res.append('1')
        res.reverse()
        return ''.join(res)
# @lc code=end

