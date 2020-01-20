#
# @lc app=leetcode id=744 lang=python3
#
# [744] Find Smallest Letter Greater Than Target
#

# @lc code=start
class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
# Use binary search.
        if target >= letters[-1] or target < letters[0]:
            return letters[0]
        else:
            left = 0
            right = len(letters) - 1
            middle = (left+right) // 2
            while left < middle:
                if letters[middle] <= target:
                    left = middle
                elif letters[middle] > target:
                    right = middle
                middle = (left + right) // 2
            return letters[right]

# @lc code=end

