#
# @lc app=leetcode id=859 lang=python3
#
# [859] Buddy Strings
#

# @lc code=start
class Solution:
    def buddyStrings(self, A: str, B: str) -> bool:
        if len(A) != len(B) or len(A) < 2:
            return False
        elif A == B and len(set(A)) < len(A): # there is at least 1 repeating charactor.
            return True
        else:
            diff = []
            for i in range(len(A)): 
                if A[i] != B[i]:
                    if len(diff) == 2:
                        return False
                    else:
                        diff.append(i)
            if len(diff) == 2 and A[diff[0]] == B[diff[1]] and A[diff[1]] == B[diff[0]]:
                return True
            else:
                return False
# @lc code=end

