#
# @lc app=leetcode id=257 lang=python3
#
# [257] Binary Tree Paths
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
# Use recursion.
        if root is None:
            return []
        path = []
        # Handle the left and right child.
        child_path = []
        if root.left is not None:
            child_path += self.binaryTreePaths(root.left)
        if root.right is not None:
            child_path += self.binaryTreePaths(root.right)
        # If root is a leaf node, return a list consist of value of root like ["23"].
        if len(child_path) == 0:
            return [str(root.val)]
        for s in child_path:
            path.append(str(root.val) + "->" + s)
        return path
# @lc code=end

