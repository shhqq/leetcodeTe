#
# @lc app=leetcode id=53 lang=python3
#
# [53] Maximum Subarray
#

# @lc code=start
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
# solution 1
        resu = sum(nums)
        temp = 0
        i = 0
        flag = True
        if len(nums) == 1:
            return resu
        for i in range(len(nums)):
            temp += nums[i]
            if temp > resu:
                resu = temp
                flag = False
                if resu < 0:
                    break
            else:
                if temp <= 0 and flag:
                    resu -= temp
                    temp = 0
                elif temp <= 0 and flag == False:
                    break

        if i < len(nums)-1:
            solu = Solution()
            resu2 = solu.maxSubArray(nums[i+1: len(nums)])
            resu = max(resu, resu2)
        return resu

# solution 2
        # curMax = numMax = nums[0]
        # for i in nums[1: ]:
        #     curMax = max(i, curMax + i)
        #     numMax = max(curMax, numMax)
        # return numMax
# @lc code=end

