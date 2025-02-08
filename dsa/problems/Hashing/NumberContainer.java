package dsa.problems.Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class NumberContainer {
    class NumberContainers {
        Map<Integer,Integer> map;
        Map<Integer, TreeSet<Integer>> treeMap;

        public NumberContainers() {
            map = new HashMap<>();
            treeMap = new TreeMap<>();


        }

        public void change(int index, int number) {
            if(map.containsKey(index)){
                int oldNum = map.get(index);
                if(oldNum!=number){
                    treeMap.get(oldNum).remove(index);
                    if(treeMap.get(oldNum).isEmpty()){
                        treeMap.remove(oldNum);
                    }
                }
            }

            map.put(index,number);
            treeMap.computeIfAbsent(number, k ->new TreeSet<>()).add(index);
        }

        public int find(int number) {
            if(!treeMap.containsKey(number)){
                return -1;
            }
            return treeMap.get(number).first();

        }
    }

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
}
