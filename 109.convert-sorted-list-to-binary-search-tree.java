import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        // 将链表转换成数组，便于直接按索引进行取值。
        // Transform the Linked list to array so that we can get value by index.
        List<Integer> nums = new ArrayList<>();
        while (head != null){
            nums.add(head.val);
            head = head.next;
        }
        return sortedArrayToBST(nums, 0, nums.size()-1);
    }

    /**
     * 将排序的数组组成BST，分为左右两边。递归构成子树
     * Construct the binary search tree using sorted array.
     * @param nums sorted array.
     * @param start start index of array.
     * @param end end index of array.
     */
    private TreeNode sortedArrayToBST(List<Integer> nums, int start, int end){
        if(start > end){
            return null;
        } else if (start == end){
            return new TreeNode(nums.get(start));
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }
}
// @lc code=end

