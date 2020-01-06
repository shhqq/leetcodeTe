#
# @lc app=leetcode id=383 lang=python3
#
# [383] Ransom Note
#

# @lc code=start
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
# Use a set to storage charactors in ransomNote.
        ransom = set(ransomNote)
        for c in ransom:
            if c not in magazine:
                return False
            if magazine.count(c) < ransomNote.count(c):
                return False
        return True
# @lc code=end

