#
# @lc app=leetcode id=299 lang=python3
#
# [299] Bulls and Cows
#

# @lc code=start
class Solution:
    def getHint(self, secret: str, guess: str) -> str:
# Use the hash table to storage the digit and its amount.
        a = 0
        b = 0
        n_str = str(secret)
        m_str = str(guess)
        n_dic = {}
        m_dic = {}

        for i in range(len(n_str)):
            if n_str[i] == m_str[i]:
                a += 1
            else:
                if n_str[i] in n_dic.keys():
                    n_dic[n_str[i]] += 1
                else:
                    n_dic[n_str[i]] = 1
                if m_str[i] in m_dic.keys():
                    m_dic[m_str[i]] += 1
                else:
                    m_dic[m_str[i]] = 1
        for i in n_dic.keys():
            if i in m_dic.keys():
                b += min(n_dic[i], m_dic[i])
        return str.format("%dA%dB" %(a, b))
# @lc code=end

