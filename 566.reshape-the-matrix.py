#
# @lc app=leetcode id=566 lang=python3
#
# [566] Reshape the Matrix
#

# @lc code=start
class Solution:
    def matrixReshape(self, nums: List[List[int]], r: int, c: int) -> List[List[int]]:
        if len(nums) == 0 or r *c  != len(nums) * len(nums[0]):
            return nums
        else:
            res = [[]]
            for i in range(len(nums)):
                for j in range(len(nums[i])):
                    res[-1].append(nums[i][j])
                    if len(res[-1]) == c:
                        res.append([])
            # Remove the redundant empty list in the end.
            res.pop()
            return res
# @lc code=end

