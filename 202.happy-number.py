#
# @lc app=leetcode id=202 lang=python3
#
# [202] Happy Number
#

# @lc code=start
class Solution:
    def isHappy(self, n: int) -> bool:
# Solution 1:
# Use a list to store the intermediate variables.
# Or use hash table to be a little faster.
        """
        nums = []
        while True:
            nums.append(n)
            temp = 0
            while n > 0:
                temp += pow(n % 10, 2)
                n = n // 10
            n = temp
            if n in nums:
                # print(n, nums)
                break
        return n == 1
        """
# solution 2:
# Use the Floyd Cycle.
# Use two pointer h(hare) and t(tortoise). they move forward
# with different speed. For example, h moves two steps while 
# t moves one step once. When there is a loop in linked list, finite
# state machine or recursion method, h will meet t at a point.
# 
        slow = n
        fast = n
        while True:
            slow = self.squared_sum(slow)
            fast = self.squared_sum(self.squared_sum(fast))
            if slow == 1 or fast == 1:
                return True
            elif slow == fast:
                return False
    def squared_sum(self, n: int) -> int:
        temp = 0
        while n > 0:
            temp += pow(n % 10, 2)
            n = n // 10
        return temp

# @lc code=end

