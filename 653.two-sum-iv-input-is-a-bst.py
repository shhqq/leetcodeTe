#
# @lc app=leetcode id=653 lang=python3
#
# [653] Two Sum IV - Input is a BST
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findTarget(self, root: TreeNode, k: int) -> bool:
# Use a hash table and traverse the tree.
        self.dic = {}

        def first_order_traversal(root: TreeNode, k: int) -> bool:
            if root is None:
                return False
            else:
                if k-root.val in self.dic.keys():
                    return True
                else:
                    self.dic[root.val] = 1
                    if first_order_traversal(root.left, k) or first_order_traversal(root.right, k):
                        return True
                    else:
                        return False
        return first_order_traversal(root, k)
                    
# @lc code=end

