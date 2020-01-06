#
# @lc app=leetcode id=404 lang=python3
#
# [404] Sum of Left Leaves
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
# Use recursion to get the sum of left and right child tree.
# Notice: If root is None or there is only one node, then sum is 0.
        if root is None:
            return 0
        res = 0
        if root.left is not None:
            if root.left.left is None and root.left.right is None:
                res += root.left.val
            else:
                res += self.sumOfLeftLeaves(root.left)
        if root.right is not None:
            if root.right.left is not None or root.right.right is not None:
                res += self.sumOfLeftLeaves(root.right)
        return res
# @lc code=end

