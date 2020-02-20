#
# @lc app=leetcode id=824 lang=python3
#
# [824] Goat Latin
#

# @lc code=start
class Solution:
    def toGoatLatin(self, S: str) -> str:
        vowel = ['a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U']
        words = S.split(' ')
        ans = ''
        for i in range(len(words)):
            if words[i][0] in vowel:
                ans += words[i]
            else:
                ans += words[i][1: len(words[i])] + words[i][0]
            ans += 'ma' + 'a' * (i+1)
            if i != len(words) - 1:
                ans += ' '
        return ans
# @lc code=end

