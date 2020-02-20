#
# @lc app=leetcode id=836 lang=python3
#
# [836] Rectangle Overlap
#

# @lc code=start
class Solution:
    def isRectangleOverlap(self, rec1: List[int], rec2: List[int]) -> bool:
        x11 = rec1[0]
        x12 = rec1[2]
        y11 = rec1[1]
        y12 = rec1[3]

        x21 = rec2[0]
        x22 = rec2[2]
        y21 = rec2[1]
        y22 = rec2[3]

        if x21 >= x12 or x22 <= x11 or y21 >= y12 or y22 <= y11:
            return False
        else:
            return True
# @lc code=end

