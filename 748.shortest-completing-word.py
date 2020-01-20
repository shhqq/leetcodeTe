#
# @lc app=leetcode id=748 lang=python3
#
# [748] Shortest Completing Word
#

# @lc code=start
class Solution:
    def shortestCompletingWord(self, licensePlate: str, words: List[str]) -> str:
        lp = licensePlate.lower()
        letters = {}
        for i in lp:
            if i.isalpha():
                if i in letters.keys():
                    letters[i] += 1
                else:
                    letters[i] = 1
        
        word_dic = {}
        for w in words:
            if len(w) in word_dic.keys():
                word_dic[len(w)].append(w)
            else:
                word_dic[len(w)] = [w]
        
        # print(letters)
        # print(word_dic)
        for length_word in range(min(word_dic.keys()), max(word_dic.keys())+1):
            if length_word in word_dic.keys():
                for w in word_dic[length_word]:
                    for c in letters:
                        if w.count(c) < letters[c]:
                            break
                    else:
                        return w
# @lc code=end

