#
# @lc app=leetcode id=88 lang=python3
#
# [88] Merge Sorted Array
#

# @lc code=start
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
# solution 1 
        # for i in range(m, m + n):
        #     nums1[i] = nums2[i - m]
        # nums1.sort()
# solution 2
        nums3 = []
        i = j = 0
        while i < m and j < n:
            if nums1[i] < nums2[j]:
                nums3.append(nums1[i])
                i += 1
                # print(nums3)
            else:
                nums3.append(nums2[j])
                j += 1
                # print(÷nums3)
        for k in range(i, m):
            nums3.append(nums1[k])
            # print(nums3)
        for k in range(j, n):
            nums3.append(nums2[k])
            # print(nums3)
        for k in range(0, n+m):
            nums1[k]=nums3[k]
        # nums1 = nums3  # 为什么直接赋值不可以？
        # print(nums1)

# @lc code=end

