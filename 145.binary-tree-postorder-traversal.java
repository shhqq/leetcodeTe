import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        if (root == null) return nums;

        while (true) {
            if (root != null) {
                // if (root.left == null && root.right == null) {
                //     nums.add(root.val);
                // }
                nodes.add(root);
                root = root.left;
            } else if (nodes.size() > 0) {
                // 如果当前节点是栈中最后一个节点的右节点，则要弹栈，否则不弹栈。要一直向上追溯
                while (nodes.size() > 0 && nodes.get(nodes.size()-1).right == root) {
                    root = nodes.remove(nodes.size() - 1);
                    nums.add(root.val);
                }
                // 一直向上追溯右节点后，如果nodes还有节点，则先要处理它的右子树
                if (nodes.size() > 0) {
                    root = nodes.get(nodes.size() - 1).right;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return nums;
    }
}
// @lc code=end

