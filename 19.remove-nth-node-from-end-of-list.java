/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // *********** algorithm 1: use one pass
        // Use two pointers. The two pointers maintain distance of n.
        // When the front pointer reaches the end of list, the back pointer
        // points the N-th from the end.
        ListNode front = head, back = head;
        for(int i = 0; i < n; i++){
            front = front.next;
        }
        if(front == null){      // n is the count of the list.
            return head.next;
        }

        while(front.next != null){
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return head;
        

        /*
        // *********** algorithm 2 : use two pass. ************
        
        int count = 0;
        ListNode t = head;
        while(t != null){
            count++;
            t = t.next;
        }

        if(count == n){
            return head.next;
        }else{
            t = head;
            for(int i = 0; i < count; i++){
                if(i == count - n - 1){
                    t.next = t.next.next;
                }else {
                    t = t.next;
                }
            }
            return head;
        }
        // */
    }
}
// @lc code=end

