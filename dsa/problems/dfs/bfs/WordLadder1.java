package dsa.problems.dfs.bfs;

import java.util.*;

public class WordLadder1 {
    class Solution {
        class GraphEdge{
            String word ;
            int steps;
            GraphEdge  (String w , int c){
                this.word =w;
                this.steps=c;
            }

            public String getWord(){
                return word;
            }
            public int getSteps(){
                return steps;
            }



        }
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            Queue<GraphEdge> q= new LinkedList<>();
            Set<String> set = new HashSet<>();
            for(String s : wordList){
                set.add(s);
            }
            //int steps =0;
            q.offer(new GraphEdge(beginWord,1));

            while(!q.isEmpty()){
                GraphEdge curr = q.poll();
                String word = curr.getWord();
                int steps = curr.getSteps();
                if(word.equals(endWord)) return steps;

                for(int i =0;i<word.length();i++){
                    for(char ch ='a';ch<='z';ch++){
                        char charArray[] = word.toCharArray();
                        charArray[i]=ch;
                        String newString  = new String(charArray);
                        if(set.contains(newString)){
                            set.remove(newString);
                            q.offer(new GraphEdge(newString, steps+1));
                        }
                    }
                }
            }

            return 0;

        }
    }
}
