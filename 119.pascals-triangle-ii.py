#
# @lc app=leetcode id=119 lang=python3
#
# [119] Pascal's Triangle II
#

# @lc code=start
class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        list1 = [1]
        list2 = [1]
        for i in range(rowIndex):
            list1 = [0] + list2 + [0]
            list2.clear()
            for j in range(i + 2):
                list2.append(list1[j] + list1[j + 1])
        return list2 
# @lc code=end

