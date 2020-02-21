#
# @lc app=leetcode id=876 lang=python3
#
# [876] Middle of the Linked List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        ans = head
        count = 1
        temp = head
        while temp.next is not None:
            temp = temp.next
            count += 1
            if count % 2 == 0:
                ans = ans.next
        return ans
            
# @lc code=end

