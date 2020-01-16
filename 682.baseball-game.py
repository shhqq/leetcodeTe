#
# @lc app=leetcode id=682 lang=python3
#
# [682] Baseball Game
#

# @lc code=start
class Solution:
    def calPoints(self, ops: List[str]) -> int:
# Use a list to storage the score of every round.
        if len(ops) == 0:
            return 0
        scores  = []
        for i in ops:
            if i == 'D':
                # if len(scores) == 0:
                #     return 0
                scores.append(scores[-1] * 2)
            elif i == 'C':
                # if len(scores) == 0:
                #     return 0
                scores.pop()
            elif i == '+':
                # if len(scores) < 2:
                #     return 0
                scores.append(scores[-1] + scores[-2])
            else:
                scores.append(int(i))
        return sum(scores)

# @lc code=end

