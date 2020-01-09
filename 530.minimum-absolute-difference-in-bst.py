#
# @lc app=leetcode id=530 lang=python3
#
# [530] Minimum Absolute Difference in BST
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def getMinimumDifference(self, root: TreeNode) -> int:
# Use in-order traversal to traverse the binary search tree.
        values = self.in_order_traversal(root)
        min_absolute_difference = max(values) - min(values)
        for i in range(len(values) - 1):
            min_absolute_difference = min(min_absolute_difference, abs(values[i] - values[i + 1]))
        return min_absolute_difference

    def in_order_traversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        res = self.in_order_traversal(root.left)
        res = res + [root.val] + self.in_order_traversal(root.right)
        return res
# @lc code=end

