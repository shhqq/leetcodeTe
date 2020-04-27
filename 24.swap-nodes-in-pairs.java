/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }else {
            ListNode n1 = head;
            ListNode n2 = n1.next;
            ListNode n3 = n2.next;

            n2.next = n1;
            n1.next = n3;
            head = n2;
            while(n3 != null && n3.next != null){
                // 注意要将前面的连上第四个
                n1.next = n3.next;
                n1 = n3;
                n2 = n3.next;
                n3 = n2.next;
                n2.next = n1;
                n1.next = n3;
            }
            return head;
        }
    }
}
// @lc code=end

