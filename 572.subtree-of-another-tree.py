#
# @lc app=leetcode id=572 lang=python3
#
# [572] Subtree of Another Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSubtree(self, s: TreeNode, t: TreeNode) -> bool:
        '''
        Use recursion.
        '''
        if s is None:
            return t is None
        elif t is None:
            return False
        else:
            if s.val == t.val:
                if self.same_tree(s, t):
                    return True
            if self.isSubtree(s.left, t) or self.isSubtree(s.right, t):
                return True
            else:
                return False

    def same_tree(self, s: TreeNode, t: TreeNode) -> bool:
        '''
        Check s and t have the same structure, and all nodes at the same
        position have the same value.
        '''
        if s is None:
            return t is None
        elif t is None:
            return False
        else:
            if s.val == t.val:
                return self.same_tree(s.left, t.left) and self.same_tree(s.right, t.right)
            else:
                return False

# @lc code=end

