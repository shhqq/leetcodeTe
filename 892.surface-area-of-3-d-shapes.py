#
# @lc app=leetcode id=892 lang=python3
#
# [892] Surface Area of 3D Shapes
#

# @lc code=start
class Solution:
    def surfaceArea(self, grid: List[List[int]]) -> int:
        if len(grid) == 0:
            return 0
        
        # count of cubes
        count_cube = sum([sum(row) for row in grid])
        # count of areas from the top.
        top = len(grid) * len(grid[0]) - sum([row.count(0) for row in grid])

        # maximum layer of the 3-dimension shape.
        max_layer = max([max(row) for row in grid])

        # count of side that is not in surface.
        common_side = 0

        for layer in range(1, max_layer + 1):
            for i in range(len(grid)):
                for j in range(len(grid[i])):
                    if grid[i][j] >= layer:
                        if i > 0 and grid[i-1][j] >= layer:
                            common_side += 1
                        if i < len(grid)-1 and grid[i+1][j] >= layer:
                            common_side += 1
                        if j > 0 and grid[i][j-1] >= layer:
                            common_side += 1
                        if j < len(grid[0]) - 1 and grid[i][j+1] >= layer:
                            common_side += 1
        
        # All the hidden cubes from top will cause double of hidden sides.
        return count_cube * 6 - (count_cube - top)*2 - common_side
# @lc code=end

