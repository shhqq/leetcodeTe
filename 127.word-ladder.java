import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
         * 1. wordList中必须包含beginWord，或者至少存在一个与beginWord只相差一个字母的单词。
         * 2. endWord必须在wordList中
         * 3. 不能出现循环变换。
         * 
         * 1. wordList如果包含beginWord，则从beginWord开始，如果不包含，那么从相差一个字母的数组开始
         * 2. 记录遍历过的index，不能重复。
         * 3. 每次都找到改变一个单词后的数列，如果没有则不存在。
         * 3. 如果都遍历完，不能到达endWord，则结束。
         */
        
        // 1. 如果不包含endWord，则结束
        if(!wordList.contains(endWord)){
            return 0;
        }
        // 2. 遍历数组，找到和beginWord相差一个字母的数组
        List<String> temp1 = new ArrayList<>();
        
        temp1.add(beginWord);

        wordList.remove(beginWord);         // 不需要判断是否存在

        // 步骤计数
        int step = 1;
        while(wordList.size() > 0){
            List<String> temp2 = new ArrayList<>();
            step++; 
            for(String s: wordList){        // 遍历wordList
                for(String st: temp1){
                    if(diffOneChar(s, st) && !temp2.contains(s)){   //如果temp1中存在一个与s相差一个字母，且temp2中不包含s 
                        if(s.equals(endWord)) {
                            return step;
                        }
                        temp2.add(s);
                    }
                }
            }
            if(temp2.size() == 0){          // 如果中断了，即没有中间元素，那么就结束
                return 0;
            }
            // 遍历temp2，将元素加入temp1， 并将wordList中删除，然后清空temp2
            for(String s: temp2){
                temp1.add(s);
                wordList.remove(s);
            }
        }

        // 如果没有结果，wordList为0，那么就结束
        return 0;
    }

    /**
     * check if s1 and s2 differ by one character.
     * @param s1
     * @param s2
     * @return
     */
    private boolean diffOneChar(String s1, String s2){
        int diff = 0;
        for (int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }
}
// @lc code=end

