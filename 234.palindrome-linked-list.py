#
# @lc app=leetcode id=234 lang=python3
#
# [234] Palindrome Linked List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
# solution 1:
# reverse the linked list.
# Notice not to change the head.
        """
        tail = self.reverse_linked_list(head)
        while head is not None:
            if head.val != tail.val:
                return False
            head = head.next
            tail = tail.next
        return True

    def reverse_linked_list(self, head: ListNode) -> ListNode:
        # reverse linked list.
        if head is None:
            return None
        h = head
        p = ListNode(h.val)
        while h.next is not None:
            p1 = ListNode(h.next.val)
            p1.next = p
            p = p1
            h = h.next
        return p
        """
# solution 2:
# Just reverse the first half, and then compare it to the last
# half.
        if head is None:
            return True
        slow = fast = head
        rev = None
        while fast and fast.next:
            fast = fast.next.next
            p = ListNode(slow.val)
            p.next = rev
            rev = p
            slow = slow.next
        # if fast is not None, then lenth of linked list is odd.
        # slow should move one step.
        if fast is not None:
            slow = slow.next
        while slow is not None:
            if slow.val != rev.val:
                return False
            slow = slow.next
            rev = rev.next
        return True

# @lc code=end

