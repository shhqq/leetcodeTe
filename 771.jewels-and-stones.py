#
# @lc app=leetcode id=771 lang=python3
#
# [771] Jewels and Stones
#

# @lc code=start
class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        # ans = 0
        # for s in S:
        #     if s in J:
        #         ans += 1
        # return ans

        return sum([S.count(c) for c in J])
# @lc code=end

