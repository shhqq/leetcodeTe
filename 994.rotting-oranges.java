/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        /*
        用一个queue存储上次的2，然后遍历存储的2，将周围的1变成2，这样新变为的2不会遍历
        但是这样需要每次遍历所有的2，以前已经判断的2会重复判断.

        第二种：
            第一次，将2相邻的1改为-1
            第二次，将-1相邻的1改为-2。。。
            直到坏橘子周围没有1
            最后检查是否还剩有1，如果有，应返回-1
            这样就不用重复判断每个2周围是否有1，而是只判断上次变为rotting的
            数字周围有没有1.

        */

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
            i++;
            int temp = i == 1 ? 2 : -i+1;
            for(int j = 0; j < row; j++){
                for(int k = 0; k < column; k++){
                    if(grid[j][k] == temp){                 // 上次变坏的橘子
                        if(j > 0 && grid[j-1][k] == 1){
                            grid[j-1][k] = -i;
                            exist1 = true;
                        }
                        if(j < row - 1 && grid[j+1][k] == 1){
                            grid[j+1][k] = -i;
                            exist1 = true;
                        }
                        if(k > 0 && grid[j][k-1] == 1){
                            grid[j][k-1] = -i;
                            exist1 = true;
                        }
                        if(k < column - 1 && grid[j][k+1] == 1){
                            grid[j][k+1] = -i;
                            exist1 = true;
                        }
                    }
                }
            }
        }
        for(int j = 0; j< row; j++){
            for(int k = 0; k < column; k++){
                if(grid[j][k] == 1){
                    return -1;
                }
            }
        }
        return i - 1;
    }
}
// @lc code=end

