#
# @lc app=leetcode id=671 lang=python3
#
# [671] Second Minimum Node In a Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findSecondMinimumValue(self, root: TreeNode) -> int:
        min_value = root.val
        second_min_value = root.val
        if root.left == None:
            return -1
        nodes = [root]
        while nodes:
            nodes_value = []
            next_nodes = []
            for n in nodes:
                if n.val != min_value:
                    nodes_value.append(n.val)
                elif n.left:
                    next_nodes.append(n.left)
                    next_nodes.append(n.right)
            if len(nodes_value) > 0:
                if second_min_value == root.val:
                    second_min_value = min(nodes_value)
                else:
                    second_min_value = min(second_min_value, min(nodes_value))
            nodes = next_nodes
        return second_min_value if second_min_value > root.val else -1
            
            
# @lc code=end

