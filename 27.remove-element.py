#
# @lc app=leetcode id=27 lang=python3
#
# [27] Remove Element
#

# @lc code=start
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        if len(nums) == 0:
            return 0
        count = 0
        left = 0
        right = len(nums) - 1
        while left <= right:
            if nums[left] == val:
                count += 1
                while left < right:
                    if nums[right] == val:
                        count += 1
                        right -= 1
                    else:
                        temp = nums[left]
                        nums[left] = nums[right]
                        nums[right] = temp
                        right -= 1
                        break
            left += 1

        return len(nums) - count


# @lc code=end

