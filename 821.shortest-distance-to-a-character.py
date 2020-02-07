#
# @lc app=leetcode id=821 lang=python3
#
# [821] Shortest Distance to a Character
#

# @lc code=start
class Solution:
    def shortestToChar(self, S: str, C: str) -> List[int]:
        ans1 = [len(S) for _ in range(len(S))]
        ans2 = [len(S) for _ in range(len(S))]
        for i in range(len(S)):
            if S[i] == C:
                ans1[i] = 0
            else:
                if i > 0:
                    ans1[i] = ans1[i - 1] + 1
        for i in range(len(S)-1, -1, -1):
            if S[i] == C:
                ans2[i] = 0
            else:
                if i < len(S) - 1:
                    ans2[i] = ans2[i+1] + 1
        ans = [min(ans1[i], ans2[i]) for i in range(len(S))]
        return ans


# @lc code=end

