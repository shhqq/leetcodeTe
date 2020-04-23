import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.sun.javafx.scene.layout.region.Margins.Converter;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/*
 * @lc app=leetcode id=970 lang=java
 *
 * [970] Powerful Integers
 */

// @lc code=start
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < bound; i++){
            if(Math.pow(x, i) > bound){
                break;
            }
            for(int j = 0; j < bound; j++){
                int temp = (int)(Math.pow(x, i) + Math.pow(y, j));
                if(temp > bound){
                    break;
                } else {
                    res.add(temp);
                }
            }
        }
        return new ArrayList(res);
    }
}
// @lc code=end

