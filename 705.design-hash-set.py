#
# @lc app=leetcode id=705 lang=python3
#
# [705] Design HashSet
#

# @lc code=start
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.values = {}

    def add(self, key: int) -> None:
        if key in self.values.keys():
            pass
        else:
            self.values[key] = 1

    def remove(self, key: int) -> None:
        try:
            self.values.pop(key)
        except KeyError:
            pass
        
    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        return key in self.values.keys()
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
# @lc code=end

