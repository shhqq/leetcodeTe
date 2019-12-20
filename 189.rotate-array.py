#
# @lc app=leetcode id=189 lang=python3
#
# [189] Rotate Array
#

# @lc code=start
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
# solution 1:
# rotate 3 times
        """
        Do not return anything, modify nums in-place instead.
        """
        # print(nums)
        # print(k)
        l = len(nums)
        k = k % l
        # nums = nums[l - k: l] + nums[0: l - k]
        nums.reverse()
        temp = nums[0: k]
        temp.reverse()
        nums[0: k] = temp 
        temp = nums[k: l]
        temp.reverse()
        nums[k: l] = temp
        # print(nums)

# solution 2:
# use extra list to store the original list.
# then assign to nums.
# @lc code=end

