#
# @lc app=leetcode id=290 lang=python3
#
# [290] Word Pattern
#

# @lc code=start
class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:
# Use set to guarantee a full match.
# Use a hash table to storage the relationship.
        words = str.split()
        if len(pattern) != len(words) or len(set(words)) != len(set(pattern)):
            return False
        mode = {}
        for i in range(len(pattern)):
            c = pattern[i]
            if c in mode.keys():
                if words[i] != mode[c]:
                    return False
            else:
                mode[c] = words[i]
        return True
# @lc code=end

