#
# @lc app=leetcode id=717 lang=python3
#
# [717] 1-bit and 2-bit Characters
#

# @lc code=start
class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
# Count 1s between the second last 0 and the last 0.
# Maybe there is no second last 0, but it has no effect.
# If count is even, result is true. If count is odd, result is false.
        count = 0
        for i in range(len(bits)-2, -1, -1):
            if bits[i] == 1:
                count += 1
            else:
                break
        return count % 2 == 0
# @lc code=end

