import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        /**
         * solution 1：
         * 使用一个栈（一个List），每次将node入栈，然后遍历左子树，之后遍历右子树。
         * 这样可以不使用递归
         */
        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        if (root == null) return nums;

        while (true) {
            if (root != null) {
                nums.add(root.val);
                nodes.add(root);
                root = root.left;
            } else if (nodes.size() > 0){
                root = nodes.remove(nodes.size() - 1);
                root = root.right;
            } else {
                break;
            }
        }
        return nums;
    }
}
// @lc code=end

