#
# @lc app=leetcode id=917 lang=python3
#
# [917] Reverse Only Letters
#

# @lc code=start
class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        i = 0
        j = len(S) - 1
        ans = ['' for _ in range(len(S))]

        # When using subscripts, pay attention to the corss-border issue.
        # do not use 'i<=j' because i+1 may out of range.
        while i < j:
            if not S[i].isalpha():
                ans[i] = S[i]
                i += 1
            if not S[j].isalpha():
                ans[j] = S[j]
                j -= 1
            if S[i].isalpha() and S[j].isalpha() and i < j:
                ans[i] = S[j]
                ans[j] = S[i]
                i += 1
                j -= 1
        
        # Handle the element where i is equal to j.
        if i == j:
            ans[i] = S[i]
        return ''.join(ans)
# @lc code=end

