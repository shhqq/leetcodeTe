#
# @lc app=leetcode id=405 lang=python3
#
# [405] Convert a Number to Hexadecimal
#

# @lc code=start
class Solution:
    def toHex(self, num: int) -> str:
# solution 1:
# Get remainder then transform to hexadecimal.
        '''
        t = ['a', 'b', 'c', 'd', 'e', 'f']
        res = [0 for _ in range(8)]
        flag = False
        if num < 0:
            flag = True
            num = abs(num) - 1
        i = len(res) - 1
        while num > 0:
            res[i] = num % 16
            num = num // 16
            i -= 1
        for i in range(8):
            if flag:
                res[i] = 15 - res[i]
            if res[i] >= 10:
                res[i] = t[res[i] - 10]
            res[i] = str(res[i])
        brief_res = []
        first_not_zero = True
        for i in range(len(res)):
            if res[i] == '0' and first_not_zero:
                continue
            else:
                first_not_zero = False
                brief_res.append(res[i])
        if len(brief_res) == 0:
            return '0'
        return ''.join(brief_res)
        '''

# solution 2:
# Use bit manipulation, '&' and '>>'.
# It can also work on negative integers.
        buff = []
        for i in range(8):
            # Get the last four bits.
            temp = num & 15
            if temp >= 10:
                temp = chr(ord('a') + temp - 10)
            buff.append(str(temp))

            # divide num by 16.
            num = num >> 4
            if num == 0:
                break
        buff.reverse()
        return ''.join(buff)
# @lc code=end

