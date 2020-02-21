#
# @lc app=leetcode id=874 lang=python3
#
# [874] Walking Robot Simulation
#

# @lc code=start
class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
# 1. Return the maximum distance rather than the final distance.
# 2. Use set to storage the obstacles, because using 'in' with 'list' costs 
# more time. Usage of 'set' will cost extra space. 
        po = [0, 0]
        x = 0
        y = 1
        max_distance = 0

        obstaclesSet = set(map(tuple, obstacles))

        for i in commands:
            if i > 0:
                for j in range(i):
                    if (po[0]+x, po[1]+y) not in obstaclesSet:
                        po[0] += x
                        po[1] += y
                        max_distance = max(max_distance, pow(po[0], 2) + pow(po[1], 2))
                    else:
                        break
            elif x == 0:
                if i == -1:
                    x = y
                    y = 0
                else:
                    x = -y
                    y = 0
            else:
                if i == -1:
                    y = -x
                    x = 0
                else:
                    y = x
                    x = 0
        return max_distance

# @lc code=end

