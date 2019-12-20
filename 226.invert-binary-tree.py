#
# @lc app=leetcode id=226 lang=python3
#
# [226] Invert Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
# Use recursion.
        if root == None:
            return None
        if root.left is not None or root.right is not None:
            # Exchange left and right.
            temp = root.left
            root.left = root.right
            root.right = temp
            # Handle the left and right child node.
            self.invertTree(root.left)
            self.invertTree(root.right)
        return root
# @lc code=end

