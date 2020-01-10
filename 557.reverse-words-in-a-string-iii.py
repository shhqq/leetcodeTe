#
# @lc app=leetcode id=557 lang=python3
#
# [557] Reverse Words in a String III
#

# @lc code=start
class Solution:
    def reverseWords(self, s: str) -> str:
# Firstly, split the sentence, then reverse every single word.
        # ws = s.split(' ')
        # for i in range(len(ws)):
        #     temp = ws[i]
        #     new_w = list(reversed(temp))
        #     ws[i] = ''.join(new_w)
        # return ' '.join(ws)

# Reverse the sentence firstly, then split the sentence.
# Reverse the splitting result, then join them with space.
        new_s = ''.join(list(reversed(s)))
        ws = new_s.split(' ')
        ws.reverse()
        return ' '.join(ws)
# @lc code=end

