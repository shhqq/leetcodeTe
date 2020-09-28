import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
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
class BSTIterator {
    TreeNode current = null;
    List<TreeNode> nodes = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        // nodes 保存当前节点的父节点及更高节点
        // current 指向当前节点
        current = root;
        while (current != null && current.left != null) {
            nodes.add(current);
            current = current.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        int res = current.val;
        // *** 调用后，current指向下一个，如果没有下一个，则为null***
        // 1. 如果当前节点有右子树，则指向右子树的最左侧节点；
        // 2. 如果当前节点没有右子树，则向上追溯，如果是栈尾元素的右子树，则继续向上；
        // 3. 如果是栈尾元素的左子树，则先输出栈尾元素
        if (current.right != null) {
            nodes.add(current);
            current = current.right;
            while (current.left != null) {
                nodes.add(current);
                current = current.left;
            }
        } else if (nodes.size() == 0) {
            // 此时current 为root，且无right child node
            // 这是current赋为空
            current = null;
        } else {
            int n = nodes.size();
            TreeNode t = nodes.get(n - 1);
            while (t.left != current) {
                current = t;
                nodes.remove(nodes.size() - 1);
                if (nodes.size() > 0){
                    t = nodes.get(nodes.size() - 1);
                } else {
                    current = null;
                    break;
                }
            }
            if (current != null) {
                current = t;
                nodes.remove(nodes.size()-1);
            }
        }
        return res;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

/**
 * 初步思路应该是像迭代遍历二叉树类似，使用一个栈存储一些节点。
 * 1. 使用一个栈存放当前节点的高层节点
 * 2. 使用一个节点记录当前遍历位置
 * 3. 每次调用next时，current都指向下一个，如果没有下一个，则赋为null，这样
 * hasNext()只需要判断current是否为null即可。
 */