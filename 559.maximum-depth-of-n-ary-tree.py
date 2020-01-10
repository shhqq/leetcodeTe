#
# @lc app=leetcode id=559 lang=python3
#
# [559] Maximum Depth of N-ary Tree
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def maxDepth(self, root: 'Node') -> int:
# Use recursion to get depth.
        if root is None:
            return 0
        else:
            max_depth = 0
            for n in root.children:
                max_depth = max(max_depth, self.maxDepth(n))
            return 1 + max_depth
# @lc code=end

