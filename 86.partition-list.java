/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return head;
        } else {
            /**
             * 存储头结点，最后一个小于x的节点，第一个>=x的节点，最后一个>=x的节点
             */
            ListNode h = null;
            ListNode firstGorE = null;
            ListNode p = null;
            ListNode lastLess = null;
            ListNode lastGorE = null;
            if (head.val < x){
                h = head;
                lastLess = head;
            }else {
                firstGorE = head;
                lastGorE = firstGorE;
            }
            p = head.next;
            while(p != null){
                if(p.val < x){
                    if(h == null){                  // 判断h是否为空
                        h = lastLess = p;
                    } else {
                        lastLess.next = p;
                        lastLess = lastLess.next;
                    }
                } else{
                    if (firstGorE == null){         // 判断firstGorE是否为空
                        firstGorE = lastGorE = p;
                    } else {
                        lastGorE.next = p;
                        lastGorE = lastGorE.next;
                    }
                }
                p = p.next;
            }
            if (h == null){                         // 需要判断h或firstGorE是否为空
                return firstGorE;
            } else if(firstGorE == null){
                return h;
            }
            lastGorE.next = null;      // 如果lastGorE不是原来链表的最后一个节点，那么需要将lastGorE.next置空
            lastLess.next = firstGorE;
            return h;
        }
    }
}
// @lc code=end

