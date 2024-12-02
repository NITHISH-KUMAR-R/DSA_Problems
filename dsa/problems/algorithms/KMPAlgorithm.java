package dsa.problems.algorithms;


import java.util.ArrayList;
class KMPAlgorithm {
    public int [] computeTemporaryArray(String pattern){
        int lps[] = new int[pattern.length()];
        int i =1;
        int len =0;
        int m = pattern.length();
        while(i<m){
            if(pattern.charAt(len)==pattern.charAt(i)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len!=0){
                    len = lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        ArrayList<Integer> result = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();
        int [] lps = computeTemporaryArray(pat);
        int i = 0; // Index for txt
        int j = 0; // Index for pat

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                // Pattern found, add starting index to result
                result.add(i - j);
                j = lps[j - 1]; // Reset j using LPS
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1]; // Reset j using LPS
                } else {
                    i++;
                }
            }
        }

        return result;

    }
}

