package dsa.problems.trie;

public class TrieDs {
    public static class TrieNode {
    public TrieNode children[];
    public boolean isEndWord;
    public TrieNode(){
        children = new TrieNode[26];
        isEndWord = false;
    }

    public void insert(String s){
        TrieNode curr = this;
        for(char c : s.toCharArray()){
            int index = c-'a';
            if(curr.children[index]==null){
             curr.children[index] = new TrieNode();
            }
            curr =  curr.children[index];
        }
        curr.isEndWord = true;
    }

    public boolean searrch(String s){
        TrieNode curr = this;
        for(char c : s.toCharArray()){
            int index = c-'a';
            if(curr.children[index]==null){
                return false;
            }
              curr=curr.children[index];
        }
        return curr.isEndWord;
    }

    public boolean prefix(String s){
        TrieNode curr = this;
        for(char c : s.toCharArray()){
            int index = c-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }

    }
    public static  void main(String a[]){

        TrieNode ds = new TrieNode();

        String s [] = {"ant","and", "animal"};

        for(String word : s){
            ds.insert(word);
        }

        System.out.println(ds.searrch("ani"));
        System.out.println(ds.prefix("ani"));


    }
}
