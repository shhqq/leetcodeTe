#
# @lc app=leetcode id=908 lang=python3
#
# [908] Smallest Range I
#

# @lc code=start
class Solution:
    def smallestRangeI(self, A: List[int], K: int) -> int:
        max_A = max(A)
        min_A = min(A)
        return max(0, max_A - min_A - 2 * abs(K))
# @lc code=end

