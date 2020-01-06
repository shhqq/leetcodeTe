#
# @lc app=leetcode id=374 lang=python3
#
# [374] Guess Number Higher or Lower
#

# @lc code=start
# The guess API is already defined for you.
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num: int) -> int:

class Solution:
    def guessNumber(self, n: int) -> int:
# Use the dichotomy.
        left = 1
        right = n
        mid = (left + right) // 2
        while left < mid:
            if guess(mid) < 0:
                right = mid
            elif guess(mid) > 0:
                left = mid
            else:
                return mid
            mid = (left + right) // 2
        return mid if guess(mid) == 0 else right
# @lc code=end

