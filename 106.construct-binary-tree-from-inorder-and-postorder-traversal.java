/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeAlgorithm1(inorder, postorder);
    }

    // shiy
    private TreeNode buildTreeAlgorithm1(int[] inorder, int[] postorder) {
        if(inorder.length == 0){
            return null;
        } else {
            int rootValue = postorder[postorder.length - 1];
            TreeNode root = new TreeNode(rootValue);
            int indexOfRoot = 0;
            for(int i = 0; i < inorder.length; i++){
                if(inorder[i] == rootValue){
                    indexOfRoot = i;
                    break;
                }
            }
            int[] leftArrayPost = getSubArray(postorder, 0, indexOfRoot - 1);
            int[] rightArrayPost = getSubArray(postorder, indexOfRoot, postorder.length - 2);
            int[] leftArrayIn = getSubArray(inorder, 0, indexOfRoot - 1);
            int[] rightArrayIn = getSubArray(inorder, indexOfRoot + 1, inorder.length - 1);
            root.left = buildTreeAlgorithm1(leftArrayIn, leftArrayPost);
            root.right = buildTreeAlgorithm1(rightArrayIn, rightArrayPost);
            return root;
        }
    }
    private int[] getSubArray(int[] array, int start, int end){
        if(start < 0 || end > array.length-1 || start > end){
            return new int[0];
        } else {
            int[] res = new int[end-start+1];
            for(int i = start; i <= end; i++) {
                res[i-start] = array[i];
            }
            return res;
        }
    }

}
// @lc code=end

