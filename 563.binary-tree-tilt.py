#
# @lc app=leetcode id=563 lang=python3
#
# [563] Binary Tree Tilt
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findTilt(self, root: TreeNode) -> int:
'''
Like problem 543, you can define a internal method which get sum of 
tree and tilt at the same time.
'''
        if root is None:
            return 0
        self.tilt = 0

        def cal_tilt(root):
            if root is None:
                return 0
            l = cal_tilt(root.left) 
            r = cal_tilt(root.right)
            self.tilt += abs(l - r)
            return l + r + root.val
        
        cal_tilt(root)
        return self.tilt

# @lc code=end

