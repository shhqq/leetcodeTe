import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
    public int countNodes(TreeNode root) {
        return solution3(root);
    }

    /**
     * solution1:
     * 最简单的方法使用BFS，稍微修改一下可以适用于所有的二叉树。
     * @param root
     * @return
     */
    private int solution1(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        int count = 1;
        while (nodes.size() > 0) {
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode n: nodes) {
                if (n.left != null) {
                    temp.add(n.left);
                } else {
                    return count + temp.size();
                }
                if (n.right != null) {
                    temp.add(n.right);
                } else {
                    return count + temp.size();
                }
            }
            count += temp.size();
            nodes = temp;
        }
        return count;
    }

    /**
     * solution2:
     * 使用递归，这个也适用于所有的二叉树，但没有用到完全二叉树的特性。
     * @param root
     * @return
     */
    private int solution2(TreeNode root) {
        if (root == null) return 0;
        return solution2(root.left) + solution2(root.right) + 1;
    }

    /**
     * solution3：
     * 第三种是对递归的优化。利用完全二叉树的结构
     * 如果左子树高度==右子树高度，说明左子树为：完美二叉树；
     * 如果左子树高度 = 右子树高度+1，说明右子树为：完美二叉树。
     * 完美二叉树的节点数直接使用公式 2^h-1 ,h为高度
     * @param root
     * @return
     */
    private int solution3(TreeNode root) {
        int h = calHeight(root);
        if (h == 0) return h;
        if (calHeight(root.right) == h-1) {
            // 此时左子树为满二叉树，高度为h-1
            return (1<<h-1) + solution3(root.right);
        } else {
            // 此时，右子树为满二叉树，高度为h-2
            return (1<<h-2) + solution3(root.left);
        }
    }
    private int calHeight(TreeNode root) {
        int h = 0;
        while (root != null) {
            root = root.left;
            h++;
        }
        return h;
    }
}
// @lc code=end

