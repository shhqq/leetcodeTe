#
# @lc app=leetcode id=235 lang=python3
#
# [235] Lowest Common Ancestor of a Binary Search Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # if value of root is equal to p or q, return root
        if root.val == p.val or root.val == q.val:
            return root
        # if p and q are in different side, return root
        elif max(p.val, q.val) > root.val and min(p.val, q.val) < root.val:
            return root
        # if p and q are in the same side, use recursion.
        elif p.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        else:
            return self.lowestCommonAncestor(root.right, p, q)
# @lc code=end

