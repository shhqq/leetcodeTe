/*
 * @lc app=leetcode id=997 lang=java
 *
 * [997] Find the Town Judge
 */

// @lc code=start
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for(int[] t : trust){
            count[t[0]]--;
            count[t[1]]++;
        }
        for(int i = 1; i <= N; i++){
            if(count[i] == N - 1){
                return i;
            }
        }
        return -1;

        /*
        if( N == 1){return 1;}
        Map<Integer, List<Integer>> m = new HashMap();
        Map<Integer, List<Integer>> possible = new HashMap();
        for(int i = 0; i < trust.length; i++){
            if(!m.keySet().contains(trust[i][0])){
                List<Integer> list = new ArrayList();
                list.add(trust[i][1]);
                m.put(trust[i][0], list);
            }else {
                m.get(trust[i][0]).add(trust[i][1]);
                
            }
            if(!possible.keySet().contains(trust[i][1])){
                List<Integer> list = new ArrayList();
                list.add(trust[i][0]);
                possible.put(trust[i][1], list);
            }else{
                possible.get(trust[i][1]).add(trust[i][0]);
            }
        }
        for(int i = 1; i < N+1; i++){
            if(m.keySet().contains(i)){
                continue;
            }else if(possible.keySet().contains(i)){
                int j = 0;
                for(j = 1; j < N + 1; j++){
                    if(j != i){
                        if(!possible.get(i).contains(j)){
                            break;
                        }
                    }
                }
                if(j == N + 1){
                    return i;
                }
            }
        }
        return -1;
        // */
    }
}
// @lc code=end

