package dsa.problems.Hashing;

import java.util.*;

public class Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> anagramGroups = new HashMap<>();

        for(String str : strs) {
        // Convert string to char array, sort it, and convert it back to a string
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        String sortedStr = new String(charArray);

        // If the sorted string is not in the map, add it
        anagramGroups.putIfAbsent(sortedStr, new ArrayList<>());
        // Add the original string to the corresponding list
        anagramGroups.get(sortedStr).add(str);
    }

    // Return the values of the map as a list of lists
        return new ArrayList<>(anagramGroups.values());
}
}
