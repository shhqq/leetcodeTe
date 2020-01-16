#
# @lc app=leetcode id=697 lang=python3
#
# [697] Degree of an Array
#

# @lc code=start
class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
# Firstly, use collections to make a dictionary.
# Secondly, find the maximum frequency.
# Finally, find the minimum subarray.
        '''
        c = collections.Counter(nums)
        max_count = 0
        ele = []
        for k in c.keys():
            if c[k] > max_count:
                max_count = c[k]
                ele = [k]
            elif c[k] == max_count:
                ele.append(k)
        # print(ele)
        dic = {}
        for i in range(len(nums)):
            if nums[i] in ele:
                if nums[i] in dic.keys():
                    dic[nums[i]][1] = i
                else:
                    dic[nums[i]] = [i, i]
        min_length = len(nums)
        # print(dic)
        for k in dic.keys():
            min_length = min(min_length, dic[k][1] - dic[k][0] + 1)
        return min_length
        '''
        
# generate the two dictionays at the same time to save running time.
        dic = {}    # structure of dic is {e: [times, left, right]} 
        max_count = 1
        ans = len(nums)
        for i in range(len(nums)):
            if nums[i] in dic.keys():
                dic[nums[i]][0] += 1
                dic[nums[i]][2] = i
                max_count = max(max_count, dic[nums[i]][0])
            else:
                dic[nums[i]] = [1, i, i]
        for i in dic.keys():
            if dic[i][0] == max_count:
                ans = min(ans, dic[i][2] - dic[i][1] + 1)
        return ans

# @lc code=end

