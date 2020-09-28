import java.util.Arrays;

/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        int count = nums.length;
        Integer[] numbers = new Integer[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = nums[i];
        }

        Arrays.sort(numbers, (o1, o2) -> helper(String.valueOf(o1), String.valueOf(o2)));

        // 如果nums只包含0，则直接返回“0”
        if (numbers[0].equals(0)) return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(numbers[i]);
        }
        
        return sb.toString();
    }

    /**
     * 实际的比较器函数。
     * 注意：这里要用字符串，不能用数字，因为字符串转数字可能会丢0，如“060”
     * @param o1
     * @param o2
     * @return
     */
    private int helper(String o1, String o2) {
        if (o1.equals(o2)) return 0;

        int minLength = Math.min(o1.length(), o2.length());
        int i = 0, a = 0, b = 0;
        while (i < minLength) {
            a = (int) o1.charAt(i);
            b = (int) o2.charAt(i);
            if (a > b) return -1;
            else if (a < b) return 1;
            else i++;
        } 
        // 如果没有返回，说明o1和o2的一部分是相同的，如234，2343
        // 此时需要比较长的数字的剩余部分和较短数字，使用递归
        if (o1.length() > o2.length()) {
            return helper(o1.substring(minLength), o2);
        } else {
            return helper(o1, o2.substring(minLength));
        }
    }
}
// @lc code=end

/**
 * 其实就是写一个比较器，
 * 1. 首先按照第一个数字排序，从小到大，如果相同就比较第二位。
 * 2. 如果其中一个比较短，如a=23和b=23234比较，则应该比较b后面的三位和a进行比较，使用递归
 * 3. 注意要使用字符串，因为例如"023"这样的字符串转为数字，会丢失第一个0.
 */