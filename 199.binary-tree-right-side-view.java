import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    public List<Integer> rightSideView(TreeNode root) {
        /**
         * 就是一个广度优先遍历 
         */
        List<Integer> result = new ArrayList<>();
        List<TreeNode> nodesOfLayer = new ArrayList<>();

        if (root == null) return result;

        nodesOfLayer.add(root);
        while (nodesOfLayer.size() > 0) {
            List<TreeNode> temp = new ArrayList<>();
            for(int i = 0; i < nodesOfLayer.size(); i++) {
                if (nodesOfLayer.get(i).left != null) temp.add(nodesOfLayer.get(i).left);
                if (nodesOfLayer.get(i).right != null) temp.add(nodesOfLayer.get(i).right);
            }
            result.add(nodesOfLayer.get(nodesOfLayer.size() - 1).val);
            nodesOfLayer = temp;
        }
        return result;
    }
}
// @lc code=end

