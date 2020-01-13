#
# @lc app=leetcode id=598 lang=python3
#
# [598] Range Addition II
#

# @lc code=start
class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:
        # min_a = m
        # min_b = n
        # for operater in ops:
        #     min_a = min(min_a, operater[0])
        #     min_b = min(min_b, operater[1])
        # return min_a*min_b
        if len(ops) == 0:
            return m*n
        min_a = min([i[0] for i in ops])
        min_b = min([i[1] for i in ops])
        return min_a*min_b
# @lc code=end

