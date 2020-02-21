#
# @lc app=leetcode id=883 lang=python3
#
# [883] Projection Area of 3D Shapes
#

# @lc code=start
class Solution:
    def projectionArea(self, grid: List[List[int]]) -> int:
        top = 0
        front = [0] * len(grid[0])
        side = [max(row) for row in grid]
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] > 0:
                    top += 1
                front[j] = max(front[j], grid[i][j])
        return top + sum(front + side)
# @lc code=end

