#
# @lc app=leetcode id=687 lang=python3
#
# [687] Longest Univalue Path
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def longestUnivaluePath(self, root: TreeNode) -> int:
# Use recursion.
# Count left and right child continuous value of root.
# If the child node has different value with the root, invoke the 
# method with new value.
        if root is None:
            return 0
        self.max_length = 0

        def find_nums_of_value_with_root(root: TreeNode, value) -> int:
            if root is None:
                return 0
            if root.val != value:
                find_nums_of_value_with_root(root, root.val)
                return 0
            else:
                l = find_nums_of_value_with_root(root.left, value)
                r = find_nums_of_value_with_root(root.right, value)
                self.max_length = max(self.max_length, l + r)
                return 1 + max(l, r)
        
        find_nums_of_value_with_root(root, root.val)
        return self.max_length
        '''

# this solution is a little hard to understand.
        self.ans = 0

        def arrow_length(node):
            if not node: return 0
            left_length = arrow_length(node.left)
            right_length = arrow_length(node.right)
            left_arrow = right_arrow = 0
            if node.left and node.left.val == node.val:
                left_arrow = left_length + 1
            if node.right and node.right.val == node.val:
                right_arrow = right_length + 1
            self.ans = max(self.ans, left_arrow + right_arrow)
            return max(left_arrow, right_arrow)

        arrow_length(root)
        return self.ans
        '''
# @lc code=end

