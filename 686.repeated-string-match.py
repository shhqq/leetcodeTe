#
# @lc app=leetcode id=686 lang=python3
#
# [686] Repeated String Match
#

# @lc code=start
class Solution:
    def repeatedStringMatch(self, A: str, B: str) -> int:

# If B contains more types of characters than A, then return -1.
# If length of s is greater than length of B and s is more than 2 times
# of repeated A, then it is impossible that B is substring of s.
        if len(set(A)) < len(set(B)):
            return -1
        times = 1
        
        while True:
            s = A * times
            if B in s:
                return times
            else:
                if times > 2 and len(s) > 2 * len(B):
                    return -1
                else:
                    times += 1
# @lc code=end

