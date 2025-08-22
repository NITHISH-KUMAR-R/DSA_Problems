package dsa.problems.graphstriver.dfs;

import java.util.*;

public class ReconstructItinerary332  {
        public void dfs(String from , List<String> list , Map<String, PriorityQueue<String>> map ){
            PriorityQueue<String> pq = map.get(from);
            while(pq!=null && !pq.isEmpty()){
                String to  = pq.poll();
                dfs(to,list,map);
            }
            list.add(0,from);
        }
        public List<String> findItinerary(List<List<String>> tickets) {

            Map<String, PriorityQueue<String>> map = new HashMap<>();

            for(List<String> t : tickets){
                String from = t.get(0);
                String to = t.get(1);
                if(!map.containsKey(from)){
                    map.put(from , new PriorityQueue<>());
                }
                map.get(from).offer(to);
            }

            List<String> result = new ArrayList<>();
            dfs("JFK",result,map );
            return result;

        }

}
