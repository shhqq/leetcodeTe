import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        List<Node> nodes = new ArrayList<>();
        return generateNodeList(nodes, node);
    }

    /**
     * 关键是生成一个列表，用来保存所有生成的Node。也就是记录哪些值的节点已经创建了。
     * 首先生成该节点，然后再逐个添加邻居，使用递归。
     * 从第一个节点开始，判断它的邻居是否已经生成，如果没有，则新建；如果已经有了，那么直接放到他的邻居中。
     * @param nodes 节点列表，用来记录哪些值的节点已经有了
     * @param node 需要生成的节点的原始节点，两者的值相同
     * @return 返回生成的节点
     */
    private Node generateNodeList(List<Node> nodes, Node node) {

        // 如果node.val的值的节点还未生成，则生成
        if (findNode(nodes, node.val) == null) {       
            Node newNode = new Node(node.val);
            // 添加到列表中
            nodes.add(newNode);

            // 再生成该节点的所有邻居，使用递归
            for (Node n: node.neighbors) {
                newNode.neighbors.add(generateNodeList(nodes, n));
            }
            // 返回生成的节点
            return newNode;
        } else {
            // 如果这个节点已经存在了，则直接返回这个节点
            return findNode(nodes, node.val);
        }
    }

    /**
     * 判断列表中是否含有值为val的Node
     * @param nodes Node列表
     * @param val 需要查找的值
     * @return 是否含有值为val的Node
     */
    private Node findNode(List<Node> nodes, int val) {
        for (Node n: nodes) {
            if (n.val == val) {
                return n;
            }
        }
        return null;
    }
}
// @lc code=end

