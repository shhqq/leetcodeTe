#
# @lc app=leetcode id=496 lang=python3
#
# [496] Next Greater Element I
#

# @lc code=start
class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
# Solution 1:
# brute force. Because the scale of nums1 and nums2 is small(not exceed 1000),
# so brute force is ok though time complexity is O(n^2).
        '''
        res = []
        for i in nums1:
            index = nums2.index(i)
            found = False
            for j in range(index, len(nums2)):
                if nums2[j] > i:
                    res.append(nums2[j])
                    found = True
                    break
            if not found:
                res.append(-1)
        return res

        '''

# Solution 2:
# Use a stack(actually a list) and a map to shorten time.
        my_map = {}
        my_stack = []

        for i in nums2:
            # if stack is not empty and last element is less than i,
            # put it to the map.
            while my_stack and my_stack[-1] < i:
                my_map[my_stack.pop()] = i
            my_stack.append(i)
        
        return [my_map.get(n, -1) for n in nums1]
# @lc code=end

