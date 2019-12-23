#
# @lc app=leetcode id=242 lang=python3
#
# [242] Valid Anagram
#

# @lc code=start
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
# Two strings is anagram when they contain the same alphabets
# and the same amount of each alphabet.
        a = set(s)
        b = set(t)
        if a != b:
            return False
        for c in a:
            if s.count(c) != t.count(c):
                return False
        return True
# @lc code=end

