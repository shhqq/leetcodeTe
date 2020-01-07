#
# @lc app=leetcode id=482 lang=python3
#
# [482] License Key Formatting
#

# @lc code=start
class Solution:
    def licenseKeyFormatting(self, S: str, K: int) -> str:
        length_dash = S.count('-')
        length_except_dash = len(S) - length_dash
        first_group = length_except_dash % K
        if first_group == 0:
            first_group = K
        s_upper = S.upper()
        res = ''
        for i in range(len(s_upper)):
            temp = s_upper[i]
            if temp != '-' and len(res) < first_group:
                res += temp
            elif temp != '-' and (len(res) - first_group - res.count('-')) % K == 0:
                res = res + '-' + temp
            elif temp != '-':
                res += temp
        return res
# @lc code=end

