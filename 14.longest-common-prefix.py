#
# @lc app=leetcode id=14 lang=python3
#
# [14] Longest Common Prefix
#

# @lc code=start
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 0:
            return ""
        elif len(strs) == 1:
            return strs[0]
        
        prefix = strs[0]
        
        for i in range(1, len(strs)):
            flag = True
            min_len = min(len(prefix), len(strs[i]))
            for j in range(min_len):
                if prefix[j] != strs[i][j]:
                    if j == 0:
                        return ""
                    else:
                        flag = False
                        prefix = prefix[0: j]
                        break
            # 如果没有冲突，则要返回两个中较短的
            if flag:
                prefix = prefix[0: min_len]
        return prefix
            


# @lc code=end

