#
# @lc app=leetcode id=849 lang=python3
#
# [849] Maximize Distance to Closest Person
#

# @lc code=start
class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        # index of the first 1
        index_first_one = seats.index(1)
        # count of zeros between two 1s.
        count0 = 0
        ans = index_first_one
        
        for i in range(index_first_one, len(seats)):
            if seats[i] == 1:
                ans = max(ans, (count0+1) // 2)
                count0 = 0
            else:
                count0 += 1
        
        # zeros after the last 1.
        if count0 > 0:
            ans = max(ans, count0)
        return ans
# @lc code=end

