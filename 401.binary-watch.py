#
# @lc app=leetcode id=401 lang=python3
#
# [401] Binary Watch
#

# @lc code=start
class Solution:
    def readBinaryWatch(self, num: int) -> List[str]:
# solution 1:
# storage the possible numbers.
# It's very stupid.
        '''
        dic_hour = {
            0: [0],
            1: [1, 2, 4, 8],
            2: [3, 5, 9, 6, 10],
            3: [7, 11]
        }
        dic_min = {
            0: [0],
            1: [1, 2, 4, 8, 16, 32],
            2: [3, 5, 9, 17, 33, 6, 10, 18, 34, 12, 20, 36, 24, 40, 48],
            3: [7, 11, 19, 35, 13, 21, 37, 25, 41, 49, 14, 22, 38, 26, 42, 50, 28, 44, 52, 56],
            4: [15, 23, 39, 27, 43, 51, 29, 45, 57, 58, 54, 46, 30, 53],
            5: [31, 47, 55, 59]
        }

        possible_moments = []
        for i in range(max(0, num - 5), min(4, num + 1)):
            for h in dic_hour[i]:
                for m in dic_min[num - i]:
                    possible_moments.append(':'.join([str(h), str(m).zfill(2)]))
        return possible_moments
        '''

# solution 2:
# Use bin() method.
# bin(n: int) returns a string of the binary representation of the integer.
#  
        possible_moments = []
        for i in range(12):
            for j in range(60):
                if (bin(i) + bin(j)).count('1') == num:
                    possible_moments.append(':'.join([str(i), str(j).zfill(2)]))
        return possible_moments
# @lc code=end

