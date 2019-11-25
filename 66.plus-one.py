#
# @lc app=leetcode id=66 lang=python3
#
# [66] Plus One
#

# @lc code=start
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
# solution1
        # flag = True
        # for i in range(1, len(digits) + 1):
        #     digits[-i] += 1
        #     if digits[-i] == 10:
        #         digits[-i] = 0
        #     else:
        #         flag = False
        #         break
        # if flag:
        #     return [1] + digits
        # else:
        #     return digits

# solution2
        num = 0
        for i in range(len(digits)):
            num += digits[i] * pow(10, len(digits) - 1 - i)
        return [int(i) for i in str(num + 1)]
# @lc code=end

