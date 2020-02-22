#
# @lc app=leetcode id=937 lang=python3
#
# [937] Reorder Data in Log Files
#

# @lc code=start
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        '''
        Seprate the logs into letter-logs and digit-logs.
        Then sort the letter-logs by the substring unless tie.
        '''
        # letter_log = []
        # digit_log = []
        # for v in logs:
        #     if v[v.index(' ') + 1].isdigit():
        #         digit_log.append(v)
        #     else:
        #         letter_log.append(v)
        
        # for i in range(len(letter_log) - 1):
        #     for j in range(len(letter_log) - i - 1):
        #         left_identifier = letter_log[j][0: letter_log[j].index(' ')+1]
        #         left = letter_log[j][letter_log[j].index(' ')+1: len(letter_log[j])]
        #         right_identifier = letter_log[j+1][0: letter_log[j+1].index(' ')+1]
        #         right = letter_log[j+1][letter_log[j+1].index(' ')+1: len(letter_log[j+1])]
        #         if left > right or (left == right and left_identifier > right_identifier):
        #             temp = letter_log[j]
        #             letter_log[j] = letter_log[j+1]
        #             letter_log[j+1] = temp
        # return letter_log + digit_log

        def f(log):
            id_, rest = log.split(" ", 1)
            return (0, rest, id_) if rest[0].isalpha() else (1,)

        return sorted(logs, key = f)
# @lc code=end

