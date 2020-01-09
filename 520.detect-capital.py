#
# @lc app=leetcode id=520 lang=python3
#
# [520] Detect Capital
#

# @lc code=start
class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        if len(word) == 1 or word.islower() or word.isupper():
            return True
        else:
            s = word[1: len(word)]
            return s.lower() == s
# @lc code=end

