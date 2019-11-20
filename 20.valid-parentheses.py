#
# @lc app=leetcode id=20 lang=python3
#
# [20] Valid Parentheses
#

# @lc code=start
class Solution:
    def isValid(self, s: str) -> bool:
        left_parentheses = ['(', '[', '{']
        right_parentheses = [')', ']', '}']
        parentheses_stack = []
        for i in range(len(s)):
            if s[i] in left_parentheses:
                parentheses_stack.append(s[i])
            else:
                if len(parentheses_stack) == 0:
                    return False
                else:
                    if left_parentheses.index(parentheses_stack.pop()) != right_parentheses.index(s[i]):
                        return False
        if len(parentheses_stack) != 0:
            return False
        else:
            return True
# @lc code=end

