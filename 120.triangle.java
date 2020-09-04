/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    private int minSum = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        // minimumTotalHelper(triangle);
        dp(triangle);
        return minSum;
    }

    /**
     * algorithm 1.
     * 使用动态规划，可以减少时间，避免递归。
     * @param triangle
     */
    private void dp(List<List<Integer>> triangle){
        if(triangle.size() == 1){
            minSum = triangle.get(0).get(0);
        } else{
            // 申请一个数组，长度为倒数第二行元素的个数
            // 没必要，直接修改triangle即可
            //int[] temp = new int[triangle.size() - 1];
            for(int i = triangle.size() - 2; i >= 0; i--){
                for(int j = 0; j < triangle.get(i).size(); j++){
                    // 从倒数第二层开始。
                    // 在第i层，将每个元素加上第i+1层的左右值中的较小值。
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
                }
            }
            minSum = triangle.get(0).get(0);
        }
    }

    /**
     * algorithm 2
     * 使用backtrack递归进行遍历，这样会超时
     */
    private void minimumTotalHelper(List<List<Integer>> triangle){
        if(triangle.size() == 0){
            minSum = 0;
            return;
        }
        
        for(int i = 0; i < triangle.get(0).size(); i++){
            minimumValue(triangle, 1, i, triangle.get(0).get(i));
        }
    }

    /**
     * backtrack递归函数
     * @param triangle array
     * @param layer current layer.
     * @param index current index.
     * @param sumTemp temp sum.
     */
    private void minimumValue(List<List<Integer>> triangle, int layer, int index, int sumTemp){
        if(layer == triangle.size()){
            minSum = Math.min(sumTemp, minSum);
        } else {
            // 每个元素的左下方
            sumTemp += triangle.get(layer).get(index);
            minimumValue(triangle, layer + 1, index, sumTemp);
            sumTemp -= triangle.get(layer).get(index);

            // 每个元素的右下方
            sumTemp += triangle.get(layer).get(index + 1);
            minimumValue(triangle, layer + 1, index + 1, sumTemp);
            sumTemp -= triangle.get(layer).get(index + 1);
        }
    }
}
// @lc code=end

