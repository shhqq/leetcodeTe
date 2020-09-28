/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        System.out.println("ver1" + ver1.length);
        int n1 = ver1.length;
        int n2 = ver2.length;
        int n = n1 > n2 ? n1 : n2;
        for (int i = 0; i < n; i++) {
            int v1 = i >= n1? 0 : Integer.parseInt(ver1[i]);
            int v2 = i >= n2? 0 : Integer.parseInt(ver2[i]);
            System.out.println(i);
            System.out.println(v1);
            System.out.println(v2);
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }
    // public static void main(String[] args) {
    //     Solution1 s = new Solution1();
    //     int n = s.compareVersion("0.1", "1.1");
    //     System.out.println(n);
    //     System.out.println("hello world");
    // }
}
// @lc code=end

