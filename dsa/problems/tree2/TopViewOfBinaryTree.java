package dsa.problems.tree2;

import java.util.*;

public class TopViewOfBinaryTree {

        public static class Pair{
            Node node;
            int val ;

            public Pair(Node node, int val){
                this.node = node;
                this.val = val;
            }
        }
        // Function to return a list of nodes visible from the top view
        // from left to right in Binary Tree.
        static ArrayList<Integer> topView(Node root) {
            // code here
            Map<Integer,Integer> map = new TreeMap<>();
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(root,0));

            while(!q.isEmpty()){

                Pair p = q.poll();
                Node node = p.node;
                int val = p.val;

                if(map.get(val)==null) {
                    map.put(val,node.data);
                }
                if(node.left!=null){
                    q.offer(new Pair(node.left,val-1));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right,val+1));
                }


            }

            return new ArrayList<>(map.values());

        }

}
