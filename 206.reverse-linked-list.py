#
# @lc app=leetcode id=206 lang=python3
#
# [206] Reverse Linked List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head is None:
            return None
        if head.next is None:
            return head
        node1 = head.next
        node2 = node1.next
        node1.next = head
        # ===== Notice to assign None to head!!======
        head.next = None
        while node2 is not None:
            # print(node2.val)
            node3 = node2.next
            node2.next = node1
            node1 = node2
            node2 = node3
        return node1
# @lc code=end

