/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node leftMost = root;
        while(leftMost != null){
            Node head = leftMost;
            leftMost = null;                        // 将leftMost置空，便于保存下一层的最左侧节点
            while(head != null){
                Node cur = null;                    // 保存当前节点，记录处理的层的当前节点
                if(head.left != null){
                    if(leftMost == null){           // 如果leftMost仍为空，则该节点为该层最左侧节点
                        leftMost = head.left;
                    }

                    cur = head.left;
                    if(head.right != null){         // 如果head还有右节点，那么更新cur节点
                        cur.next = head.right;
                        cur = head.right;
                    }
                } else if (head.right != null){
                    leftMost = leftMost == null ? head.right: leftMost;

                    cur = head.right;
                } else {                            // 如果head为叶子节点，那么向右移动
                    head = head.next;
                    continue;
                }

                Node nextNotLeaf = head.next;       // 寻找head右侧第一个非叶子节点
                while(nextNotLeaf != null && nextNotLeaf.left == null && nextNotLeaf.right == null){
                    nextNotLeaf = nextNotLeaf.next;
                }

                if(nextNotLeaf != null && nextNotLeaf.left != null){
                    cur.next = nextNotLeaf.left;
                } else if(nextNotLeaf != null && nextNotLeaf.right != null){
                    cur.next = nextNotLeaf.right;
                }

                head = nextNotLeaf;                 // head指向右侧非叶子节点
            }
        }
        return root;
    }
}
// @lc code=end

