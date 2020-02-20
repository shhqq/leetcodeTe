#
# @lc app=leetcode id=872 lang=python3
#
# [872] Leaf-Similar Trees
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def leafSimilar(self, root1: TreeNode, root2: TreeNode) -> bool:
        if (root1 is None and root2 is not None) or (root1 is not None and root2 is None):
            return False
        
        leaf_val1 = self.get_leaf_values(root1)
        leaf_val2 = self.get_leaf_values(root2)
        
        return leaf_val1 == leaf_val2

    def get_leaf_values(self, root: TreeNode) -> list:
        if root is None:
            return []
        if root.left is None and root.right is None:
            return [root.val]
        else:
            return self.get_leaf_values(root.left) + self.get_leaf_values(root.right)

# @lc code=end

