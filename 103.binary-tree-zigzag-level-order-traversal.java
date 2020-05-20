import java.util.ArrayList;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    /**
     * 使用两个stack，使用一个turn表示方向
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Stack<TreeNode> s1 = new Stack<>();
        int turn = -1;
        s1.push(root);
        while(true){
            Stack<TreeNode> s2 = new Stack<>();
            List<Integer> temp = new ArrayList<>();
            while (!s1.empty()){
                TreeNode t = s1.pop();
                temp.add(t.val);
                if(turn == 1){
                    if(t.right != null){
                        s2.push(t.right);
                    }
                    if(t.left != null){
                        s2.push(t.left);
                    }
                } else if(turn == -1) {
                    if(t.left != null){
                        s2.push(t.left);
                    }
                    if(t.right != null){
                        s2.push(t.right);
                    }
                }

            }
            turn *= -1;
            ans.add(temp);
            if(s2.empty()){
                break;
            }
            s1 = s2;
        }
        return ans;
    }
}
// @lc code=end

