#
# @lc app=leetcode id=205 lang=python3
#
# [205] Isomorphic Strings
#

# @lc code=start
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        d_s = {}
        d_t = {}
        for i in range(len(s)):
            if s[i] not in d_s.keys():
                d_s[s[i]] = t[i]
            else:
                if t[i] != d_s[s[i]]:
                    return False
            if t[i] not in d_t.keys():
                d_t[t[i]] = s[i]
            else:
                if s[i] != d_t[t[i]]:
                    return False
        return True


# @lc code=end

