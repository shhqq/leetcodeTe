#
# @lc app=leetcode id=13 lang=python3
#
# [13] Roman to Integer
#

# @lc code=start
class Solution:
    def romanToInt(self, s: str) -> int:
        sym = {"I": 1, "V": 5, "X": 10,
        "L": 50, "C": 100, "D": 500, "M": 1000}
        result = 0
        # temp = ""
        length = len(s)
        j = 0
        for _ in range(length):
            if j >= length:
                break
            if j < length-1:
                if sym[s[j+1]] > sym[s[j]]:
                    result += sym[s[j+1]]-sym[s[j]]
                    j += 2
                else:
                    result += sym[s[j]]
                    j += 1
            else:
                result += sym[s[j]]
                j += 1
        return result 

# @lc code=end

