#
# @lc app=leetcode id=733 lang=python3
#
# [733] Flood Fill
#

# @lc code=start
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
# Use a hash map to storage coordinates that has been checked.
        if len(image) == 0:
            return image
        len_r = len(image)
        len_c = len(image[0])

        grids = [[sr, sc]]
        old_color = image[sr][sc]
        image[sr][sc] = newColor
        checked_coordinates = {}

        while grids:
            next_grids = []
            for g in grids:
                if 0<=g[0]-1<= len_r-1 and image[g[0]-1][g[1]] == old_color and [g[0]-1, g[1]] not in checked_coordinates.keys():
                    image[g[0]-1][g[1]] = newColor
                    checked_coordinates[[g[0]-1, g[1]]] = 1
                if 0<=g[0]+1<= len_r-1 and image[g[0]+1][g[1]] == old_color and [g[0]+1, g[1]] not in checked_coordinates.keys():
                    image[g[0]+1][g[1]] = newColor
                    checked_coordinates[[g[0]+1, g[1]]] = 1
                if 0<=g[1]-1<= len_c-1 and image[g[0]][g[1]-1] == old_color and [g[0], g[1]-1] not in checked_coordinates.keys():
                    image[g[0]][g[1]-1] = newColor
                    checked_coordinates[[g[0], g[1]-1]] = 1
                if 0<=g[1]+1<= len_c-1 and image[g[0]][g[1]+1] == old_color and [g[0], g[1]+1] not in checked_coordinates.keys():
                    image[g[0]][g[1]+1] = newColor
                    checked_coordinates[[g[0], g[1]+1]] = 1
            grids = next_grids
        return image


# @lc code=end

