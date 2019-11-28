#
# @lc app=leetcode id=101 lang=python3
#
# [101] Symmetric Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
# solution 1 
# 每一层都是对称的，保留每一层，然后从两头开始对比
        # if root == None:
        #     return True
        # if root.left is not None and root.right is None:
        #     return False
        # elif root.left is None and root.right is not None:
        #     return False
        # elif root.left is not None and root.right is not None:
        #     if root.left.val != root.right.val:
        #         return False
        #     else:
        #         layer = [root.left, root.right]
        #         l = len(layer)
        #         while l > 0:
        #             for i in range(l // 2):
        #                 if layer[i].left is None and layer[l-1-i].right is not None:
        #                     return False
        #                 elif layer[i].left is not None and layer[l-1-i].right is None:
        #                     return False
        #                 elif layer[i].right is None and layer[l-1-i].left is not None:
        #                     return False
        #                 elif layer[i].right is not None and layer[l-1-i].left is None:
        #                     return False
        #                 if layer[i].left is not None and layer[l-1-i].right is not None:
        #                     # print(layer[i].left.val, layer[-1-i].right.val)
        #                     if layer[i].left.val != layer[l-1-i].right.val:
        #                         return False
        #                 if layer[i].right is not None and layer[l-1-i].left is not None:
        #                     # print(layer[i].right.val, layer[-1-i].left.val)
        #                     if layer[i].right.val != layer[l-1-i].left.val:
        #                         return False
        #             temp = []
        #             for i in range(l):
        #                 if layer[i].left is not None:
        #                     temp.append(layer[i].left)
        #                 if layer[i].right is not None:
        #                     temp.append(layer[i].right)
        #             layer = temp
        #             l = len(layer)
        # return True
# solution 2 
# 将每层的数据提出来，是不是会好一些
# 使用try except可以减少代码量
        # if root == None:
        #     return True
        # layer = [root]
        # while True:
        #     next_layer = []
        #     for i in range(len(layer)):
        #         next_layer.append(layer[i].left)
        #         next_layer.append(layer[i].right)
        #     l = len(next_layer)
        #     count_None = next_layer.count(None)
        #     if count_None == l:
        #         return True
        #     elif count_None % 2 == 1:
        #         return False
        #     else:
        #         for i in range(l // 2):
        #             if next_layer[i] == None and next_layer[-1 - i] == None:
        #                 continue
        #             try:
        #                 if next_layer[i].val != next_layer[-1 - i].val:
        #                     return False
        #             except AttributeError:
        #                 return False
        #         layer.clear()
        #         for _ in range(count_None):
        #             next_layer.remove(None)
        #         layer = next_layer  


        def isSym(L,R):
            if not L and not R: return True
            if L and R and L.val == R.val: 
                return isSym(L.left, R.right) and isSym(L.right, R.left)
            return False
        if root is None:
            return True
        return isSym(root.left, root.right)
# @lc code=end

