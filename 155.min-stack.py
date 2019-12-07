#
# @lc app=leetcode id=155 lang=python3
#
# [155] Min Stack
#

# @lc code=start
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.values = []
    def push(self, x: int) -> None:
        self.values.append(x)

    def pop(self) -> None:
        # if len(self.values) == 0:
        #     return -1
        # else:
        self.values.pop()

    def top(self) -> int:
        # if len(self.values) == 0:
        #     return
        # else:
        return self.values[-1]

    def getMin(self) -> int:
        # if len(self.values) == 0:
        #     return 
        # else:
        return min(self.values)


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
# @lc code=end

