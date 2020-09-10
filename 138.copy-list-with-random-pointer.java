import java.util.ArrayList;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // solution 1： 利用链表的特点，在每个节点后插入复制的节点，这样找random就很方便
        // 然后再拆开即可。
        if (head == null) {
            return null;
        }
        
        // 第一步，将原始链表每个节点后插入复制的节点，即如123，变为112233
        Node n1 = head;
        while (n1!= null) {
            Node n = new Node(n1.val);
            n.next = n1.next;
            n1.next = n;
            n1 = n.next;
        }
        // 第二步，创建random关系，不能同时拆分，因为会破坏链表的关系
        n1 = head;
        while (n1 != null) {
            if (n1.random == null) {
                n1.next.random = null;
            } else {
                n1.next.random = n1.random.next;
            }
            n1 = n1.next.next;
        }
        // 第三步，拆分新链表和旧链表
        n1 = head;
        Node n2 = n1.next;
        Node copyHead = n2;
        while (n1 != null) {
            n1.next = n2.next;
            n1 = n1.next;
            if(n1 != null) {
                n2.next = n1.next;
                n2 = n2.next;
            }
        }

        return copyHead;
        

        /*
        // solution 2: 查找每个random在链表中的索引。
        // 第一步，创建出新的链表
        Node copyHead = new Node(head.val);
        Node n1 = head;
        Node n2 = copyHead;
        while(n1.next != null) {
            n2.next = new Node(n1.next.val);
            n1 = n1.next;
            n2 = n2.next;
        }

        // 第二步，对每个节点，找到其random在链表中的索引i
        // 在新链表中，创建random关系
        n1 = head;
        n2 = copyHead;
        while(n1 != null) {
            if (n1.random == null) {
                n2.random = null;
            } else {
                int index = findIndex(head, n1.random);
                int i = 0;
                n2.random = copyHead;
                while(i < index) {
                    n2.random = n2.random.next;
                    i++;
                }
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        return copyHead;
        */
    }

    private int findIndex(Node head, Node n) {
        int i = 0;
        while (true) {
            if(head == n) {
                return i;
            }
            head = head.next;
            i++;
        }
    }
}
// @lc code=end

/**
 * 思路：先把链表复制出来，然后遍历，初始链表的每个节点random，
 * 找到random是链表的第几个节点，记为i，然后在新表中找到第i个节点，
 * 新表创建random关系。
 * 
 * 第二种方法：和官网排名最高的一致
 * 对每个节点，都复制一个节点并插入源节点右侧，这样创建random
 * 关系时非常方便。之后再拆分为两个链表。
 */