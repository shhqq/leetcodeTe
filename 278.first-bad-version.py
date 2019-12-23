#
# @lc app=leetcode id=278 lang=python3
#
# [278] First Bad Version
#

# @lc code=start
# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
# using dichotomy.
        left = 1
        right = n
        middle = (left + right) // 2
        while left < middle:
            if isBadVersion(middle):
                right = middle
            else:
                left = middle
            middle = (left + right) // 2
        return left if isBadVersion(middle) else right
# @lc code=end

