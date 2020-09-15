/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
    public void reorderList(ListNode head) {
        solution2(head);
    }

    /**
     * step1: 用两个指针，一个跳1，一个跳2，就可以找到中间节点。
     * step2: 后半段翻转一下
     * step3: 翻转后的后半段插入前半段
     * @param head
     */
    private void solution2(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null) {
            p2 = p2.next.next;
            p1 = p1.next;
        }
        // 从p1的下一个节点开始，翻转列表，并将p1.next 置为null
        if (p1.next == null) return;
        p2 = p1.next;
        p1.next = null;
        p1 = p2;
        p2 = p1.next;
        ListNode p3 = null;
        if (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1.next = null;
            while (p3 != null) {
                p1 = p2;
                p2 = p3;
                p3 = p3.next;
                p2.next = p1;
            }
        } else {
            p2 = p1;
        }
        // p2为后半段翻转后的head

        // 下一步，交叉插入前半段
        while (head != null && p2 != null) {
            p1 = head.next;
            p3 = p2.next;
            head.next = p2;
            p2.next = p1;

            head = p1;
            p2 = p3;
        }
    }

    /**
     * solution 1:
     * 把最后一个节点插入head后，然后递归后面的即可。
     * 优缺点：简单，但是递归耗时和空间复杂度都比较大。
     * @param head
     */
    private void solution1(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode p = head;
        // 找到倒数第二个节点
        while (p.next != null && p.next.next != null) {
            p = p.next;
        }
        ListNode tail = p.next;
        p.next = null;
        tail.next = head.next;
        head.next = tail;

        // 递归后面的节点
        reorderList(tail.next);
    }
}
// @lc code=end

