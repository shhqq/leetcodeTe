#
# @lc app=leetcode id=110 lang=python3
#
# [110] Balanced Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
# solution 1
        # if root == None:
        #     return True
        # if self.isBalanced(root.left) and self.isBalanced(root.right):
        #     return abs(self.getHeight(root.left) - self.getHeight(root.right)) < 2
        # else:
        #     return False
# solution 2  
    #     if root == None:
    #         return True
    #     if abs(self.getHeight(root.left) - self.getHeight(root.right)) < 2:
    #         return self.isBalanced(root.left) and self.isBalanced(root.right)
    #     else:
    #         return False      
    # def getHeight(self, root: TreeNode) -> int:
    #     if root == None:
    #         return 0
    #     else:
    #         return max(self.getHeight(root.left), self.getHeight(root.right)) + 1

# solution 3
# Both solution1 and solution2 will waste calling getHeight().
# Return the depth(or height) rather than only True or False.
        return self.isBal(root) > -1

    def isBal(self, root: TreeNode) -> int:
        if root == None:
            return 0
        left = self.isBal(root.left)
        right = self.isBal(root.right)
        if left < 0 or right < 0 or abs(left - right) > 1:
            return -1
        else:
            return max(left, right) + 1
    
# @lc code=end

