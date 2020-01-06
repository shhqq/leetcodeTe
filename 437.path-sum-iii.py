#
# @lc app=leetcode id=437 lang=python3
#
# [437] Path Sum III
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> int:
# solution 1:
# Use the recursion method.
        if root is None:
            return 0
        count = 0

        # part 1: contain the root.
        if root.val == sum:
            count += 1
        count += self.pathSumWithRoot(root.left, sum - root.val)
        count += self.pathSumWithRoot(root.right, sum - root.val)
        
        # part 2: don't contain the root
        count += self.pathSum(root.left, sum)
        count += self.pathSum(root.right, sum)

        return count

    def pathSumWithRoot(self, root: TreeNode, sum: int) -> int:
        '''
        Count path which contain the root node.
        Because path must be continuous.
        '''
        if root is None:
            return 0
        count = 0
        if root.val == sum:
            count += 1
        count += self.pathSumWithRoot(root.left, sum - root.val)
        count += self.pathSumWithRoot(root.right, sum - root.val)

        return count
# @lc code=end

