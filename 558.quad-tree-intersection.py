#
# @lc app=leetcode id=558 lang=python3
#
# [558] Quad Tree Intersection
#

# @lc code=start
"""
# Definition for a QuadTree node.
class Node:
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight
"""
class Solution:
    def intersect(self, quadTree1: 'Node', quadTree2: 'Node') -> 'Node':
        res = Node(None, None, None, None, None, None)
        if quadTree1.isLeaf and quadTree2.isLeaf:
            res.val = quadTree1.val or quadTree2.val
            res.isLeaf = True
        elif quadTree1.isLeaf:
            if quadTree1.val:
                res.val = True
                res.isLeaf = True
            else:
                res = quadTree2
        elif quadTree2.isLeaf:
            if quadTree2.val:
                res.val = True
                res.isLeaf = True
            else:
                res = quadTree1
        else:
            res.topLeft = self.intersect(quadTree1.topLeft, quadTree2.topLeft)
            res.topRight = self.intersect(quadTree1.topRight, quadTree2.topRight)
            res.bottomLeft = self.intersect(quadTree1.bottomLeft, quadTree2.bottomLeft)
            res.bottomRight = self.intersect(quadTree1.bottomRight, quadTree2.bottomRight)
            if res.topLeft.isLeaf and res.topRight.isLeaf and res.bottomLeft.isLeaf and res.bottomRight.isLeaf:
                if res.topLeft.val == res.topRight.val == res.bottomLeft.val == res.bottomRight.val:
                    res.isLeaf = True
                    res.val = res.topLeft.val
        return res

'''
Explanation:
1. 对于叶子节点，四个子节点没有意义；
2. 对于非叶子节点，val没有意义。
3. 对非叶子节点，如果四个子节点都是叶子节点，且值（val）都相同，要合并为叶子节点，
   值保持不变。
4. 非叶子节点的子节点可以包含叶子节点和非叶子节点，例如例子中的B。

1. The four children node of a leaf node is meaningless.
2. The value of a non-leaf node is meaningless.
3. If the four children of a node are all leaf and they have the same value,
   you should change the node to a leaf which the value is its children's value.
4. Like the B node in the given example, a non-leaf node can contain leaf nodes
   and non-leaf nodes.
'''
# @lc code=end

