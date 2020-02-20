#
# @lc app=leetcode id=840 lang=python3
#
# [840] Magic Squares In Grid
#

# @lc code=start
class Solution:
    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:
        if len(grid) < 3:
            return 0
        elif len(grid[0]) < 3:
            return 0
        else:
            count = 0
            for i in range(len(grid) - 2):
                for j in range(len(grid[0]) - 2):
                    nums = set(grid[i][j:j+3]+grid[i+1][j:j+3]+grid[i+2][j:j+3])
                    if len(nums) != 9:
                        continue
                    for n in nums:
                        if n < 1 or n > 9:
                            break
                    else:
                        sumMatrix = sum([sum(grid[k][j:j+3]) for k in range(i, i+3)])
                        if sumMatrix != 45:
                            continue
                        sumRow = sumMatrix / 3
                        if grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2] != sumRow:
                            continue
                        if grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j] != sumRow:
                            continue

                        for k in range(3):
                            if sum(grid[i+k][j:j+3]) != sumRow:
                                break
                            if grid[i][j+k] + grid[i+1][j+k] + grid[i+2][j+k] != sumRow:
                                break
                        else:
                            count += 1
            return count

# @lc code=end

