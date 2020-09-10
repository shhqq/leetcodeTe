/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // solution 1
        // 从一个gas不小于cost的index开始，依次往后走，计算还剩多少gas
        /*
        for (int i = 0; i < gas.length; i++) {
            // 起点的gas必须不小于cost
            if (gas[i] >= cost[i]) {
                boolean flag = true;
                int remain = gas[i];
                for (int j = 0; j < gas.length; j++) {
                    int s = (i+j) % gas.length;
                    int next = (s+1) % gas.length;
                    remain = remain - cost[s] + gas[next];
                    if (remain < cost[next]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    return i;
                }
            }
        }
        return -1;
        */

        // solution 2
        // 可以用gas对应减去cost得到一个数组，然后从数组的正数开始，往后加，不能出现复数即可。
        // 并没有减少时间复杂度
        /*
        int n = gas.length;
        int[] remain = new int[n];
        for(int i = 0; i < n; i++) {
            remain[i] = gas[i] - cost[i];
        }
        
        int g = 0;
        for (int i = 0; i < n; i++) {
            if (remain[i] >= 0) {
                g = remain[i];
                for (int j = 0; j < n; j++) {
                    g += remain[(i+j+1) % n];
                    if(g < 0) {
                        break;
                    }
                }
                // 如果从这个循环出来，g>= 0，则可以。
                if (g >= 0) {
                    return i;
                }
            }
        }
        return -1;
        */

        // solution 3
        // 基于 1. 如果gas的和大于cost的和，那么一定存在解，因为保证了只有一个解，所以只需要找到满足条件的一个就可以
        // 2. 从做往后累加gas和cost的和，如果累加出负值，那么这一段中的都不能是起始点。
        // 3. 如果从某一个index开始，累加值一直到最后都是正值，那么这个点就是起始点，
        // 4. 假设这个点左侧还有一段累加是正值，那么它左边那一段的开始就会是起始点，所以假设不成立，
        // 即：不会错过起始点。

        // 需要一个值来记录gas和cost差值的和，如果 >=0 那么就存在解
        int total = 0;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];

            // tank用来记录中间的和，如果tank累加过程中出现负值，则要重新开始；start记录开始位置。
            if ((tank = tank + gas[i] - cost[i]) < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        // 如果total >= 0,则一定存在解，就是start
        return total >= 0 ? start: -1;

        /**
         * gas和大于cost和，为什么一定存在解？
         * 首先单独看每个index的gas和cost，如果gas[i] >= cost[i]，则标为green station，否则标为red station。
         * then，adjacent station of the same color 可以合并，最终肯定是G、R相隔出现，因为G之和大于等于R之和，
         * 所以一定存在某个G大于右侧的R，那么这两个就可以合并。一直这样合并下去，就证明了可以跑成一个圈。
         */
    }
}
// @lc code=end

