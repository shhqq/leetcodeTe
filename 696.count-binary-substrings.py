#
# @lc app=leetcode id=696 lang=python3
#
# [696] Count Binary Substrings
#

# @lc code=start
class Solution:
    def countBinarySubstrings(self, s: str) -> int:
# solution 1:
# Find all the contiguous two charactors that are different,
# and then extend it.
        '''
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
        '''

# Solution 2:
# group the contiguous identical charactor.
# Then add the minimum of the contiguous two group length.
        ans = 0
        prev = 0
        cur = 1
        for i in range(1, len(s)):
            if s[i] == s[i-1]:
                cur += 1
            else:
                ans += min(prev, cur)
                prev = cur
                cur = 1
        return ans + min(prev, cur)
# @lc code=end

