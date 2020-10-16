import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 */

// @lc code=start
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2) return false;
        if (k < 1 || t < 0) return false;

        // 桶的大小设为1L+t，加1是为了避免t= 0的情况
        long w = 1L + t;
        // 构建桶
        Map<Long, Long> bucket = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 首先获取桶的id
            long id = getId(nums[i], w);
            // 有几种情况可以判断存在结果为true
            // 1. 这个桶已经有元素存在了，因为桶的宽度为t，所以两个元素差绝对值一定 <=t
            // 2. 左侧相邻的桶里存在元素e，使得nums[i] - e <= t
            // 3. 右侧相邻的桶里存在元素e，使得e - nums[i] <= t
            if (bucket.containsKey(id) ||
                bucket.containsKey(id-1) && nums[i] - bucket.get(id - 1) <= t ||
                bucket.containsKey(id+1) && bucket.get(id+1) - nums[i] <= t) {
                    return true;
            }
            // 窗口向右移动时，需要移除左侧的边界
            if (bucket.size() == k) {
                bucket.remove(getId(nums[i - k], w));
            }

            // 将当前值放入bucket中
            bucket.put(id, Long.valueOf(nums[i]));
        }
        
        return false;
    }

    private long getId(long num, long w) {
        // num可能为负数，因此，减去Integer.MIN_VALUE，获取偏移量。
        // 偏移量除以w，整数部分就是桶的编号。
        return (num - Integer.MIN_VALUE) / w;
    }
}
// @lc code=end

