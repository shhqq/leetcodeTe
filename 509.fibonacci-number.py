#
# @lc app=leetcode id=509 lang=python3
#
# [509] Fibonacci Number
#

# @lc code=start
class Solution:
    def fib(self, N: int) -> int:
# calculate directly.
        if N <= 1:
            return N
        current = 0
        next = 1
        for _ in range(1, N):
            temp = next
            next = next + current
            current = temp
        return next
        

# Use recursion, but this will calculate twice on n < N - 2
        '''
        if N == 0:
            return 0
        elif N == 1:
            return 1
        else:
            return self.fib(N - 1) + self.fib(N - 2)
        '''
# @lc code=end

