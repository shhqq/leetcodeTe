/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]){
            return false;
        }

        // 一步搜索，将矩阵拉伸为一维数组。时间复杂度log(2n)
        // 
        int left = 0;
        int right = row * col - 1;
        int middle = (left + right) / 2;
        
        while (left < middle){
            int i = middle / col;       // number of row;
            int j = middle % col;       // number of column;
            if (target == matrix[i][j]){
                return true;
            } else if (target > matrix[i][j]){
                left = middle;
            } else {
                right = middle;
            }
            middle = (left + right) / 2;
        }
        
        return (target == matrix[middle / col][middle % col] || target == matrix[row-1][col-1]) ? true: false;


        /*
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]){
            return false;
        }

        // 两步搜索，第一步搜索行，第二步搜索列。时间复杂度log(n) * log(n)
        // step 1: find the possible row of the target.
        int left = 0;
        int right = row;
        int middle = (left + right) / 2;
        
        while (left < middle){
            if (target == matrix[middle][0]){
                return true;
            } else if (target > matrix[middle][0]){
                left = middle;
            } else {
                right = middle;
            }
            middle = (left + right) / 2;
        }
        // step 2: find the possible index of target in the line.
        int line = left;
        left = 0; 
        right = col;
        middle = (left + right) / 2;
        while (left < middle){
            if (target == matrix[line][middle]){
                return true;
            } else if (target < matrix[line][middle]){
                right = middle;
            } else {
                left = middle;
            }
            middle = (left + right) / 2;
        }
        return target == matrix[line][middle] ? true: false;
        // */
    }
}
// @lc code=end

