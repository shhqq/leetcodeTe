#
# @lc app=leetcode id=925 lang=python3
#
# [925] Long Pressed Name
#

# @lc code=start
class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        '''
        typed[j] should be the same as name[i] or previous of name[i]
        and j must not end before i.
        '''

        previous = ''
        i = 0
        j = 0
        while i < len(name):
            if j < len(typed) and typed[j] == name[i]:
                previous = name[i]
                j += 1
                i += 1
            elif j < len(typed) and typed[j] == previous:
                j += 1
            else:
                return False
        
        # Handle the remain of typed.
        # if name is 'alice', and typed is 'alliceeeed', it should be wrong.
        for k in range(j, len(typed)):
            if typed[k] != previous:
                return False
        return True

# @lc code=end

