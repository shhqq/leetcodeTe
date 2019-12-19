#
# @lc app=leetcode id=203 lang=python3
#
# [203] Remove Linked List Elements
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        # Find the first node whose value is not val.
        while head is not None:
            if head.val == val:
                head = head.next
            else:
                break
        if head is None:
            return head
        next_node = head
        # Remove nodes whose value are val.
        while next_node.next is not None:
            if next_node.next.val == val:
                temp = next_node.next.next
                next_node.next = temp
            else:
                next_node = next_node.next
        return head
# @lc code=end

