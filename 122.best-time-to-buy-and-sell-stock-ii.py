#
# @lc app=leetcode id=122 lang=python3
#
# [122] Best Time to Buy and Sell Stock II
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # profit = 0
        # buyPrice = 0
        # holdStock = False
        # for i in range(len(prices) - 1):
        #     if prices[i + 1] > prices[i] and not holdStock:
        #         buyPrice = prices[i]
        #         holdStock = True
        #     if prices[i + 1] < prices[i] and holdStock:
        #         holdStock = False
        #         profit += prices[i] - buyPrice
        # if holdStock:
        #     profit += prices[-1] - buyPrice
        # return profit

        profit = 0
        for i in range(len(prices) - 1):
            if prices[i + 1] > prices[i]:
                profit += prices[i + 1] - prices[i]
        return profit
# @lc code=end

