/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        /**
         * 将第一行和第一列作为该行或该列是否包含0的标记；
         * matrix[0][0]重复，因此需要额外的值来标记第一行（或第一列）是否包含0；
         * 
         */
        boolean firstRow = false;
        int row = matrix.length;
        int col = matrix[0].length;
        // 标记第一行是否含有0
        for(int i = 0; i < col; i++){
            if (matrix[0][i] == 0){
                firstRow = true;
            }
        }

        // 除第一行外，用第一行和第一列标记该行或该列是否包含0
        for (int i = 1; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // 除了第一行和第一列，将其他的位置设置为0
        for (int i = 1; i < row; i++){
            for (int j = 1; j < col; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // 先处理第一列
        if (matrix[0][0] == 0){
            for(int i = 0; i < row; i++){
                matrix[i][0] = 0;
            }
        }

        // 再处理第一行
        if (firstRow){
            for(int i = 0; i < col; i++){
                matrix[0][i] = 0;
            }
        }
    }
}
// @lc code=end

