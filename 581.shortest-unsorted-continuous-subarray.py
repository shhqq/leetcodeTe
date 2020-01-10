#
# @lc app=leetcode id=581 lang=python3
#
# [581] Shortest Unsorted Continuous Subarray
#

# @lc code=start
class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
# solution 1:
# Count the sorted left and sorted right.
        '''
        length = len(nums)
        left_sorted = right_sorted = 0
        flag = True
        for i in range(len(nums)):
            if nums[i] != min(nums[i: length]):     # this will calculate min() redundantly.
                left_sorted = i
                flag = False
                break
        if not flag:
            for j in range(length-1, left_sorted-1, -1):
                if nums[j] != max(nums[left_sorted: j+1]):
                    right_sorted = j
                    break
            return right_sorted - left_sorted + 1
        else:
            return 0
        '''

        a = sorted(nums)
        left = right = -1
        for i in range(len(a)):
            if nums[i] != a[i]:
                left = i
                break
        if left != -1:
            for i in range(len(a)-1, left-1, -1):
                if nums[i] != a[i]:
                    right = i
                    break
            return right - left + 1
        else:
            return 0
# @lc code=end

