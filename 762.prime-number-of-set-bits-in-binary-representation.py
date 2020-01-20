#
# @lc app=leetcode id=762 lang=python3
#
# [762] Prime Number of Set Bits in Binary Representation
#

# @lc code=start
class Solution:
    def countPrimeSetBits(self, L: int, R: int) -> int:
        prime_numbers = [2,3,5,7,11,13,17,19]
        ans = 0

        for i in range(L, R+1):
            if bin(i).count('1') in prime_numbers:
                ans += 1
        return ans
        '''
        Count the '1's of the binary representation.
        Then check whether it is a prime number.
        Because the R is no more than 10^6, so the maximum length
        of the binary representation is 22. You can list all prime
        numbers which are smaller than 22.
        '''
# @lc code=end

