#
# @lc app=leetcode id=796 lang=python3
#
# [796] Rotate String
#

# @lc code=start
class Solution:
    def rotateString(self, A: str, B: str) -> bool:
        if len(A) != len(B):
            return False
        elif len(A) == 0:
            return True
        else:
            for i in range(len(A)):
                if A[i:]+A[:i] == B:
                    return True
            return False
# @lc code=end

