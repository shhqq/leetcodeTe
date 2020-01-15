#
# @lc app=leetcode id=606 lang=python3
#
# [606] Construct String from Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def tree2str(self, t: TreeNode) -> str:
# Use recursion to traverse the tree.
        if t is None:
            return ''
        else:
            if t.right is None:
                if t.left is None:
                    return str(t.val)
                else:
                    return str.format('%d(%s)' % (t.val, self.tree2str(t.left)))
            else:
                return str.format('%d(%s)(%s)' %(t.val, self.tree2str(t.left), self.tree2str(t.right)))
# @lc code=end

