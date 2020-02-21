#
# @lc app=leetcode id=893 lang=python3
#
# [893] Groups of Special-Equivalent Strings
#

# @lc code=start
class Solution:
    def numSpecialEquivGroups(self, A: List[str]) -> int:
        # mode = []
        # for w in A:
        #     temp = {}
        #     for i in range(len(w)):
        #         if i % 2 == 0:
        #             temp[w[i]+'2'] = temp.get(w[i]+'2', 0) + 1
        #         else:
        #             temp[w[i]+'1'] = temp.get(w[i]+'1', 0) + 1
        #     if temp not in mode:
        #         mode.append(temp)

        # return len(mode)

# because word in A only consists of lowercase letters, so we can use a 
# list to storage the times of occurrence of every letter.
# Notice to statistics the odd and even indices respectively.
        def count(A):
            ans = [0] * 52
            for i, letter in enumerate(A):
                ans[ord(letter) - ord('a') + 26 * (i%2)] += 1
            return tuple(ans)

        return len({count(word) for word in A})

        # mode = {}
        # for w in A:
        #     temp = {}
        #     for i in range(len(w)):
        #         if i % 2 == 0:
        #             temp[w[i]+'2'] = temp.get(w[i]+'2', 0) + 1
        #         else:
        #             temp[w[i]+'1'] = temp.get(w[i]+'1', 0) + 1
        #     if temp in mode.keys():
        #         mode[temp].append(w)
        #     else:
        #         mode[temp] = [w]
        # return len(temp.keys())
# @lc code=end

