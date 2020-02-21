#
# @lc app=leetcode id=888 lang=python3
#
# [888] Fair Candy Swap
#

# @lc code=start
class Solution:
    def fairCandySwap(self, A: List[int], B: List[int]) -> List[int]:
        diff = (sum(A) - sum(B)) // 2
        set_A = set(A)
        set_B = set(B)
        for i in set_A:
            if i-diff in set_B:
                return [i, i-diff]
# @lc code=end

