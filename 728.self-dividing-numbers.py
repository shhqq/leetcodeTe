#
# @lc app=leetcode id=728 lang=python3
#
# [728] Self Dividing Numbers
#

# @lc code=start
class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
# brute force
        '''
        ans = []
        for i in range(left, right+1):
            temp = str(i)
            ans.append(i)
            for d in range(len(temp)):
                if temp[d] == '0' or i % int(temp[d]) != 0:
                    ans.pop()
                    break
        return ans
        '''
    
# Or you can use for/else loop:
        ans = []
        for i in range(left, right+1):
            temp = str(i)
            for d in range(len(temp)):
                if temp[d] == '0' or i % int(temp[d]) != 0:
                    break
            else:
                ans.append(i)
        return ans

# @lc code=end  

