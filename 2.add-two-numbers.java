/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode n = ans;
        int val1 = 0;
        int val2 = 0;
        int extra = 0;
        while(l1 != null || l2 != null){
            val1 = val2 = 0;
            if(l1 != null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val2 = l2.val;
                l2 = l2.next;
            }
            n.val = (val1 + val2 + extra) % 10;
            extra = (val1 + val2 + extra) / 10;
            if(l1 != null || l2 != null){
                n.next = new ListNode();
                n = n.next;
            }
        }
        // 注意最后的进位
        if(extra == 1){
            n.next = new ListNode(1);
        }
        return ans;
    }
}
// @lc code=end

