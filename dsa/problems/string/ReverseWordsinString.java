package dsa.problems.string;

public class ReverseWordsinString {
    class Solution {
        public String reverseWords(String s) {

            String [] wordsArray = s.split(" ");

            StringBuilder result = new StringBuilder();
            for(String word : wordsArray){
                StringBuilder sb = new StringBuilder(word).reverse();
                result.append(sb).append(" ");
            }

            return result.toString().trim();
        }
    }

    class Solution2TwoPointers {
        public void reverse(char [] arr, int left, int right ){
            while(left<right){
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        public String reverseWords(String s) {

            char [] charArray = s.toCharArray();
            int left =0;
            int right =0;

            while(right<charArray.length){
                if(charArray[right]==' '){
                    reverse(charArray,left, right-1);
                    left = right+1;
                }
                right++;
            }

            reverse(charArray, left , right-1);

            return new String(charArray);

        }
    }
}
