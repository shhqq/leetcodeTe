#
# @lc app=leetcode id=28 lang=python3
#
# [28] Implement strStr()
#

# @lc code=start
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0
        elif len(haystack) == 0:
            return -1
        for i in range(len(haystack) - len(needle) + 1):
            if haystack[i] == needle[0]:
                flag = True
                for j in range(1, len(needle)):
                    if haystack[i + j] != needle[j]:
                        flag = False
                        break
                if flag:
                    return i
        return -1
# @lc code=end

