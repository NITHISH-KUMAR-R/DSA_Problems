package dsa.problems.tree2;

import java.util.*;

public class BottomViewOfBinaryTree {

        public static class Pair{
            Node node;
            int val;
            public Pair(Node node, int val){
                this.val = val;
                this.node = node;
            }
        }
        public ArrayList<Integer> bottomView(Node root) {
            // Code here
            Map<Integer,Integer> map = new TreeMap<>();
            Queue<Pair> q = new LinkedList<>();

            q.offer(new Pair(root,0));

            while(!q.isEmpty()){
                Pair p = q.poll();
                Node node = p.node;
                int val = p.val;
                map.put(val,node.data);

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
