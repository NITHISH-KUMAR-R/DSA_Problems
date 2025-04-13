package dsa.problems.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    static class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }
    class Solution {

        public static Node cloneNodeDfs(Node node, Map<Node,Node> map){
            if(node==null){
                return node;
            }

            if(map.containsKey(node)){
                return map.get(node);
            }

            Node cloneNode = new Node(node.val);
            map.put(node,cloneNode);

            for(Node neighbor : node.neighbors){
                cloneNode.neighbors.add(cloneNodeDfs(neighbor,map));
            }
            return cloneNode;

        }
        Node cloneGraph(Node node) {
            // code here
            Map<Node,Node> map = new HashMap<>();

            return cloneNodeDfs(node,map);


        }
    }
}
