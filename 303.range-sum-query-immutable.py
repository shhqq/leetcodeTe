#
# @lc app=leetcode id=303 lang=python3
#
# [303] Range Sum Query - Immutable
#

# @lc code=start
class NumArray:
    def __init__(self, nums: List[int]):
# Use a list to storage the sum of the first i numbers of nums.
        length = len(nums)
        if length > 0:
            self.sum_list = [0 for _ in range(length)]
            self.sum_list[0] = nums[0]
            for i in range(1, length):
                self.sum_list[i] = self.sum_list[i - 1] + nums[i]
    def sumRange(self, i: int, j: int) -> int:
        length = len(self.sum_list)
        if length == 0 or i < 0 or i > j or j >= length:
            return None
        return self.sum_list[j] - self.sum_list[i - 1] if i > 0 else self.sum_list[j]


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(i,j)
# @lc code=end

