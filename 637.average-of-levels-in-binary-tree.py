#
# @lc app=leetcode id=637 lang=python3
#
# [637] Average of Levels in Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def averageOfLevels(self, root: TreeNode) -> List[float]:
# Use a stack to storage the nodes, then use a new stack
# to storage its child nodes.
        res = []
        nodes = [root]
        next_level_nodes = []
        while nodes:
            sum_level = 0
            count = len(nodes)
            for n in nodes:
                sum_level += n.val
                if n.left:
                    next_level_nodes.append(n.left)
                if n.right:
                    next_level_nodes.append(n.right)
            res.append(sum_level/count)
            nodes = next_level_nodes
            next_level_nodes = []
        return res
# @lc code=end

