#
# @lc app=leetcode id=232 lang=python3
#
# [232] Implement Queue using Stacks
#

# @lc code=start
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.nums = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.nums = [x] + self.nums

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        return self.nums.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.nums[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.nums) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
# @lc code=end

