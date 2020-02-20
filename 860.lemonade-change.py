#
# @lc app=leetcode id=860 lang=python3
#
# [860] Lemonade Change
#

# @lc code=start
class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        count_5 = 0
        count_10 = 0
        count_20 = 0
        for i in bills:
            if i == 5:
                count_5 += 1
            elif i == 10:
                if count_5 < 1:
                    return False
                else:
                    count_5 -= 1
                    count_10 += 1
            else:
                if count_5 < 1 or (count_10 < 1 and count_5 < 3):
                    return False
                else:
                    if count_10 > 0:
                        count_10 -= 1
                        count_5 -= 1
                        count_20 += 1
                    elif count_10 == 0:
                        count_5 -= 3
                        count_20 += 1
        return True
# @lc code=end

