import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    /**
     * 重写排序，将二维数组按照第一个值进行排序
     */
    private class IntervalComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b) {
            // TODO Auto-generated method stub
            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
        }
    }
    /**
     * 将二维数组按照第一个值进行升序排列。
     * 如果前一个的end大于等于后一个的start，则可以进行合并。
     * 如果前一个的end小于后一个的start，说明不能合并，直接加到merged即可。
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval: intervals) {
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                // 如果merged为空或者不可合并，则将新数组加到merged中。
                merged.add(interval);
            } else {
                // 如果可以合并，则更新end。
                merged.getLast()[1] = Math.max(interval[1], merged.getLast()[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
// @lc code=end

