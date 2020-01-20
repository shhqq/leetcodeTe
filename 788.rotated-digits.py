#
# @lc app=leetcode id=788 lang=python3
#
# [788] Rotated Digits
#

# @lc code=start
class Solution:
    def rotatedDigits(self, N: int) -> int:
# The number should only contain [0, 1, 2, 5, 6, 8, 9] and contain 
# at least one element in [2, 5, 6, 9].
        ans = 0
        status1 = [0, 1, 8]
        status2 = [2, 5, 6, 9]

        for i in range(1, N+1):
            temp = i
            changed = False
            while temp > 0:
                rem = temp % 10
                if rem in status2:
                    changed = True
                elif rem not in status1 and rem not in status2:
                    break
                temp = temp // 10
            if temp == 0 and changed:
                ans += 1
        return ans
# @lc code=end

