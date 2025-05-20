package dsa.problems.trienode;

import java.util.List;

public class WordBreak {
     class TrieNode{
            public TrieNode[] children;
            public  boolean isEndWord = false;

            public TrieNode(){
                this.children = new TrieNode[26];
                this.isEndWord = false;
            }
            public void insert(String word){
                TrieNode currNode = this;
                for(char c: word.toCharArray()){
                    int index = c-'a';
                    if(currNode.children[index]==null){
                        currNode.children[index] = new TrieNode();
                    }
                    currNode = currNode.children[index];
                }
                currNode.isEndWord = true;
            }
            public boolean fullWordSearch(String s , Boolean [] dp,int start){
                if(start== s.length()) return true;
                if(dp[start]!=null) return dp[start];
                TrieNode currNode = this;

                for(int i = start; i<s.length();i++){
                    int index = s.charAt(i)-'a';
                    if(currNode.children[index]==null)
                    {
                        break;
                    }
                    currNode = currNode.children[index];
                    if(currNode.isEndWord && fullWordSearch(s,dp,i+1)){
                        dp[start]= true;
                    }
                }

                return dp[start]= false;
            }

        }
        public boolean wordBreak(String s, List<String> wordDict) {

            TrieNode root = new TrieNode();

            for (String word : wordDict) {
                root.insert(word.toLowerCase());
            }
            Boolean[] dp = new Boolean[s.length()];

            return root.fullWordSearch(s, dp, 0);

        }
}
