#
# @lc app=leetcode id=594 lang=python3
#
# [594] Longest Harmonious Subsequence
#

# @lc code=start
class Solution:
    def findLHS(self, nums: List[int]) -> int:
        dic = collections.Counter(nums)
        count = 0
        ks = list(dic.keys())
        ks.sort()
        for i in ks:
            # if i - 1 in dic.keys():
            #     count = max(count, dic[i] + dic[i-1])
            if i + 1 in dic.keys():
                count = max(count, dic[i] + dic[i+1])
        return count
# @lc code=end

