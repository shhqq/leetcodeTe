#
# @lc app=leetcode id=914 lang=python3
#
# [914] X of a Kind in a Deck of Cards
#

# @lc code=start
class Solution:
    def hasGroupsSizeX(self, deck: List[int]) -> bool:

# The count of each unique value of deck should have a least
# commom divisor which is greater than 1.
        # unique_value = set(deck)
        # count_value = [deck.count(i) for i in unique_value]
        # min_count = min(count_value)
        # if min_count == 1:
        #     return False
        # for x in range(2, min_count + 1):
        #     if len(deck) % x != 0:
        #         continue
        #     for c in count_value:
        #         if c % x != 0:
        #             break
        #     else:
        #         return True
        # return False

        # solution 2: use collections.Counter()
        count = collections.Counter(deck)
        for i in range(2, min(count.values()) + 1):
            if len(deck) % i == 0:
                if all(v % i == 0 for v in count.values()):
                    return True
        return False

# @lc code=end

