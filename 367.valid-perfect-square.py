#
# @lc app=leetcode id=367 lang=python3
#
# [367] Valid Perfect Square
#

# @lc code=start
class Solution:
    def isPerfectSquare(self, num: int) -> bool:
# Use dichotomy.
        if num == 0 or num == 1:
            return True
        left = 0
        right = num
        mid = (left + right) // 2
        while left < mid:
            if num < pow(mid, 2):
                right = mid
            elif num > pow(mid, 2):
                left = mid
            else:
                return True
            mid = (left + right) // 2
        return False
        
# @lc code=end

