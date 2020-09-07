/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    /**
     * 这是一个深度优先算法案例，从某个节点开始，开始深度遍历，直到头。一般使用递归。
     */
    public void solve(char[][] board) {
        // 如果board为空，或者行数小于等于2，或者前两者不满足时，列数小于3，则不做改变。
        if (board == null || board.length <= 2 || board[0].length <= 2) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        
        // 从四个边开始入手，如果是O，则进行递归检查它的邻居
        // 这里已经保证了board的行和列都大于2。
        for (int i = 0; i < row; i++) {
            checkNeighbor(board, i, 0, row, col);
            checkNeighbor(board, i, col - 1, row, col);
        }
        for (int j = 0; j < col; j++) {
            checkNeighbor(board, 0, j, row, col);
            checkNeighbor(board, row - 1, j, row, col);
        }

        // 第二步是将所有的O标记为X，将所有的B标记为O
        for(int i = 1; i < row - 1; i++){
            for (int j = 1; j < col - 1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for(int i = 0; i < row; i++){
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
     * 用来判断board中第(i,j)处及其周围四个，如果是O，则进行递归判断
     */
    private void checkNeighbor(char[][] board, int i, int j, int row, int col) {
        if (board[i][j] == 'O') {
            board[i][j] = 'B';
            // 再检查周围的四个，进行递归
            if (i > 1) {
                checkNeighbor(board, i-1, j, row, col);
            }
            if (j > 1) {
                checkNeighbor(board, i, j-1, row, col);
            }
            if (i < row - 1) {
                checkNeighbor(board, i+1, j, row, col);
            }
            if (j < col - 1) {
                checkNeighbor(board, i, j+1, row, col);
            }
        }
    }
}
// @lc code=end

