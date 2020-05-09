/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0){
            return head;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        int count = 1;
        while(n1.next != null){
            count++;
            if(count > k + 1){          // n2要指向结果的前一个，所以这里k+1
                n2 = n2.next;
            }
            n1 = n1.next;
        }
        if(n2 == head && k >= count){   // 如果n2指向head，那么要么k = count-1，要么k>=count
            return rotateRight(head, k % count);
        } else {
            ListNode ans = n2.next;
            n2.next = null;
            n1.next = head;
            return ans;
        }


    }
}
// @lc code=end

