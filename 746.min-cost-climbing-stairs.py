#
# @lc app=leetcode id=746 lang=python3
#
# [746] Min Cost Climbing Stairs
#

# @lc code=start
class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
# Approach 1: dynamic programming
# Use a stack to storage the minimum cost of n-step stair.
# Do not use recursion, because recursion will calculate 
# the intermediate variable repeatly.

        # The c[n] means the minimum cost that must contain
        # the n-th step. So the finally result is min(c[-1], c[-2]).
        c = [cost[0], cost[1]]
        for i in range(2, len(cost)):
            c.append(min(c[i-2], c[i-1]) + cost[i])
        return min(c[-1], c[-2])

# @lc code=end

