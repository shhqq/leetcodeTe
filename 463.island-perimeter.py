#
# @lc app=leetcode id=463 lang=python3
#
# [463] Island Perimeter
#

# @lc code=start
class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
# Use neighbor to count the comment border.
# Use island to count the island item.
# The perimeter is island * 4 - neighbor.
        neighbor = 0
        island = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]:
                    island += 1
                    if i > 0 and grid[i-1][j]:
                        neighbor += 1
                    if i < len(grid)-1 and grid[i+1][j]:
                        neighbor += 1
                    if j > 0 and grid[i][j- 1]:
                        neighbor += 1
                    if j < len(grid[0])-1 and grid[i][j+1]:
                        neighbor += 1
        return island*4 - neighbor

# @lc code=end

