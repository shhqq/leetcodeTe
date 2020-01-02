#
# @lc app=leetcode id=345 lang=python3
#
# [345] Reverse Vowels of a String
#

# @lc code=start
class Solution:
    def reverseVowels(self, s: str) -> str:
        vowel = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']
        res = ['' for _ in range(len(s))]
        i = 0
        j = len(s) - 1
        while i <= j:
            if s[i] not in vowel:
                res[i] = s[i]
                i += 1
                continue
            if s[j] not in vowel:
                res[j] = s[j]
                j -= 1
                continue
            if s[i] in vowel and s[j] in vowel:
                res[i] = s[j] 
                res[j] = s[i]
                i += 1
                j -= 1
        return ''.join(res)
# @lc code=end

