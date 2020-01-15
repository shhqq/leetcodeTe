#
# @lc app=leetcode id=617 lang=python3
#
# [617] Merge Two Binary Trees
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def mergeTrees(self, t1: TreeNode, t2: TreeNode) -> TreeNode:
        if t1 is None:
            return t2
        elif t2 is None:
            return t1
        else:
            t2.val = t1.val + t2.val
            t2.left = self.mergeTrees(t1.left, t2.left)
            t2.right = self.mergeTrees(t1.right, t2.right)
            return t2
# @lc code=end

