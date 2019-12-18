#
# @lc app=leetcode id=9 lang=python3
#
# [9] Palindrome Number
#

# @lc code=start
class Solution:
    def isPalindrome(self, x: int) -> bool:
        # Solution 1: 
        if x < 0:
            return False
        length = 1
        while x // length >= 10:
            length *= 10
        
        while x:
            if x % 10 != x // length:
                return False
            x = (x % length) // 10
            length /=100

        return True


        # if x < 0:
        #     return False
        # length = 0
        # while True:
        #     if x // pow(10, length) > 0:
        #         length += 1
        #     else:
        #         break
        # for i in range(length // 2):
        #     if x % 10 != x // pow(10, length - i * 2 - 1):
        #         return False
        #     else:
        #         x = (x % pow(10, length - 1 - i * 2)) // 10
        # return True

        # Solution 2:
        # xlist = []
        # xtemp = x
        # if xtemp<0:
        #     return False
        # while True:
        #     xlist.append(xtemp % 10)
        #     if xtemp < 10:
        #         break
        #     else:
        #         xtemp = xtemp // 10
        # for i in range(len(xlist) // 2):
        #     if xlist[i] != xlist[len(xlist) - 1 - i]:
        #         return False
        # return True


# @lc code=end

