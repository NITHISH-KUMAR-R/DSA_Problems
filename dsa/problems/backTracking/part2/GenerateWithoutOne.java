package dsa.problems.backTracking.part2;

import java.util.ArrayList;
import java.util.List;

public class GenerateWithoutOne {
    class Solution {
        public static void generate(List<String> list , String curr, int n , boolean prevOne){
            if(n==0){
                list.add(curr);
                return;
            }

            generate(list,curr+"0",n-1,false);

            if(prevOne==false){
                generate(list,curr+"1",n-1,true);
            }

        }
        public static List<String> generateBinaryStrings(int n) {
            // code here

            List<String> result = new ArrayList<>();

            generate(result,"",n,false);
            return result;
        }
    }
}
