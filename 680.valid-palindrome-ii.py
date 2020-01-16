#
# @lc app=leetcode id=680 lang=python3
#
# [680] Valid Palindrome II
#

# @lc code=start
class Solution:
    def validPalindrome(self, s: str) -> bool:
# Solution 1:
# If s[p] is not equal to s[q], remove the s[p] if s[p+1] == s[q]
# or remove s[q] if s[p] == s[q-1].
# !! Notice that you can remove s[p] or s[q] if s[p] == s[q-1] and s[p+1] == s[q].
        '''
        p = 0
        q = len(s) - 1
        while p < q:
            if s[p] != s[q]:
                if s[p] == s[q-1] and s[p+1] == s[q]:
                    return self.check_palindrome(s[p:q]) or self.check_palindrome(s[p+1:q+1])
                elif s[p+1] == s[q]:
                    return self.check_palindrome(s[p+1: q+1])
                elif s[p] == s[q-1]:
                    return self.check_palindrome(s[p: q])
                else:
                    return False
            else:
                p += 1
                q -= 1
        return True

    def check_palindrome(self, s: str) -> bool:
        p = 0
        q = len(s) - 1
        while p < q:
            if s[p] != s[q]:
                return False
            else:
                p += 1
                q -= 1
        return True
        '''

# Solution 2:
# The palindrome judgment can be simplified to s == s[::-1].
# It's unnecessary to check if s[p] == s[q-1] or s[p+1] == s[q].
        p = 0
        q = len(s) - 1
        while p < q:
            if s[p] != s[q]:
                # unnecessary to check if s[p] == s[q-1] or s[p+1] == s[q]
                return self.check_palindrome(s[p:q]) or self.check_palindrome(s[p+1:q+1])
            else:
                p += 1
                q -= 1
        return True

    def check_palindrome(self, s: str) -> bool:
        return s == s[::-1]
# @lc code=end

