#
# @lc app=leetcode id=459 lang=python3
#
# [459] Repeated Substring Pattern
#

# @lc code=start
class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
# str.find(sub[, start[, end]])
        length = len(s)
        start  = 1
        end = length // 2 + 2
        first_c = s[0]

        while start < end:
            # Find the next char in a slice.
            temp = s.find(first_c, start, end)
            if temp == -1:  
                return False
            if s == s[0: temp] * (length // temp):
                return True
            start = temp + 1
        return False
# @lc code=end

