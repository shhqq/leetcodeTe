#
# @lc app=leetcode id=896 lang=python3
#
# [896] Monotonic Array
#

# @lc code=start
class Solution:
    def isMonotonic(self, A: List[int]) -> bool:
        # return A == sorted(A) or A == sorted(A, reverse=True)

        return (all(A[i]<=A[i+1] for i in range(len(A)-1))) or (all(
            A[i] >= A[i+1] for i in range(len(A) -1)
        ))
# @lc code=end

