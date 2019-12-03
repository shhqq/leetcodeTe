#
# @lc app=leetcode id=111 lang=python3
#
# [111] Minimum Depth of Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDepth(self, root: TreeNode) -> int:
# solution 1: use recursive method.
# Recursive method is not the best. It takes more memory.
        # if root == None:
        #     return 0
        # elif root.left == None:
        #     return self.minDepth(root.right) + 1
        # elif root.right == None:
        #     return self.minDepth(root.left) + 1
        # else:
        #     return min(self.minDepth(root.left), self.minDepth(root.right)) + 1

# solution 2: use loop to find the first leaf node from the top to the bottom.
# And then return the number of layer.
        if root is None:
            return 0
        i = 0
        nodes = [root]
        j = len(nodes)
        nodesTemp = []
        while True:
            i += 1
            while j > 0:
                temp = nodes[len(nodes) - j]
                if temp.left is None and temp.right is None:
                    return i
                if temp.left is not None:
                    nodesTemp.append(temp.left)
                if temp.right is not None:
                    nodesTemp.append(temp.right)
                j -= 1
            nodes = nodesTemp.copy()
            nodesTemp.clear()
            j = len(nodes)
# @lc code=end

