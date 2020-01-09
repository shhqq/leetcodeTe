#
# @lc app=leetcode id=541 lang=python3
#
# [541] Reverse String II
#

# @lc code=start
class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        res = ''
        s += '*' * (2*k - len(s) % (2*k))
        for i in range(0, len(s) // 2 // k, 1):
            res += ''.join(list(reversed(s[i*2*k: i*2*k+k])))
            res += s[i*2*k+k: (i+1)*2*k]
        return res.replace('*', '')
# @lc code=end

