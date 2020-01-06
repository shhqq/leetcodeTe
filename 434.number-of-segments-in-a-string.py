#
# @lc app=leetcode id=434 lang=python3
#
# [434] Number of Segments in a String
#

# @lc code=start
class Solution:
    def countSegments(self, s: str) -> int:
        count = 0
        # whether the previous element is space or not. 
        space = True
        for i in range(len(s)):
            if s[i] != ' ' and not space:
                continue
            elif s[i] != ' ' and space: # the previous is space and the current is not space.
                count += 1
                space = False
            elif s[i] == ' ' and not space:
                space = True
        return count
# @lc code=end

