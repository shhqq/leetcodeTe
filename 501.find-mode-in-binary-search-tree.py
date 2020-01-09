#
# @lc app=leetcode id=501 lang=python3
#
# [501] Find Mode in Binary Search Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findMode(self, root: TreeNode) -> List[int]:
# Solution 1:
# Use the in-order traversal to traverse the binary search tree.
# But this needs extra space to store the valuse.
        '''
        if root is None:
            return []
        traverse_res = self.in_order_traversal(root)
        count_i = 0
        temp = traverse_res[0]
        count_max = 0
        res = []
        for i in traverse_res:
            if i == temp:
                count_i += 1
            else:
                if count_i == count_max:
                    res.append(temp)
                elif count_i > count_max:
                    count_max = count_i
                    res = []
                    res.append(temp)
                count_i = 1
                temp = i
        if count_i == count_max:
            res.append(traverse_res[-1])
        elif count_i > count_max:
            res = []
            res.append(traverse_res[-1])
        return res
    
    def in_order_traversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        res = []
        res = self.in_order_traversal(root.left)
        res += [root.val]
        res += self.in_order_traversal(root.right)
        return res
        '''

# Solution 2:
# Use collections and deep first traversal.
# The collections would also cost extra space.
        if root is None:
            return []
        values_map = collections.Counter()
        self.dfs(root, values_map)
        max_count = max(values_map.values())
        return [k for k, v in values_map.items() if v == max_count]
    def dfs(self, node, count):
        if node:
            count[node.val] += 1
            self.dfs(node.left, count)
            self.dfs(node.right, count)
    
# @lc code=end

