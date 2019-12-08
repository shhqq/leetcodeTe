#
# @lc app=leetcode id=167 lang=python3
#
# [167] Two Sum II - Input array is sorted
#

# @lc code=start
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
# solution 1
# Use hash tabel to store elements which is smaller than or equal to 
# target / 2. It will shorten running time but cost extra memory.
        i = 0
        nums = {}
        for i in range(len(numbers)):
            if numbers[i] <= target / 2:
                if numbers[i] in nums.keys():
                    nums[numbers[i]].append(i)
                else:
                    nums[numbers[i]] = [i]
            else:
                break
        for j in range(i, len(numbers)):
            if target - numbers[j] in nums.keys():
                return [nums[target - numbers[j]][0] + 1, j + 1]
        if target / 2 in nums.keys():
            if len(nums[target/2]) == 2:
                return [nums[target/2][0] + 1, nums[target/2][1] + 1]

# solution 2
# Use brute force to find the boundary of target/2, then find result.
# It will save memory but cost more time.
# Possibly run time is more important than memory.
        # if there are two elements which are equal to t // 2, return them
        # if target/2 in numbers:
        #     i = numbers.index(target/2)
        #     if numbers[i+1] == target/2:
        #         return [i+1, i+2]
        # # else
        # boundary = 0    # boundary is defined as nums[b-1] <= t/2 and 
        #                 # nums[b] is greater than t/2.
        # for i in range(len(numbers)):
        #     if numbers[i] > target / 2:
        #         boundary = i
        #         break
        # for i in range(boundary):
        #     for j in range(boundary, len(numbers)):
        #         if numbers[i] + numbers[j] == target:
        #             return [i+1, j+1]
# @lc code=end

