/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        // Whether grid has a value of 2.
        boolean exist2 = false;
        boolean exist1 = false;
        int row = grid.length;
        int column = grid[0].length;
        for(int j = 0; j < row; j++){
            for(int k = 0; k < column; k++){
                if(grid[j][k] == 2){
                    exist2 = true;
                }
                else if(grid[j][k] == 1){
                    exist1 = true;
                }
            }
        }
        if(!exist2 && !exist1)return 0;
        else if(!exist2) return -1;      // if there is no 2 in grid.
        else if(!exist1) return 0;

        int i = 0;
        
        while(exist1){
            exist1 = false;
            for(int j = 0; j < row; j++){
                for(int k = 0; k < column; k++){
                    if(grid[j][k] == 1){
                        exist1 = true;
                        if(have2(grid, j, k)){
                            grid[j][k] = -1;
                        }else if(all0(grid, j, k)){
                            return -1;
                        }
                    }
                }
            }
            for(int j = 0; j < row; j++){
                for(int k = 0; k < column; k++){
                    if(grid[j][k] == -1){
                        grid[j][k] = 2;
                    }
                }
            }
            
            i++;
        }
        return i - 1;
    }

    public boolean have2(int[][] grid, int j, int k){
        int row = grid.length;
        int column = grid[0].length;
        if(j > 0 && grid[j-1][k] == 2){
            return true;
        } else if(j < row - 2 && grid[j+1][k] == 2){
            return true;
        }else if(k>0 && grid[j][k-1] == 2){
            return true;
        }else if(k<column-2 && grid[j][k+1] == 2){
            return true;
        }else{
            return false;
        }
    }

    public boolean all0(int[][] grid, int j, int k){
        int row = grid.length;
        int column = grid[0].length;
        if(j > 0 && grid[j-1][k] != 0){
            return false;
        } else if(j < row - 1 && grid[j+1][k] != 0){
            return false;
        }else if(k > 0 && grid[j][k-1] != 0){
            return false;
        }else if(k < column - 1 && grid[j][k+1] != 0){
            return false;
        }else{
            return true;
        }
    }
}
// @lc code=end

