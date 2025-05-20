package dsa.problems.trienode;

public class TrieNode {

    public TrieNode children[];
    public boolean isEndWord = false;
    public TrieNode(){
        this.children = new TrieNode[26];
        this.isEndWord = false;
    }

    public void insert(String word){
        TrieNode  currNode = this;

        for(char c : word.toCharArray()){
            int index = c-'a';
            if(currNode.children[index]==null){
                currNode.children[index] = new TrieNode();
            }
            currNode = currNode.children[index];
        }

        currNode.isEndWord = true;
    }

    public boolean search(String s ){
        TrieNode currNode = this;
        for(char c: s.toCharArray()){
            int index = c-'a';
            if(currNode.children[index]==null){
                return false;
            }
            currNode = currNode.children[index];

        }
        return currNode.isEndWord;

    }

    public static void main(String a[]){
        TrieNode node  = new TrieNode();
        node.insert("nithish");
        System.out.println(node.search("nithi"));
    }


}
