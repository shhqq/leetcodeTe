#
# @lc app=leetcode id=69 lang=python3
#
# [69] Sqrt(x)
#

# @lc code=start
class Solution:
    def mySqrt(self, x: int) -> int:
        # if x == 0:
        #     return 0
        # i = 1
        left = 0
        right = (x + 3) // 2
        mid = (left + right) // 2
        while left != mid:
            if pow(mid, 2) > x:
                right = mid
                mid = (left + right) // 2
            elif pow(mid, 2) < x:
                left = mid
                mid = (left + right) // 2
            else:
                return mid
        return mid


# @lc code=end

