/*
 * @lc app=leetcode id=965 lang=java
 *
 * [965] Univalued Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        // use recursion.
        if (root == null){
            return false;
        } else{
            int uniValue = root.val;
            boolean checkLeft = true;
            boolean checkRight = true;
            if(root.left != null){
                if(root.left.val != uniValue){
                    return false;
                } else{
                    checkLeft = isUnivalTree(root.left);
                }
            }
            if(root.right != null){
                if(root.right.val != uniValue){
                    return false;
                } else {
                    checkRight = isUnivalTree(root.right);
                }
            }
            return checkLeft && checkRight;
        }
    }
}
// @lc code=end

