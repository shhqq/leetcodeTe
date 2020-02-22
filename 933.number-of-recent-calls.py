#
# @lc app=leetcode id=933 lang=python3
#
# [933] Number of Recent Calls
#

# @lc code=start
class RecentCounter:

    def __init__(self):
        self.ping_time = collections.deque()

    def ping(self, t: int) -> int:
        self.ping_time.append(t)
        while True:
            if self.ping_time[0] < t - 3000:
                self.ping_time.popleft()
            else:
                break
        return len(self.ping_time)


# Your RecentCounter object will be instantiated and called as such:
# obj = RecentCounter()
# param_1 = obj.ping(t)
# @lc code=end

