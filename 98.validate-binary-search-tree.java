import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    // 使用中序遍历————递归方法
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        // List<Integer> nums = inorderTraversalRecursion(root);
        List<Integer> nums = inorderTraNoRecursion(root);
        
        for(int i = 0; i < nums.size() - 1; i++){
            if (nums.get(i) >= nums.get(i+1)){
                return false;
            }
        }
        return true;
    }

    /**
     * 使用递归进行中序遍历
     * @param root
     * @return
     */
    private List<Integer> inorderTraversalRecursion(TreeNode root){
        List<Integer> nums = new ArrayList<>();
        if(root.left != null){
            nums.addAll(inorderTraversalRecursion(root.left));
        }
        nums.add(root.val);
        if(root.right != null){
            nums.addAll(inorderTraversalRecursion(root.right));
        }
        return nums;
    }

    /**
     * 不使用递归进行中序遍历
     * @param root
     * @return
     */
    private List<Integer> inorderTraNoRecursion(TreeNode root){
        List<Integer> nums = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur != null){
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            nums.add(cur.val);
            cur = cur.right;
        }
        return nums;
    }

    /*
    // 使用最大值最小值
    // 每个子树都要重新获取最大值最小值，会有一些重复
    public boolean isValidBST(TreeNode root) {
        // 左子树最大值应 < root.val
        // 右子树最小值应 > root.val
        // 遍历最大值最小值时，可以不用管子树是不是BST
        if(root == null){
            return true;
        }else {
            if (root.left != null && getMax(root.left) >= root.val){
                return false;
            }
            if(root.right != null && getMin(root.right) <= root.val){
                return false;
            }
            return isValidBST(root.left) && isValidBST(root.right);
        }
    }

    private int getMax(TreeNode root){
        int maxValue = root.val;
        while(root.right != null){
            root = root.right;
            maxValue = root.val;
        }
        return maxValue;
    }

    private int getMin(TreeNode root){
        int minValue = root.val;
        while(root.left != null){
            root = root.left;
            minValue = root.val;
        }
        return minValue;
    }
    */
}
// @lc code=end

