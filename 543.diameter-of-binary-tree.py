#
# @lc app=leetcode id=543 lang=python3
#
# [543] Diameter of Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
# solution 1:
# Use recursion to get the max diameter. The max diameter including the root is
# depth of left plus depth of right.
        '''
        max_diameter = 0
        if root is None:
            return 0
        else:
            max_diameter = self.get_depth(root.left) + self.get_depth(root.right)
            return max([max_diameter, self.diameterOfBinaryTree(root.left), self.diameterOfBinaryTree(root.right)])
    
    def get_depth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        else:
            return max(self.get_depth(root.left), self.get_depth(root.right)) + 1

        '''
# solution 2:
# You can get max diameter at the same time when calculating the depth of root.
# It can avoid calculate the depth repeatedly.
        if root is None:
            return 0
        else:
            self.max_diameter = 0

            def get_d_and_max_dia(root: TreeNode) -> int:
                '''
                Get depth and max diameter of this root at the same time.
                '''
                if root is None:
                    return 0
                else:
                    d_left = get_d_and_max_dia(root.left)
                    d_right = get_d_and_max_dia(root.right)
                    self.max_diameter = max(self.max_diameter, d_left + d_right)
                    return max(d_left, d_right) + 1
            
            get_d_and_max_dia(root)
            return self.max_diameter
# @lc code=end

