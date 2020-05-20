import java.util.ArrayList;
import java.util.List;


/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new ArrayList<TreeNode>();
        }
        return generateTrees(n, 1);
    }

    private List<TreeNode> generateTrees(int n, int start){
        List<TreeNode> ans = new ArrayList<>();
        if(n < start){
            ans.add(null);
            return ans;
        }
        if(n == start){
            ans.add(new TreeNode(start));
            return ans;
        }

        for (int i = start; i <= n; i++){
            List<TreeNode> leftList = generateTrees(i - 1, start);
            List<TreeNode> rightList = generateTrees(n, i + 1);
            for (int j = 0; j < leftList.size(); j++){
                for (int k = 0; k < rightList.size(); k++){
                    TreeNode t = new TreeNode(i);
                    t.left = leftList.get(j);
                    t.right = rightList.get(k);
                    ans.add(t);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

