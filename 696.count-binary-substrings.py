#
# @lc app=leetcode id=696 lang=python3
#
# [696] Count Binary Substrings
#

# @lc code=start
class Solution:
    def countBinarySubstrings(self, s: str) -> int:
# solution 1:
# Find all the 
        length = len(s)
        if length == 0:
            return 0
        ans = 0
        for i in range(length - 1):
            if s[i] != s[i+1]:
                ans += 1
                for j in range(min(i, length - i - 2)):
                    if s[i] == s[i-j-1] and s[i+1] == s[i+1+j+1]:
                        ans += 1
                    else:
                        break
        return ans
# @lc code=end

