#
# @lc app=leetcode id=107 lang=python3
#
# [107] Binary Tree Level Order Traversal II
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        if root == None:
            return []
        nodeList = [root]
        nodeListNext = []
        nums = [[root.val]]
        numNext = []
        while True:
            for node in nodeList:
                if node.left is not None:
                    nodeListNext.append(node.left)
                    numNext.append(node.left.val)
                if node.right is not None:
                    nodeListNext.append(node.right)
                    numNext.append(node.right.val)
            if len(nodeListNext) == 0:
                break
            nodeList = nodeListNext.copy()
            nodeListNext.clear()
            nums.append(numNext.copy())
            numNext.clear()
        nums.reverse()
        return nums
# @lc code=end

