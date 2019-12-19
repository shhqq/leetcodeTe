#
# @lc app=leetcode id=204 lang=python3
#
# [204] Count Primes
#

# @lc code=start
class Solution:
# Solution 1:
# brute force
# when n is getting larger, it will cause time limit exceeded.
    def countPrimes(self, n: int) -> int:
        """
        if n < 3:
            return 0
        count = 1
        for i in range(3, n):
            if self.is_prime_number(i):
                count += 1
        return count
    
    def is_prime_number(self, n: int) -> bool:
        if n == 1 or n % 2 == 0:
            return False
        for i in range(3, n // 2, 2):
            if n % i == 0:
                return False
        return True
    """
# solution 2:
# Generate a list of 1 whose length is n. Then change 1 to 0 at index
# i which is prime number.
        if n < 3:
            return 0
        
        prime = [1 for _ in range(n)]
        prime[0] = 0
        prime[1] = 0
        p = 2
        while p ** 2 < n:
            if prime[p]:
                for i in range(p**2, n, p):
                    prime[i] = 0
            p += 1
        return sum(prime)
# @lc code=end

