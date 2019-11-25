#
# @lc app=leetcode id=58 lang=python3
#
# [58] Length of Last Word
#

# @lc code=start
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        words = s.strip().split(' ')
        return len(words[-1])
        # i = 0
        # while len(words[-1-i]) == 0 and i<len(words)-1:
        #     i += 1
        # return len(words[-1 - i])
# @lc code=end

