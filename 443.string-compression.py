#
# @lc app=leetcode id=443 lang=python3
#
# [443] String Compression
#

# @lc code=start
class Solution:
    def compress(self, chars: List[str]) -> int:
        c = ''
        count = 0
        count_c = 1
        for i in chars:
            if c != i:
                c = i
                count += 1
                if count_c > 1:
                    count += len(str(count_c))
                count_c = 1
            else:
                count_c += 1
        if count_c > 1:
            count += len(str(count_c))
        print(count)
        return count
# @lc code=end

