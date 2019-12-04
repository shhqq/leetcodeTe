#
# @lc app=leetcode id=118 lang=python3
#
# [118] Pascal's Triangle
#

# @lc code=start
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
# solution 1
        # result = []
        # temp = []
        # i = 0
        # while i < numRows:
        #     if i > 0:
        #         temp.append(1)
        #     for j in range(2, i + 1):
        #         temp.append(result[i - 1][j - 2] + result[i - 1][j - 1])
        #     temp.append(1)
        #     result.append(temp.copy())
        #     temp.clear()
        #     i += 1
        # return result
# solution 2 
# Add extra "0" to the head and the tail of last element. Then generate
# the next element.
# Use the "+" operation of list to connect two or more lists.
        if numRows == 0: 
            return []
        else:
            result = [[1]]
            i = 1
            while i < numRows:
                temp = [0] + result[i - 1] + [0]
                temp2 = [0 for _ in range(i + 1)]
                for j in range(i + 1):
                    temp2[j] = temp[j] + temp[j + 1]
                result.append(temp2.copy())
                i += 1
            return result
            
# @lc code=end

