#
# @lc app=leetcode id=690 lang=python3
#
# [690] Employee Importance
#

# @lc code=start
"""
# Employee info
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        # It's the unique id of each node.
        # unique id of this employee
        self.id = id
        # the importance value of this employee
        self.importance = importance
        # the id of direct subordinates
        self.subordinates = subordinates
"""
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
# Use hash table to storage the employees.
        if not employees:
            return 0
        dic = {}
        ans = 0
        for e in employees:
            dic[e.id] = [e.importance, e.subordinates]
        if id not in dic.keys():
            return 0
        else:
            es = [id]
            while es:
                next_es = []
                for e in es:
                    ans += dic[e][0]
                    next_es += dic[e][1]
                es = next_es
            return ans
# @lc code=end

