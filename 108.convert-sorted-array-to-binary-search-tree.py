#
# @lc app=leetcode id=108 lang=python3
#
# [108] Convert Sorted Array to Binary Search Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
# recursive python solution
        if len(nums) == 0:
            return None
        length = len(nums)
        # print(length)
        head = TreeNode(nums[length // 2])
        head.left = self.sortedArrayToBST(nums[0: length // 2])
        head.right = self.sortedArrayToBST(nums[length // 2 + 1: length])
        return head
# @lc code=end

