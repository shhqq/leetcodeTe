#
# @lc app=leetcode id=538 lang=python3
#
# [538] Convert BST to Greater Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def convertBST(self, root: TreeNode) -> TreeNode:
# if you assume there is no duplicate, then use last order traversal 
# to calculate right child tree of a node and the parent and its
# right child tree.
# But if there is duplicate, it will not work.
        if root is None:
            return None
        values = self.in_order_traversal(root)
        values_greater = self.greater(values)
        self.greater_bst(root, values_greater)
        return root
    
    # Simple in order traversal.
    def in_order_traversal(self, root: TreeNode) -> TreeNode:
        if root is None:
            return []
        res = self.in_order_traversal(root.left) 
        res += ([root.val] + self.in_order_traversal(root.right))
        return res
    
    # Get a dictionary of nums and their corresponding new values.
    def greater(self, nums):
        sum_v = nums[-1]
        val_dic = {nums[-1]: nums[-1]}

        for i in range(len(nums) -2, -1, -1):
            # if there is duplicate, add it to sum_v.
            if nums[i] not in val_dic:
                val_dic[nums[i]] = nums[i] + sum_v
            sum_v += nums[i]
        return val_dic
    
    # Use new valuse to update the binary search tree.
    def greater_bst(self, root, values):
        if root is None:
            return
        root.val = values[root.val]
        self.greater_bst(root.left, values)
        self.greater_bst(root.right, values)

# @lc code=end

