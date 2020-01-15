#
# @lc app=leetcode id=633 lang=python3
#
# [633] Sum of Square Numbers
#

# @lc code=start
class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        for i in range(int(pow(c/2, 1/2)) + 1):
            if pow(c-pow(i ,2), 1/2).is_integer():
                return True
        return False
# @lc code=end

