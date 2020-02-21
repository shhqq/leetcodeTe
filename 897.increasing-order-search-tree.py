#
# @lc app=leetcode id=897 lang=python3
#
# [897] Increasing Order Search Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def increasingBST(self, root: TreeNode) -> TreeNode:

# Solution 1:
# Use in order traversal to get the values of the binary
# search tree. Then generate a tree with the values.
        # if root is None:
        #     return None

        # self.values = []
        # def in_order_traversal(root: TreeNode) -> None:
        #     if root is not None:
        #         in_order_traversal(root.left)
        #         self.values.append(root.val)
        #         in_order_traversal(root.right)
        
        # in_order_traversal(root)

        # head = TreeNode(self.values[0])
        # temp = head
        # for i in range(1, len(self.values)):
        #     temp.right = TreeNode(self.values[i])
        #     temp = temp.right
        # return head

# Solution 2:
# Assign the current node to the right of the previous node.
# And assign None to the left node of all nodes.

        ans = self.cur = TreeNode(None)
        def in_order_traversal(root: TreeNode) -> None:
            if root:
                in_order_traversal(root.left)
                self.cur.right = root
                self.cur = root
                root.left = None
                in_order_traversal(root.right)
        
        in_order_traversal(root)
        return ans.right

# @lc code=end

