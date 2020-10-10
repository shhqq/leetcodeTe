import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return solution3(numCourses, prerequisites);
    }

    /**
     * 第三种方法：
     * 使用有向无环图(DAG)的深度优先搜索方法(DFS)。
     * 需要使用一个visited数组表示节点访问状态，初始化都为0，当某个循环访问了节点，设为1，如果该节点
     * 直到末尾都没有出现环，设为2，表示该节点安全。
     * @param numCourses
     * @param prerequisites
     * @return
     */
    private boolean solution3(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // visited的初始状态，均为0；
        int[] visited = new int[numCourses];

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
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(Map<Integer, List<Integer>> graph, int[] visited, int i) {
        if (visited[i] == 1) return false;
        if (visited[i] == 2) return true;
        visited[i] = 1;
        for (int j: graph.getOrDefault(i, new ArrayList<>())) {
            if( !dfs(graph, visited, j)) {
                return false;
            }
        }
        visited[i] = 2;
        return true;
    }
    /**
     * 第二种方法：
     * 使用有向无环图(DAG)的广度优先搜索方法(BFS)
     * @param numCourses
     * @param prerequisites
     * @return
     */
    private boolean solution2(int numCourses, int[][] prerequisites) {
        // 首先要用一个字典记录所有的节点指向关系，还需要一个数组记录每个节点的入度
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        // 第一步：生成map和节点的入度信息
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            // 1. 更新map
            if (graph.containsKey(b)) {
                graph.get(b).add(a);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(a);
                graph.put(b, temp);
            }

            // 2. 更新节点入度信息
            inDegree[a]++;
        }

        // 第二步：遍历节点，判断是否有环
        for (int i = 0; i < numCourses; i++) {
            boolean existNode = false;
            int j;
            for (j = 0; j < numCourses; j++) {
                if (inDegree[j] == 0) {
                    existNode = true;
                    break;
                }
            }
            if (!existNode) {
                return false;
            }
            // 如果找到了入度为0的节点，则更新入度信息
            inDegree[j] = -1;
            for (int k : graph.getOrDefault(j, new ArrayList<>())){
                inDegree[k]--;
            }
        }
        return true;
    }

    /**
     * 第一种方法：
     * 试图用一个map来存储关系，键是线头，值是这个线头下的值。
     * 如果出现环就不可以。
     * 这种方式比较麻烦。
     * @param numCourses
     * @param prerequisites
     * @return
     */
    private boolean solution1(int numCourses, int[][] prerequisites) {
        // 试图用一个map来存储关系，键是线头，值是这个线头下的值。
        // 如果出现环就不可以
        Map<Integer, Set<Integer>> dependency = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            // 用a依赖b表示，
            // 1. 如果a在dep的键中，那么要看b是否在值中，
                // 1.1 如果在，那么就出现了环
                // 1.2 如果不在，还要看b是不是键，
                    // 1.2.1 如果b是键，那么就整合（a,a的值，b的值）
                    // 1.2.2 如果不是键，那么就创建b键，然后整合（a和a的值）
            // 2. 如果a不在dep键中，还要看b是不是键，
                // 2.1 如果b是键，那么就整合（a,a的值，b的值）
                // 2.2 如果不是键，那么就创建b键，然后整合（a和a的值）
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            if (dependency.containsKey(a)) {
                if (dependency.get(a).contains(b)) {
                    return false;
                } else if (dependency.containsKey(b)) { 
                    dependency.get(a).add(a);
                    dependency.get(b).addAll(dependency.get(a));
                    dependency.remove(a);
                } else {
                    dependency.get(a).add(a);
                    dependency.put(b, dependency.get(a));
                    dependency.remove(a);
                }
            } else {
                if (dependency.containsKey(b)) {
                    dependency.get(b).add(a);
                } else {
                    Set<Integer> temp = new HashSet<>();
                    temp.add(a);
                    dependency.put(b, temp);
                }
            }

        }

        // 上述是有漏洞的，还需要进一步验证
        // 如果一个键k的值v中，有一个值v[i]，也是一个键，且这个键v[i]的值v[i].val中又有k
        // 则会产生环。
        for (int k: dependency.keySet()) {
            for (int v : dependency.get(k)) {
                if (dependency.containsKey(v) && dependency.get(v).contains(k)) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

