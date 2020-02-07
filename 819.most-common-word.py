#
# @lc app=leetcode id=819 lang=python3
#
# [819] Most Common Word
#

# @lc code=start
class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        para = paragraph.lower()+'.'
        words = {}
        left = 0
        right = 0
        isword = False
        for i in range(len(para)):
            if para[i].isalpha():
                if isword:
                    right += 1
                else:
                    isword = True
                    left = right = i
            else:
                if isword:
                    w = para[left: right + 1]
                    if w not in banned:
                        if w in words.keys():
                            words[w] += 1
                        else:
                            words[w] = 1
                isword = False
        c = 0
        ans = ''
        for i in words.items():
            if i[1] > c:
                c = i[1]
                ans = i[0]
        return ans
# @lc code=end

