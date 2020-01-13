#
# @lc app=leetcode id=590 lang=python3
#
# [590] N-ary Tree Postorder Traversal
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
    def postorder(self, root: 'Node') -> List[int]:
# Like the Preorder, traverse the root firstly, then its
# children from right to left.
# Finally, reverse the result list.
        if root == None:
            return []
        res = []
        nodes = [root]
        while nodes:
            p = nodes.pop()
            res.append(p.val)
            nodes += [k for k in p.children]
        res.reverse()
        return res
# @lc code=end

