#
# @lc app=leetcode id=733 lang=python3
#
# [733] Flood Fill
#

# @lc code=start
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
# Use a hash map to storage coordinates that has been checked.
        '''
        if len(image) == 0:
            return image
        len_r = len(image)
        len_c = len(image[0])

        grids = [[sr, sc]]
        old_color = image[sr][sc]
        image[sr][sc] = newColor
        coordinate = str.format('%d, %d' %(sr, sc))
        checked_coordinates = {coordinate: 1}

        while grids:
            next_grids = []
            for g in grids:
                if 0<=g[0]-1<= len_r-1 and image[g[0]-1][g[1]] == old_color:
                    coordinate = str.format('%d, %d'%(g[0]-1, g[1]))
                    if coordinate not in checked_coordinates.keys():
                        image[g[0]-1][g[1]] = newColor
                        checked_coordinates[coordinate] = 1
                        next_grids.append([g[0]-1, g[1]])
                if 0<=g[0]+1<= len_r-1 and image[g[0]+1][g[1]] == old_color:
                    coordinate = str.format('%d, %d'%(g[0]+1, g[1]))
                    if coordinate not in checked_coordinates.keys():
                        image[g[0]+1][g[1]] = newColor
                        checked_coordinates[coordinate] = 1
                        next_grids.append([g[0]+1, g[1]])
                if 0<=g[1]-1<= len_c-1 and image[g[0]][g[1]-1] == old_color:
                    coordinate = str.format('%d, %d'%(g[0], g[1]-1))
                    if coordinate not in checked_coordinates.keys():
                        image[g[0]][g[1]-1] = newColor
                        checked_coordinates[coordinate] = 1
                        next_grids.append([g[0], g[1]-1])
                if 0<=g[1]+1<= len_c-1 and image[g[0]][g[1]+1] == old_color:
                    coordinate = str.format('%d, %d'%(g[0], g[1]+1))
                    if coordinate not in checked_coordinates.keys():
                        image[g[0]][g[1]+1] = newColor
                        checked_coordinates[coordinate] = 1
                        next_grids.append([g[0], g[1]+1])
            grids = next_grids
        return image
        '''

# you don't need a hash map to record grids which are checked.
# If the newColor is equal to the pixel of image[sr][sc], the image will not
# change at all!!!.
        if len(image) == 0 or image[sr][sc] == newColor:
            return image
        len_r = len(image)
        len_c = len(image[0])

        grids = [[sr, sc]]
        old_color = image[sr][sc]
        image[sr][sc] = newColor

        while grids:
            next_grids = []
            for g in grids:
                if 0<=g[0]-1<= len_r-1 and image[g[0]-1][g[1]] == old_color:
                    image[g[0]-1][g[1]] = newColor
                    next_grids.append([g[0]-1, g[1]])
                if 0<=g[0]+1<= len_r-1 and image[g[0]+1][g[1]] == old_color:
                    image[g[0]+1][g[1]] = newColor
                    next_grids.append([g[0]+1, g[1]])
                if 0<=g[1]-1<= len_c-1 and image[g[0]][g[1]-1] == old_color:
                    image[g[0]][g[1]-1] = newColor
                    next_grids.append([g[0], g[1]-1])
                if 0<=g[1]+1<= len_c-1 and image[g[0]][g[1]+1] == old_color:
                    image[g[0]][g[1]+1] = newColor
                    next_grids.append([g[0], g[1]+1])
            grids = next_grids
        return image
# @lc code=end

