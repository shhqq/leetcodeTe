#
# @lc app=leetcode id=844 lang=python3
#
# [844] Backspace String Compare
#

# @lc code=start
class Solution:
    def backspaceCompare(self, S: str, T: str) -> bool:
        # Record the count of '#' from back to front.
        space_s = space_t = 0
        
        # Use two pointers to point the S and T respectively.
        i = len(S) - 1
        j = len(T) - 1

        while i >= 0 and j >= 0:
            if space_s == 0 and space_t == 0 and S[i] != '#' and T[j] != '#' and S[i] != T[j]:
                return False
            elif space_s == 0 and space_t == 0 and S[i] != '#' and T[j] != '#' and S[i] == T[j]:
                i -= 1
                j -= 1
            else:
                if S[i] == '#':
                    space_s += 1
                    i -= 1
                elif space_s > 0:
                    space_s -= 1
                    i -= 1
                # elif j < 0:
                #     return False

                if T[j] == '#':
                    space_t += 1
                    j -= 1
                elif space_t > 0:
                    space_t -= 1
                    j -= 1
                # elif i < 0:
                #     return False
        
        # Handle the remain string of S or T
        while i >= 0:
            if S[i] == '#':
                space_s += 1
                i -= 1
            elif space_s > 0:
                space_s -= 1
                i -= 1
            else:
                return False
        while j >= 0:
            if T[j] == '#':
                space_t += 1
                j -= 1
            elif space_t > 0:
                space_t -= 1
                j -= 1
            else:
                return False
        return True
# @lc code=end

