import java.util.HashSet;

/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if (m * n < word.length()){
            return false;
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    HashSet<String> temp = new HashSet<>();
                    temp.add("r" + i + "c" + j);
                    if (existHelper(board, word, temp, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * The character at [row][col] equals to the first character of word.
     * @param board two dimension matrix of character.
     * @param word  word to check.
     * @param posiUsed  positions of character that has been used.
     * @param row       row number of board.
     * @param col       column number of board.
     * @return
     */
    private boolean existHelper(char[][] board, String word, HashSet<String> posiUsed, int row, int col){
        if(word.length() == 1){
            return true;
        }

        char c = word.charAt(1);

        if (row > 0 && board[row - 1][col] == c && !posiUsed.contains("r"+ (row - 1) + "c" + col)){
            posiUsed.add("r"+ (row - 1) + "c" + col);
            if (existHelper(board, word.substring(1), posiUsed, row - 1, col)){
                return true;
            }
            posiUsed.remove("r"+ (row - 1) + "c" + col);    // 这里，如果不满足，要将加入的位置删除掉，不然posiUsed会积累。
        }

        if (row < board.length - 1 && board[row + 1][col] == c && !posiUsed.contains("r"+ (row + 1) + "c" + col)){
            posiUsed.add("r"+ (row + 1) + "c" + col);
            if (existHelper(board, word.substring(1), posiUsed, row + 1, col)){
                return true;
            }
            posiUsed.remove("r"+ (row + 1) + "c" + col);
        }

        if (col > 0 && board[row][col - 1] == c && !posiUsed.contains("r"+ row + "c" + (col - 1))){
            posiUsed.add("r"+ row + "c" + (col - 1));
            if (existHelper(board, word.substring(1), posiUsed, row, col - 1)){
                return true;
            }
            posiUsed.remove("r"+ row + "c" + (col - 1));
        }

        if (col < board[0].length - 1 && board[row][col + 1] == c && !posiUsed.contains("r" + row + "c" + (col + 1))){
            posiUsed.add("r" + row + "c" + (col + 1));
            if (existHelper(board, word.substring(1), posiUsed, row, col + 1)){
                return true;
            }
            posiUsed.remove("r" + row + "c" + (col + 1));
        }

        return false;
    }
}
// @lc code=end

