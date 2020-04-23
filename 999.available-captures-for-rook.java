/*
 * @lc app=leetcode id=999 lang=java
 *
 * [999] Available Captures for Rook
 */

// @lc code=start
class Solution {
    public int numRookCaptures(char[][] board) {
        int row = 8, column = 8;
        int rowR = 0, colR = 0;
        for(int i = 0; i< row; i++){
            for (int j = 0; j < column; j++){
                if(board[i][j] == 'R'){
                    rowR = i;
                    colR = j;
                }
            }
        }
        int ans = 0;
        for(int i = rowR; i >= 0; i--){
            if (board[i][colR] == 'p'){
                ans++;
                break;
            }else if(board[i][colR] == 'B'){
                break;
            }
        }
        for(int i = rowR; i < row; i++){
            if (board[i][colR] == 'p'){
                ans++;
                break;
            }else if(board[i][colR] == 'B'){
                break;
            }
        }
        for(int i = colR; i>= 0; i--){
            if (board[rowR][i] == 'p'){
                ans++;
                break;
            }else if(board[rowR][i] == 'B'){
                break;
            }
        }
        for(int i = colR; i < column; i++){
            if (board[rowR][i] == 'p'){
                ans++;
                break;
            }else if(board[rowR][i] == 'B'){
                break;
            }
        }
        return ans;
    }
}
// @lc code=end

