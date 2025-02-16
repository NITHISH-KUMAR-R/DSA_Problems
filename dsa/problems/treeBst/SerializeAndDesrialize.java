package dsa.problems.treeBst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDesrialize {
    class Tree {
        // Function to serialize a tree and return a list containing nodes of tree.
        public ArrayList<Integer> serialize(Node root) {

            ArrayList<Integer> list = new ArrayList<>();

            Queue<Node> q = new LinkedList<>();
            if(root==null) return list;
            q.offer(root);
            while(!q.isEmpty()){
                int levelSize = q.size();
                Node node  = q.poll();
                if(node!=null){
                    list.add(node.data);
                    q.offer(node.left);
                    q.offer(node.right);
                }else{
                    list.add(null);
                }

            }

            return list;
            // code here
        }

        // Function to deserialize a list and construct the tree.
        public Node deSerialize(ArrayList<Integer> arr) {
            // code here

            if(arr==null || arr.isEmpty()) return null;
            Queue<Node> q = new LinkedList<>();
            Node root = new Node(arr.get(0));
            q.offer(root);
            int i =1;
            while(!q.isEmpty() && i < arr.size()){
                Node current = q.poll();

                if(i<arr.size() && arr.get(i)!=null){
                    current.left = new Node(arr.get(i));
                    q.offer(current.left);
                }
                i++;
                if(i<arr.size() && arr.get(i)!=null){
                    current.right = new Node(arr.get(i));
                    q.offer(current.right);
                }
                i++;
            }
            return root;
        }
    }
}
