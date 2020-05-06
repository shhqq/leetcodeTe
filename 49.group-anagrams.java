import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList();
        for (String s: strs){
            Map<Character, Integer> m = generateMap(s);
            boolean exist = false;
            for (List<String> temp : ans){

                if (temp.get(0).length() != s.length()){
                    continue;
                } else {
                    Map<Character, Integer> mExist = generateMap(temp.get(0));
                    boolean anagram = true;
                    for (char cnew: m.keySet()){
                        if(!mExist.containsKey(cnew) || mExist.get(cnew) != m.get(cnew)){
                            anagram = false;
                            break;
                        }
                    }
                    if (anagram){
                        temp.add(s);
                        exist = true;
                    }
                }
            }
            if(!exist){
                List<String> l = new ArrayList<>();
                l.add(s);
                ans.add(l);
            }
        }
        return ans;
    }

    private Map<Character, Integer> generateMap(String s){
        Map<Character, Integer> m = new HashMap<>();
        for(char c: s.toCharArray()){
            if(m.containsKey(c)){
                m.put(c, m.get(c) + 1);
            } else {
                m.put(c, 1);
            }
        }
        return m;
    }
}
// @lc code=end

