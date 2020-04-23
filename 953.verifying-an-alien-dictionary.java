/*
 * @lc app=leetcode id=953 lang=java
 *
 * [953] Verifying an Alien Dictionary
 */

// @lc code=start
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i < words.length - 1; i++){
            int j = 0;
            while(true){
                if(words[i].length() < j+1){
                    break;
                }else if(words[i + 1].length() < j+1){
                    return false;
                }else{
                    if(order.indexOf(words[i].charAt(j)) > order.indexOf(words[i+1].charAt(j))){
                        return false;
                    }else if(order.indexOf(words[i].charAt(j)) < order.indexOf(words[i+1].charAt(j))){
                        break;
                    }else{
                        j++;
                    }
                }
                
            }
        }
        return true;
    }
}
// @lc code=end

