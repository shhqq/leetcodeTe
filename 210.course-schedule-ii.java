import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return solution1(numCourses, prerequisites);
    }

    /**
     * 使用有向无环图的广度优先搜索方法，每次选出入度为0的节点，并将它们的下一级入度-1；
     * @param numCourses
     * @param prerequisites
     * @return
     */
    private int[] solution1(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        // 第一步：生成图和节点的入度信息
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            if (graph.containsKey(b)) {
                graph.get(b).add(a);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(a);
                graph.put(b, temp);
            }

            inDegree[a]++;
        }

        // 第二步：每次找出入度为0的节点，将其入度改为-1，并将其所有下级节点入度-1；
        int currentIndex = 0;
        int[] ans = new int[numCourses];
        while (currentIndex < numCourses) {
            boolean existZeroInDegree = false;
            int start = currentIndex;
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    existZeroInDegree = true;
                    ans[currentIndex] = i;
                    currentIndex++;
                    inDegree[i] = -1;
                }
            }
            // 如果不存在入度为0的节点，则说明存在环
            if (!existZeroInDegree) {
                return new int[0];
            }

            // 将这些节点的下级节点入度都-1；
            for (int i = start; i < currentIndex; i++) {
                for (int j: graph.getOrDefault(ans[i], new ArrayList<>())) {
                    inDegree[j]--;
                }
            }
        }
        
        return ans;
    }
}
// @lc code=end

