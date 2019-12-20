#
# @lc app=leetcode id=190 lang=python3
#
# [190] Reverse Bits
#

# @lc code=start
class Solution:
# solution 1
# real bit manipulation.
    def reverseBits(self, n: int) -> int:
        res = 0
        for _ in range(32):
            res = (res << 1) + (n & 1)
            n >>= 1
        return res
# solution 2
# Transform n to binary, then reverse the list. Finally, transform 
# the list back to decimal.
"""
    def reverseBits(self, n: int) -> int:
        binary_list = self.decimal_to_binary(n, 4)
        binary_list.reverse()
        return self.binary_to_unsigned_decimal(binary_list)

    def binary_to_unsigned_decimal(self, s: list) -> int:
        '''
        Transform binary list to unsigned integer.
        Args:
            s: binary list.
        Returns:
            return the unsigned integer.
        '''
        l = len(s)
        resu = 0
        for i in range(l):
            resu += s[i] * pow(2, l-1-i)
        return resu
    def binary_to_signed_decimal(self, s: list) -> int:
        '''
        Transform binary list to signed integer.
        Args:
            s: binary list.
        Returns:
            return the signed integer.
        '''
        l = len(s)
        resu = 0
        # If s represents a non-negative integer.
        if s[0] == 0:
            for i in range(l):
                resu += s[i] * pow(2, l-1-i)
            return resu
        # If s represents a negative integer.
        else:
            for i in range(1, l):
                resu += (s[i] ^ 1) * pow(2, l-1-i)
            return -(resu + 1)
    
    def decimal_to_binary(self, n: int, k: int) -> list:
        '''
        Transform decimal to binary.
        @param:
            n: integer
            k: bytes of integer
        @return:
            return the binary list of integer.
        '''
        resu = []
        if n >= 0:
            while n > 1:
                resu.append(n % 2)
                n = n // 2
            resu.append(n)
            # fill in 0 to result
            while len(resu) < k * 8:
                resu.append(0)
            # Reverse the result to get binary of n.
            resu.reverse()
            return resu
        else:
            # if n is negative, get binary of ((absolute value of n) minus 1)
            resu = self.decimal_to_binary(abs(n) - 1, k)
            # Negate values of result.
            for i in range(len(resu)):
                resu[i] = resu[i] ^ 1
            return resu
"""
# print(Solution().binary_to_signed_decimal([0,1,1,1,1,1,0,1]))
# print(Solution().decimal_to_binary(-3, 1))
# @lc code=end

