/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        /**
         * 这个题目的关键点是需要断开某些连接，否则会出现环
         */
        if (head == null || head.next == null) return head;

        ListNode p1 = head.next;
        // 这里要断开连接
        head.next = null;
        while (p1 != null) {
            ListNode p2 = p1;
            p1 = p1.next;
            p2.next = null;     // 这里也要断开

            // 如果p2小于head，直接放在head之前
            if (p2.val < head.val) {
                p2.next = head;
                head = p2;
            } else {
                // 如果p2.val >= head.val，那么向后找
                ListNode p3 = head;
                while (p3.next != null) {
                    if (p3.next.val >= p2.val) {
                        p2.next = p3.next;
                        p3.next = p2;
                        break;
                    } else {
                        p3 = p3.next;
                    }
                }
                //printList(head);
                if (p3.next != p2) {
                    p3.next = p2;
                }
            }
        }
        return head;
    }
    
    private void printList(ListNode head) {
        int i = 0;
        while (i < 6) {
            if (head != null) {
                System.out.println(head.val);
                head = head.next;
            } else {
                break;
            }
            i++;
        }
        System.out.println("=======");
    }
}
// @lc code=end

