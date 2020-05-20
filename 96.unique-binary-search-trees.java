/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        if(n == 0){
            return 0;
        }
        // 使用数组存储中间值，可以不使用递归
        int[] countTrees = new int[n+1];
        for(int i = 0; i<= n; i++){
            if(i<2){
                countTrees[i] = 1;
            } else {
                int count = 0;
                for(int j = 0; j < i; j++){
                    // 左节点排列数乘以右节点排列数
                    count += countTrees[j] * countTrees[i - 1 - j];
                }
                countTrees[i] = count;
            }
        }
        return countTrees[n];
    }
}
// @lc code=end

