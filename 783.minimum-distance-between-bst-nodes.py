#
# @lc app=leetcode id=783 lang=python3
#
# [783] Minimum Distance Between BST Nodes
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDiffInBST(self, root: TreeNode) -> int:
        # Use inorder traversal.
        self.values = []

        def inorder_traversal(root: TreeNode) -> int:
            if root is None:
                pass
            else:
                inorder_traversal(root.left)
                self.values.append(root.val)
                inorder_traversal(root.right)

        inorder_traversal(root)
        return min([self.values[i+1]-self.values[i] for i in range(len(self.values)-1)])

# @lc code=end

