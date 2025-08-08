package dsa.problems.graphstriver.bfs;

import java.util.*;

public class WordLadder {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> dict = new HashSet<>(wordList);
            if(!dict.contains(endWord)) return 0;

            Queue<String> q = new LinkedList<>();
            q.offer(beginWord);

            Set<String> visited = new HashSet<>();
            visited.add(beginWord);
            int steps =1;

            while(!q.isEmpty()){
                int size = q.size();
                for(int i =0;i<size;i++){
                    String s1 = q.poll();
                    if(s1.equals(endWord)) return steps;
                    char arr[]=  s1.toCharArray();
                    for(int j =0;j<arr.length;j++){
                        char original = arr[j];
                        for(char c ='a';c<='z';c++){
                            if(c==original) continue;
                            arr[j] = c;
                            String nextWord = new String(arr);
                            if(dict.contains(nextWord) && !visited.contains(nextWord)){
                                visited.add(nextWord);
                                q.offer(nextWord);
                            }

                        }
                        arr[j] = original;
                    }

                }
                steps++;
            }

            return 0;

        }

}
