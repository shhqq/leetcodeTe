#
# @lc app=leetcode id=409 lang=python3
#
# [409] Longest Palindrome
#

# @lc code=start
class Solution:
    def longestPalindrome(self, s: str) -> int:
# solution 1:
# Use a set to storage distinct letters, then count each single letter.
        '''
        single_letter = set(s)
        count = 0
        exist_odd = False
        for l in single_letter:
            temp = s.count(l)
            if temp % 2 == 0:
                count += temp
            else:
                exist_odd = True
                count += temp - 1
        if exist_odd:
            count += 1
        return count
        '''
# The solution can be optimized as:
        '''
        single_letter = set(s)
        count = 0
        for l in single_letter:
            temp = s.count(l)
            count += (temp // 2 * 2)    # Add temp if temp is even or temp-1
            # Add 1 if s has a single letter like 'aab'.
            if temp % 2 == 1 and count % 2 == 0:
                count += 1
        return count
        '''

# solution 2:
# Use collection.
# collections.Counter(s).values()
        count = 0
        for value in collections.Counter(s).values():
            count += (value // 2 * 2)
            if value % 2 == 1 and count % 2 == 0:
                count += 1
        return count
# @lc code=end 

