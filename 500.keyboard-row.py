#
# @lc app=leetcode id=500 lang=python3
#
# [500] Keyboard Row
#

# @lc code=start
class Solution:
    def findWords(self, words: List[str]) -> List[str]:
        res = []
        rows = ['qwertyuiop', 'asdfghjkl', 'zxcvbnm']
        for word in words:
            flag = True
            row = -1
            for c in word:
                for i in range(len(rows)):
                    if c.lower() in rows[i]:
                        if row == -1:
                            row = i
                        elif i != row:
                            flag = False
                            break
            if flag:
                res.append(word)
        return res
# @lc code=end

