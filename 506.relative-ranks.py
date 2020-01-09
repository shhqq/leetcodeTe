#
# @lc app=leetcode id=506 lang=python3
#
# [506] Relative Ranks
#

# @lc code=start
class Solution:
    def findRelativeRanks(self, nums: List[int]) -> List[str]:
# Sorted the nums and get index of ranking.
        res = []
        sorted_nums = sorted(nums,reverse = True)
        for i in range(len(nums)):
            rank = sorted_nums.index(nums[i])
            if rank == 0:
                res.append('Gold Medal')
            elif rank == 1:
                res.append('Silver Medal')
            elif rank == 2:
                res.append('Bronze Medal')
            else:
                res.append(str(rank + 1))
        return res

# @lc code=end

