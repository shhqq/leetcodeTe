#
# @lc app=leetcode id=344 lang=python3
#
# [344] Reverse String
#

# @lc code=start
class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        l = len(s)
        if l == 0:
            return 
        else:
            for i in range(l // 2):
                temp = s[i]
                s[i] = s[l -1-i]
                s[l-1-i] = temp
        
# @lc code=end

