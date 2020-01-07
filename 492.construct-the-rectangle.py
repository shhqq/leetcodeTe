#
# @lc app=leetcode id=492 lang=python3
#
# [492] Construct the Rectangle
#

# @lc code=start
class Solution:
    def constructRectangle(self, area: int) -> List[int]:
        sqrt = pow(area, 1/2)
        for i in range(int(sqrt)+1, 0,  -1):
            if area % i == 0:
                res = [area // i, i]
                res.sort(reverse=True)
                return res
        
# @lc code=end

