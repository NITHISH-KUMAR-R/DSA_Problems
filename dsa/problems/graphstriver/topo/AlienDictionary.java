package dsa.problems.graphstriver.topo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
        List<Integer> topoSort( List<List<Integer>> adj, boolean[] present) {
            int[] indegree = new int[26];
            for (int i = 0; i < 26; i++) {
                for (int j : adj.get(i)) {
                    indegree[j]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < 26; i++) {
                if (present[i] && indegree[i] == 0) {
                    q.offer(i);
                }
            }

            List<Integer> topo = new ArrayList<>();
            while (!q.isEmpty()) {
                int node = q.poll();
                topo.add(node);
                for (int nei : adj.get(node)) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        q.offer(nei);
                    }
                }
            }

            return topo;
        }

        public String findOrder(String[] words) {
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                adj.add(new ArrayList<>());
            }

            boolean[] present = new boolean[26];

            for (String word : words) {
                for (char c : word.toCharArray()) {
                    present[c - 'a'] = true;
                }
            }

            for (int i = 0; i < words.length - 1; i++) {
                String s1 = words[i];
                String s2 = words[i + 1];
                if (s1.length() > s2.length() && s1.startsWith(s2)) {
                    return "";
                }
                int len = Math.min(s1.length(), s2.length());
                for (int j = 0; j < len; j++) {
                    if (s1.charAt(j) != s2.charAt(j)) {
                        int u = s1.charAt(j) - 'a';
                        int v = s2.charAt(j) - 'a';
                        adj.get(u).add(v);
                        break;
                    }
                }
            }

            List<Integer> topo = topoSort(adj, present);

            // If cycle detected (not all present characters are in topo)
            int totalChars = 0;
            for (boolean b : present) {
                if (b) totalChars++;
            }

            if (topo.size() != totalChars) return "";

            StringBuilder sb = new StringBuilder();
            for (int i : topo) {
                sb.append((char) (i + 'a'));
            }

            return sb.toString();
        }
    }


