/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        } else {
            int currentValue = head.val;
            int count = 1;
            while(head.next != null && head.next.val == currentValue){
                count++;
                head = head.next;
            }
            if (count > 1){
                return deleteDuplicates(head.next);     // 第一个节点的值出现重复
            } else {
                head.next = deleteDuplicates(head.next);    // 递归后面的节点
                return head;
            }
        }
    }
}
// @lc code=end

