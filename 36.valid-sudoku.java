import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> values = new HashSet<>();

        int row = 9;
        int col = 9;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = board[i][j];
                if(c == '.'){
                    continue;
                }
                if (!values.add("r" + i + "v" + c)
                        || !(values.add("c" + j + "v" + c)) || !(values.add("b" + i / 3 + j / 3 + "v" + c))) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
