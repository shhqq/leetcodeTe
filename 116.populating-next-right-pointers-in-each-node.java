/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
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
    /**
     * 可以使用第n层的next指针连接n+1层
     * 因为是完美二叉树，所以左右节点都存在。
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node leftMost = root;               // 保存每层的最左侧节点
        while(leftMost.left != null){       
            Node head = leftMost;                       // 使用head遍历该层所有节点
            while (head != null){
                head.left.next = head.right;            // head的左节点的next指向head右节点
                if(head.next != null){
                    head.right.next = head.next.left;   // head右节点的next指向head的next的左节点
                }
                head = head.next;
            }
            leftMost = leftMost.left;                   // 指向下一层
        }
        return root;
    }
}
// @lc code=end

