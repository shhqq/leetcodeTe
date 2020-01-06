#
# @lc app=leetcode id=387 lang=python3
#
# [387] First Unique Character in a String
#

# @lc code=start
class Solution:
    def firstUniqChar(self, s: str) -> int:
# Use a list to storage charactors which appear more than once.
        repeated = []
        for i in range(len(s)):
            if s[i] not in repeated:
                if s.count(s[i]) == 1:
                    return i
                else:
                    repeated.append(s[i])
        return -1
# @lc code=end

