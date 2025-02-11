package dsa.problems.string;

public class RemoveOccurencesString {
    class Solution {
        public String removeOccurrences(String s, String part) {

            // while(s.contains(part)){
            //     int index = s.indexOf(part);
            //     s = s.substring(0,index)+ s.substring(index + part.length());
            // }
            // return s;

            // StringBuilder str=new StringBuilder();
            // for(int i=0;i<s.length();i++){
            //     str.append(s.charAt(i));
            //     int j=str.length()-part.length();

            //     if(j>=0&&str.substring(j).equals(part)){
            //         str.setLength(j);

            //     }

            // }
            // return str.toString();

            // Stack<Character> stack = new Stack<>();
            //     int partLength = part.length();

            //     for (char c : s.toCharArray()) {
            //         stack.push(c); // Push the current character onto the stack

            //         // Check if the top of the stack matches `part`
            //         if (stack.size() >= partLength && isTopEqualToPart(stack, part)) {
            //             // Pop the characters of `part` from the stack
            //             for (int i = 0; i < partLength; i++) {
            //                 stack.pop();
            //             }
            //         }
            //     }

            //     // Build the result string from the stack
            //     StringBuilder result = new StringBuilder();
            //     for (char c : stack) {
            //         result.append(c);
            //     }
            //     return result.toString();
            // }

            // // Helper function to check if the top of the stack matches `part`
            // private static boolean isTopEqualToPart(Stack<Character> stack, String part) {
            //     int stackSize = stack.size();
            //     int partLength = part.length();

            //     for (int i = 0; i < partLength; i++) {
            //         if (stack.get(stackSize - partLength + i) != part.charAt(i)) {
            //             return false;
            //         }
            //     }
            //     return true;
            StringBuilder stack = new StringBuilder();
            int partLength = part.length();

            for (char c : s.toCharArray()) {
                stack.append(c); // Push the current character to StringBuilder

                // Check if the end of the StringBuilder matches `part`
                if (stack.length() >= partLength &&
                        stack.substring(stack.length() - partLength).equals(part)) {
                    stack.setLength(stack.length() - partLength); // Remove `part`
                }
            }

            return stack.toString();


        }
    }
}
