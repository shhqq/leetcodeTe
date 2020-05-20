import java.util.Stack;


/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeMethod2(preorder, inorder);
    }

    // algorithm1 不使用递归，使用迭代
    private TreeNode buildTreeMethod2(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        } else {
            Stack<TreeNode> s = new Stack<>();
            TreeNode root = new TreeNode(preorder[0]);
            TreeNode cur = root;
            // 前序遍历结果中，每个值n的后一个值，要么是n的左节点，要么是n的右节点（无左节点），要么是n父节点的右节点，或者再往上推的右节点
            for(int i = 1, j = 0; i < preorder.length; i++){
                if (cur.val != inorder[j]){                 // 此时该节点有左节点
                    cur.left = new TreeNode(preorder[i]);   
                    s.push(cur);                            // 将当前节点存入栈，便于后续生成右节点
                    cur = cur.left;
                } else {                                    // 此时该节点无左节点
                    j++;
                    while (!s.isEmpty() && s.peek().val == inorder[j]) {    // 此时该节点无右节点
                        cur = s.pop();                          // 向上返回
                        j++;
                    }
                    cur.right = new TreeNode(preorder[i]);
                    cur = cur.right;
                }
            }
            return root;
        }
    }
    
    // algorithm2 使用递归，构建子树
    private TreeNode buildTreeMethod1(int[] preorder, int[] inorder){
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length){
            return null;
        }else if(preorder.length == 1){
            return new TreeNode(preorder[0]);
        } else {
            TreeNode root = new TreeNode(preorder[0]);
            int indexOfRoot = 0;
            for(int i = 0; i< inorder.length; i++){
                if(inorder[i] == preorder[0]){
                    indexOfRoot = i;
                    break;
                }
            }
            int[] leftArrayPre = getSubArray(preorder, 1, indexOfRoot);
            int[] rightArrayPre = getSubArray(preorder, indexOfRoot + 1, preorder.length - 1);
            int[] leftArrayIn = getSubArray(inorder, 0, indexOfRoot - 1);
            int[] rightArrayIn = getSubArray(inorder, indexOfRoot + 1, inorder.length - 1);
            root.left = buildTree(leftArrayPre, leftArrayIn);
            root.right = buildTree(rightArrayPre, rightArrayIn);
            return root;
        }
    }
    /**
     * 获取数组中索引在start到end（包含）之间的子数组
     * @param array Array
     * @param start start index of array.
     * @param end   end index of array.
     * @return      sub array.
     */
    private int[] getSubArray(int[] array, int start, int end){
        if(start < 0 || end > array.length || start > end){
            return new int[0];
        }
        int [] subArray = new int[end - start + 1];
        for(int i = start; i <= end; i++){
            subArray[i - start] = array[i];
        }
        return subArray;
    }
}
// @lc code=end

