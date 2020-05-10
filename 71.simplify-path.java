import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        List<String> dirs = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < path.length(); i++){
            char c = path.charAt(i);
            if(c == '/'){
                continue;
            } else {   
                // .也可以作为文件名的一部分，所以这里截取.到下一个/之间的部分
                // 但这样好像还是没考虑 a.b a..b 的情况。 不过也没有报错
                // 现在考虑了这种情况
                StringBuilder temp = new StringBuilder();
                while(i < path.length() && path.charAt(i) != '/'){
                    temp.append(path.charAt(i));
                    i++;
                }
                String str = temp.toString();
                if(str.equals(".")){
                    continue;
                } else if(str.equals("..")){
                    if(dirs.size() > 0){
                        dirs.remove(dirs.size()-1);
                    }
                } else {
                    dirs.add(str);
                }
            }
        }

        s = new StringBuilder();
        for(String str: dirs){
            s.append('/');
            s.append(str);
        }
        if(s.length() == 0){
            s.append('/');
        }
        return s.toString();
    }
}
// @lc code=end

