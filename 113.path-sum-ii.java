import java.util.ArrayList;
import java.util.List;
/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // algorithm 1
        // return pathSumMethod1(root, sum);

        // algorithm 2
        return pathSumMethod2(root, sum);
    }
    /**
     * Algorithm 1
     * use recursion.
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSumMethod1(TreeNode root, int sum){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        } else if (root.left == null && root.right == null){    // root is a leaf node.
            if(root.val == sum){
                List<Integer> temp = new ArrayList<>();
                temp.add(root.val);
                ans.add(temp);
                return ans;
            } else {
                return ans;
            }
        } else {                                                // root is not a leaf node.
            List<List<Integer>> temp = new ArrayList<>();
            if(root.left != null){                              // Recurse the left.
                temp.addAll(pathSum(root.left, sum - root.val));
            }
            if(root.right != null){                             // Recurse the right.
                temp.addAll(pathSum(root.right, sum - root.val));
            }
            if(temp.size() > 0) {                               // Add the value of root.
                for (List<Integer> l : temp){
                    l.add(0, root.val);
                }
            }
            return temp;
        }
    }

    /**
     * 使用backtrack
     * @param root
     * @param sum
     * @return
     */
    private List<List<Integer>> pathSumMethod2(TreeNode root, int sum){
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), root, sum);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> temp, TreeNode root, int sum){
        if(root == null){
            return;
        } else {
            if (root.left == null && root.right == null){
                if(root.val == sum){
                    temp.add(root.val);
                    ans.add(new ArrayList<>(temp));
                    temp.remove(temp.size() - 1);           // 这里要降后加入的删除
                }
            }
            if (root.left != null){
                temp.add(root.val);
                dfs(ans, temp, root.left, sum - root.val);
                temp.remove(temp.size() - 1);               // 这里要降后加入的删除
            }
            if(root.right != null){
                temp.add(root.val);
                dfs(ans, temp, root.right, sum - root.val);
                temp.remove(temp.size() - 1);               // 这里要降后加入的删除
            }
        }
    }
}
// @lc code=end

