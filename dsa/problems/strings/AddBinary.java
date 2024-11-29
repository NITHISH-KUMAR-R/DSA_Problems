package dsa.problems.strings;

class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry =0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0 || carry ==1){
            int curr = carry;
            curr += i>=0 ? a.charAt(i--)-'0':0;
            curr += j>=0 ? b.charAt(j--)-'0':0;
            sb.append(curr%2); // this is give remainder
            carry = curr/2; //this will give quotient value

        }

        sb.reverse();
        //if they asked us to remove leading zeroes - we need to enable this condition check
        // int k =0;
        // while(k<sb.length() && sb.charAt(k)=='0'){
        //     k++;
        // }

        // sb.delete(0,k);
        return sb.toString();
    }
}