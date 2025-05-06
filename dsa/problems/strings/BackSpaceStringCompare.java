package dsa.problems.strings;

public class BackSpaceStringCompare {
    class Solution {

        public static String builder(String s){

            StringBuilder sb = new StringBuilder();
            int hashCount =0;
            for(int i =s.length()-1;i>=0;i--){
                if(s.charAt(i)=='#'){
                    hashCount++;
                }else{
                    if(hashCount==0){
                        sb.append(s.charAt(i));
                    }else{
                        hashCount--;
                    }
                }

            }
            return sb.reverse().toString();

        }
        public boolean backspaceCompare(String s, String t) {

            return builder(s).equals(builder(t));

        }
    }
}
