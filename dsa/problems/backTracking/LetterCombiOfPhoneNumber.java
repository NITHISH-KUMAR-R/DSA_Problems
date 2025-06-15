package dsa.problems.backTracking;


import java.util.ArrayList;
import java.util.List;

public class LetterCombiOfPhoneNumber {

    static List<String> result;
    public static  final String [] strArray = new String []{
            "",    // 0
            "",    // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs",// 7
            "tuv", // 8
            "wxyz" // 9
    };
    public static List<String> methodCheck(String s){
        result = new ArrayList<>();

        dfs(0, s,new StringBuilder());
        return result;
    }

    private static void dfs(int i, String s, StringBuilder sb) {
        if(i == s.length()){
            result.add(sb.toString());
            return;
        }
        char ch = s.charAt(i);
        System.out.println(ch);
        String keyWord = strArray[ch-'0'];
        for(char c: keyWord.toCharArray()){
            sb.append(c);
            dfs(i+1,s,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    public static void main(String a[]){
        String s ="23";
        System.out.println(methodCheck(s));
    }
}

