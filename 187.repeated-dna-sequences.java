import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // 无论是使用set还是map，本质都是hash，
        // 但是不能使用List.contains()，String.indexOf()之类的函数，因为这种函数是使用遍历
        // 耗时比较长。
        return solution2(s);
    }

    /**
     * 使用set存储键
     * @param s
     * @return
     */
    private List<String> solution1(String s) {
        Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList(repeated);
    }

    /**
     * 使用Map存储key。
     * @param s
     * @return
     */
    private List<String> solution2(String s) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> subs = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String temp = s.substring(i, i + 10);
            if (!subs.containsKey(temp)) {
                subs.put(temp, 1);
            } else if (subs.get(temp) == 1){
                result.add(temp);
                subs.put(temp, 2);
            }
        }
        return result;
    }
}
// @lc code=end

/**
 * 为什么使用set不会超时，但是使用map就会超时？
 * 因为使用了String.indexOf(),并不是map的问题。
 */