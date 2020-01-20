#
# @lc app=leetcode id=804 lang=python3
#
# [804] Unique Morse Code Words
#

# @lc code=start
class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        morse = [".-","-...","-.-.","-..",".","..-.","--.",
        "....","..",".---","-.-",".-..","--","-.","---",".--.",
        "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        morse_dic = {}
        for w in words:
            temp = ''
            for i in w:
                temp += morse[ord(i) - 97]
            if temp not in morse_dic.keys():
                morse_dic[temp] = 1
        return len(morse_dic.keys())
# @lc code=end

