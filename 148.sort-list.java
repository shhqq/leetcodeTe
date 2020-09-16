/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 获取链表长度
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        // 第二步，使用bottom-up方式，进行排序
        // 使用一个节点保存head信息
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left, right, tail;
        for (int step = 1; step < length; step *= 2) {
            cur = dummy.next;
            tail = dummy;
            while (cur != null) {
                left = cur;
                right = splitLinkedList(left, step);
                cur = splitLinkedList(right, step);
                tail = merge(left, right, tail);
            }
        }
        return dummy.next;
    }

    /**
     * 把链表分成两部分：第一部分包含step个节点，然后
     * 返回第二部分的头结点
     * @param head
     * @param step
     * @return
     */
    private ListNode splitLinkedList(ListNode head, int step) {
        for (int i = 1; head != null && i <step; i++) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }
        ListNode second = head.next;
        head.next = null;
        return second;
    }

    /**
     * 首先合并两个排好序的链表，
     * 然后把合并的链表加到tail后面。
     * 返回合并后的链表的尾节点。
     * @param left
     * @param right
     * @param tail
     * @return
     */
    private ListNode merge(ListNode left, ListNode right, ListNode tail) {
        ListNode cur = tail;
        while (left != null && right != null) {
            if (left.val > right.val) {
                cur.next = right;
                cur = right;
                right = right.next;
            } else {
                cur.next = left;
                cur = left;
                left = left.next;
            }
        }
        // 剩余部分
        cur.next = left != null ? left : right;

        // 最终返回链表的尾节点
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }
}
// @lc code=end

