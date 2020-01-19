#
# @lc app=leetcode id=720 lang=python3
#
# [720] Longest Word in Dictionary
#

# @lc code=start
class Solution:
    def longestWord(self, words: List[str]) -> str:
# Firstly, generate a dictionary to storage key: l and value:
# list of words which have length of l.
# Secondly, find words in dic[i+1] which the previous i substring
# is in the dic[i].
# Thirdly, if dic.keys doesn't contain i+1 or reach the maximum 
# of length, return the minimum word.
        dic = {}
        for w in words:
            l = len(w)
            if l in dic.keys():
                dic[l].append(w)
            else:
                dic[l] = [w]
        length_of_shortest_word = min(dic.keys())

        ws = dic[length_of_shortest_word]
        # From the shortest to the longest.
        for i in range(length_of_shortest_word, max(dic.keys())):
            next_ws = []
            if i+1 not in dic.keys():
                return min(ws)
            else:
                for w in dic[i+1]:
                    if w[0: i] in ws:
                        next_ws.append(w)
                if not next_ws:
                    return min(ws)
                else:
                    ws = next_ws
        return min(ws)

# @lc code=end

