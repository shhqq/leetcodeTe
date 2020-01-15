#
# @lc app=leetcode id=605 lang=python3
#
# [605] Can Place Flowers
#

# @lc code=start
class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        length = len(flowerbed)
        index = 0
        # Find the index of the first occurrence of 1.
        try:
            index = flowerbed.index(1)
        except ValueError:
            return (length + 1) // 2 >= n
        res = index // 2    # Flowers can be placed before the first 1.
        next_index = index
        while index < length:
            try:
                next_index = flowerbed.index(1, index + 1, length) 
                # flowers can be placed between two 1s.
                res += (next_index - index - 2) // 2   
                index = next_index
            except ValueError:  # No more 1s in the rest list.
                res += (length - index - 1) // 2
                break
        return res >= n
        
# @lc code=end

