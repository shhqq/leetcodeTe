#
# @lc app=leetcode id=160 lang=python3
#
# [160] Intersection of Two Linked Lists
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
# solution 1:
# Firstly, let next of single node of A is None, then len(B) will change.
# Secondly, if the intersetion node is the last node of A as also as B, it will be wrong.
# The time complexity will be O(m*n).
    #     if headA is None or headB is None:
    #         return None
    #     lB, lastB = self.getListLength(headB)
    #     lA, lastA = self.getListLength(headA)
        
    #     temp = headA

    #     while temp is not None:
    #         t2 = temp.next
    #         temp.next = None
    #         if self.getListLength(headB)[0] != lB:
    #             temp.next = t2
    #             return temp
    #         else:
    #             temp.next = t2
    #             temp = t2
    #     if lastA is lastB:
    #         return lastA
    #     return None

    # def getListLength(self, head: ListNode) -> int:
    #     l = 0
    #     temp = head
    #     last = temp
    #     while temp is not None:
    #         last = temp
    #         l += 1
    #         temp = temp.next
    #     return l, last

# solution 2
        if headA is None or headB is None:
            return None
        pA = headA
        pB = headB
        lA = self.getListLength(headA)
        lB = self.getListLength(headB)

        for _ in range(lA + lB + 1):
            if pA is None:
                pA = headB
            if pB is None:
                pB = headA
            if pA is pB:
                return pA
            pA = pA.next
            pB = pB.next
        return None

    def getListLength(self, head: ListNode) -> int:
        l = 0
        temp = head
        while temp is not None:
            l += 1
            temp = temp.next
        return l
# @lc code=end

