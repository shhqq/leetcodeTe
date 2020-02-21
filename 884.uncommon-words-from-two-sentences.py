#
# @lc app=leetcode id=884 lang=python3
#
# [884] Uncommon Words from Two Sentences
#

# @lc code=start
class Solution:
    def uncommonFromSentences(self, A: str, B: str) -> List[str]:
# the word only occurs once in A + B.

        count = {}
        for w in A.split():
            count[w] = count.get(w, 0) + 1
        for w in B.split():
            count[w] = count.get(w, 0) + 1
        
        ans = [w for w in count.keys() if count[w] == 1]
        return ans
        '''
        words_a = A.split(' ')
        dic_a = {}
        for w in words_a:
            if w != ' ':
                if w not in dic_a.keys():
                    dic_a[w] = 1
                else:
                    dic_a[w] += 1
        
        words_b = B.split(' ')
        dic_b = {}
        for w in words_b:
            if w != ' ':
                if w not in dic_b.keys():
                    dic_b[w] = 1
                else:
                    dic_b[w] += 1
        
        ans = []
        for k in dic_a.keys():
            if dic_a[k] == 1 and k not in dic_b.keys():
                ans.append(k)
        for k in dic_b.keys():
            if dic_b[k] == 1 and k not in dic_a.keys():
                ans.append(k)
        
        return ans
        '''
# @lc code=end

