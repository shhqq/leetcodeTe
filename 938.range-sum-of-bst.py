#
# @lc app=leetcode id=938 lang=python3
#
# [938] Range Sum of BST
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        self.ans = 0
        
        def in_order_traversal(root: TreeNode) -> None:
            if root:
                if root.val > L:
                    in_order_traversal(root.left)
                if root.val >= L and root.val <= R:
                    self.ans += root.val
                if root.val < R:
                    in_order_traversal(root.right)
        
        in_order_traversal(root)
        return self.ans
# @lc code=end

