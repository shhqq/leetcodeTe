#
# @lc app=leetcode id=703 lang=python3
#
# [703] Kth Largest Element in a Stream
#

# @lc code=start
class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.k = k
        self.nums = nums
        self.nums.sort(reverse = True)
        while len(self.nums) > self.k:
            self.nums.pop()

    def add(self, val: int) -> int:
        self.nums.append(val)
        self.nums.sort(reverse = True)
        if len(self.nums) > self.k:
            self.nums.pop()
        return self.nums[-1]

# After initialization and add operation, make sure that 
# the length of nums won't be greater than k.

# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)
# @lc code=end

