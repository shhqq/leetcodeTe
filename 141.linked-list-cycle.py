#
# @lc app=leetcode id=141 lang=python3
#
# [141] Linked List Cycle
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
# solution 1:
# use Hash map
        if head is None:
            return False
        hashNode = {}
        node = head
        while True:
            if node.next is None:
                return False
            if node.next in hashNode:
                return True
            else:
                hashNode[node] = 1
                node = node.next

# @lc code=end

