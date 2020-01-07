#
# @lc app=leetcode id=447 lang=python3
#
# [447] Number of Boomerangs
#

# @lc code=start
class Solution:
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
# Solution:
# Use two layer circulation. Calculate the distance of each point and 
# the others. So the time complexity is O(n^2).
        count = 0
        for i in range(len(points)):
            distance = {}
            for j in range(len(points)):
                if i != j:
                    dist = pow(points[i][0] - points[j][0], 2) + \
                            pow(points[i][1] - points[j][1], 2)
                    if dist in distance.keys():
                        distance[dist] += 1
                    else:
                        distance[dist] = 1
            for k in distance.keys():
                count += (distance[k] * (distance[k] - 1))
        return count

# @lc code=end

