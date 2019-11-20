#
# @lc app=leetcode id=21 lang=python3
#
# [21] Merge Two Sorted Lists
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # temp = ListNode()
        # headNode = ListNode()
        if l1 == None:
            return l2
        if l2 == None:
            return l1

        if l1.val <= l2.val:
            headNode = ListNode(l1.val)
            l1 = l1.next
        else:
            headNode = ListNode(l2.val)
            l2 = l2.next
        temp = headNode
        while l1 is not None and l2 is not None:
            if l1.val <= l2.val:
                temp.next = ListNode(l1.val)
                temp = temp.next
                l1 = l1.next
            else:
                temp.next = ListNode(l2.val)
                temp = temp.next
                l2 = l2.next
        while l1 is not None:
            temp.next = ListNode(l1.val)
            temp = temp.next
            l1 = l1.next
        while l2 is not None:
            temp.next = ListNode(l2.val)
            temp = temp.next
            l2 = l2.next
        return headNode


# @lc code=end

