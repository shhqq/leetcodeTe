#
# @lc app=leetcode id=599 lang=python3
#
# [599] Minimum Index Sum of Two Lists
#

# @lc code=start
class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        min_sum = len(list1) * len(list2)
        restaurant = []
        for i in range(len(list1)):
            if list1[i] in list2:
                if min_sum > i + list2.index(list1[i]):
                    min_sum = i + list2.index(list1[i])
                    restaurant = [list1[i]]
                elif min_sum == i + list2.index(list1[i]):
                    restaurant.append(list1[i])
        return restaurant
# @lc code=end

