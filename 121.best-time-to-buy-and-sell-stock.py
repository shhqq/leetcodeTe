#
# @lc app=leetcode id=121 lang=python3
#
# [121] Best Time to Buy and Sell Stock
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
# solution 1
        # # firstly, find the first element whose next is bigger than
        # # it.
        # if len(prices) == 0:
        #     return 0
        # left = -1
        # for i in range(len(prices) - 1):
        #     if prices[i + 1] - prices[i] > 0:
        #         left = i
        #         break
        # if left == -1:
        #     return 0
        # # Secondly, find the maximum of the rest part.
        # maxValue = max(prices[left + 1 : len(prices)])
        # maxValueIndex = left + (prices[left+1:len(prices)]).index(maxValue) + 1
        # # Thirdly, check if there is an element smaller than prices[left]
        # # between left and maxValue. Then get the partial max profit.
        # minValue = min(prices[left:maxValueIndex])
        # profilt_of_part = maxValue - minValue
        # return max(profilt_of_part, self.maxProfit(prices[maxValueIndex: len(prices)]))

# solution 2
# Traversal.
# When the length of prices is very big, time will not be accepted.
        # maxProfitValue = 0
        # for i in range(len(prices)):
        #     for j in range(i + 1, len(prices)):
        #         maxProfitValue = max(prices[j] - prices[i], maxProfitValue)
        # return maxProfitValue

# solution 3
# dynamic programming
        if len(prices) == 0:
            return 0
        maxProfitValue = 0
        minValue = max(prices)
        for i in range(len(prices)):
            if prices[i] < minValue:
                minValue = prices[i]
            else:
                maxProfitValue = max(maxProfitValue, prices[i] - minValue)
        return maxProfitValue
# @lc code=end

