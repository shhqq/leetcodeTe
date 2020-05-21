/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        plattenMethod1(root);
    }

    private TreeNode previous = null;
    /**
     * algorithm 1
     * 还是使用递归，每次都保存一下上次的root节点，从后往前整理。
     * excellent idea。
     */
    private void plattenMethod1(TreeNode root){
        if (root == null) {
            return;
        } else {
            plattenMethod1(root.right);
            plattenMethod1(root.left);
            root.right = previous;
            root.left = null;
            previous = root;
        }
    }
    /**
     * algorithm 2
     * 使用递归
     * 1. 先保存root.right， 然后记得断开右侧
     * 2. 整理左侧，然后赋给root.right，记得断开root.left
     * 3. 然后找到root的最右端，保存为cur
     * 4. 整理右侧，并赋给cur.right
     * @param root
     */
    private void flattenMethod2(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode r = root.right;
        root.right = null;              // notice: break the right.
        if(root.left != null){
            flatten(root.left);
            root.right = root.left;
            root.left = null;           // notice: break the left.
        }
        TreeNode cur = root;
        while (cur.right != null){
            cur = cur.right;
        }
        cur.right = r;
        flatten(r);
    }
}
// @lc code=end

