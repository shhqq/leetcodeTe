#
# @lc app=leetcode id=589 lang=python3
#
# [589] N-ary Tree Preorder Traversal
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
    def preorder(self, root: 'Node') -> List[int]:
# Solution 1:
# Use iteration.
# Use a stack to storage nodes. Pop one node and then append its
# children in reversed order.
        if root == None:
            return []
        res = []
        nodes = [root]
        while nodes:
            p = nodes.pop()
            res.append(p.val)
            nodes += [k for k in p.children[::-1]]
        return res
# @lc code=end

