import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
     * 使用递归，获取左右子节点结果，然后合一起
     * Use recursion to get result of left ans right child.
     * Then combine them together.
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        List<Integer> l = new ArrayList<>();
        l.add(root.val);
        ans.add(l);
        List<List<Integer>> leftRes = levelOrder(root.left);
        List<List<Integer>> rightRes = levelOrder(root.right);
        int maxLength = Math.max(leftRes.size(), rightRes.size());
        for(int i =0; i < maxLength; i++){
            List<Integer> temp = new ArrayList<>();
            if(leftRes.size() > i){
                temp.addAll(leftRes.get(i));
            }
            if(rightRes.size() > i){
                temp.addAll(rightRes.get(i));
            }
            ans.add(temp);
        }
        return ans;
    }

    /**
     * 使用两个队列，一个队列维护当前层，另一个队列保存下一层。
     * Use two queues. Use the one to storage nodes of the current level.
     * Use another one to storage nodes of the next level.
     */
    /*
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> s1 = new LinkedList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        s1.add(root);
        while(true){
            List<Integer> temp = new ArrayList<>();
            Queue<TreeNode> s2 = new LinkedList<>();
            while(!s1.isEmpty()){
                TreeNode t = s1.remove();
                temp.add(t.val);
                if(t.left!= null){
                    s2.add(t.left);
                }
                if(t.right != null){
                    s2.add(t.right);
                }
            }
            ans.add(temp);
            if(s2.isEmpty()){
                break;
            }else{
                s1 = s2;
            }
        }
        return ans;
    }
    // */
}
// @lc code=end

