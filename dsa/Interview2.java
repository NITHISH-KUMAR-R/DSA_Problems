package dsa;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//Given a string s of lowercase English letters,
//the task is to find the first non-repeating character. If there is no such character, return ‘$’.
//Input: s = “racecar”
//Output: ‘e’
//Explanation: ‘e’ is the only character in the string which does not repeat.
//Input: “aabbccc”
//Output: ‘$’
//Explanation: All the characters in the given string are repeating.
public class Interview2 {

    public static String check(String s){

        Map<Character,Integer> map = new HashMap<>();

        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(Map.Entry<Character,Integer> c:map.entrySet()){
            if(c.getValue()==1){
                return new String(String.valueOf(c.getValue()));
            }
        }
        return "$";
    }
    public static void  main(String[] args) {
        String s= "sahsh";
        String output = "a";
        String s2 = "aabbccc";
        LocalDateTime check = LocalDateTime.now();
        System.out.println(check);
        char c [] = {'c','a'};
        System.out.println(new String(c));

        System.out.println(check(s2));


    }
}
