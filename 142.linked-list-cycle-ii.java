import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        return solution3(head);
    }

    
    /**
     * solution 1： 最直观的就是保存所有的节点，如果已经保存过了，则返回该节点
     * 这种方式的空间复杂度是o(n)
     */
    private ListNode solution1 (ListNode head){
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            if (nodes.contains(head)) {
                break;
            } else {
                nodes.add(head);
                head = head.next;
            }
        }
        return head;
    }

    // solution 2: 
    /**
     * 挨个断开每个节点的next，然后从head开始计数，如果依次增加，则还没有出现环。
     * 如果从某个节点开始，head开始的计数没有增加1，则这个节点就是环。
     * 例如测试用例中第二次遍历到2时，计数从4变为了2，说明这里是环。
     * 这样空间复杂度只需要保存一个计数即可，但时间复杂度貌似增加了不少
     */
    private ListNode solution2 (ListNode head) {
        if (head == null) {
            return null;
        }
        int count = 0;
        ListNode p = head;

        while (p != null) {
            // 保存p的下一个节点
            ListNode temp = p.next;
            // 断开p的next
            p.next = null;
            int n = countLinkedList(head);
            if (n == count + 1) {
                count += 1;
                p.next = temp;
                p = temp;
            } else {
                return p;
            }
        }
        return p;
    }

    /**
     * 统计链表的节点数
     * @param head 链表头结点
     * @return 返回链表节点数
     */
    private int countLinkedList(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        return n;
    }

    /**
     * solution 3：
     * 使用两个指针，一个每次跳两个，一个每次跳一个，如果存在环，那么必然会相遇。
     * 相遇之后，让p1回到head，然后两个指针每次都移动一位，必定在环的起点相遇。
     * @param head
     * @return
     */
    private ListNode solution3(ListNode head) {
        if (head == null) return null;

        ListNode p1 = head, p2 = head;
        int jump = 0;
        
        while (true) {
            if (p2 != null && p2.next != null && p2.next.next != null) {
                p2 = p2.next.next;
                p1 = p1.next;
            } else {
                return null;
            }

            jump++;
            if (p1 == p2) {
                break;
            }
        }

        // p1返回起点
        p1 = head;
        while (true) {
            // 先判断p1是否等于p2，因为可能head就是环的起点，这个容易出错
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
            
        }
    }
}
// @lc code=end

