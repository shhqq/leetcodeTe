/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n){
            return head;
        }
        ListNode ps = new ListNode();
        ListNode pend = ps;             // 保存m的前一个节点
        pend.next = head;
        ListNode p = head;              // 遍历变量
        ListNode pm = head;             // 保存第m个节点
        for(int i = 1; ; i++){
            if(i < m){                  // 在m之前，pend，p均往前走
                pend = p;               
                p = p.next;
            }
            if(i == m){                 // 找到第m个，pend.next = 第m个
                pm = p;                 // 保存第m个到pm
                pend.next = pm;
                p = p.next;
            }
            if(i > m){                  // 第m个之后，第i个接pend.next，然后pend接第i个
                ListNode temp = p;
                p = p.next;
                temp.next = pend.next;
                pend.next = temp;
            }
            if (i == n){               // 找到第n个后，pm接第n+1个
                pm.next = p;            // 因为上面已经有p = p.next了，所以这里pm.next直接等于p
                break;
            }
            
        }
        return ps.next;
    }
}
// @lc code=end

