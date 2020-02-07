#
# @lc app=leetcode id=806 lang=python3
#
# [806] Number of Lines To Write String
#

# @lc code=start
class Solution:
    def numberOfLines(self, widths: List[int], S: str) -> List[int]:
        lines = 0
        used_one_line = 0
        length_line = 100
        for c in S:
            width_c = widths[ord(c) - 97]
            if length_line - used_one_line < width_c:
                lines += 1
                used_one_line = width_c
            else:
                used_one_line += width_c
        if used_one_line > 0:
            lines += 1
        return [lines, used_one_line]
# @lc code=end

