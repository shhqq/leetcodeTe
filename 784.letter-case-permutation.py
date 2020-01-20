#
# @lc app=leetcode id=784 lang=python3
#
# [784] Letter Case Permutation
#

# @lc code=start
class Solution:
    def letterCasePermutation(self, S: str) -> List[str]:
# solution 1:
# Count alphabetic elements of S. And the length of result is 2 to 
# the power of n.
# Use the binary representation of 0 to pow(2, n)-1 where the '1' 
# means upper and '0' means lower.
        '''
        s_l = S.lower()
        num_alpha = sum([i.isalpha() for i in s_l])
        ans = ['' for _ in range(pow(2, num_alpha))]
        for i in range(pow(2, num_alpha)):
            bin_i = bin(i)[2:].zfill(num_alpha)
            temp = ''
            k = 0
            for j in s_l:
                if j.isalpha():
                    if bin_i[k] == '1':
                        temp += j.upper()
                    else:
                        temp += j
                    k += 1
                else:
                    temp += j
            ans[i] = temp
        return ans
        '''

# Solution 2:
# Like a tree, for each charactor in S, if it is a letter, add the 
# lower case orupper case to ans.
        ans = ['']
        for i in S:
            if i.isalpha():
                ans = [k+j for k in ans for j in [i.lower(), i.upper()]]
            else:
                ans = [k+i for k in ans]
        return ans
# @lc code=end

