import java.util.HashMap;

import javax.swing.tree.TreeNode;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetException;

/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
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
    Map<Integer, Integer> depth;
    Map<Integer, Integer> parent;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap();
        parent = new HashMap();
        dfs(root, null);
        // System.out.println(depth);
        return depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y);
    }

    public void dfs(TreeNode node, TreeNode par){
        if(node != null){
            depth.put(node.val, par == null? 0: depth.get(par.val) + 1);
            parent.put(node.val, par == null ? -1 : par.val);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
    /*  
    public boolean isCousins(TreeNode root, int x, int y) {
        if(isBrother(root, x, y)){
            return false;
        }
        int depthX = countDepth(root, x, 0);
        int depthY = countDepth(root, y, 0);
        return depthX == depthY;
    }

    public static int countDepth(TreeNode root, int x, int depth){
        if(root == null){
            return 0;
        }
        if(root.val == x){
            return depth;
        } else{
            return Math.max(countDepth(root.left, x, depth + 1), countDepth(root.right, x, depth + 1));
        }
    }

    public static boolean isBrother(TreeNode root, int x, int y){
        if(root == null){
            return false;
        }
        else if(root.left != null && root.right != null && root.left.val == x && root.right.val == y){
            return true;
        }else if(root.left != null && root.right != null && root.left.val == y && root.right.val == x){
            return true;
        }else{
            return isBrother(root.left, x, y) || isBrother(root.right, x, y);
        }
    }
    // */
}
// @lc code=end

