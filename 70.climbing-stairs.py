#
# @lc app=leetcode id=70 lang=python3
#
# [70] Climbing Stairs
#

# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        elif n == 2:
            return 2
        else:
# solution 1 
# 二分的思想，大概70
            # return (self.climbStairs(n // 2 ) * (self.climbStairs(n - n // 2) - self.climbStairs(n - n // 2 - 1))
            #         + self.climbStairs(n // 2 + 1) * self.climbStairs(n - n // 2 - 1))
# solution 2
# 简单的递归会大量的重复计算，如f（2）等，超时
            # return self.climbStairs(n - 1) + self.climbStairs(n - 2)

#solution 3
# 使用迭代的方法，从下往上计算，也可以用一个数列存储每个值，然后计算
            a = 1
            b = 2
            c = a + b
            for _ in range(n - 2):
                c = a + b
                a = b
                b = c
            return c

# solution 3
# 公式法，由于python不自带sqrt，可以使用0.5次方计算

# solution 4
# 使用矩阵计算
# @lc code=end

