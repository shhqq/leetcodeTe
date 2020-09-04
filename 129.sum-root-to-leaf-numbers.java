/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if(root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return root.val;
        } else {
            if(root.left != null) {
                sum += sumHelper(root.left, root.val);
            }
            if(root.right != null) {
                sum += sumHelper(root.right, root.val);
            }
            return sum;
        }
    }

    /**
     * 要保证root不是null，每层将parent乘以10加上本层的值。
     * @param: parent root节点的上一层所积累的值。
     */
    private int sumHelper(TreeNode root, int parent) {
        if (root.left == null && root.right == null) {
            return parent * 10 + root.val;
        } else {
            int sum = 0;
            if(root.left != null) {
                sum += sumHelper(root.left, parent * 10 + root.val);
            }
            if (root.right != null) {
                sum += sumHelper(root.right, parent * 10 + root.val);
            }
            return sum;
        }
    }
}
// @lc code=end

