#
# @lc app=leetcode id=67 lang=python3
#
# [67] Add Binary
#

# @lc code=start
class Solution:
    def addBinary(self, a: str, b: str) -> str:
# solution 1
        # num1 = int(a)
        # num2 = int(b)
        # sumStr = str(num1 + num2)
        # temp = 0
        # resu = ''
        # for i in range(len(sumStr)):
        #     t = int(sumStr[- i- 1]) + temp
        #     resu = str(t % 2) + resu
        #     temp = t // 2
        # return str(int(str(temp) + resu))

# solution 2
        if len(a) == 0:
            return b
        elif len(b) == 0:
            return a
        else:
            if a[-1] == '1' and b[-1] == '1':
                return self.addBinary(self.addBinary(a[0: -1], b[0: -1]), '1') + '0'
            elif a[-1] == '0' and b[-1] == '0':
                return self.addBinary(a[0: -1], b[0: -1]) + '0'
            else:
                return self.addBinary(a[0: -1], b[0: -1]) + '1'

# @lc code=end

