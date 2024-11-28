package dsa.problems.strings;

//public class AtoiImplement {
//}

class AtoiImplement {
    public int myAtoi(String s) {

        int i =0;
        int n = s.length();
        while(i<n && s.charAt(i)==' '){
            i++;
        }

        int sign =1;
        if(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            sign = (s.charAt(i)=='-') ? -1:1;
            i++;
        }
        // Ensure no multiple signs
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            return 0; // Invalid format
        }
        int res=0;

        while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
            int digi = s.charAt(i)-'0';

            if(res>(Integer.MAX_VALUE -digi)/10){
                return (sign==1) ?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res= res*10+digi;
            i++;
        }

        return sign*res;


    }
}
//
//Cases for atoi() conversion:
//
//Skip any leading whitespaces.
//Check for a sign (‘+’ or ‘-‘), default to positive if no sign is present.
//Read the integer by ignoring leading zeros until a non-digit character is encountered or end of the string is reached. If no digits are present, return 0.
//If the integer is greater than 231 – 1, then return 231 – 1 and if the integer is smaller than -231, then return -231.