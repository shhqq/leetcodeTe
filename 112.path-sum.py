#
# @lc app=leetcode id=112 lang=python3
#
# [112] Path Sum
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if root is None:
            return False
        else:
            if root.left is not None:
                if self.hasPathSum(root.left, sum - root.val):
                    return True
            if root.right is not None:
                if self.hasPathSum(root.right, sum - root.val):
                    return True
            if root.left is None and root.right is None and root.val == sum:
                return True
            return False


# @lc code=end

