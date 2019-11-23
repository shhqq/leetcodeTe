#
# @lc app=leetcode id=38 lang=python3
#
# [38] Count and Say
#

# @lc code=start
class Solution:
    def countAndSay(self, n: int) -> str:
        num_str = "1"
        for _ in range(1, n):
            num = num_str[0]
            count = 1
            new_num_str = ""
            for j in range(1, len(num_str)):
                if num == num_str[j]:
                    count += 1
                else:
                    new_num_str += str(count) + str(num)
                    num = num_str[j]
                    count = 1
            new_num_str += str(count) + str(num)
            num_str = new_num_str
        return num_str
# @lc code=end

